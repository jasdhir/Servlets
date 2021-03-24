package com.jasdhir.servlets.nosession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ItemCollector
 */
public class ItemCollector extends HttpServlet {
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
		String name=request.getParameter("name");
		session.setAttribute("name", name);
		String []itemList =request.getParameterValues("items");
		session.setAttribute("items", itemList);
		out.print("<html><body>");
		out.print("<h2>Hello "+name+"</h2>");
		out.print("<h3>U Have Selected the Following Items</h3>");
		for(int i=0;i<itemList.length;i++){
			out.print(itemList[i]+"<br/>");
			
		}
		out.print("<br/><br/><br/><br/><br/>");
		out.print("<form action=checkOut>");
		out.print("<input type=submit value='Check Out'/>");
		out.print("</form>");
		out.print("</body></html>");
	}

}
