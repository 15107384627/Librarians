package window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import data.BaseDao;
import util.Constant;

public class UserAdd extends JFrame{
	private JPanel dialogPane;

	private JPanel contentPanel;

	private JLabel lb_username;
	
	private JLabel lb_Determine_pass;
	
	private JTextField tf_Determine_pass;

	private JTextField tf_username;

	private JLabel lb_password;

	private JTextField tf_password;


	private JPanel buttonBar;

	private JButton btn_save;

	private JButton btn_close;

	public UserAdd() {
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		lb_username = new JLabel();
		tf_username = new JTextField();
		
		lb_password = new JLabel();
		tf_password = new JTextField();
		
		lb_Determine_pass=new JLabel();
		tf_Determine_pass= new JTextField();
		
		buttonBar = new JPanel();
		btn_save = new JButton();
		btn_close = new JButton();

		setTitle("添加用户");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		{
			dialogPane.setBorder(new EmptyBorder(5, 4, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			{
				contentPanel.setLayout(new GridLayout(3, 1, 0, 0));

				lb_username.setText("账号：");
				lb_username.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_username);
				contentPanel.add(tf_username);
				lb_password.setText("密码：");
				lb_password.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_password);
				contentPanel.add(tf_password);	
				lb_Determine_pass.setText("确认密码：");
				lb_Determine_pass.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_Determine_pass);
				contentPanel.add(tf_Determine_pass);
				
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[] {
						0, 85, 80 };
				((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[] {
						1.0, 0.0, 0.0 };

				btn_save.setText("确定");
				btn_save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_saveActionPerformed(e);
					}
				});
				buttonBar.add(btn_save, new GridBagConstraints(1, 0, 1, 1, 0.0,
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
		setSize(300, 160);
		setLocationRelativeTo(getOwner());
		show();
	}

	private void btn_saveActionPerformed(ActionEvent e) {
		// 获取用户输入信息
		String username = tf_username.getText();
		
		String password = tf_password.getText();
		
		String Determine_pass=tf_Determine_pass.getText();
		System.out.println(password+Determine_pass);
		if(password.equals(Determine_pass)) {
			String sql= "insert into user(name,pass) values('"
					+ username
					+ "','"
					+ password
					+ "');";
					
			int i = BaseDao.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "添加成功");
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
				dispose();
			}
		}else {
			JOptionPane.showMessageDialog(null, "2次输入的密码不相同");
		}


	}
	private void btn_closeActionPerformed(ActionEvent e) {
		dispose();
	}

}
