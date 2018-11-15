package com.spring.springwebsocket;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor{

	@Override //
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> map	) throws Exception {//파라미터값은 다 웹컨테이너에서 만들어줌
		
		//위의 파라미터 중, attributes 에 값을 저장하면 웹소켓 핸들러 클래스의 WebSocketSession에 전달된다
		System.out.println("핸드쉐이크 인터셉터 : 비포어 핸드쉐이크 : Before Handshake");
		ServletServerHttpRequest ssreq = (ServletServerHttpRequest) request;
		System.out.println("핸드쉐이크 인터셉터 : URI:"+request.getURI());
		HttpServletRequest req = ssreq.getServletRequest(); //아파치에서 생성해주는 HttpServletRequest
		//String id = (String)req.getParameter("id");
		//HttpSession 에 저장된 이용자의 아이디를 추출하는 경우
		//String id = (String)req.getSession().getAttribute("id");
		String id = "admin"; //테스트용
		map.put("userId", id);
		System.out.println("핸드쉐이크 인터셉터 : HttpSession에 저장된 id"+ id);
		
		return super.beforeHandshake(request, response, wsHandler, map);
	}
	
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, 
			WebSocketHandler wsHandler, Exception ex) {
		System.out.println("핸드쉐이크 인터셉터 : After Handshake");
		
		super.afterHandshake(request, response, wsHandler, ex);
	}
}
