package com.spring.springwebsocket;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//서버단의 SocketHandler 정의
//Websocket에서 서버단의 프로세스를 정의할수 있다.
public class SocketHandler extends TextWebSocketHandler{
	
	private final Logger logger = LogManager.getLogger(getClass());
	HttpServletRequest request;
	
	//접속하는 사용자에 대한 세션을 보관하기 위해 정의
	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	
	public SocketHandler () {
		super();
		System.out.println("socketHandler : socketHandler socketHandler 생성");
		this.logger.info("create SocketHandler instance!");
	}
	
	// 클라이언트에서 연결을 종료할 경우 발생하는 이벤트
	@Override							//연결이 끊긴 세션의 정보가 session엔 저장됨
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		sessionSet.remove(session); //클라이언트에서 서버에접속하면 접속한 모든 세션의 정보를 sessionSet에서 저장되어 
		this.logger.info("remove session!");
		System.out.println("socketHandler : afterConnectionClosed 커넥션 연결 종료 후");
	}
	// 클라이언트에서 접속을 하여 성공할 경우 발생하는 이벤트
		@Override
		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			super.afterConnectionEstablished(session);
			
			sessionSet.add(session);
			this.logger.info("add session!");
			System.out.println("socketHandler : afterConnectionEstablished 커넥션 생성 이후");
		}
		
	
	//클라이언트에서 send를 이용해서 메시지를 발송을 한 경우 이벤트 핸들링
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message)throws Exception{
		super.handleMessage(session, message);						//타입설정, ?는 어떤타입상관없음, 텍스트, 바이너리(파일전송) 타입
		
		//session.getAttribute(): HandshakeInterceptor의 beforHandShake()메서드에서 저장한 map을 가져온다.
		Map<String, Object> map = session.getAttributes();
		String userId = (String)map.get("userId");
		System.out.println("socketHandler-handleMessage : 전송자 아이디:" + userId);
		
		for (WebSocketSession client_session : this.sessionSet) {
			if(client_session.isOpen()) { 
				try {
					client_session.sendMessage(message);
				}catch(Exception ignored) {
					this.logger.error("fail to send message!", ignored);
				}
			}
		}
	}
	
	
	// 전송 에러 발생할때	 호출
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		this.logger.error("web socket error!", exception);
	}
	
	//메세지가 긴 경우 분할해서 보낼 수 있는지 여부를 결정하는 메소드
	@Override
	public boolean supportsPartialMessages() {
		this.logger.info("call method!");
		
		return false;
	}
}
