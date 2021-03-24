package com.jasdhir.servlets.nosession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckOut
 */
public class CheckOut extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response)	;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("name");
		out.print("<html><body>");
		out.print("Dear  "+"<h3>"+name+"</h3>");
		out.print("U have Purchases these items <br/><br/><br/><ol>");
		
		//session.invalidate();
		
		String []itemList=(String[]) session.getAttribute("items");
		for(int i=0;i<itemList.length;i++){
			out.print("<li>"+itemList[i]+"</li>");
		}
		out.print("</ol><body></html>");
		
		
		  int timeOut=30; 
		  session.setMaxInactiveInterval(timeOut);
		  response.setHeader("Refresh", timeOut + "; URL=timeout.html");
		 
		 

}

}
