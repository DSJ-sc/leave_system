package com.greathiit.websocket;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSONObject;
import com.greathiit.entity.Message;


/***
 * Web Socket 主题(被观察者)
 *
 *
 */
public class WebSocketSubject extends Observable {

	/** subject键值 */
	private String principal;

	private WebSocketSubject(String principal) {
		this.principal = principal;
	}

	public String getPrincipal() {
		return principal;
	}

	public void notify(String key) {
		List<Message> list = IninService.getMessage(key);
		if(!list.isEmpty()) {
				super.setChanged();
				super.notifyObservers(JSONObject.toJSONString(list));
			}else {
				super.setChanged();
				super.notifyObservers(JSONObject.toJSONString("0"));
			}
		
	}

	public static class Holder {
		private static Map<String, WebSocketSubject> subjects = new ConcurrentHashMap<>();

		public static WebSocketSubject getSubject(String principal) {
			if (subjects.containsKey(principal)) {
				return subjects.get(principal);
			}

			WebSocketSubject subject = new WebSocketSubject(principal);
			subjects.put(principal, subject);
			return subject;
		}
	}
	
}
