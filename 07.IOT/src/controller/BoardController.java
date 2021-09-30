package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardPage;
import board.BoardServiceImpl;
import board.BoardVO;
import common.PageVO;
import customer.CustomerServiceImpl;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	BoardServiceImpl boService = new BoardServiceImpl();
	BoardPage page = new BoardPage();
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	   String url = req.getServletPath();
   		RequestDispatcher rd = req.getRequestDispatcher("error/404.jsp");
   		if (url.equals("/list.bo")) {
   			String search = req.getParameter("search");
   			String keyword = req.getParameter("keyword");
   			int curPage = req.getParameter("curPage") == null ? 1 : Integer.parseInt(req.getParameter("curPage"));
			page.setSearch(search);
			page.setKeyword(keyword);
			System.out.println(page.getKeyword());
   			page.setCurPage(curPage)	;
			
			req.setAttribute("page", boService.board_list(page));
			rd = req.getRequestDispatcher("board/list.jsp");
			rd.forward(req, resp);
   			
		}else if(url.equals("/detail.bo")) {
			rd = req.getRequestDispatcher("board/detail.jsp");
			int id = Integer.parseInt( req.getParameter("id"));
			req.setAttribute("vo", boService.board_view(id));
			rd.forward(req, resp);
		}else if(url.equals("/new.bo")) {
			rd = req.getRequestDispatcher("board/new.jsp");
			rd.forward(req, resp);
		}else if(url.equals("/insert.bo")) {
			req.setCharacterEncoding("utf-8");
			
			BoardVO vo = new BoardVO();
			vo.setId(Integer.parseInt( req.getParameter("id")));
			vo.setTitle(req.getParameter("title"));
			vo.setContent(req.getParameter("content"));
			vo.setWritter(req.getParameter("writter"));		
			boService.board_insert(vo);
			rd = req.getRequestDispatcher("/list.bo");
			rd.forward(req, resp);
		}
   			
    }

}
