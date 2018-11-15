package com.spring.naonnaTest.socket;

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
//Websocket 에서 서버단의 프로세스를 정의할 수 있다.
public class SocketHandler extends TextWebSocketHandler{

	private final Logger logger = LogManager.getLogger(getClass());
	HttpServletRequest request;
	
	//접속하는 사용자에 대한 세션을 보관하기 위해 정의
	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	
	public SocketHandler() {
		super();
		this.logger.info("create SocketHandler instance!");
	}
	
	//클라이언트 연결을 종료할 경우 발생하는 이벤트
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		
		sessionSet.remove(session);
		this.logger.info("remove session!");
	}
	
	//클라이언트 접속하여 성공할 경우 발생하는 이벤트
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		
		sessionSet.add(session);
		this.logger.info("add session!");
	}
	
	//클라이언트에서 send를 이용해서 메세지 발송을 한 경우 이벤트 핸들링
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		
		//session.getAttribute() : HandshakeInterceptor의 beforeHandshake() 메소드에서 저장한 map을 가져온다
		Map<String, Object> map = session.getAttributes();
		String nickname = (String) map.get("nickname");
		System.out.println("전송자 아이디 : " + nickname);
		
		for(WebSocketSession client_session: this.sessionSet) {
			if(client_session.isOpen()) {
				try {
					client_session.sendMessage(message);
				}
				catch (Exception ignored) {
					this.logger.error("fail to send  message", ignored);
				}
			}
		}
	}
	
	//전송 에러 발생할 때 호출
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		this.logger.error("Web socket error!", exception);
		
	}
	
	@Override
	public boolean supportsPartialMessages() {
		this.logger.info("call method");
		
		return false;
	}
}
