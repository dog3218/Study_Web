package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerServiceImpl;
import customer.CustomerVO;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	
	CustomerServiceImpl cusService = new CustomerServiceImpl();
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//System.out.println(cusService.customer_test());
		String url = req.getServletPath();
		RequestDispatcher rd = req.getRequestDispatcher("error/404.jsp");
		if(url.equals("/list.cu")) {
			rd = req.getRequestDispatcher("customer/list.jsp");
			req.setAttribute("list", cusService.customer_list());
			rd.forward(req, res);
			
		}else if(url.equals("/detail.cu")){
			rd = req.getRequestDispatcher("customer/detail.jsp");
			int id = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("vo", cusService.customer_detail(id));
			rd.forward(req, res);
		}else if(url.contentEquals("/new.cu")){
			rd = req.getRequestDispatcher("customer/new.jsp");
					rd.forward(req, res);
		}else if(url.contentEquals("/insert.cu")){
			CustomerVO vo = new CustomerVO();
			req.setCharacterEncoding("utf-8");
			vo.setName(req.getParameter("name"));
			vo.setGender(req.getParameter("gender"));
			vo.setEmail(req.getParameter("email"));
			vo.setPhone(req.getParameter("phone"));
			
			cusService.customer_insert(vo);
			rd = req.getRequestDispatcher("member/login.jsp");
			rd.forward(req, res);
		}else if(url.contentEquals("/modify.cu")){
			int id = Integer.parseInt(req.getParameter("id"));
			rd = req.getRequestDispatcher("customer/modify.jsp");
			req.setAttribute("vo", cusService.customer_detail(id));
			rd.forward(req, res);
			
		}else if(url.contentEquals("/update.cu")){
			/*System.out.println(Integer.parseInt(req.getParameter("id"))); 아이디 값 넘어오는 거 확인*/
			CustomerVO vo = new CustomerVO();
			req.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
			vo.setId(id);
			vo.setName(req.getParameter("name"));
			vo.setGender(req.getParameter("gender"));
			vo.setEmail(req.getParameter("email"));
			vo.setPhone(req.getParameter("phone"));
			cusService.customer_update(vo);
			rd = req.getRequestDispatcher("/list.cu");
			rd.forward(req, res);
			
		}else if(url.contentEquals("/delete.cu")) {
			int id = Integer.parseInt(req.getParameter("id"));
			cusService.customer_delete(id);
			rd = req.getRequestDispatcher("/list.cu");
			rd.forward(req, res);
		}else {
			rd.forward(req, res);
		}
	}

}
