package com.greathiit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.greathiit.entity.Teacher;

/**
 * @author 邓世江
 * @date 2018年11月20日 下午3:11:37
 * 
 */
public class ManagerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if(teacher == null) {
			response.sendRedirect("../login.html");
			return false;
		}
		if("001".equals(teacher.getTeacherPost())||"003".equals(teacher.getTeacherPost())||"002".equals(teacher.getTeacherPost())) {
			return true;
		}
		switch (teacher.getTeacherPost()) {
		case "000":
		case "001":
		case "002":
		case "003":
			return true;
		default:
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	

}
