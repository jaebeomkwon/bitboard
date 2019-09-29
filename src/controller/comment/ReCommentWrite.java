package controller.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.BDao;

public class ReCommentWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String cId = request.getParameter("cId");
		HttpSession session = request.getSession();
		String cName = (String)session.getAttribute("id");
		if(cName==null) {
			request.setAttribute("message","알림창 : 로그인을 하지 않아 댓글을 달지 못하였습니다.");
			request.getRequestDispatcher("login").forward(request, response);
			return;
		}
		String cContent = request.getParameter("cContent");
		String cGroup = request.getParameter("cGroup");
		String cGroup2 = request.getParameter("cGroup2");
		String cStep = request.getParameter("cStep");
		String cIndent = request.getParameter("cIndent");
		
		BDao dao = BDao.getInstance();
		dao.reComment(cId, cName, cContent, cGroup, cGroup2, cStep, cIndent);
		
		request.getRequestDispatcher("BList.do").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
