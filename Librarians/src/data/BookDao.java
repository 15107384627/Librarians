package data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.BookEntity;

public class BookDao {
	//����ͼ���ţ���õ���ͼ��ʵ��
	public static BookEntity selectBook(String id) {
		String sql = "select *  from book where id='" + id +"'";
		ResultSet rs = BaseDao.executeQuery(sql);
		BookEntity book = null;
		try {
			if (rs.next()) {
				book = new BookEntity();
				book.setId(rs.getString("id"));
				book.setType(rs.getString("type"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setTranslator(rs.getString("translator"));
				book.setPublisher(rs.getString("publisher"));
				book.setPublish_time(rs.getDate("publish_time"));
				book.setPrice(rs.getDouble("price"));
				book.setStock(rs.getInt("stock"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return book;
	}
	
	//�������sql����ͼ��ʵ���б�
	public static List selectBookList(String sql) {
		List list = new ArrayList();
		ResultSet rs = BaseDao.executeQuery(sql);
		try {
			while (rs.next()) {
				BookEntity book = new BookEntity();
				book.setId(rs.getString("id"));
				book.setType(rs.getString("type"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setTranslator(rs.getString("translator"));
				book.setPublisher(rs.getString("publisher"));
				book.setPublish_time(rs.getDate("publish_time"));
				book.setPrice(rs.getDouble("price"));
				book.setStock(rs.getInt("stock"));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
}
