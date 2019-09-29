package controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDao;
import model.dto.MemberDto;

public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		MemberDto dto = new MemberDto(id, pw, name);

		response.setCharacterEncoding("EUC-KR");
		MemberDao dao = MemberDao.getInstance();
		if (dao.confirmId(dto.getId())) {
			request.setAttribute("message", "알림창 : 아이디가 이미 존재 합니다. 다시 가입하세요.");
			request.getRequestDispatcher("join").forward(request, response);
		} else {
			if (dao.insertMember(dto)) {
				request.setAttribute("id", dto.getId());
				request.setAttribute("message", "알림창 : 회원가입이 성공하였습니다.");
				request.getRequestDispatcher("login").forward(request, response);
			} else {
				request.setAttribute("message", "알림창 : 회원가입이 실패 하였습니다. 다시 가입하세요.");
				request.getRequestDispatcher("login").forward(request, response);
			}
		}
	}
}
