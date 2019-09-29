package controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.BDao;

public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();
		String cName = (String)session.getAttribute("id");
		if(cName==null) {
			request.setAttribute("message","알림창 : 로그인을 하지 않아 댓글을 달지 못하였습니다.");
			request.getRequestDispatcher("login").forward(request, response);
			return;
		}
		String bId = request.getParameter("bId");
		String cContent = request.getParameter("cContent");
		
		BDao dao = BDao.getInstance();
		dao.writeComment(bId, cName, cContent);
		
		response.sendRedirect("BList.do");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
