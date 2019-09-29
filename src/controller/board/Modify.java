package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.BDao;

public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		if(id==null||!(bName.equals(id))) {
			request.setAttribute("message","알림창 : 로그인을 하지 않았거나 아이디가 달라 글수정를 하지 못하였습니다.");
			request.getRequestDispatcher("login").forward(request, response);
			return;
		}
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = BDao.getInstance();
		dao.modify(bId, bName, bTitle, bContent);
		
		request.getRequestDispatcher("BList.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
