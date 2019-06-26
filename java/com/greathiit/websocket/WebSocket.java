package com.greathiit.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


/***
 * Web Scoket服务.
 *
 */
@ServerEndpoint(value = "/websocket/{principal}")
public class WebSocket {
	/** Web Socket连接建立成功的回调方法 */
	@OnOpen
	public void onOpen(@PathParam("principal") String principal, Session session) {
		// create observer
		WebSocketObserver observer = new WebSocketObserver(session);
		// get subject
		WebSocketSubject subject = WebSocketSubject.Holder.getSubject(principal);
		// register observer into subject
		subject.addObserver(observer);
		subject.notify(principal);
	}

	/** 服务端收到客户端发来的消息 */
	@OnMessage
	public void onMessage(String message, Session session) {
		if(!"ping".equals(message)) {
			WebSocketSubject.Holder.getSubject(message).notify(message);
		}else {
			try {
				session.getBasicRemote().sendText("ping");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@OnClose
	public void onClose(@PathParam("principal") String principal, Session session) {
		// get subject
		WebSocketSubject subject = WebSocketSubject.Holder.getSubject(principal);
		// get observer
		WebSocketObserver observer = new WebSocketObserver(session);
		// delete observer from subject
		subject.deleteObserver(observer);
		// close session and close Web Socket connection
		try {
			if (session.isOpen()) {
				session.close();
			}
		} catch (IOException e) {
			throw new RuntimeException("close web socket session error.", e);
		}

	}

	@OnError
	public void onError(@PathParam("principal") String principal, Session session, Throwable error) {
		throw new RuntimeException("web socket error.", error);
	}
	

}
