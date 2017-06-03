package SuperMarket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class Personnel_Management extends JFrame {
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12;
	private JButton button1, button2, button3, button4;
	private JSplitPane splitpanel1;
	private JComboBox<String> comboBox1, comboBox2;
	private DefaultMutableTreeNode rootNode, childNode1, childNode2;
	private JTree tree;
	private JTextField textfield0,textfield1, textfield2, textfield3, textfieldA, textfieldB, textfieldC, textfieldD, textfield4,
			textfield5;
	private DefaultTableModel model;
	private JTable table;
	private Personnel_Bean personnel_bean;
	private JFrame frame;
	public Personnel_Management(JSplitPane splitpane) {
		Font s = new Font("", 28, 28);
		Font font = new Font("", 30, 32);
		Font font1 = new Font("", 20, 20);
		Color color = new Color(2);

		rootNode = new DefaultMutableTreeNode("人员管理");
		tree = new JTree(rootNode);
		tree.setFont(font1);
		textfield0 = new JTextField(10);
		textfield0.setFont(font1);
		textfield1 = new JTextField(10);
		textfield1.setFont(font1);
		textfield2 = new JTextField(10);
		textfield2.setFont(font1);
		textfield3 = new JTextField(10);
		textfield3.setFont(font1);
		textfield4 = new JTextField(10);
		textfield4.setFont(font1);
		textfield5 = new JTextField(10);
		textfield5.setFont(font1);
		textfieldA = new JTextField(10);
		textfieldA.setFont(font1);
		textfieldB = new JTextField(10);
		textfieldB.setFont(font1);
		textfieldC = new JTextField(10);
		textfieldC.setFont(font1);
		textfieldD = new JTextField(10);
		textfieldD.setFont(font1);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent arg0) {

				if (!tree.isSelectionEmpty()) {
					TreePath selectPaths = tree.getSelectionPath();
					Object path = selectPaths.getLastPathComponent();
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) path;
					String userObject = (String) node.getUserObject();
					repaint();
					if (userObject.equals("基本信息")) {
						panel5.removeAll();
						panel3 = new JPanel();
						panel4 = new JPanel();

						label4 = new JLabel("姓名   ");
						label4.setFont(font);
						label4.setForeground(color.red);
						label5 = new JLabel("年龄   ");
						label5.setFont(font);
						label5.setForeground(color.red);
						label6 = new JLabel("性别   ");
						label6.setFont(font);
						label6.setForeground(color.red);
						label7 = new JLabel("职务   ");
						label7.setFont(font);
						label7.setForeground(color.red);
						label8 = new JLabel("部门   ");
						label8.setFont(font);
						label8.setForeground(color.red);
						JLabel label9 = new JLabel("                                           ");
						label9.setFont(font1);
						panel3.add(label4);
						panel3.add(textfield1);
						panel3.add(label5);
						panel3.add(textfield2);
						panel3.add(label6);
						panel3.add(textfield3);
						panel3.add(label7);
						panel3.add(textfield4);
						panel3.add(label8);
						panel3.add(textfield5);
						panel3.add(label9);
						panel5.add(panel3);
						panel5.add(panel4);

						panel5.setLayout(new GridLayout(1, 2));
					} else if (userObject.equals("联系电话")) {
						panel5.removeAll();
						panel6 = new JPanel();
						panel7 = new JPanel();
						label9 = new JLabel("微信    ");
						label9.setFont(font);
						label9.setForeground(color.red);
						label10 = new JLabel(" 电话   ");
						label10.setFont(font);
						label10.setForeground(color.red);
						label11 = new JLabel("手机   ");
						label11.setFont(font);
						label11.setForeground(color.red);
						label12 = new JLabel(" E-mail ");
						label12.setFont(font);
						label12.setForeground(color.red);
						panel6.add(label9);
						panel6.add(textfieldA);
						panel6.add(label10);
						panel6.add(textfieldB);
						panel6.add(label11);
						panel6.add(textfieldC);
						panel6.add(label12);
						panel6.add(textfieldD);
						panel5.setLayout(new GridLayout(1, 2));
						panel5.add(panel6);
						panel5.add(panel7);

					}
				}
			}

		});
		childNode1 = new DefaultMutableTreeNode("基本信息");
		childNode2 = new DefaultMutableTreeNode("联系电话");
		rootNode.add(childNode1);
		rootNode.add(childNode2);

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel5 = new JPanel();
		label1 = new JLabel("部门  ");
		label1.setFont(font);
		label1.setForeground(color.BLUE);
		comboBox1 = new JComboBox<String>();
		comboBox1.setFont(font1);
		comboBox1.addItem("请输入部门信息");
		comboBox1.addItem("监察部");
		comboBox1.addItem("财务部");
		comboBox1.addItem("营销部");
		comboBox1.addItem("营运部");
		comboBox1.addItem("信息部");
		comboBox1.addItem("财务部");
		comboBox1.addItem("保卫部");

		label2 = new JLabel("   姓名  ");
		label2.setFont(font);
		label2.setForeground(color.BLUE);
		comboBox2 = new JComboBox<String>();
		comboBox2.setFont(font1);
		comboBox2.addItem("请输入姓名");
		Personnel_All_method pr = new Personnel_All_method();
		List<Personnel_Bean> bianli = pr.select_personnel();
		for (int i = 0; i < bianli.size(); i++) {
			comboBox2.addItem(bianli.get(i).getXingming());
		}
		label3 = new JLabel("         ");
		button1 = new JButton("查询");
		button1.setFont(font1);
		button2 = new JButton("添加");
		button2.setFont(font1);
		button3 = new JButton("修改");
		button3.setFont(font1);
		button4 = new JButton("删除");
		button4.setFont(font1);

		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String item1 = String.valueOf(comboBox1.getSelectedItem());
				String item2 = String.valueOf(comboBox2.getSelectedItem());

				Personnel_All_method op = new Personnel_All_method();
				List<Personnel_Bean> ss = op.select_personnel(item1, item2);
				textfield1.setText(ss.get(0).getXingming());
				textfield2.setText(ss.get(0).getNianling());
				textfield3.setText(ss.get(0).getXingbie());
				textfield4.setText(ss.get(0).getZhiwu());
				textfield5.setText(ss.get(0).getBumen());
				textfieldA.setText(ss.get(0).getWeixin());
				textfieldB.setText(ss.get(0).getDianhua());
				textfieldC.setText(ss.get(0).getShouji());
				textfieldD.setText(ss.get(0).getMail());
			}

		});

		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Font f = new Font("", 21, 21);
				JPanel pa = new JPanel();
				JFrame frame = new JFrame();
				JLabel la1 = new JLabel("编号");
				JLabel la2 = new JLabel("姓名");
				JLabel la3 = new JLabel("年龄");
				JLabel la4 = new JLabel("性别");
				JLabel la5 = new JLabel("职务");
				JLabel la6 = new JLabel("部门");
				JLabel la7 = new JLabel("微信");
				JLabel la8 = new JLabel("电话");
				JLabel la9 = new JLabel("手机");
				JLabel la10 = new JLabel("Mail");
				la1.setFont(f);
				la2.setFont(f);
				la3.setFont(f);
				la4.setFont(f);
				la5.setFont(f);
				la6.setFont(f);
				la7.setFont(f);
				la8.setFont(f);
				la9.setFont(f);
				la10.setFont(f);
				la1.setForeground(Color.BLUE);
				la2.setForeground(Color.BLUE);
				la3.setForeground(Color.BLUE);
				la4.setForeground(Color.BLUE);
				la5.setForeground(Color.BLUE);
				la6.setForeground(Color.BLUE);
				la7.setForeground(Color.BLUE);
				la8.setForeground(Color.BLUE);
				la9.setForeground(Color.BLUE);
				la10.setForeground(Color.BLUE);

				JTextField text1 = new JTextField(12);
				JTextField text2 = new JTextField(12);
				JTextField text3 = new JTextField(12);
				JTextField text4 = new JTextField(12);
				JTextField text5 = new JTextField(12);
				JTextField text6 = new JTextField(12);
				JTextField text7 = new JTextField(12);
				JTextField text8 = new JTextField(12);
				JTextField text9 = new JTextField(12);
				JTextField text10 = new JTextField(12);
				text1.setFont(f);
				text2.setFont(f);
				text3.setFont(f);
				text4.setFont(f);
				text5.setFont(f);
				text6.setFont(f);
				text7.setFont(f);
				text8.setFont(f);
				text9.setFont(f);
				text10.setFont(f);

				JButton bu1 = new JButton("确认");
				JButton bu2 = new JButton("取消");
				bu1.setFont(f);
				bu2.setFont(f);
				bu1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						Personnel_Bean personnel_bean = new Personnel_Bean();
						personnel_bean.setId(text1.getText());
						personnel_bean.setXingming(text2.getText());
						personnel_bean.setNianling(text3.getText());
						personnel_bean.setXingbie(text4.getText());
						personnel_bean.setZhiwu(text5.getText());
						personnel_bean.setBumen(text6.getText());
						personnel_bean.setWeixin(text7.getText());
						personnel_bean.setDianhua(text8.getText());
						personnel_bean.setShouji(text9.getText());
						personnel_bean.setMail(text10.getText());
						Personnel_All_method er = new Personnel_All_method();
						er.add_personnel(personnel_bean);
						frame.setVisible(false);
					}

				});

				pa.add(la1);
				pa.add(text1);
				pa.add(la2);
				pa.add(text2);
				pa.add(la3);
				pa.add(text3);
				pa.add(la4);
				pa.add(text4);
				pa.add(la5);
				pa.add(text5);
				pa.add(la6);
				pa.add(text6);
				pa.add(la7);
				pa.add(text7);
				pa.add(la8);
				pa.add(text8);
				pa.add(la9);
				pa.add(text9);
				pa.add(la10);
				pa.add(text10);
				pa.add(bu1);
				pa.add(bu2);
				frame.add(pa);
				frame.setBounds(750, 300, 600, 600);
				frame.setSize(550, 450);
				frame.setVisible(true);
				frame.setTitle("添加");

			}

		});

		button3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String item1 = String.valueOf(comboBox1.getSelectedItem());
				String item2 = String.valueOf(comboBox2.getSelectedItem());
				if(!(item1.equals("请输入部门信息")&&item2.equals("请输入姓名"))) {
				Personnel_All_method op = new Personnel_All_method();
				List<Personnel_Bean> ss = op.select_personnel(item1, item2);

				JFrame fa = new JFrame();
				JPanel panel = new JPanel();
				Font f = new Font("", 21, 21);
				JLabel la1 = new JLabel("编号");
				JLabel la2 = new JLabel("姓名");
				JLabel la3 = new JLabel("年龄");
				JLabel la4 = new JLabel("性别");
				JLabel la5 = new JLabel("职务");
				JLabel la6 = new JLabel("部门");
				JLabel la7 = new JLabel("微信");
				JLabel la8 = new JLabel("电话");
				JLabel la9 = new JLabel("手机");
				JLabel la10 = new JLabel("Mail");
				JButton button1 = new JButton("确认");
				JButton button2 = new JButton("取消");
				button1.setFont(f);
				button2.setFont(f);
				la1.setFont(f);
				la2.setFont(f);
				la3.setFont(f);
				la4.setFont(f);
				la5.setFont(f);
				la6.setFont(f);
				la7.setFont(f);
				la8.setFont(f);
				la9.setFont(f);
				la10.setFont(f);
				la1.setForeground(Color.BLUE);
				la2.setForeground(Color.BLUE);
				la3.setForeground(Color.BLUE);
				la4.setForeground(Color.BLUE);
				la5.setForeground(Color.BLUE);
				la6.setForeground(Color.BLUE);
				la7.setForeground(Color.BLUE);
				la8.setForeground(Color.BLUE);
				la9.setForeground(Color.BLUE);
				la10.setForeground(Color.BLUE);

				JTextField text1 = new JTextField(ss.get(0).getId(),12);
				JTextField text2 = new JTextField(ss.get(0).getXingming(),12);
				JTextField text3 = new JTextField(ss.get(0).getNianling(),12);
				JTextField text4 = new JTextField(ss.get(0).getXingbie(),12);
				JTextField text5 = new JTextField(ss.get(0).getZhiwu(),12);
				JTextField text6 = new JTextField(ss.get(0).getBumen(),12);
				JTextField text7 = new JTextField(ss.get(0).getWeixin(),12);
				JTextField text8 = new JTextField(ss.get(0).getDianhua(),12);
				JTextField text9 = new JTextField(ss.get(0).getShouji(),12);
				JTextField text10 = new JTextField(ss.get(0).getMail(),12);
				
				text1.setFont(f);
				text2.setFont(f);
				text3.setFont(f);
				text4.setFont(f);
				text5.setFont(f);
				text6.setFont(f);
				text7.setFont(f);
				text8.setFont(f);
				text9.setFont(f);
				text10.setFont(f);
				
				button1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						int result = JOptionPane.showConfirmDialog(frame, "是否修改这条数据", "提示信息", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
						if(result==0) {
						Personnel_All_method opp = new Personnel_All_method();
						personnel_bean = new Personnel_Bean();
						personnel_bean.setId(text1.getText());
						personnel_bean.setXingming(text2.getText());
						personnel_bean.setNianling(text3.getText());
						personnel_bean.setXingbie(text4.getText());
						personnel_bean.setZhiwu(text5.getText());
						personnel_bean.setBumen(text6.getText());
						personnel_bean.setWeixin(text7.getText());
						personnel_bean.setDianhua(text8.getText());
						personnel_bean.setShouji(text9.getText());
						personnel_bean.setMail(text10.getText());
						opp.update_personnel(personnel_bean);
					     fa.setVisible(false);
					     JOptionPane.showMessageDialog(frame, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
						else {
							System.out.println("结果");
						}
	
					}
				
					
				});
				panel.add(la1);
				panel.add(text1);
				panel.add(la2);
				panel.add(text2);
				panel.add(la3);
				panel.add(text3);
				panel.add(la4);
				panel.add(text4);
				panel.add(la5);
				panel.add(text5);
				panel.add(la6);
				panel.add(text6);
				panel.add(la7);
				panel.add(text7);
				panel.add(la8);
				panel.add(text8);
				panel.add(la9);
				panel.add(text9);
				panel.add(la10);
				panel.add(text10);
				panel.add(button1);
				panel.add(button2);
				fa.add(panel);
				fa.setBounds(750, 300, 600, 600);
				fa.setVisible(true);
				fa.setSize(550, 450);
				fa.setTitle("修改");
				
			}
            else {
    				JOptionPane.showMessageDialog(frame, "请先选择修改人", "提示", JOptionPane.INFORMATION_MESSAGE);
    		}
			}
			

		});

		button4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				Personnel_All_method d = new Personnel_All_method();
				List<Personnel_Bean> bianli = d.select_personnel();
				Vector<Object> rowAll = new Vector<Object>();

				for (int i = 0; i < bianli.size(); i++) {
					Vector<String> row = new Vector<String>();
					row.add(bianli.get(i).getId());
					row.add(bianli.get(i).getXingming());
					row.add(bianli.get(i).getNianling());
					row.add(bianli.get(i).getXingbie());
					row.add(bianli.get(i).getZhiwu());
					row.add(bianli.get(i).getBumen());
					row.add(bianli.get(i).getWeixin());
					row.add(bianli.get(i).getDianhua());
					row.add(bianli.get(i).getShouji());
					row.add(bianli.get(i).getMail());
					rowAll.add(row);
				}
				Vector<Object> head = new Vector<Object>();
				head.add("编号");
				head.add("姓名");
				head.add("年龄");
				head.add("性别");
				head.add("职务");
				head.add("部门");
				head.add("微信");
				head.add("电话");
				head.add("手机");
				head.add("E-mail");
				 model = new DefaultTableModel(rowAll, head);
				 table = new JTable(model);
				 table.setRowHeight(20);
				JScrollPane jsp = new JScrollPane();
				jsp.setViewportView(table);
				table.setPreferredScrollableViewportSize(new Dimension(850, 600));
				JPanel pan = new JPanel();
				JPanel pan1 = new JPanel();
				JButton b1 = new JButton("确定");
				JButton b2 = new JButton("取消");
				b1.setFont(font1);
				b2.setFont(font1);
				
				JFrame jf = new JFrame();
				pan.add(b1);
				pan.add(b2);
				pan1.add(jsp);
				JSplitPane slibpaneA = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				slibpaneA.setLeftComponent(pan);
				slibpaneA.setDividerLocation(80);
				slibpaneA.setRightComponent(pan1);
				jf.add(slibpaneA);
				jf.setBounds(750, 300, 600, 600);
				jf.setSize(900, 600);
				jf.setVisible(true);
				jf.setTitle("删除");
				
				b1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						
						int row = table.getSelectedRow();
						table.getValueAt(row,0);
						String delete = String.valueOf(table.getValueAt(row,0));
						model.removeRow(row);
						d.delete_personnel(delete);
					}

				});

			}

		});

		splitpanel1 = new JSplitPane();
		splitpanel1.setOrientation(1);

		panel1.add(label1);
		panel1.add(comboBox1);
		panel1.add(label2);
		panel1.add(comboBox2);
		panel1.add(label3);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel2.add(tree);
		splitpane.setLeftComponent(panel1);
		splitpane.setOrientation(0);
		splitpane.setDividerLocation(80);
		splitpane.setRightComponent(splitpanel1);
		splitpanel1.setDividerLocation(130);
		splitpanel1.setLeftComponent(panel2);
		splitpanel1.setRightComponent(panel5);

	}

}
