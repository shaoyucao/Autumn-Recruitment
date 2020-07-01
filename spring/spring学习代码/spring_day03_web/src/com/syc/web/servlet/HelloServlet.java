package com.syc.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.syc.service.AccountService;

public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从application作用域（ServletContext）获得spring容器
		//方式1： 手动从作用域获取
		ApplicationContext applicationContext = 
				(ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		//方式2：通过工具获取
		ApplicationContext apppApplicationContext2 = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.transfer("jack", "rose", 1000);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
