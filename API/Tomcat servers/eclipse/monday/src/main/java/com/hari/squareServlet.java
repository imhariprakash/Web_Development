package com.hari;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class squareServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int num = (int) request.getAttribute("num");
		
		response.getWriter().println("Square of the " + num + " is : " + num * num);
	}
}
