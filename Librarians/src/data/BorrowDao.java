package data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.BookEntity;
import entity.BorrowEntity;

public class BorrowDao {
	//根据借书编号，获得单个实体
	public static BorrowEntity selectBorrow(String id) {
		String sql = "select *  from borrow where id='" + id +"'";
		ResultSet rs = BaseDao.executeQuery(sql);
		BorrowEntity borrow = null;
		try {
			if (rs.next()) {
				borrow = new BorrowEntity();
				borrow.setId(rs.getInt("id"));
				borrow.setBook_id(rs.getString("book_id"));
				borrow.setReader_id(rs.getInt("reader_id"));
				borrow.setBorrowDate(rs.getTimestamp("borrow_date"));
				borrow.setBackDate(rs.getTimestamp("Back_date"));
				borrow.setIs_back(rs.getInt("Is_back"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return borrow;
	}
	//获得满足sql语句的借书记录实体列表
	public static List selectBorrowList(String sql) {
		List list = new ArrayList();
		ResultSet rs = BaseDao.executeQuery(sql);
		try {
			while (rs.next()) {
				BorrowEntity borrow = new BorrowEntity();
				borrow.setId(rs.getInt("id"));
				borrow.setBook_id(rs.getString("book_id"));
				borrow.setReader_id(rs.getInt("reader_id"));
				borrow.setBorrowDate(rs.getTimestamp("borrow_date"));
				borrow.setBackDate(rs.getTimestamp("Back_date"));
				borrow.setIs_back(rs.getInt("Is_back"));
				list.add(borrow);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
}
