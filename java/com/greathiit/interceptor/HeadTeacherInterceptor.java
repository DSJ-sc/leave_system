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
public class HeadTeacherInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if(teacher == null) {
			response.sendRedirect("../login.html");
			return false;
		}
		if("005".equals(teacher.getTeacherPost()) || "004".equals(teacher.getTeacherPost())) {
			return true;
		}
		return false;
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
