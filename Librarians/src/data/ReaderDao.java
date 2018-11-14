package data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.ReaderEntity;

public class ReaderDao {
	//根据读者编号，获得单个读者实体
	public static ReaderEntity selectReader(String id) {
		String sql = "select *  from reader where id='" + id +"'";
		ResultSet rs = BaseDao.executeQuery(sql);
		ReaderEntity reader = null;
		try {
			if (rs.next()) {
				reader = new ReaderEntity();
				reader.setId(rs.getString("id"));
				reader.setType(rs.getString("type"));
				reader.setName(rs.getString("name"));
				reader.setSex(rs.getString("sex"));
				reader.setMax_num(rs.getString("max_num"));
				reader.setDays_num(rs.getInt("days_num"));
				reader.setHas_borrow(rs.getInt("has_borrow"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return reader;
	}
	
	//获得满足sql语句的读者实体列表
	public static List selectReaderList(String sql) {
		List list = new ArrayList();
		ResultSet rs = BaseDao.executeQuery(sql);
		ReaderEntity reader = null;
		try {
			while (rs.next()) {
				reader = new ReaderEntity();
				reader.setId(rs.getString("id"));
				reader.setType(rs.getString("type"));
				reader.setName(rs.getString("name"));
				reader.setSex(rs.getString("sex"));
				reader.setMax_num(rs.getString("max_num"));
				reader.setDays_num(rs.getInt("days_num"));
				reader.setHas_borrow(rs.getInt("has_borrow"));
				list.add(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
}
