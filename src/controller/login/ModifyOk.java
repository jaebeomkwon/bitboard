package controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDao;
import model.dto.MemberDto;

public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();

		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		session.setAttribute("name", name);
		
		MemberDto dto = new MemberDto(pw, name);
		String id = (String)session.getAttribute("id");
		dto.setId(id);
		
		MemberDao dao = MemberDao.getInstance();
		if (dao.updateMember(dto)) {
			request.setAttribute("message", "정보가 수정되었습니다.");
			request.getRequestDispatcher("main").forward(request, response);
		} else {
			request.setAttribute("message", "정보 수정 실패 하였습니다.");
			request.getRequestDispatcher("modify").forward(request, response);
		}
	}
}
