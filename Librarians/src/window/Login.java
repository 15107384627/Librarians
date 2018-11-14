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
		
	
	
	private JPanel jp,jp1, jp2, jp3;	//4�����
	
	private JLabel jlb,jlb1,jlb2;		//3����ǩ
	
	private JButton btn_ok,btn_cancel;  //������ť
	
	private JTextField tf_user;			//�����ı���
	
	private JPasswordField pf_pass;		//���������

	

	public Login() {
		UIUtil.setUIFont(new FontUIResource("΢���ź�", Font.BOLD, 15));//��������
		initComponents();														//���ó�ʼ������
	}

	// ��ʼ�����
	private void initComponents() {
		
		jp  = new JPanel();		//����
		jp1 = new JPanel();		//����
		jp2 = new JPanel();		//����
		jp3 = new JPanel();		//����
		jlb = new JLabel("ͼ�����ϵͳ�û��������");	//��ǩ
		jlb1 = new JLabel("�˺�");			//��ǩ
		jlb2 = new JLabel("����");			//��ǩ
		tf_user = new JTextField(8);		//�˺������
		pf_pass = new JPasswordField(8);	//���������
		btn_ok = new JButton("����");			//ȷ����ť
		btn_cancel = new JButton("ע��"); 	//ע�ᰴť
		btn_ok.setBorderPainted(false);		//��ť����Ϊ͸��
		btn_cancel.setBorderPainted(false);	//��ť����Ϊ͸��
		
		setTitle("ͼ�����ϵͳ�û�����");  		//����
		setIconImage("images/log.png");		//logͼƬ
		setLayout(new GridLayout(4,1));		//����
		
		
		jp.add(jlb);
		add(jp);							//��������1
		
		jp1.add(jlb1);
		tf_user.setBorder(new LoginTextFieldBorder());
		jp1.add(tf_user);
		add(jp1);							//��������2
		
		jp2.add(jlb2);
		pf_pass.setBorder(new LoginTextFieldBorder());
		jp1.add(pf_pass);
		jp2.add(pf_pass);
		add(jp2);							//��������3
		
		jp3.add(btn_ok);
		jp3.add(btn_cancel);				//��������4
		add(jp3);

		btn_ok.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				btn_okActionPerformed(e);
			}
		});																//��ӵ���¼�


		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_cancelActionPerformed(e);
			}
		});																//��ӵ���¼�

		setSize(250, 200);							//���ô��ڴ�С
		setLocationRelativeTo(getOwner());			//���ô򿪺����
		setResizable(false);						//��ʾ���ڲ��ɸı�
		setVisible(true);							//��ʾ����
		
	}

	private void setIconImage(String strPath) {
		Image icon = Toolkit.getDefaultToolkit().getImage(strPath); 
	    setIconImage(icon); 						//logͼƬ
		
	}

	// "ȷ��"��ť��Ӧ�¼�
	private void btn_okActionPerformed(ActionEvent e) {
		String user = tf_user.getText(); // ����û���
		String pass = pf_pass.getText(); // �������
		String username = "";
		int is_admin;

		// δ�����û���
		if (user.equals("")) {
			JOptionPane.showMessageDialog(this, "�û���������Ϊ�գ�");
			return;
		}

		try {
			// �����ݿ��в�ѯ
			String sqlStr = "select * from user where name=" + "'" + user
					+ "' and pass=" + "'" + pass + "'";
			ResultSet result = BaseDao.executeQuery(sqlStr);
			if (result.next()) {
				username = result.getString("name");
				is_admin = result.getInt("is_admin");
				BaseDao.close();
			} else {
				JOptionPane.showMessageDialog(this, "�û��������벻��ȷ!");
				BaseDao.close();
				return;
			}

			GlobalVar.login_user = username; // ��¼��ǰ�û�

			// ����������
			Main main = new Main();
			main.setPurView((byte) is_admin);
			this.dispose();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// "ȡ��"��ť��Ӧ�¼�
	private void btn_cancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	public static void main(String args[]) {
		(new Login()).show();
	}
}