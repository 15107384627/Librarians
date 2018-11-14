package window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import data.BackDao;
import data.BorrowDao;
import entity.BackEntity;
import entity.BorrowEntity;

public class BackQuery extends JFrame {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd "); 
	private JTable table;

	private JTextField tf_id;
	
	private String[] heads = { "还书id","读者id","还书日期" };
	
	private Object[][] getResult(List list) {
		Object[][] results = new Object[list.size()][heads.length];
		for (int i = 0; i < list.size(); i++) {
			BackEntity back = (BackEntity) list.get(i);
			results[i][0] = back.getId();
			results[i][1] = back.getBorrow_id();
			results[i][2] = sdf.format(back.getBack_time());
		}
		return results;
	}
	
	public BackQuery() {
		super();
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setTitle("还书记录查询");
		setBounds(100, 100, 593, 406);
		
		final JPanel panel_cx = new JPanel();
		getContentPane().add(panel_cx, BorderLayout.NORTH);
		
		panel_cx.setLayout(new GridLayout(1, 3));
		JLabel lb_name = new JLabel("还书编号：");
		lb_name.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_id = new JTextField();
		JButton btn_cx = new JButton("查询");
		btn_cx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_cxActionPerformed(e);
			}
		});
		panel_cx.add(lb_name);
		panel_cx.add(tf_id);
		panel_cx.add(btn_cx);

		final JPanel panel_2 = new JPanel();
		final BorderLayout borderLayout_1 = new BorderLayout();
		borderLayout_1.setVgap(5);
		panel_2.setLayout(borderLayout_1);
		panel_2.setBorder(new EmptyBorder(5, 10, 5, 10));
		getContentPane().add(panel_2);

		final JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		Object[][] results = getResult(BackDao.selectBackList("select *  from back"));
		table = new JTable(results, heads);
		TableColumn firsetColumn2 = table.getColumnModel().getColumn(2);
		firsetColumn2.setPreferredWidth(30);
		firsetColumn2.setMinWidth(120);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);

		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.setLayout(flowLayout);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
			}
		});
		button_1.setText("关闭");
		panel_1.add(button_1);

		setSize(400, 400);
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}

	private void btn_cxActionPerformed(ActionEvent e) {
		String id = tf_id.getText(); // 获取借书记录编号
		String sql = "select *  from back";
		if (id != null && id.length() > 0) {
			sql = "select * from back where id like '%" + id + "%'";
		}
		// 执行查询操作，将查询结果显示到界面
		Object[][] results = getResult(BackDao.selectBackList(sql));
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setDataVector(results, heads);
	}
}
