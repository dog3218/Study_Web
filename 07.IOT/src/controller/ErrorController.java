package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Throwable exception
		= (Throwable) request.getAttribute("javax.sevlet.error.exception");
		StringBuffer msg = new StringBuffer();
		while(exception!=null) {
			msg.append("<p>").append(exception.getMessage()).append("</p>");
			exception = exception.getCause();//exception 발생한 근본적인 원인을 리턴한다.
		
		}
		request.setAttribute("msg", msg.toString());
		int code = (int) request.getAttribute("javax.servlet.error.status_code");
		System.out.println(code);
		//System.out.println(msg.toString());
		
			RequestDispatcher rd = request.getRequestDispatcher("error/404.jsp");
			rd.forward(request, response);
			//return "페이지명";
	}

}
