package window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import Beautify.LoginTextFieldBorder;
import util.GlobalVar;
import data.BaseDao;

public class Login extends JFrame {
		
	
	
	private JPanel jp,jp1, jp2, jp3;	//4个面板
	
	private JLabel jlb,jlb1,jlb2;		//3个标签
	
	private JButton btn_ok,btn_cancel;  //两个按钮
	
	private JTextField tf_user;			//输入文本框
	
	private JPasswordField pf_pass;		//输入密码框

	

	public Login() {
		UIUtil.setUIFont(new FontUIResource("微软雅黑", Font.BOLD, 15));//设置字体
		initComponents();														//调用初始化方法
	}

	// 初始化组件
	private void initComponents() {
		
		jp  = new JPanel();		//容器
		jp1 = new JPanel();		//容器
		jp2 = new JPanel();		//容器
		jp3 = new JPanel();		//容器
		jlb = new JLabel("图书管理系统用户登入界面");	//标签
		jlb1 = new JLabel("账号");			//标签
		jlb2 = new JLabel("密码");			//标签
		tf_user = new JTextField(8);		//账号输入框
		pf_pass = new JPasswordField(8);	//密码输入框
		btn_ok = new JButton("登入");			//确定按钮
		btn_cancel = new JButton("注册"); 	//注册按钮
		btn_ok.setBorderPainted(false);		//按钮设置为透明
		btn_cancel.setBorderPainted(false);	//按钮设置为透明
		
		setTitle("图书管理系统用户登入");  		//标题
		setIconImage("images/log.png");		//log图片
		setLayout(new GridLayout(4,1));		//布局
		
		
		jp.add(jlb);
		add(jp);							//容器布局1
		
		jp1.add(jlb1);
		tf_user.setBorder(new LoginTextFieldBorder());
		jp1.add(tf_user);
		add(jp1);							//容器布局2
		
		jp2.add(jlb2);
		pf_pass.setBorder(new LoginTextFieldBorder());
		jp1.add(pf_pass);
		jp2.add(pf_pass);
		add(jp2);							//容器布局3
		
		jp3.add(btn_ok);
		jp3.add(btn_cancel);				//容器布局4
		add(jp3);

		btn_ok.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				btn_okActionPerformed(e);
			}
		});																//添加点击事件


		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_cancelActionPerformed(e);
			}
		});																//添加点击事件

		setSize(250, 200);							//设置窗口大小
		setLocationRelativeTo(getOwner());			//设置打开后居中
		setResizable(false);						//显示窗口不可改变
		setVisible(true);							//显示窗口
		
	}

	private void setIconImage(String strPath) {
		Image icon = Toolkit.getDefaultToolkit().getImage(strPath); 
	    setIconImage(icon); 						//log图片
		
	}

	// "确定"按钮响应事件
	private void btn_okActionPerformed(ActionEvent e) {
		String user = tf_user.getText(); // 获得用户名
		String pass = pf_pass.getText(); // 获得密码
		String username = "";
		int is_admin;

		// 未输入用户名
		if (user.equals("")) {
			JOptionPane.showMessageDialog(this, "用户名不允许为空！");
			return;
		}

		try {
			// 在数据库中查询
			String sqlStr = "select * from user where name=" + "'" + user
					+ "' and pass=" + "'" + pass + "'";
			ResultSet result = BaseDao.executeQuery(sqlStr);
			if (result.next()) {
				username = result.getString("name");
				is_admin = result.getInt("is_admin");
				BaseDao.close();
			} else {
				JOptionPane.showMessageDialog(this, "用户名或密码不正确!");
				BaseDao.close();
				return;
			}

			GlobalVar.login_user = username; // 记录当前用户

			// 进入主界面
			Main main = new Main();
			main.setPurView((byte) is_admin);
			this.dispose();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// "取消"按钮响应事件
	private void btn_cancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	public static void main(String args[]) {
		(new Login()).show();
	}
}