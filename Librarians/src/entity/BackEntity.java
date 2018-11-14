package entity;

import java.util.Date;

public class BackEntity {
	int id;
	int borrow_id;
	Date back_time;
	String is_overdue;
	int reader_id;
	String book_id;
	@Override
	public String toString() {
		return "BackEntity [id=" + id + ", borrow_id=" + borrow_id + ", back_time=" + back_time + ", is_overdue="
				+ is_overdue + ", reader_id=" + reader_id + ", book_id=" + book_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBorrow_id() {
		return borrow_id;
	}
	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
	}
	public Date getBack_time() {
		return back_time;
	}
	public void setBack_time(Date back_time) {
		this.back_time = back_time;
	}
	public String getIs_overdue() {
		return is_overdue;
	}
	public void setIs_overdue(String is_overdue) {
		this.is_overdue = is_overdue;
	}
	public int getReader_id() {
		return reader_id;
	}
	public void setReader_id(int reader_id) {
		this.reader_id = reader_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
}
