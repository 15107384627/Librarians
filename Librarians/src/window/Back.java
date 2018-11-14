package window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.DateUtils;
import data.BackDao;
import data.BaseDao;
import data.BookDao;
import data.BorrowDao;
import data.ReaderDao;
import entity.BookEntity;
import entity.BorrowEntity;
import entity.ReaderEntity;

public class Back extends JFrame {
	private String is_str=null;
	
	private JPanel dialogPane;

	private JPanel contentPanel;

	private JLabel lb_book_id;
	
	private JLabel lb_borrow_id; //借书编号
	
	private JLabel lb_is_overdue; //是否逾期
	
	private JLabel lb_fine; //罚款

	private JTextField tf_book_id;
	
	private JTextField tf_borrow_id; //借书id输出框

	private JLabel lb_reader_id;

	private JTextField tf_reader_id;

	private JLabel lb_book_name;

	private JTextField tf_book_name;

	private JLabel lb_reader_name;

	private JTextField tf_reader_name;

	private JLabel lb_book_publisher;

	private JTextField tf_book_publisher;

	private JLabel lb_reader_type;

	private JTextField tf_reader_type;

	private JLabel lb_book_publish_time;

	private JTextField tf_book_publish_time;
	
	
	private JTextField tf_is_overdue;			//是否逾期
	
	private JTextField tf_fine;				//罚款

	private JLabel lb_reader_sex;
	
	private JLabel lb_layou;				//布局
	
	private JLabel lb_layou1;				//布局

	private JTextField tf_reader_sex;

	private JLabel lb_borrow;

	private JLabel lb_borrow_date;

	private JLabel lb_back;

	private JLabel lb_back_date;

	private JPanel buttonBar;

	private JButton btn_back;

	private JButton btn_close;

	public Back() {
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		lb_book_id = new JLabel();
		lb_borrow_id = new JLabel();
		lb_is_overdue = new JLabel();		//是否逾期
		lb_layou = new JLabel();		//布局
		lb_layou1 = new JLabel();		//布局
		lb_fine=new JLabel();			//罚款
		tf_fine = new JTextField();		//罚款
		tf_book_id = new JTextField();
		tf_borrow_id = new JTextField();
		lb_reader_id = new JLabel();
		tf_reader_id = new JTextField();
		lb_book_name = new JLabel();
		tf_book_name = new JTextField();
		lb_reader_name = new JLabel();
		tf_reader_name = new JTextField();
		lb_book_publisher = new JLabel();
		tf_book_publisher = new JTextField();
		lb_reader_type = new JLabel();
		tf_reader_type = new JTextField();
		lb_book_publish_time = new JLabel();
		tf_book_publish_time = new JTextField();
		tf_is_overdue=new JTextField();
		lb_reader_sex = new JLabel();
		tf_reader_sex = new JTextField();
		lb_borrow = new JLabel();
		lb_borrow_date = new JLabel();
		lb_back = new JLabel();
		lb_back_date = new JLabel();
		buttonBar = new JPanel();
		btn_back = new JButton();
		btn_close = new JButton();

		setTitle("还书");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			{
				contentPanel.setLayout(new GridLayout(8, 4, 6, 6));
				
				lb_borrow_id.setText("借书编号：");							//借书编号
				lb_borrow_id.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_borrow_id);		
				tf_borrow_id.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						tf_borrow_id(e);
					}
				});					
				contentPanel.add(tf_borrow_id);	
				
				contentPanel.add(lb_layou);		
				contentPanel.add(lb_layou1);	
				
				lb_book_id.setText("图书编号：");
				lb_book_id.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_book_id);

				tf_book_id.setEditable(false);
				contentPanel.add(tf_book_id);

				lb_reader_id.setText("用户编号：");
				lb_reader_id.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_reader_id);

				tf_reader_id.setEditable(false);
				contentPanel.add(tf_reader_id);

				lb_book_name.setText("图书名称：");
				lb_book_name.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_book_name);

				tf_book_name.setEnabled(false);
				contentPanel.add(tf_book_name);

				lb_reader_name.setText("用户姓名：");
				lb_reader_name.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_reader_name);

				tf_reader_name.setEnabled(false);
				contentPanel.add(tf_reader_name);

				lb_book_publisher.setText("出版社：");
				lb_book_publisher.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_book_publisher);

				tf_book_publisher.setEnabled(false);
				contentPanel.add(tf_book_publisher);

				lb_reader_type.setText("用户类别：");
				lb_reader_type.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_reader_type);

				tf_reader_type.setEnabled(false);
				contentPanel.add(tf_reader_type);

				lb_book_publish_time.setText("出版时间：");
				lb_book_publish_time
						.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_book_publish_time);

				tf_book_publish_time.setEnabled(false);
				contentPanel.add(tf_book_publish_time);

				lb_reader_sex.setText("性别：");
				lb_reader_sex.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_reader_sex);

				tf_reader_sex.setEnabled(false);
				contentPanel.add(tf_reader_sex);

				lb_borrow.setText("借书时间：");
				lb_borrow.setHorizontalAlignment(SwingConstants.RIGHT);
				lb_borrow.setForeground(SystemColor.blue);
				contentPanel.add(lb_borrow);

				lb_borrow_date.setHorizontalAlignment(SwingConstants.CENTER);
				lb_borrow_date.setForeground(SystemColor.desktop);
				contentPanel.add(lb_borrow_date);

				lb_back.setText("还书时间：");
				lb_back.setHorizontalAlignment(SwingConstants.RIGHT);
				lb_back.setForeground(SystemColor.blue);
				contentPanel.add(lb_back);

				lb_back_date.setHorizontalAlignment(SwingConstants.CENTER);
				lb_back_date.setForeground(SystemColor.desktop);
				contentPanel.add(lb_back_date);
				
				lb_is_overdue.setText("是否逾期：");							//是否逾期
				lb_is_overdue.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_is_overdue);

				tf_is_overdue.setEnabled(false);
				contentPanel.add(tf_is_overdue);

				lb_fine.setText("逾期天数：");							//是否逾期
				lb_fine.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_fine);

				tf_fine.setEnabled(false);
				contentPanel.add(tf_fine);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[] {
						0, 85, 80 };
				((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[] {
						1.0, 0.0, 0.0 };

				btn_back.setText("确定");
				btn_back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_backActionPerformed(e);
					}
				});
				buttonBar.add(btn_back, new GridBagConstraints(1, 0, 1, 1, 0.0,
						0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));

				btn_close.setText("关闭");
				btn_close.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_closeActionPerformed(e);
					}
				});
				buttonBar.add(btn_close, new GridBagConstraints(2, 0, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize(625, 400);
		setLocationRelativeTo(getOwner());
		show();
	}
	//图书信息
	private void tf_book_idKeyTyped(BookEntity book) {
			// 在界面上显示图书信息
			if (book != null) {
				tf_book_id.setText(book.getId());
				tf_book_name.setText(book.getName());
				tf_book_publisher.setText(book.getPublisher());
				tf_book_publish_time.setText(book.getPublish_time().toString());
				
			}
		}
	
	//读者信息
	private void tf_reader_idKeyTyped(ReaderEntity reader) {
			// 在界面上显示读者信息
			if (reader != null) {
				tf_reader_id.setText(reader.getId());
				tf_reader_name.setText(reader.getName());
				tf_reader_type.setText(reader.getType());
				tf_reader_sex.setText(reader.getSex());
				
			}
		}
	
	//借书编号
	private void tf_borrow_id(KeyEvent e) {
		if (e.getKeyChar() == '\n') {
			String id = tf_borrow_id.getText(); // 获取借书编号
			BorrowEntity borrow= BorrowDao.selectBorrow(id); // 提取指定编号的读者信息
			if(borrow!=null) {
				if(borrow.getIs_back()==1) {
					btn_back.setText("已还");
					btn_back.setEnabled(false);
				}else {
					btn_back.setText("确定");
					btn_back.setEnabled(true);
				}
				BookEntity book = BookDao.selectBook(borrow.getBook_id());		//图书查询
				ReaderEntity reader = ReaderDao.selectReader(String.valueOf(borrow.getReader_id()));	//读者查询
				tf_reader_idKeyTyped(reader);	//读者方法
				tf_book_idKeyTyped(book);			//图书方法
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				lb_borrow_date.setText(sdf.format(borrow.getBorrowDate()));//借书时间
				lb_back_date.setText(sdf.format(borrow.getBackDate()));//应还书时间
				Date date=new Date();	
				String dateString = sdf.format(date);
				Date borrowDate=null;
				Date backDate=null;
				try {
					borrowDate = sdf.parse(dateString);
					backDate=sdf.parse(sdf.format(borrow.getBackDate())); //应还书时间
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	//现在还书时间
				
				if(backDate.getTime()>borrowDate.getTime()) {
					tf_is_overdue.setText("否");
					is_str="否";
				}else {
					is_str="是";
					tf_is_overdue.setText("是");
					int day=(int) ((borrowDate.getTime()-backDate.getTime())/(24*60*60*1000));
					
					String moneyStr=String.valueOf(day);
					tf_fine.setText(moneyStr);
				}
			}else {
				JOptionPane.showMessageDialog(null, "未找到此借书编号", "错误", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void btn_backActionPerformed(ActionEvent e) {
		String id = tf_borrow_id.getText();
		int userId=-1;
		 int a = Integer.parseInt(id);
		// 拼sql语句
		String sql = "update borrow set is_back=1 where id='"+a+"'";
		// 执行数据库操作
		int i = BaseDao.executeUpdate(sql);
		if (i == 0) {
			JOptionPane.showMessageDialog(null, "还书失败");
			dispose();
		}else if(i == 1){
			String str="select reader_id from borrow where id="+a+";";
			ResultSet rs=BaseDao.executeQuery(str);
			try {
				while(rs.next()){
				    try {
						userId = rs.getInt(1);
						System.out.println(userId);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String strUp="update reader SET has_borrow=has_borrow-1 WHERE id="+userId+";";
			BaseDao.executeUpdate(strUp);
			JOptionPane.showMessageDialog(null, "还书成功");
			
			dispose();
		}
	}

	private void btn_closeActionPerformed(ActionEvent e) {
		dispose();
	}

}
