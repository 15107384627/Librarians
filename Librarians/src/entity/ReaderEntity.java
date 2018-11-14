package entity;

import java.sql.Date;

public class ReaderEntity {
	private String id;	//���߱��
	private String name;	//��������
	private String sex;	//�Ա�
	private String type;	//�������
	private String max_num;	//���ɽ�����
	private int days_num;	//���ɽ�����
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
