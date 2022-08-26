package com.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int a = Integer.parseInt(request.getParameter("num1"));
        int b = Integer.parseInt(request.getParameter("num2"));
        int c = a + b;
//        response.getWriter().println("Addition of " + a + " and " + b + " is " + c);
        System.out.println(c);
    }
}
