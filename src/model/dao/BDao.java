package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.dto.BDto;
import model.dto.CDto;

public class BDao {
	private Connection conn;
	private PreparedStatement pStmt;
	private ResultSet result;

	private static BDao instance = new BDao();

	private BDao() {
		connection();
	}

	private void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BDao getInstance() {
		return instance;
	}

	public void write(String bName, String bTitle, String bContent) {
		try {
			String sql = "insert into board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (boardSeq.nextval, ?, ?, ?, 0, boardSeq.currval, 0, 0 )";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, bName);
			pStmt.setString(2, bTitle);
			pStmt.setString(3, bContent);
			pStmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public ArrayList<BDto> list(int start, int end) {
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		try {
			String sql = "select * from ( select A.*, rownum as rn from ( select * from board order by bGroup desc, bStep asc) A ) where rn between ? and ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, start);
			pStmt.setInt(2, end);
			result = pStmt.executeQuery();

			while (result.next()) {
				int bId = result.getInt("bId");
				String bName = result.getString("bName");
				String bTitle = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");

				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public BDto contentView(String strID) {
		upHit(strID);
		BDto dto = null;
		try {
			String sql = "select * from board where bId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(strID));
			result = pStmt.executeQuery();

			if (result.next()) {
				int bId = result.getInt("bId");
				String bName = result.getString("bName");
				String bTitle = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");

				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public void modify(String bId, String bName, String bTitle, String bContent) {
		try {
			String sql = "update board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, bName);
			pStmt.setString(2, bTitle);
			pStmt.setString(3, bContent);
			pStmt.setInt(4, Integer.parseInt(bId));
			pStmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void delete(String bId) {
		try {
			String sql = "delete from board where bId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(bId));
			pStmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("포링키 걸려서 못지웁니다.");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public BDto replyView(String str) {
		BDto dto = null;
		try {
			String sql = "select * from board where bId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(str));
			result = pStmt.executeQuery();

			if (result.next()) {
				int bId = result.getInt("bId");
				String bName = result.getString("bName");
				String bTitle = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");

				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {
		replyShape(bGroup, bStep);
		try {
			String sql = "insert into board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (boardSeq.nextval, ?, ?, ?, ?, ?, ?)";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, bName);
			pStmt.setString(2, bTitle);
			pStmt.setString(3, bContent);
			pStmt.setInt(4, Integer.parseInt(bGroup));
			pStmt.setInt(5, Integer.parseInt(bStep) + 1);
			pStmt.setInt(6, Integer.parseInt(bIndent) + 1);
			pStmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void replyShape(String strGroup, String strStep) {
		try {
			String sql = "update board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(strGroup));
			pStmt.setInt(2, Integer.parseInt(strStep));
			pStmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void upHit(String bId) {
		try {
			String sql = "update board set bHit = bHit + 1 where bId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, bId);
			pStmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public List<BDto> searchBoard(String... strs) {
		List<BDto> dtos = null;
		try {
			String sql = "";
			if (strs.length == 2) {
				sql = "select * from (select * from board  where  " + strs[0]
						+ " like ? ) order by bGroup desc, bStep asc";
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, "%" + strs[1] + "%");
			} else {
				sql = "select * from board";
				pStmt = conn.prepareStatement(sql);
			}
			result = pStmt.executeQuery();
			dtos = new ArrayList<BDto>();
			while (result.next()) {
				int bId = result.getInt("bId");
				String bName = result.getString("bName");
				String bTitle = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");

				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public void writeComment(String bId, String cName, String cContent) {
		String sql = "insert into comments (cId, cName, cContent, cGroup, cGroup2, cStep, cIndent) values (commentsseq.nextval, ?, ?, ?,commentsseq.currval, 0, 0)";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, cName);
			pStmt.setString(2, cContent);
			pStmt.setInt(3, Integer.parseInt(bId));
			pStmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public List<CDto> contentView2(String bId) {

		List<CDto> dtos = new ArrayList<CDto>();
		try {
			String sql = "select * from comments where cGroup= ? order by cGroup2 asc, cStep asc";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(bId));
			result = pStmt.executeQuery();

			while (result.next()) {
				int cId = result.getInt("cId");
				String cName = result.getString("cName");
				String cContent = result.getString("cContent");
				Timestamp cDate = result.getTimestamp("cDate");
				int cGroup = result.getInt("cGroup");
				int cGroup2 = result.getInt("cGroup2");
				int cStep = result.getInt("cStep");
				int cIndent = result.getInt("cIndent");

				CDto dto = new CDto(cId, cName, cContent, cDate, cGroup, cGroup2, cStep, cIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public CDto reCommentView(String str) {

		CDto dto = null;
		try {
			String sql = "select * from comments where cId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(str));
			result = pStmt.executeQuery();

			if (result.next()) {
				int cId = result.getInt("cId");
				String cName = result.getString("cName");
				String cContent = result.getString("cContent");
				Timestamp cDate = result.getTimestamp("cDate");
				int cGroup = result.getInt("cGroup");
				int cGroup2 = result.getInt("cGroup2");
				int cStep = result.getInt("cStep");
				int cIndent = result.getInt("cIndent");

				dto = new CDto(cId, cName, cContent, cDate, cGroup, cGroup2, cStep, cIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public void reComment(String cId, String cName, String cContent, String cGroup, String cGroup2, String cStep,
			String cIndent) {
		reCommentShape(cGroup2, cStep);
		try {
			String sql = "insert into comments (cId, cName, cContent, cGroup, cGroup2, cStep, cIndent) values (commentsSeq.nextval, ?, ?, ?, ?, ?, ?)";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, cName);
			pStmt.setString(2, cContent);
			pStmt.setInt(3, Integer.parseInt(cGroup));
			pStmt.setInt(4, Integer.parseInt(cGroup2));
			pStmt.setInt(5, Integer.parseInt(cStep) + 1);
			pStmt.setInt(6, Integer.parseInt(cIndent) + 1);
			pStmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void reCommentShape(String strGroup2, String strStep) {
		try {
			String sql = "update comments set cStep = cStep + 1 where cGroup2 = ? and cStep > ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(strGroup2));
			pStmt.setInt(2, Integer.parseInt(strStep));
			pStmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public int count() {
		int resultCount = 0;
		try {
			String sql = "select count(*) from board";
			pStmt = conn.prepareStatement(sql);
			result = pStmt.executeQuery();
			if (result.next()) {
				resultCount = result.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultCount;
	}

}
