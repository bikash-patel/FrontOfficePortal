package com.bikash.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bikash.appconst.AppConst;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
								HttpServletResponse response,
								Object handler) throws Exception {

		// Check if the session attribute "userId" is null
		if(request.getSession().getAttribute(AppConst.STR_USERID)==null)
		{
			 // Redirect to the home page
			response.sendRedirect(AppConst.STR_HOME_REDIRECT);
			return false;
		}
		//proceed if session is not null
		return true;
	}
}
