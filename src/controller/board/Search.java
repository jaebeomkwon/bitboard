package controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BDao;
import model.dto.BDto;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		String opt=  request.getParameter("opt");
		String keywork=  request.getParameter("keywork");
		if(keywork==null) {
			keywork="";
		}else {
			keywork.trim();
		}
		List<BDto> dtos = null;
		BDao dao = BDao.getInstance();
		if(keywork.isEmpty()) {
			response.sendRedirect("BList.do");
			return;
		}else {
			dtos = dao.searchBoard(opt,keywork);
		}
		request.setAttribute("list", dtos);
			
		request.getRequestDispatcher("list").forward(request, response);

	}
}
