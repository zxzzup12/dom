package kr.ac.sihnhanin.esp;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class HahahanServlet extends HttpServlet {
	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/plain");
	resp.getWriter().println("calle HahahanServlet.doPost() ");
	resp.getWriter().println("이름: " + req.getParameter("name") +"");
	resp.getWriter().println("학번 : "+ req.getParameter("id") +"");
	resp.getWriter().println("전화번호 : "+ req.getParameter("socialNumber") +"");
	resp.getWriter().println("메일주소 : "+ req.getParameter("t3") +"");
	resp.getWriter().println("카카오톡 아이디  : "+ req.getParameter("t4") +"");
	resp.getWriter().println(""+ req.getParameter("t5") +"");
	
	String t5=req.getParameter("t5");
	if(t5 != null)
	{
	resp.getWriter().println("팀장이 아님니다");
	}
	else
	{
	  resp.getWriter().println("팀장입니다");
	}
	
	resp.getWriter().println("GitHub : "+ req.getParameter("t6") +"");
	
	resp.getWriter().println("");
	}
}
