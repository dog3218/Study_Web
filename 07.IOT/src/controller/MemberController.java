package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberVo;
import member.MemberServiceImpl;
import member.MemberVO;

@WebServlet(urlPatterns = {   "/login"      ,       "/iotlogin"  ,  "/logout" ,  "/join"  ,      "/id_check" , "/iotjoin" })
public class MemberController extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("로그인 화면으로 이동중입니다.");
		//System.out.println(req.getServletPath());
		RequestDispatcher rd;
		if(req.getServletPath().equals("/login")) {
			rd = req.getRequestDispatcher("member/login.jsp");
			rd.forward(req, res);
		}else if(req.getServletPath().equals("/iotlogin")) {
			login(req, res);
		}else if(req.getServletPath().equals("/logout")) {
			HttpSession session = req.getSession();
			session.removeAttribute("logininfo");
			res.sendRedirect("home");
		}else if(req.getServletPath().equals("/join")) {
			rd = req.getRequestDispatcher("member/join.jsp");
			rd.forward(req, res);
		}else if(req.getServletPath().equals("/id_check")){
			id_check(req, res);
		}else if (req.getServletPath().equals("/iotjoin")) {
			req.setCharacterEncoding("UTF-8");
			/*System.out.println(req.getParameter("name"));
			System.out.println(req.getParameter("id"));
			System.out.println(req.getParameter("pw"));
			System.out.println(req.getParameter("pw_chk"));
			System.out.println(req.getParameter("gender"));
			System.out.println(req.getParameter("email"));*/
			join(req, res);
		}
	}
	
	MemberServiceImpl service = new MemberServiceImpl();//IV
	private void join(HttpServletRequest req, HttpServletResponse res) {
		MemberVO vo = new MemberVO();
		vo.setNAME(req.getParameter("name"));
		vo.setID(req.getParameter("id"));
		vo.setGENDER(req.getParameter("gender"));
		vo.setPW(req.getParameter("pw"));
		vo.setEMAIL(req.getParameter("email"));
		boolean result = service.member_join(vo);
		if(result) {
		try {
			res.sendRedirect(req.getContextPath()+"/home");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
	}
	
	private void id_check(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = (req.getParameter("id")+"");
		boolean result = service.member_id_check(id);
		/*System.out.println(result);*/
		PrintWriter out = res.getWriter();
		out.print(result);
		
	}
	private void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//Mybatis를 이용하여 로그인을 처리할 수 있는 로직을 호출
		HashMap<String , String> map = new HashMap<>();
		map.put("id", req.getParameter("id")+"");
		map.put("pw", req.getParameter("pw")+"");
		MemberVO vo = service.member_login(map);//map을 만들어야함
		
		//Session(로그인, 장바구니 등)
		//사용자가 인터넷을 종료, Tomcat서버를 다시 시작하면 정보가 remove됨
		HttpSession session = req.getSession();
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		//DB에서 정보를 조회해서 1건이라도 있으면 회원이다ㅣ
		session.setAttribute("logininfo", vo);
		boolean rtnBool = vo == null ? false : true;
		out.print(rtnBool);
	}
}
