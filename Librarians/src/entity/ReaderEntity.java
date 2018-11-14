package entity;

import java.sql.Date;

public class ReaderEntity {
	private String id;	//读者编号
	private String name;	//读者姓名
	private String sex;	//性别
	private String type;	//读者类别
	private String max_num;	//最多可借数量
	private int days_num;	//最大可借天数
	private int has_borrow;
	@Override
	public String toString() {
		return "ReaderEntity [id=" + id + ", name=" + name + ", sex=" + sex + ", type=" + type + ", max_num=" + max_num
				+ ", days_num=" + days_num + ", has_num=" + has_borrow + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMax_num() {
		return max_num;
	}
	public void setMax_num(String max_num) {
		this.max_num = max_num;
	}
	public int getDays_num() {
		return days_num;
	}
	public void setDays_num(int days_num) {
		this.days_num = days_num;
	}
	public int getHas_borrow() {
		return has_borrow;
	}
	public void setHas_borrow(int has_borrow) {
		this.has_borrow = has_borrow;
	}
}
