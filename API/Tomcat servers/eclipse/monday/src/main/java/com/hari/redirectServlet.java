package com.hari;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;

public class redirectServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		int num = Integer.parseInt(request.getParameter("num"));
//		response.getWriter().println("Redirected : " + num);
		
		// without url rewriting -> session holding
		
		HttpSession session = request.getSession();
		int num = (int) session.getAttribute("num");
		response.getWriter().println("Without URL rewriting : " + num);
	}

}
