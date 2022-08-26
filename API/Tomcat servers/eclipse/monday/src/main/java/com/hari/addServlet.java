package com.hari;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class addServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int a = Integer.parseInt(request.getParameter("num1"));
        int b = Integer.parseInt(request.getParameter("num2"));
        int c = a + b;
        response.getWriter().println("Get : Addition of " + a + " and " + b + " is " + c);
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int a = Integer.parseInt(request.getParameter("num1"));
        int b = Integer.parseInt(request.getParameter("num2"));
        int c = a + b;
        //response.getWriter().println("Post : Addition of " + a + " and " + b + " is " + square(c));
        
        /* requestDispatcher
        
        
        request.setAttribute("num", c);
        
        RequestDispatcher rd = request.getRequestDispatcher("square");
        
        rd.forward(request, response);
        
        */
        
        /* sendRedirect
        
        */
        
        /*  url rewriting
        
        //request.setAttribute("num", c);                //-----> won't work
        response.sendRedirect("redirect?num="+c);
        */
        
        // with out url rewriting
        
        HttpSession session = request.getSession();
        session.setAttribute("num", c);
        response.sendRedirect("redirect");
    }
	
	public int square(int x) {
		return (x * x);
	}
}
