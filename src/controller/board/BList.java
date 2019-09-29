package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BDao;
import model.dto.BDto;
import test.PageMaker;

public class BList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BDao dao = BDao.getInstance();
		//��ü���� ������ ��� �ִ��� Ȯ��
		int count = dao.count();
		// ����¡�� ����  
		int currentPage = 1;
		System.out.println(request.getParameter("currentPage"));
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		PageMaker page = new PageMaker(count, currentPage);
		int start = page.getPageStart();
		int end = page.getPageEnd();

		ArrayList<BDto> dtos = dao.list(start, end);
		request.setAttribute("page", page);
		request.setAttribute("list", dtos);
		request.getRequestDispatcher("list").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
