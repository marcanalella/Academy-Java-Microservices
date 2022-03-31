package com.acme.helloweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
					throws ServletException, IOException {
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter pw = response.getWriter();
//		pw.println("<html><body>");
//		pw.println(LocalDateTime.now());
//		pw.println("</body></html>");
		String result = LocalDateTime.now().toString(); // TODO: format
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("Hour.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, 
					      HttpServletResponse response) 
	    		    throws ServletException, IOException {
		doGet(request, response);
	}

}
