package com.revature.exceptions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandlerServlet
 */

public class ErrorHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();

	        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

	        Class exceptionClass = (Class) request.getAttribute("javax.servlet.error.exception_type");
	      
	        Integer status_code = (Integer) request.getAttribute("javax.servlet.error.status_code");       

	        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
	       
	        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");

	        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
	       
		out.println("Exception: " + exception);
		out.println("Exception Type: " + exceptionClass);
		out.println("HttpError Status code: " + status_code);
		out.println("ErrorMessage: " + errorMessage);
		out.println("Request URI: " + requestUri);
		out.println("Servlet Name: " + servletName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
