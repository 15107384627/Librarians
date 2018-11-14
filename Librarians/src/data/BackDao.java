package data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.BackEntity;
import entity.BorrowEntity;

public class BackDao {
	//���ݻ����ţ���õ���ʵ��
	public static BackEntity selectBack(String id) {
		String sql = "select *  from back where id='" + id +"'";
		ResultSet rs = BaseDao.executeQuery(sql);
		BackEntity back = null;
		try {
			if (rs.next()) {
				back = new BackEntity();
				back.setId(rs.getInt("id"));
				back.setBorrow_id(rs.getInt("borrow_id"));
				back.setBack_time(rs.getTimestamp("back_time"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return back;
	}
	//�������sql���Ľ����¼ʵ���б�
	public static List selectBackList(String sql) {
		List list = new ArrayList();
		ResultSet rs = BaseDao.executeQuery(sql);
		try {
			while (rs.next()) {
				BackEntity back = new BackEntity();
				back.setId(rs.getInt("id"));
				back.setBorrow_id(rs.getInt("borrow_id"));
				back.setBack_time(rs.getTimestamp("back_time"));
				list.add(back);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
	//ִ��
	public static BackEntity UpdateBack(String sql) {
		ResultSet rs = BaseDao.executeQuery(sql);
		BackEntity back = null;
		try {
			if (rs.next()) {
				back = new BackEntity();
				back.setId(rs.getInt("id"));
				back.setBorrow_id(rs.getInt("borrow_id"));
				back.setBack_time(rs.getTimestamp("back_time"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return back;	
	}
}
