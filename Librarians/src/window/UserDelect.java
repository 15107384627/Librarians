package window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import data.BaseDao;

public class UserDelect extends JFrame{
	private JPanel dialogPane;

	private JPanel contentPanel;

	private JLabel lb_username;

	private JTextField tf_username;

	private JButton btn_delect;

	private JButton btn_close;

	private JPanel buttonBar;

	public UserDelect() {
		initComponents();
	}

	private void initComponents() {
		
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		lb_username = new JLabel();		//账号
		tf_username = new JTextField();	//账号
		buttonBar = new JPanel();	
		btn_delect = new JButton();		
		btn_close = new JButton();

		setTitle("删除用户");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		{
			dialogPane.setBorder(new EmptyBorder(2, 2, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			{
				contentPanel.setLayout(new GridLayout(1, 2, 6, 6));

				lb_username.setText("账号：");
				lb_username.setHorizontalAlignment(SwingConstants.LEFT);
				contentPanel.add(lb_username);
				contentPanel.add(tf_username);
				
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[] {
						0, 85, 80 };
				((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[] {
						1.0, 0.0, 0.0 };

				btn_delect.setText("确定");
				btn_delect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_delectActionPerformed(e);
					}
				});
				buttonBar.add(btn_delect, new GridBagConstraints(1, 0, 1, 1, 0.0,
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
		setSize(260, 110);
		setLocationRelativeTo(getOwner());
		show();
	}

	private void btn_delectActionPerformed(ActionEvent e) {
		// 获取用户输入信息
		String username = tf_username.getText();
		String sql= "delete from user where name='"+username+"';";
		int i = BaseDao.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "删除成功");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "删除失败");
			dispose();
		}


	}
	private void btn_closeActionPerformed(ActionEvent e) {
		dispose();
	}
}
