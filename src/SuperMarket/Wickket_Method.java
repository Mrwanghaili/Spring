package SuperMarket;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane; 
import javax.swing.JPanel;
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
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class Wickket_Method extends JFrame {
	JTextField Field1, Field2;
	JButton button1, button2, button3, button4;
	JLabel label, label1, label2, label3, label4, labelB;
	JSplitPane splitpane, splitpane1;
	static JFrame frame;
	JFrame frame1; 
	JFrame frame2;
	DefaultMutableTreeNode rootTree, childTree1, childTree2, childTree3, childTree4, childTree5;
	JPanel panel2, panel3, panel4;
	JTree tree; 
	Table_Bean bean, beanA, beanB, beanC, beanD;
	DefaultTableModel defaultModel;
	DefaultTableModel defaultModel2;
	DefaultTableModel defaultModel3;
	DefaultTableModel defaultModel4;
	DefaultTableModel defaultModel5;
	Vector<Object> allA, allB, allC, allD, allE, headA;
	JScrollPane jspA, jspB, jspC, jspD, jspE;
	JTable tableA, tableB, tableC, tableD, tableE;
	Object delete_database;
	JTextField field1A, field2A, field1B, field2B, field1C, field2C, field1D, field2D, field1E, field2E;
	JLabel label1A, label2A, label1B, label2B, label1C, label2C, label1D, label2D, label1E, label2E;
	JButton button1A, button2A, button3A, button4A;
	JButton button1B, button2B, button3B, button4B;
	JButton button1C, button2C, button3C, button4C;
	JButton button1D, button2D, button3D, button4D;
	JButton button1E, button2E, button3E, button4E;
	String op,op1,op2,op3,op4,op5,op6,op7,op8,op9,op10; 
	public Wickket_Method(JSplitPane split) {
		frame = new JFrame();
		Font font = new Font("", 20, 22);
		Color s = new Color(1);
		label = new JLabel("基本档案管理");
		labelB = new JLabel("基      本        档       案      管      理");
		labelB.setForeground(s.BLUE);
		labelB.setFont(font);
     
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();

		split.setLeftComponent(panel2);
		split.setDividerLocation(110);
		splitpane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		splitpane1.setDividerLocation(80);
		splitpane1.setDividerSize(10);
		splitpane1.setOneTouchExpandable(true);
		splitpane1.setContinuousLayout(true);

		split.setOrientation(1);
		split.setRightComponent(splitpane1);
		splitpane1.setLeftComponent(panel3);
		splitpane1.setRightComponent(panel4);

		rootTree = new DefaultMutableTreeNode("基本档案管理");
		tree = new JTree(rootTree);

		childTree1 = new DefaultMutableTreeNode("供货商管理");
		childTree2 = new DefaultMutableTreeNode("销售商管理");
		childTree3 = new DefaultMutableTreeNode("货品档案管理");
		childTree4 = new DefaultMutableTreeNode("仓库管理");
		childTree5 = new DefaultMutableTreeNode("职务管理");

		panel3.add(labelB, BorderLayout.CENTER);

		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {

				if (!tree.isSelectionEmpty()) {
					TreePath selectionPaths = tree.getSelectionPath();
					Object path = selectionPaths.getLastPathComponent();
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) path;
					String userObject = (String) node.getUserObject();
					repaint();
					if (userObject.equals("供货商管理")) {
						panel3.removeAll();
						panel4.removeAll();
						label1A = new JLabel("供货商名称");
						label2A = new JLabel("    简称");
						label1A.setForeground(s.BLUE);
						label2A.setForeground(s.BLUE);
						label1A.setFont(font);
						label2A.setFont(font);
						field1A = new JTextField(12);
						field2A = new JTextField(12);
						field1A.setFont(font);
						field2A.setFont(font);
						button1A = new JButton("搜索");
						button2A = new JButton("添加");
						button3A = new JButton("修改");
						button4A = new JButton("删除");

						panel3.add(label1A);
						panel3.add(field1A);
						panel3.add(label2A);
						panel3.add(field2A);
						panel3.add(button1A);
						panel3.add(button2A);
						panel3.add(button3A);
						panel3.add(button4A);

						Vector<Object> headA = new Vector<Object>();
						headA.add("供货商编号");
						headA.add("供货商名称");
						headA.add("简称");
						headA.add("公司营业证编号");
						headA.add("电话");
						headA.add("传真");
						headA.add("联系人");
						headA.add("联系人电话");
						headA.add("开户行");
						headA.add("账户密码 ");
						headA.add("供货 E-mail");

						Table_All_Method s = new Table_All_Method();

						List<Table_Bean> add = s.selectTable_Element();

						allA = new Vector<Object>();

						for (int i = 0; i < add.size(); i++) {
							Vector<Object> row = new Vector<Object>();
							row.add(add.get(i).getId());
							row.add(add.get(i).getName());
							row.add(add.get(i).getJc());
							row.add(add.get(i).getBianma());
							row.add(add.get(i).getTel());
							row.add(add.get(i).getFax());
							row.add(add.get(i).getLian());
							row.add(add.get(i).getLtel());
							row.add(add.get(i).getYh());
							row.add(add.get(i).getZh());
							row.add(add.get(i).getMail());
							allA.add(row);

						}

						button3A.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								JPanel panelR1 = new JPanel();
								JFrame frameR1 = new JFrame();
								
								Font fontA = new Font("", 30, 40);
								Font fontB = new Font("", 20, 20);
								Font fontC = new Font("", 100, 20);
								Color f = new Color(2);
								JButton buttonR1 = new JButton("确定");
								JButton buttonR2 = new JButton("取消");
								buttonR1.setFont(fontC);
								buttonR2.setFont(fontC);

								JLabel labelR1 = new JLabel("供货商编号    ");
								JLabel labelR2 = new JLabel("供货商名称    ");
								JLabel labelR3 = new JLabel("供货商简称    ");
								JLabel labelR4 = new JLabel("公司营业编号");
								JLabel labelR5 = new JLabel("供货商电话    ");
								JLabel labelR6 = new JLabel("供货商传真    ");
								JLabel labelR7 = new JLabel("供货商联系人");
								JLabel labelR8 = new JLabel("联系人电话    ");
								JLabel labelR9 = new JLabel("供货开户行    ");
								JLabel labelR10 = new JLabel("账 户 密 码    ");
								JLabel labelR11 = new JLabel("供货   E-mail ");
								
								int row = tableA.getSelectedRow();
								if(row>-1) { 
									Object update_database = tableA.getValueAt(row, 0);
									Object update_database1 = tableA.getValueAt(row, 1);
									Object update_database2 = tableA.getValueAt(row, 2);
									Object update_database3 = tableA.getValueAt(row, 3);
									Object update_database4 = tableA.getValueAt(row, 4);
									Object update_database5 = tableA.getValueAt(row, 5);
									Object update_database6 = tableA.getValueAt(row, 6);
									Object update_database7 = tableA.getValueAt(row, 7);
									Object update_database8 = tableA.getValueAt(row, 8);
									Object update_database9 = tableA.getValueAt(row, 9);
									Object update_database10 = tableA.getValueAt(row, 10);
									  op = String.valueOf(update_database);
									  op1 = String.valueOf(update_database1);
									  op2 = String.valueOf(update_database2);
									  op3 = String.valueOf(update_database3);
									  op4 = String.valueOf(update_database4);
									  op5 = String.valueOf(update_database5);
									  op6 = String.valueOf(update_database6);
									  op7 = String.valueOf(update_database7);
									  op8 = String.valueOf(update_database8);
									  op9 = String.valueOf(update_database9);
									  op10 = String.valueOf(update_database10);
									  
								JTextField fieldR1 = new JTextField(op,13);
								JTextField fieldR2 = new JTextField(op1,13);
								JTextField fieldR3 = new JTextField(op2,13);
								JTextField fieldR4 = new JTextField(op3,13);
								JTextField fieldR5 = new JTextField(op4,13);
								JTextField fieldR6 = new JTextField(op5,13);
								JTextField fieldR7 = new JTextField(op6,13);
								JTextField fieldR8 = new JTextField(op7,13);
								JTextField fieldR9 = new JTextField(op8,13);
								JTextField fieldR10 = new JTextField(op9,13);
								JTextField fieldR11 = new JTextField(op10,13);

								labelR1.setForeground(f.BLUE);
								labelR1.setFont(font);
								labelR2.setForeground(f.BLUE);
								labelR2.setFont(font);
								labelR3.setForeground(f.BLUE);
								labelR3.setFont(font);
								labelR4.setForeground(f.BLUE);
								labelR4.setFont(font);
								labelR5.setForeground(f.BLUE);
								labelR5.setFont(font);
								labelR6.setForeground(f.BLUE);
								labelR6.setFont(font);
								labelR7.setForeground(f.BLUE);
								labelR7.setFont(font);
								labelR8.setForeground(f.BLUE);
								labelR8.setFont(font);
								labelR9.setForeground(f.BLUE);
								labelR9.setFont(font);
								labelR10.setForeground(f.BLUE);
								labelR10.setFont(font);
								labelR11.setForeground(f.BLUE);
								labelR11.setFont(font);

								fieldR1.setFont(fontB);
								fieldR2.setFont(fontB);
								fieldR3.setFont(fontB);
								fieldR4.setFont(fontB);
								fieldR5.setFont(fontB);
								fieldR6.setFont(fontB);
								fieldR7.setFont(fontB);
								fieldR8.setFont(fontB);
								fieldR9.setFont(fontB);
								fieldR10.setFont(fontB);
								fieldR11.setFont(fontB);

								buttonR1.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										bean = new Table_Bean();
										bean.setId(fieldR1.getText());
										bean.setName(fieldR2.getText());
										bean.setJc(fieldR3.getText());
										bean.setBianma(fieldR4.getText());
										bean.setTel(fieldR5.getText());
										bean.setFax(fieldR6.getText());
										bean.setLian(fieldR7.getText());
										bean.setLtel(fieldR8.getText());
										bean.setYh(fieldR9.getText());
										bean.setZh(fieldR10.getText());
										bean.setMail(fieldR11.getText());

										Table_All_Method s = new Table_All_Method();
										s.updateTable_Element1(bean);
									    List<Table_Bean> op = s.selectTable_Element();
									   
										allA = new Vector<Object>();

										for (int i = 0; i < op.size(); i++) {
											Vector<Object> row = new Vector<Object>();
											row.add(op.get(i).getId());
											row.add(op.get(i).getName());
											row.add(op.get(i).getJc());
											row.add(op.get(i).getBianma());
											row.add(op.get(i).getTel());
											row.add(op.get(i).getFax());
											row.add(op.get(i).getLian());
											row.add(op.get(i).getLtel());
											row.add(op.get(i).getYh());
											row.add(op.get(i).getZh());
											row.add(op.get(i).getMail());
											allA.add(row);

										}
									    
									    Vector<Object> headAll = new Vector<Object>();
										headAll.add("供货商编号");
										headAll.add("供货商名称");
										headAll.add("简称");
										headAll.add("营业证编号");
										headAll.add("电话");
										headAll.add("传真");
										headAll.add("联系人");
										headAll.add("联系人电话");
										headAll.add("开户行");
										headAll.add("账户密码 ");
										headAll.add("供货 E-mail");
										
										defaultModel = new DefaultTableModel(allA,headAll);
										tableA.setModel(defaultModel);
										tableA.setRowHeight(25);
										tableA.setPreferredScrollableViewportSize(new Dimension(1240, 800));
										jspA.setViewportView(tableA);
										panel4.add(jspA); 
										frameR1.setVisible(false);
									}

								});

								panelR1.add(labelR1);
								panelR1.add(fieldR1);
								panelR1.add(labelR2);
								panelR1.add(fieldR2);
								panelR1.add(labelR3);
								panelR1.add(fieldR3);
								panelR1.add(labelR4);
								panelR1.add(fieldR4);
								panelR1.add(labelR5);
								panelR1.add(fieldR5);
								panelR1.add(labelR6);
								panelR1.add(fieldR6);
								panelR1.add(labelR7);
								panelR1.add(fieldR7);
								panelR1.add(labelR8);
								panelR1.add(fieldR8);
								panelR1.add(labelR9);
								panelR1.add(fieldR9);
								panelR1.add(labelR10);
								panelR1.add(fieldR10);
								panelR1.add(labelR11);
								panelR1.add(fieldR11);

								panelR1.add(buttonR1);
								panelR1.add(buttonR2);

								panelR1.add(buttonR1);
								panelR1.add(buttonR2);

								frameR1.add(panelR1);
								frameR1.setBounds(750, 300, 600, 600);
								frameR1.setSize(400, 500);
								frameR1.setVisible(true);
								frameR1.setTitle("修改行界面");
								frameR1.setResizable(false);
								} 
								else {
									JOptionPane.showMessageDialog(frame,"未选中修改行","提示",JOptionPane.INFORMATION_MESSAGE);
								}
							} 
						}); 

						button1A.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								JFrame frame;
								JPanel panel1;
								JTable tableA;
								DefaultTableModel modelA;
								JScrollPane scroll;  
								frame = new JFrame();
								panel1 = new JPanel();
								scroll = new JScrollPane();
								String S1 = field1A.getText();
								String S2 = field2A.getText();
								Table_All_Method ss = new Table_All_Method();

								List<Table_Bean> addF = ss.selectTable_Element1(S1, S2);

								Vector<Object> allG = new Vector<Object>();
								for (int i = 0; i < addF.size(); i++) {
									Vector<Object> rowAll = new Vector<Object>();
									rowAll.add(addF.get(i).getId());
									rowAll.add(addF.get(i).getName());
									rowAll.add(addF.get(i).getJc());
									rowAll.add(addF.get(i).getBianma());
									rowAll.add(addF.get(i).getTel());
									rowAll.add(addF.get(i).getFax());
									rowAll.add(addF.get(i).getLian());
									rowAll.add(addF.get(i).getLtel());
									rowAll.add(addF.get(i).getYh());
									rowAll.add(addF.get(i).getZh());
									rowAll.add(addF.get(i).getMail());
									allG.add(rowAll);
								}
								Vector<Object> headAll = new Vector<Object>();
								headAll.add("供货商编号");
								headAll.add("供货商名称");
								headAll.add("简称");
								headAll.add("营业证编号");
								headAll.add("电话");
								headAll.add("传真");
								headAll.add("联系人");
								headAll.add("联系人电话");
								headAll.add("开户行");
								headAll.add("账户密码 ");
								headAll.add("供货 E-mail");

								modelA = new DefaultTableModel(allG, headAll);
								tableA = new JTable(modelA);
								tableA.setEnabled(true);
								tableA.setPreferredScrollableViewportSize(new Dimension(780, 600));
								scroll.setViewportView(tableA);
								panel1.add(scroll);
								frame.add(panel1);
								frame.setBounds(750, 300, 600, 600);
								frame.add(panel1);
								frame.setSize(820, 600);
								frame.setVisible(true);

							}

						}); 

						button4A.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
									
								int row = tableA.getSelectedRow();
								if(row>-1) {
								  int  result = JOptionPane.showConfirmDialog(frame,"是否删除这条数据","提示信息",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
								if(result == 0) {
								delete_database = tableA.getValueAt(row, 0);
								defaultModel.removeRow(row);
								Table_All_Method se = new Table_All_Method();
								se.deleteTable_Element(delete_database);
								    }
								}
								else {
									JOptionPane.showMessageDialog(frame,"未选中删除行","提示",JOptionPane.INFORMATION_MESSAGE);
								}
									
							}
						});

						button2A.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JFrame jframe = new JFrame();
								JPanel jpanel = new JPanel();
								JButton jbutton1, jbutton2;
								Font fontA = new Font("", 30, 40);
								Font fontB = new Font("", 20, 20);
								Font fontC = new Font("", 100, 20);
								Color f = new Color(2);
								jbutton1 = new JButton("确定");
								jbutton2 = new JButton("取消");
								jbutton1.setFont(fontC);
								jbutton2.setFont(fontC);
								JLabel jlabel1 = new JLabel("供货商编号    ");
								JLabel jlabel2 = new JLabel("供货商名称    ");
								JLabel jlabel3 = new JLabel("供货商简称    ");
								JLabel jlabel4 = new JLabel("公司营业编号");
								JLabel jlabel5 = new JLabel("供货商电话    ");
								JLabel jlabel6 = new JLabel("供货商传真    ");
								JLabel jlabel7 = new JLabel("供货商联系人");
								JLabel jlabel8 = new JLabel("联系人电话    ");
								JLabel jlabel9 = new JLabel("供货开户行    ");
								JLabel jlabel10 = new JLabel("账 户 密 码    ");
								JLabel jlabel11 = new JLabel("供货   E-mail ");

								jlabel1.setForeground(f.BLUE);
								jlabel1.setFont(font);
								jlabel2.setForeground(f.BLUE);
								jlabel2.setFont(font);
								jlabel3.setForeground(f.BLUE);
								jlabel3.setFont(font);
								jlabel4.setForeground(f.BLUE);
								jlabel4.setFont(font);
								jlabel5.setForeground(f.BLUE);
								jlabel5.setFont(font);
								jlabel6.setForeground(f.BLUE);
								jlabel6.setFont(font);
								jlabel7.setForeground(f.BLUE);
								jlabel7.setFont(font);
								jlabel8.setForeground(f.BLUE);
								jlabel8.setFont(font);
								jlabel9.setForeground(f.BLUE);
								jlabel9.setFont(font);
								jlabel10.setForeground(f.BLUE);
								jlabel10.setFont(font);
								jlabel11.setForeground(f.BLUE);
								jlabel11.setFont(font);
								
								JTextField field1 = new JTextField(13);
								JTextField field2 = new JTextField(13);
								JTextField field3 = new JTextField(13);
								JTextField field4 = new JTextField(13);
								JTextField field5 = new JTextField(13);
								JTextField field6 = new JTextField(13);
								JTextField field7 = new JTextField(13);
								JTextField field8 = new JTextField(13);
								JTextField field9 = new JTextField(13);
								JTextField field10 = new JTextField(13);
								JTextField field11 = new JTextField(13);
								jbutton1.addActionListener(new ActionListener() {
 
									public void actionPerformed(ActionEvent arg0) {
										bean = new Table_Bean();
										bean.setId(field1.getText());
										bean.setName(field2.getText());
										bean.setJc(field3.getText());
										bean.setBianma(field4.getText());
										bean.setTel(field5.getText());
										bean.setFax(field6.getText());
										bean.setLian(field7.getText());
										bean.setLtel(field8.getText());
										bean.setYh(field9.getText());
										bean.setZh(field10.getText());
										bean.setMail(field11.getText());

										Table_All_Method s = new Table_All_Method();
										s.addTable_Element(bean);
										List<Table_Bean> er = s.selectTable_Element();

										Vector<Object> allA = new Vector<Object>();
										for (int i = 0; i < er.size(); i++) {
											Vector<Object> rowAll = new Vector<Object>();
											rowAll.add(er.get(i).getId());
											rowAll.add(er.get(i).getName());
											rowAll.add(er.get(i).getJc());
											rowAll.add(er.get(i).getBianma());
											rowAll.add(er.get(i).getTel());
											rowAll.add(er.get(i).getFax());
											rowAll.add(er.get(i).getLian());
											rowAll.add(er.get(i).getLtel());
											rowAll.add(er.get(i).getYh());
											rowAll.add(er.get(i).getZh());
											rowAll.add(er.get(i).getMail());
											allA.add(rowAll);
										}
										Vector<Object> headAll = new Vector<Object>();
										headAll.add("供货商编号");
										headAll.add("供货商名称");
										headAll.add("简称");
										headAll.add("营业证编号");
										headAll.add("电话");
										headAll.add("传真");
										headAll.add("联系人");
										headAll.add("联系人电话");
										headAll.add("开户行");
										headAll.add("账户密码 "); 
										headAll.add("供货 E-mail");
										 
										defaultModel = new DefaultTableModel(allA,headAll);
										tableA.setModel(defaultModel);
										tableA.setRowHeight(25);
										tableA.setPreferredScrollableViewportSize(new Dimension(1240, 800));
										jspA.setViewportView(tableA);
										panel4.add(jspA);
										jframe.setVisible(false);
									} 

								});

								field1.setFont(fontB);
								field2.setFont(fontB);
								field3.setFont(fontB);
								field4.setFont(fontB);
								field5.setFont(fontB);
								field6.setFont(fontB);
								field5.setFont(fontB);
								field6.setFont(fontB);
								field7.setFont(fontB);
								field8.setFont(fontB);
								field9.setFont(fontB);
								field10.setFont(fontB);
								field11.setFont(fontB);

								jpanel.add(jlabel1);
								jpanel.add(field1);
								jpanel.add(jlabel2);
								jpanel.add(field2);
								jpanel.add(jlabel3);
								jpanel.add(field3);
								jpanel.add(jlabel4);
								jpanel.add(field4);
								jpanel.add(jlabel5);
								jpanel.add(field5);
								jpanel.add(jlabel6);
								jpanel.add(field6);
								jpanel.add(jlabel7);
								jpanel.add(field7);
								jpanel.add(jlabel8);
								jpanel.add(field8);
								jpanel.add(jlabel9);
								jpanel.add(field9);
								jpanel.add(jlabel10);
								jpanel.add(field10);
								jpanel.add(jlabel11);
								jpanel.add(field11);
								jpanel.add(jbutton1);
								jpanel.add(jbutton2);

								jframe.setBounds(750, 300, 600, 600);
								jframe.add(jpanel);
								jframe.setSize(400, 500);
								jframe.setVisible(true);
								jframe.setResizable(false);

								jframe.setTitle("添加行元素");
							}

						});

						defaultModel = new DefaultTableModel(allA, headA);
						tableA = new JTable(defaultModel);
						tableA.setEnabled(true);
						tableA.setRowHeight(25);
						tableA.setPreferredScrollableViewportSize(new Dimension(1240, 800));
						jspA = new JScrollPane();
						jspA.setViewportView(tableA);
						panel4.add(jspA);
						repaint();
					}

					else if (userObject.equals("销售商管理")) {
						panel3.removeAll();
						panel4.removeAll();
						label1B = new JLabel("品种数量");
						label2B = new JLabel("合计金额");
						label1B.setForeground(s.BLUE);
						label2B.setForeground(s.BLUE);
						label1B.setFont(font);
						label2B.setFont(font);
						field1B = new JTextField(12);
						field2B = new JTextField(12);
						field1B.setFont(font);
						field2B.setFont(font);
						button1B = new JButton("搜索");
						button2B = new JButton("添加");
						button3B = new JButton("修改");
						button4B = new JButton("删除");

						panel3.add(label1B);
						panel3.add(field1B);
						panel3.add(label2B);
						panel3.add(field2B);
						panel3.add(button1B);
						panel3.add(button2B);
						panel3.add(button3B);
						panel3.add(button4B);

						Vector<Object> headB = new Vector<Object>();
						headB.add("销售单编号");
						headB.add("品种数量");
						headB.add("合计金额");
						headB.add("验收结论");
						headB.add("客户名称");
						headB.add("销售时间");
						headB.add("操作员");
						headB.add("经手人");
						headB.add("结算方式");

						Table_All_Method s1 = new Table_All_Method();

						List<Table_Bean> addD1 = s1.selectTable_ElementA();

						allB = new Vector<Object>();

						for (int i = 0; i < addD1.size(); i++) {
							Vector<Object> row = new Vector<Object>();
							row.add(addD1.get(i).getSellid());
							row.add(addD1.get(i).getPzs());
							row.add(addD1.get(i).getJe());
							row.add(addD1.get(i).getYsjl());
							row.add(addD1.get(i).getKhname());
							row.add(addD1.get(i).getXsdate());
							row.add(addD1.get(i).getCzy());
							row.add(addD1.get(i).getJsr());
							row.add(addD1.get(i).getJsfs());
							allB.add(row);

						}

						button3B.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								JPanel panelR1 = new JPanel();
								JFrame frameR1 = new JFrame();
								
								Font fontA = new Font("", 30, 40);
								Font fontB = new Font("", 20, 20);
								Font fontC = new Font("", 100, 20);
								Color f = new Color(2);
								JButton buttonR1 = new JButton("确定");
								JButton buttonR2 = new JButton("取消");
								buttonR1.setFont(fontC);
								buttonR2.setFont(fontC);

								JLabel labelR1 = new JLabel("销售单编号   ");
								JLabel labelR2 = new JLabel("品 种 数 量    ");
								JLabel labelR3 = new JLabel("合 计 金 额    ");
								JLabel labelR4 = new JLabel("验 收 结 论    ");
								JLabel labelR5 = new JLabel("客 户  名  称  ");
								JLabel labelR6 = new JLabel("销 售 时 间    ");
								JLabel labelR7 = new JLabel("操    作   员    ");
								JLabel labelR8 = new JLabel("经     手      人");
								JLabel labelR9 = new JLabel("结  算  方  式 ");
								
								int row = tableB.getSelectedRow();
								if(row>-1) { 
									Object update_database = tableB.getValueAt(row, 0);
									Object update_database1 = tableB.getValueAt(row, 1);
									Object update_database2 = tableB.getValueAt(row, 2);
									Object update_database3 = tableB.getValueAt(row, 3);
									Object update_database4 = tableB.getValueAt(row, 4);
									Object update_database5 = tableB.getValueAt(row, 5);
									Object update_database6 = tableB.getValueAt(row, 6);
									Object update_database7 = tableB.getValueAt(row, 7);
									Object update_database8 = tableB.getValueAt(row, 8);
									  op = String.valueOf(update_database);
									  op1 = String.valueOf(update_database1);
									  op2 = String.valueOf(update_database2);
									  op3 = String.valueOf(update_database3);
									  op4 = String.valueOf(update_database4);
									  op5 = String.valueOf(update_database5);
									  op6 = String.valueOf(update_database6);
									  op7 = String.valueOf(update_database7);
									  op8 = String.valueOf(update_database8);
								JTextField fieldR1 = new JTextField(op,13);
								JTextField fieldR2 = new JTextField(op1,13);
								JTextField fieldR3 = new JTextField(op2,13);
								JTextField fieldR4 = new JTextField(op3,13);
								JTextField fieldR5 = new JTextField(op4,13);
								JTextField fieldR6 = new JTextField(op5,13);
								JTextField fieldR7 = new JTextField(op6,13);
								JTextField fieldR8 = new JTextField(op7,13);
								JTextField fieldR9 = new JTextField(op8,13);

								labelR1.setForeground(f.BLUE);
								labelR1.setFont(font);
								labelR2.setForeground(f.BLUE);
								labelR2.setFont(font);
								labelR3.setForeground(f.BLUE);
								labelR3.setFont(font);
								labelR4.setForeground(f.BLUE);
								labelR4.setFont(font);
								labelR5.setForeground(f.BLUE);
								labelR5.setFont(font);
								labelR6.setForeground(f.BLUE);
								labelR6.setFont(font);
								labelR7.setForeground(f.BLUE);
								labelR7.setFont(font);
								labelR8.setForeground(f.BLUE);
								labelR8.setFont(font);
								labelR9.setForeground(f.BLUE);
								labelR9.setFont(font);

								fieldR1.setFont(fontB);
								fieldR2.setFont(fontB);
								fieldR3.setFont(fontB);
								fieldR4.setFont(fontB);
								fieldR5.setFont(fontB);
								fieldR6.setFont(fontB);
								fieldR7.setFont(fontB);
								fieldR8.setFont(fontB);
								fieldR9.setFont(fontB);

								buttonR1.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										bean = new Table_Bean();
										bean.setSellid(fieldR1.getText());
										bean.setPzs(fieldR2.getText());
										bean.setJe(fieldR3.getText());
										bean.setYsjl(fieldR4.getText());
										bean.setKhname(fieldR5.getText());
										bean.setXsdate(fieldR6.getText());
										bean.setCzy(fieldR7.getText());
										bean.setJsr(fieldR8.getText());
										bean.setJsfs(fieldR9.getText());

										Table_All_Method s = new Table_All_Method();
										s.updateTable_Element2(bean);
										List<Table_Bean> op = s.selectTable_ElementA();

										Vector<Object> allB = new Vector<Object>();

										for (int i = 0; i < op.size(); i++) {
											Vector<Object> row = new Vector<Object>();
											row.add(op.get(i).getSellid());
											row.add(op.get(i).getPzs());
											row.add(op.get(i).getJe());
											row.add(op.get(i).getYsjl());
											row.add(op.get(i).getKhname());
											row.add(op.get(i).getXsdate());
											row.add(op.get(i).getCzy());
											row.add(op.get(i).getJsr());
											row.add(op.get(i).getJsfs());
											allB.add(row);

										}
										
										Vector<Object> headAll = new Vector<Object>();
										headAll.add("销售单编号");
										headAll.add("品种数量");
										headAll.add("合计金额");
										headAll.add("验收结论");
										headAll.add("客户名称");
										headAll.add("销售时间"); 
										headAll.add("操作员");
										headAll.add("经手人");
										headAll.add("结算方式");
										defaultModel2 = new DefaultTableModel(allB,headAll);
										tableB.setModel(defaultModel2);
										tableB.setRowHeight(25);
										tableB.setPreferredScrollableViewportSize(new Dimension(1240, 800));
										jspB.setViewportView(tableB);
										panel4.add(jspB);
                                         frameR1.setVisible(false);
									}

								});

								

								panelR1.add(labelR1);
								panelR1.add(fieldR1);
								panelR1.add(labelR2);
								panelR1.add(fieldR2);
								panelR1.add(labelR3);
								panelR1.add(fieldR3);
								panelR1.add(labelR4);
								panelR1.add(fieldR4);
								panelR1.add(labelR5);
								panelR1.add(fieldR5);
								panelR1.add(labelR6);
								panelR1.add(fieldR6);
								panelR1.add(labelR7);
								panelR1.add(fieldR7);
								panelR1.add(labelR8);
								panelR1.add(fieldR8);
								panelR1.add(labelR9);
								panelR1.add(fieldR9);

								panelR1.add(buttonR1);
								panelR1.add(buttonR2);

								panelR1.add(buttonR1);
								panelR1.add(buttonR2);

								frameR1.add(panelR1);
								frameR1.setBounds(750, 300, 600, 600);
								frameR1.setSize(400, 500);
								frameR1.setVisible(true);
								frameR1.setTitle("修改行界面");
								frameR1.setResizable(false);
								}
								
								else {
									JOptionPane.showMessageDialog(frame,"未选中修改行","提示",JOptionPane.INFORMATION_MESSAGE);
								}
							}
						});

						button1B.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								JFrame frame;
								JPanel panel1;
								JTable tableA;
								DefaultTableModel modelA;
								JScrollPane scroll;
								frame = new JFrame();
								panel1 = new JPanel();
								scroll = new JScrollPane();
								String S1 = field1B.getText();
								String S2 = field2B.getText();
								Table_All_Method ss = new Table_All_Method();

								List<Table_Bean> addF = ss.selectTable_Element2(S1, S2);

								Vector<Object> allG = new Vector<Object>();
								for (int i = 0; i < addF.size(); i++) {
									Vector<Object> rowAll = new Vector<Object>();
									rowAll.add(addF.get(i).getSellid());
									rowAll.add(addF.get(i).getPzs());
									rowAll.add(addF.get(i).getJe());
									rowAll.add(addF.get(i).getYsjl());
									rowAll.add(addF.get(i).getKhname());
									rowAll.add(addF.get(i).getXsdate());
									rowAll.add(addF.get(i).getCzy());
									rowAll.add(addF.get(i).getJsr());
									rowAll.add(addF.get(i).getJsfs());

									allG.add(rowAll);
								}
								Vector<Object> headAll = new Vector<Object>();
								headAll.add("销售单编号");
								headAll.add("品种数量");
								headAll.add("合计金额");
								headAll.add("验收结论");
								headAll.add("客户名称");
								headAll.add("销售时间");
								headAll.add("操作员");
								headAll.add("经手人");
								headAll.add("结算方式");

								modelA = new DefaultTableModel(allG, headAll);
								tableA = new JTable(modelA);
								tableA.setEnabled(true);
								tableA.setPreferredScrollableViewportSize(new Dimension(780, 600));
								scroll.setViewportView(tableA);
								panel1.add(scroll);
								frame.add(panel1);
								frame.setBounds(750, 300, 600, 600);
								frame.add(panel1);
								frame.setSize(800, 600);
								frame.setVisible(true);

							}

						});

						button4B.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								int row = tableB.getSelectedRow(); 
								
								if(row>-1) { 
								int  result = JOptionPane.showConfirmDialog(frame,"是否删除这条数据","提示信息",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
								if(result == 0) {
								delete_database = tableB.getValueAt(row, 0);
								defaultModel2.removeRow(row);
								Table_All_Method se = new Table_All_Method();
								se.deleteTable_ElementA(delete_database);
									}
								} 
								else {
									JOptionPane.showMessageDialog(frame,"未选中删除行","提示",JOptionPane.INFORMATION_MESSAGE);
								}
								
							}

						});

						button2B.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								JFrame jframe = new JFrame();
								JPanel jpanel = new JPanel();
								JButton jbutton1, jbutton2;
								Font fontA = new Font("", 30, 40);
								Font fontB = new Font("", 20, 20);
								Font fontC = new Font("", 100, 20);
								Color f = new Color(2);
								jbutton1 = new JButton("确定");
								jbutton2 = new JButton("取消");
								jbutton1.setFont(fontC);
								jbutton2.setFont(fontC);
								JLabel jlabel1 = new JLabel("销售单编号   ");
								JLabel jlabel2 = new JLabel("品 种 数 量    ");
								JLabel jlabel3 = new JLabel("合 计 金 额    ");
								JLabel jlabel4 = new JLabel("验 收 结 论    ");
								JLabel jlabel5 = new JLabel("客 户  名  称  ");
								JLabel jlabel6 = new JLabel("销 售 时 间    ");
								JLabel jlabel7 = new JLabel("操    作   员    ");
								JLabel jlabel8 = new JLabel("经     手      人");
								JLabel jlabel9 = new JLabel("结  算  方  式 ");

								jlabel1.setForeground(f.BLUE);
								jlabel1.setFont(font);
								jlabel2.setForeground(f.BLUE);
								jlabel2.setFont(font);
								jlabel3.setForeground(f.BLUE);
								jlabel3.setFont(font);
								jlabel4.setForeground(f.BLUE);
								jlabel4.setFont(font);
								jlabel5.setForeground(f.BLUE);
								jlabel5.setFont(font);
								jlabel6.setForeground(f.BLUE);
								jlabel6.setFont(font);
								jlabel7.setForeground(f.BLUE);
								jlabel7.setFont(font);
								jlabel8.setForeground(f.BLUE);
								jlabel8.setFont(font);
								jlabel9.setForeground(f.BLUE);
								jlabel9.setFont(font);
								
								JTextField field1 = new JTextField(13);
								JTextField field2 = new JTextField(13);
								JTextField field3 = new JTextField(13);
								JTextField field4 = new JTextField(13);
								JTextField field5 = new JTextField(13);
								JTextField field6 = new JTextField(13);
								JTextField field7 = new JTextField(13);
								JTextField field8 = new JTextField(13);
								JTextField field9 = new JTextField(13);

								jbutton1.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										bean = new Table_Bean();
										bean.setSellid(field1.getText());
										bean.setPzs(field2.getText());
										bean.setJe(field3.getText());
										bean.setYsjl(field4.getText());
										bean.setKhname(field5.getText());
										bean.setXsdate(field6.getText());
										bean.setCzy(field7.getText());
										bean.setJsr(field8.getText());
										bean.setJsfs(field9.getText());

										Table_All_Method s = new Table_All_Method();
										s.addTable_ElementA(bean);
										List<Table_Bean> er = s.selectTable_ElementA();
										allB = new Vector<Object>();

										for (int i = 0; i < er.size(); i++) {
											Vector<Object> row = new Vector<Object>();
											row.add(er.get(i).getSellid());
											row.add(er.get(i).getPzs());
											row.add(er.get(i).getJe());
											row.add(er.get(i).getYsjl());
											row.add(er.get(i).getKhname());
											row.add(er.get(i).getXsdate());
											row.add(er.get(i).getCzy());
											row.add(er.get(i).getJsr());
											row.add(er.get(i).getJsfs());
											allB.add(row);

										}
										Vector<Object> headAll = new Vector<Object>();
										headAll.add("销售单编号");
										headAll.add("品种数量");
										headAll.add("合计金额");
										headAll.add("验收结论");
										headAll.add("客户名称");
										headAll.add("销售时间");
										headAll.add("操作员");
										headAll.add("经手人");
										headAll.add("结算方式");
										defaultModel2 = new DefaultTableModel(allB,headAll);
										tableB.setModel(defaultModel2);
										tableB.setPreferredScrollableViewportSize(new Dimension(1240, 800));
										tableB.setRowHeight(25);
										jspB.setViewportView(tableB);
										panel4.add(jspB);
										jframe.setVisible(false);
									}
								});
								field1.setFont(fontB);
								field2.setFont(fontB);
								field3.setFont(fontB);
								field4.setFont(fontB);
								field5.setFont(fontB);
								field6.setFont(fontB);
								field5.setFont(fontB);
								field6.setFont(fontB);
								field7.setFont(fontB);
								field8.setFont(fontB);
								field9.setFont(fontB);

								jpanel.add(jlabel1);
								jpanel.add(field1);
								jpanel.add(jlabel2);
								jpanel.add(field2);
								jpanel.add(jlabel3);
								jpanel.add(field3);
								jpanel.add(jlabel4);
								jpanel.add(field4);
								jpanel.add(jlabel5);
								jpanel.add(field5);
								jpanel.add(jlabel6);
								jpanel.add(field6);
								jpanel.add(jlabel7);
								jpanel.add(field7);
								jpanel.add(jlabel8);
								jpanel.add(field8);
								jpanel.add(jlabel9);
								jpanel.add(field9);

								jpanel.add(jbutton1);
								jpanel.add(jbutton2);
								jframe.setBounds(750, 300, 600, 600);
								jframe.add(jpanel);
								jframe.setSize(400, 500);
								jframe.setVisible(true);
								jframe.setResizable(false);

								jframe.setTitle("添加行元素");

							}

						});
						defaultModel2 = new DefaultTableModel(allB, headB);
						tableB = new JTable(defaultModel2);
						tableB.setEnabled(true);
						tableB.setRowHeight(25);
						tableB.setPreferredScrollableViewportSize(new Dimension(1240, 800));
						jspB = new JScrollPane();
						jspB.setViewportView(tableB);
						panel4.add(jspB);
						repaint();
					}

					else if (userObject.equals("货品档案管理")) {
						panel3.removeAll();
						panel4.removeAll();
						label1C = new JLabel("商品名称");
						label2C = new JLabel("       简称");
						label1C.setForeground(s.BLUE);
						label2C.setForeground(s.BLUE);
						label1C.setFont(font);
						label2C.setFont(font);
						field1C = new JTextField(12);
						field2C = new JTextField(12);
						field1C.setFont(font);
						field2C.setFont(font);
						button1C = new JButton("搜索");
						button2C = new JButton("添加");
						button3C = new JButton("修改");
						button4C = new JButton("删除");
						panel3.add(label1C);
						panel3.add(field1C);
						panel3.add(label2C);
						panel3.add(field2C);
						panel3.add(button1C);
						panel3.add(button2C);
						panel3.add(button3C);
						panel3.add(button4C);

						Vector<Object> headC = new Vector<Object>();
						headC.add("商品编号");
						headC.add("商品名称");
						headC.add("简称");
						headC.add("计量单位");
						headC.add("规格");
						headC.add("标准");
						headC.add("批准文号");
						headC.add("备注");
						headC.add("供应商编号");

						Table_All_Method s2 = new Table_All_Method();

						List<Table_Bean> addD2 = s2.selectTable_ElementB();

						allC = new Vector<Object>();

						for (int i = 0; i < addD2.size(); i++) {
							Vector<Object> row = new Vector<Object>();
							row.add(addD2.get(i).getId1());
							row.add(addD2.get(i).getSpname());
							row.add(addD2.get(i).getJc1());
							row.add(addD2.get(i).getDw());
							row.add(addD2.get(i).getGg());
							row.add(addD2.get(i).getBz());
							row.add(addD2.get(i).getPzwh());
							row.add(addD2.get(i).getMemo());
							row.add(addD2.get(i).getProviderID());
							allC.add(row);

						}

						button3C.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								JPanel panelR1 = new JPanel();
								JFrame frameR1 = new JFrame();
								
								Font fontA = new Font("", 30, 40);
								Font fontB = new Font("", 20, 20);
								Font fontC = new Font("", 100, 20);
								Color f = new Color(2);
								JButton buttonR1 = new JButton("确定");
								JButton buttonR2 = new JButton("取消");
								buttonR1.setFont(fontC);
								buttonR2.setFont(fontC);

								JLabel labelR1 = new JLabel("商品编号 ");
								JLabel labelR2 = new JLabel("商品名称 ");
								JLabel labelR3 = new JLabel("简  称       ");
								JLabel labelR4 = new JLabel("计量单位 ");
								JLabel labelR5 = new JLabel("规     格    ");
								JLabel labelR6 = new JLabel("标     准    ");
								JLabel labelR7 = new JLabel("批准文号 ");
								JLabel labelR8 = new JLabel("备        注 ");
								JLabel labelR9 = new JLabel("供应商编号");
								
								int row = tableC.getSelectedRow();
								if(row>-1) {
									Object update_database = tableC.getValueAt(row, 0);
									Object update_database1 = tableC.getValueAt(row, 1);
									Object update_database2 = tableC.getValueAt(row, 2);
									Object update_database3 = tableC.getValueAt(row, 3);
									Object update_database4 = tableC.getValueAt(row, 4);
									Object update_database5 = tableC.getValueAt(row, 5);
									Object update_database6 = tableC.getValueAt(row, 6);
									Object update_database7 = tableC.getValueAt(row, 7);
									Object update_database8 = tableC.getValueAt(row, 8);
									  op = String.valueOf(update_database);
									  op1 = String.valueOf(update_database1);
									  op2 = String.valueOf(update_database2);
									  op3 = String.valueOf(update_database3);
									  op4 = String.valueOf(update_database4);
									  op5 = String.valueOf(update_database5);
									  op6 = String.valueOf(update_database6);
									  op7 = String.valueOf(update_database7);
									  op8 = String.valueOf(update_database8);
								JTextField fieldR1 = new JTextField(op,13);
								JTextField fieldR2 = new JTextField(op1,13);
								JTextField fieldR3 = new JTextField(op2,13);
								JTextField fieldR4 = new JTextField(op3,13);
								JTextField fieldR5 = new JTextField(op4,13);
								JTextField fieldR6 = new JTextField(op5,13);
								JTextField fieldR7 = new JTextField(op6,13);
								JTextField fieldR8 = new JTextField(op7,13);
								JTextField fieldR9 = new JTextField(op8,13);

								labelR1.setForeground(f.BLUE);
								labelR1.setFont(font);
								labelR2.setForeground(f.BLUE);
								labelR2.setFont(font);
								labelR3.setForeground(f.BLUE);
								labelR3.setFont(font);
								labelR4.setForeground(f.BLUE);
								labelR4.setFont(font);
								labelR5.setForeground(f.BLUE);
								labelR5.setFont(font);
								labelR6.setForeground(f.BLUE);
								labelR6.setFont(font);
								labelR7.setForeground(f.BLUE);
								labelR7.setFont(font);
								labelR8.setForeground(f.BLUE);
								labelR8.setFont(font);
								labelR9.setForeground(f.BLUE);
								labelR9.setFont(font);

								fieldR1.setFont(fontB);
								fieldR2.setFont(fontB);
								fieldR3.setFont(fontB);
								fieldR4.setFont(fontB);
								fieldR5.setFont(fontB);
								fieldR6.setFont(fontB);
								fieldR7.setFont(fontB);
								fieldR8.setFont(fontB);
								fieldR9.setFont(fontB);

								buttonR1.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										bean = new Table_Bean();
										bean.setId1(fieldR1.getText());
										bean.setSpname(fieldR2.getText());
										bean.setJc1(fieldR3.getText());
										bean.setDw(fieldR4.getText());
										bean.setGg(fieldR5.getText());
										bean.setBz(fieldR6.getText());
										bean.setPzwh(fieldR7.getText());
										bean.setMemo(fieldR8.getText());
										bean.setProviderID(fieldR9.getText());

										Table_All_Method s = new Table_All_Method();
										s.updateTable_Element3(bean);
										List<Table_Bean> op = s.selectTable_ElementB();

										Vector<Object> allC = new Vector<Object>();

										for (int i = 0; i < op.size(); i++) {
											Vector<Object> row = new Vector<Object>();
											row.add(op.get(i).getId1());
											row.add(op.get(i).getSpname());
											row.add(op.get(i).getJc1());
											row.add(op.get(i).getDw());
											row.add(op.get(i).getGg());
											row.add(op.get(i).getBz());
											row.add(op.get(i).getPzwh());
											row.add(op.get(i).getMemo());
											row.add(op.get(i).getProviderID());
											allC.add(row);

										}

										Vector<Object> headAll = new Vector<Object>();
										headAll.add("商品编号");
										headAll.add("商品名称");
										headAll.add("简称");
										headAll.add("计量单位");
										headAll.add("规格");
										headAll.add("标准");
										headAll.add("批准文号");
										headAll.add("备注");
										headAll.add("供应商编号");

										defaultModel3 = new DefaultTableModel(allC,headAll);
										tableC.setModel(defaultModel3);
										tableC.setRowHeight(25);
										tableC.setPreferredScrollableViewportSize(new Dimension(1240, 800));
										jspC.setViewportView(tableC);
										panel4.add(jspC);
										frameR1.setVisible(false);

									}

								});


								panelR1.add(labelR1);
								panelR1.add(fieldR1);
								panelR1.add(labelR2);
								panelR1.add(fieldR2);
								panelR1.add(labelR3);
								panelR1.add(fieldR3);
								panelR1.add(labelR4);
								panelR1.add(fieldR4);
								panelR1.add(labelR5);
								panelR1.add(fieldR5);
								panelR1.add(labelR6);
								panelR1.add(fieldR6);
								panelR1.add(labelR7);
								panelR1.add(fieldR7);
								panelR1.add(labelR8);
								panelR1.add(fieldR8);
								panelR1.add(labelR9);
								panelR1.add(fieldR9);

								panelR1.add(buttonR1);
								panelR1.add(buttonR2);

								panelR1.add(buttonR1);
								panelR1.add(buttonR2);

								frameR1.add(panelR1);
								frameR1.setBounds(750, 300, 600, 600);
								frameR1.setSize(400, 500);
								frameR1.setVisible(true);
								frameR1.setTitle("修改行界面");
								frameR1.setResizable(false);
								}
								
								else {
									JOptionPane.showMessageDialog(frame,"未选中修改行","提示",JOptionPane.INFORMATION_MESSAGE);
								}
							}
						});

						button1C.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								JFrame frame;
								JPanel panel1;
								JTable tableA;
								DefaultTableModel modelA;
								JScrollPane scroll;
								frame = new JFrame();
								panel1 = new JPanel();
								scroll = new JScrollPane();
								String S1 = field1C.getText();
								String S2 = field2C.getText();
								Table_All_Method ss = new Table_All_Method();

								List<Table_Bean> addF = ss.selectTable_Element3(S1, S2);

								Vector<Object> allG = new Vector<Object>();
								for (int i = 0; i < addF.size(); i++) {
									Vector<Object> rowAll = new Vector<Object>();
									rowAll.add(addF.get(i).getId1());
									rowAll.add(addF.get(i).getSpname());
									rowAll.add(addF.get(i).getJc1());
									rowAll.add(addF.get(i).getDw());
									rowAll.add(addF.get(i).getGg());
									rowAll.add(addF.get(i).getBz());
									rowAll.add(addF.get(i).getPzwh());
									rowAll.add(addF.get(i).getMemo());
									rowAll.add(addF.get(i).getProviderID());
									allG.add(rowAll);
								}
								Vector<Object> headAll = new Vector<Object>();
								headAll.add("商品编号");
								headAll.add("商品名称");
								headAll.add("简称");
								headAll.add("计量单位");
								headAll.add("规格");
								headAll.add("标准");
								headAll.add("批准文号");
								headAll.add("备注");
								headAll.add("供应商编号");

								modelA = new DefaultTableModel(allG, headAll);
								tableA = new JTable(modelA);
								tableA.setEnabled(true);
								tableA.setPreferredScrollableViewportSize(new Dimension(780, 600));
								scroll.setViewportView(tableA);
								panel1.add(scroll);
								frame.add(panel1);
								frame.setBounds(750, 300, 600, 600);
								frame.add(panel1);
								frame.setSize(800, 600);
								frame.setVisible(true);

							}

						});

						button4C.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								int row = tableC.getSelectedRow(); 
									
								 if(row>-1) {
									 int  result = JOptionPane.showConfirmDialog(frame,"是否删除这条数据","提示信息",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
								  if(result == 0) {
								delete_database = tableC.getValueAt(row, 0);
								defaultModel3.removeRow(row);
								Table_All_Method se = new Table_All_Method();
								se.deleteTable_ElementB(delete_database);
									}
								}
								 else {
									 JOptionPane.showMessageDialog(frame,"未选中删除行","提示",JOptionPane.INFORMATION_MESSAGE);
								 }
							}

						});

						button2C.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								JFrame jframe = new JFrame();
								JPanel jpanel = new JPanel();
								JButton jbutton1, jbutton2;
								Font fontA = new Font("", 30, 40);
								Font fontB = new Font("", 20, 20);
								Font fontC = new Font("", 100, 20);
								Color f = new Color(2);
								jbutton1 = new JButton("确定");
								jbutton2 = new JButton("取消");
								jbutton1.setFont(fontC);
								jbutton2.setFont(fontC);
								JLabel jlabel1 = new JLabel("商品编号 ");
								JLabel jlabel2 = new JLabel("商品名称 ");
								JLabel jlabel3 = new JLabel("简  称       ");
								JLabel jlabel4 = new JLabel("计量单位 ");
								JLabel jlabel5 = new JLabel("规     格    ");
								JLabel jlabel6 = new JLabel("标     准    ");
								JLabel jlabel7 = new JLabel("批准文号 ");
								JLabel jlabel8 = new JLabel("备        注 ");
								JLabel jlabel9 = new JLabel("供应商编号");

								jlabel1.setForeground(f.BLUE);
								jlabel1.setFont(font);
								jlabel2.setForeground(f.BLUE);
								jlabel2.setFont(font);
								jlabel3.setForeground(f.BLUE);
								jlabel3.setFont(font);
								jlabel4.setForeground(f.BLUE);
								jlabel4.setFont(font);
								jlabel5.setForeground(f.BLUE);
								jlabel5.setFont(font);
								jlabel6.setForeground(f.BLUE);
								jlabel6.setFont(font);
								jlabel7.setForeground(f.BLUE);
								jlabel7.setFont(font);
								jlabel8.setForeground(f.BLUE);
								jlabel8.setFont(font);
								jlabel9.setForeground(f.BLUE);
								jlabel8.setFont(font);
								
								JTextField field1 = new JTextField(13);
								JTextField field2 = new JTextField(13);
								JTextField field3 = new JTextField(13);
								JTextField field4 = new JTextField(13);
								JTextField field5 = new JTextField(13);
								JTextField field6 = new JTextField(13);
								JTextField field7 = new JTextField(13);
								JTextField field8 = new JTextField(13);
								JTextField field9 = new JTextField(13);
								jbutton1.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										bean = new Table_Bean();
										bean.setId1(field1.getText());
										bean.setSpname(field2.getText());
										bean.setJc1(field3.getText()); 
										bean.setDw(field4.getText());
										bean.setGg(field5.getText());
										bean.setBz(field6.getText());
										bean.setPzwh(field7.getText());
										bean.setMemo(field8.getText());
										bean.setProviderID(field9.getText());

										Table_All_Method s = new Table_All_Method();
										   s.addTable_ElementB(bean);
										List<Table_Bean> er = s.selectTable_ElementB();
										Vector<Object> allC = new Vector<Object>();
										for (int i = 0; i < er.size(); i++) {
											Vector<Object> rowAll = new Vector<Object>();
											rowAll.add(er.get(i).getId1());
											rowAll.add(er.get(i).getSpname());
											rowAll.add(er.get(i).getJc1());
											rowAll.add(er.get(i).getDw());
											rowAll.add(er.get(i).getGg());
											rowAll.add(er.get(i).getBz());
											rowAll.add(er.get(i).getPzwh());
											rowAll.add(er.get(i).getMemo());
											rowAll.add(er.get(i).getProviderID());
											allC.add(rowAll);
										}
										Vector<Object> headAll = new Vector<Object>();
										
										headAll.add("商品编号");
										headAll.add("商品名称");
										headAll.add("简称");
										headAll.add("计量单位"); 
										headAll.add("规格");
										headAll.add("标准");
										headAll.add("批准文号");
										headAll.add("备注");
										headAll.add("供应商编号");
										defaultModel3 = new DefaultTableModel(allC,headAll);
										tableC.setModel(defaultModel3);
										tableC.setRowHeight(25);
										tableC.setPreferredScrollableViewportSize(new Dimension(1240, 800));
										jspC.setViewportView(tableC);
										panel4.add(jspC);
										jframe.setVisible(false);

									}
								});

								field1.setFont(fontB);
								field2.setFont(fontB);
								field3.setFont(fontB);
								field4.setFont(fontB);
								field5.setFont(fontB);
								field6.setFont(fontB);
								field7.setFont(fontB);
								field8.setFont(fontB);
								field9.setFont(fontB);

								jpanel.add(jlabel1);
								jpanel.add(field1);
								jpanel.add(jlabel2);
								jpanel.add(field2);
								jpanel.add(jlabel3);
								jpanel.add(field3);
								jpanel.add(jlabel4);
								jpanel.add(field4);
								jpanel.add(jlabel5);
								jpanel.add(field5);
								jpanel.add(jlabel6);
								jpanel.add(field6);
								jpanel.add(jlabel7);
								jpanel.add(field7);
								jpanel.add(jlabel8);
								jpanel.add(field8);
								jpanel.add(jbutton1);
								jpanel.add(jbutton2);
								jframe.setBounds(750, 300, 600, 600);
								jframe.add(jpanel);
								jframe.setSize(400, 500);
								jframe.setVisible(true);
								jframe.setResizable(false);

								jframe.setTitle("添加行元素");
							}
						});
						defaultModel3 = new DefaultTableModel(allC, headC);
						tableC = new JTable(defaultModel3);
						tableC.setEnabled(true);
						tableC.setRowHeight(25);
						tableC.setPreferredScrollableViewportSize(new Dimension(1240, 800));
						jspC = new JScrollPane();
						jspC.setViewportView(tableC);
						panel4.add(jspC);
						repaint();
					}

					else if (userObject.equals("仓库管理")) {
						panel3.removeAll();
						panel4.removeAll();
						label1D = new JLabel("品种数量");
						label2D = new JLabel("合计金额");
						label1D.setForeground(s.BLUE);
						label2D.setForeground(s.BLUE);
						label1D.setFont(font);
						label2D.setFont(font);
						field1D = new JTextField(12);
						field2D = new JTextField(12);
						field1D.setFont(font);
						field2D.setFont(font);
						button1D = new JButton("搜索");
						button2D = new JButton("添加");
						button3D = new JButton("修改");
						button4D = new JButton("删除");
						panel3.add(label1D);
						panel3.add(field1D);
						panel3.add(label2D);
						panel3.add(field2D);
						panel3.add(button1D);
						panel3.add(button2D);
						panel3.add(button3D);
						panel3.add(button4D);

						Vector<Object> headD = new Vector<Object>();
						headD.add("入库编号");
						headD.add("品种数量");
						headD.add("合计金额");
						headD.add("验收结论");
						headD.add("供应商编号");
						headD.add("入库时间");
						headD.add("操作员");
						headD.add("经手人");
						headD.add("结算方式");

						Table_All_Method s1 = new Table_All_Method();

						List<Table_Bean> addD1 = s1.selectTable_ElementC();

						allD = new Vector<Object>();

						for (int i = 0; i < addD1.size(); i++) {
							Vector<Object> row = new Vector<Object>();
							row.add(addD1.get(i).getRkid());
							row.add(addD1.get(i).getPzsA());
							row.add(addD1.get(i).getJeA());
							row.add(addD1.get(i).getYsjlA());
							row.add(addD1.get(i).getProviderIDA());
							row.add(addD1.get(i).getRkidA());
							row.add(addD1.get(i).getCzyA());
							row.add(addD1.get(i).getJsrA());
							row.add(addD1.get(i).getJsfsA());
							allD.add(row);

						}

						button3D.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								JPanel panelR1 = new JPanel();
								JFrame frameR1 = new JFrame();

								Font fontA = new Font("", 30, 40);
								Font fontB = new Font("", 20, 20);
								Font fontC = new Font("", 100, 20);
								Color f = new Color(2);
								JButton buttonR1 = new JButton("确定");
								JButton buttonR2 = new JButton("取消");
								buttonR1.setFont(fontC);
								buttonR2.setFont(fontC);
								JLabel labelR1 = new JLabel("入库编号    ");
								JLabel labelR2 = new JLabel("品种数量    ");
								JLabel labelR3 = new JLabel("合计金额    ");
								JLabel labelR4 = new JLabel("验收结论    ");
								JLabel labelR5 = new JLabel("供应商编号");
								JLabel labelR6 = new JLabel("入库时间    ");
								JLabel labelR7 = new JLabel("操   作  员   ");
								JLabel labelR8 = new JLabel("经    手    人");
								JLabel labelR9 = new JLabel("结算方式    ");
								int row = tableD.getSelectedRow();
								if(row>-1) {
									Object update_database = tableD.getValueAt(row, 0);
									Object update_database1 = tableD.getValueAt(row, 1);
									Object update_database2 = tableD.getValueAt(row, 2);
									Object update_database3 = tableD.getValueAt(row, 3);
									Object update_database4 = tableD.getValueAt(row, 4);
									Object update_database5 = tableD.getValueAt(row, 5);
									Object update_database6 = tableD.getValueAt(row, 6);
									Object update_database7 = tableD.getValueAt(row, 7);
									Object update_database8 = tableD.getValueAt(row, 8);
									  op = String.valueOf(update_database);
									  op1 = String.valueOf(update_database1);
									  op2 = String.valueOf(update_database2);
									  op3 = String.valueOf(update_database3);
									  op4 = String.valueOf(update_database4);
									  op5 = String.valueOf(update_database5);
									  op6 = String.valueOf(update_database6);
									  op7 = String.valueOf(update_database7);
									  op8 = String.valueOf(update_database8);
									
								JTextField fieldR1 = new JTextField(op,13);
								JTextField fieldR2 = new JTextField(op1,13);
								JTextField fieldR3 = new JTextField(op2,13);
								JTextField fieldR4 = new JTextField(op3,13);
								JTextField fieldR5 = new JTextField(op4,13);
								JTextField fieldR6 = new JTextField(op5,13);
								JTextField fieldR7 = new JTextField(op6,13);
								JTextField fieldR8 = new JTextField(op7,13);
								JTextField fieldR9 = new JTextField(op8,13);

								labelR1.setForeground(f.BLUE);
								labelR1.setFont(font);
								labelR2.setForeground(f.BLUE);
								labelR2.setFont(font); 
								labelR3.setForeground(f.BLUE);
								labelR3.setFont(font);
								labelR4.setForeground(f.BLUE);
								labelR4.setFont(font);
								labelR5.setForeground(f.BLUE);
								labelR5.setFont(font);
								labelR6.setForeground(f.BLUE);
								labelR6.setFont(font);
								labelR7.setForeground(f.BLUE);
								labelR7.setFont(font);
								labelR8.setForeground(f.BLUE);
								labelR8.setFont(font);
								labelR9.setForeground(f.BLUE);
								labelR9.setFont(font);

								fieldR1.setFont(fontB);
								fieldR2.setFont(fontB);
								fieldR3.setFont(fontB);
								fieldR4.setFont(fontB);
								fieldR5.setFont(fontB);
								fieldR6.setFont(fontB);
								fieldR7.setFont(fontB);
								fieldR8.setFont(fontB);
								fieldR9.setFont(fontB);

								buttonR1.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										bean = new Table_Bean();
										bean.setRkid(fieldR1.getText());
										bean.setPzsA(fieldR2.getText());
										bean.setJeA(fieldR3.getText());
										bean.setYsjlA(fieldR4.getText());
										bean.setProviderIDA(fieldR5.getText());
										bean.setRkidA(fieldR6.getText());
										bean.setCzyA(fieldR7.getText());
										bean.setJsrA(fieldR8.getText());
										bean.setJsfsA(fieldR9.getText());

										Table_All_Method s = new Table_All_Method();
										s.updateTable_Element4(bean);
										List<Table_Bean> op = s.selectTable_ElementC();
										  
										Vector<Object> allD = new Vector<Object>();
										for (int i = 0; i < op.size(); i++) {
											Vector<Object> rowAll = new Vector<Object>();
											rowAll.add(op.get(i).getRkid());
											rowAll.add(op.get(i).getPzsA());
											rowAll.add(op.get(i).getJeA());
											rowAll.add(op.get(i).getYsjlA());
											rowAll.add(op.get(i).getProviderIDA());
											rowAll.add(op.get(i).getRkidA());
											rowAll.add(op.get(i).getCzyA());
											rowAll.add(op.get(i).getJsrA());
											rowAll.add(op.get(i).getJsfsA());
											allD.add(rowAll);
										}
										Vector<Object> headAll = new Vector<Object>();
										headAll.add("入库编号");
										headAll.add("品种数量");
										headAll.add("合计金额");
										headAll.add("验收结论");
										headAll.add("供应商编号");
										headAll.add("入库时间");
										headAll.add("操作员");
										headAll.add("经手人");
										headAll.add("结算方式");

										defaultModel4 = new DefaultTableModel(allD,headAll);
										tableD.setModel(defaultModel4);
										tableD.setRowHeight(25);
										tableD.setPreferredScrollableViewportSize(new Dimension(1240, 800));
										jspD.setViewportView(tableD);
										panel4.add(jspD);
										frameR1.setVisible(false);


									}

								});
								
								panelR1.add(labelR1);
								panelR1.add(fieldR1);
								panelR1.add(labelR2);
								panelR1.add(fieldR2);
								panelR1.add(labelR3);
								panelR1.add(fieldR3);
								panelR1.add(labelR4);
								panelR1.add(fieldR4);
								panelR1.add(labelR5);
								panelR1.add(fieldR5);
								panelR1.add(labelR6);
								panelR1.add(fieldR6);
								panelR1.add(labelR7);
								panelR1.add(fieldR7);
								panelR1.add(labelR8);
								panelR1.add(fieldR8);
								panelR1.add(labelR9);
								panelR1.add(fieldR9);

								panelR1.add(buttonR1);
								panelR1.add(buttonR2);

								frameR1.add(panelR1);
								frameR1.setBounds(750, 300, 600, 600);
								frameR1.setSize(400, 500);
								frameR1.setVisible(true);
								frameR1.setTitle("修改行界面");
								frameR1.setResizable(false);
								}
							
							else {
								JOptionPane.showMessageDialog(frame,"未选中修改行","提示",JOptionPane.INFORMATION_MESSAGE);
							  }
								
							}	
						});

						button1D.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								JFrame frame;
								JPanel panel1;
								JTable tableA;
								DefaultTableModel modelA;
								JScrollPane scroll;
								frame = new JFrame();
								panel1 = new JPanel();
								scroll = new JScrollPane();
								String S1 = field1D.getText();
								String S2 = field2D.getText();
								Table_All_Method ss = new Table_All_Method();

								List<Table_Bean> addF = ss.selectTable_Element4(S1, S2);

								Vector<Object> allG = new Vector<Object>();
								for (int i = 0; i < addF.size(); i++) {
									Vector<Object> rowAll = new Vector<Object>();
									rowAll.add(addD1.get(i).getRkid());
									rowAll.add(addD1.get(i).getPzsA());
									rowAll.add(addD1.get(i).getJeA());
									rowAll.add(addD1.get(i).getYsjlA());
									rowAll.add(addD1.get(i).getProviderIDA());
									rowAll.add(addD1.get(i).getRkidA());
									rowAll.add(addD1.get(i).getCzyA());
									rowAll.add(addD1.get(i).getJsrA());
									rowAll.add(addD1.get(i).getJsfsA());
									allG.add(rowAll);
								}
								Vector<Object> headAll = new Vector<Object>();
								headAll.add("入库编号");
								headAll.add("品种数量");
								headAll.add("合计金额");
								headAll.add("验收结论");
								headAll.add("供应商编号");
								headAll.add("入库时间");
								headAll.add("操作员");
								headAll.add("经手人");
								headAll.add("结算方式");

								modelA = new DefaultTableModel(allG, headAll);
								tableA = new JTable(modelA);
								tableA.setEnabled(true);
								tableA.setPreferredScrollableViewportSize(new Dimension(780, 600));
								scroll.setViewportView(tableA);
								panel1.add(scroll);
								frame.add(panel1);
								frame.setBounds(750, 300, 600, 600);
								frame.add(panel1);
								frame.setSize(800, 600);
								frame.setVisible(true);

							}

						});

						button4D.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								
								 int row = tableD.getSelectedRow();
							  if(row>-1) {	
								  int  result = JOptionPane.showConfirmDialog(frame,"是否删除这条数据","提示信息",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
							  if(result == 0) {
								delete_database = tableD.getValueAt(row, 0);
								defaultModel4.removeRow(row);
								Table_All_Method se = new Table_All_Method();
								se.deleteTable_ElementC(delete_database);
									} 
								 } 
								 else {
									 JOptionPane.showMessageDialog(frame,"未选中删除行","提示",JOptionPane.INFORMATION_MESSAGE);
								 }
							}

						});

						button2D.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								JFrame jframe = new JFrame();
								JPanel jpanel = new JPanel();
								JButton jbutton1, jbutton2;
								Font fontA = new Font("", 30, 40);
								Font fontB = new Font("", 20, 20);
								Font fontC = new Font("", 100, 20);
								Color f = new Color(2);
								jbutton1 = new JButton("确定");
								jbutton2 = new JButton("取消");
								jbutton1.setFont(fontC);
								jbutton2.setFont(fontC);
								JLabel jlabel1 = new JLabel("入库编号    ");
								JLabel jlabel2 = new JLabel("品种数量    ");
								JLabel jlabel3 = new JLabel("合计金额    ");
								JLabel jlabel4 = new JLabel("验收结论    ");
								JLabel jlabel5 = new JLabel("供应商编号");
								JLabel jlabel6 = new JLabel("入库时间    ");
								JLabel jlabel7 = new JLabel("操   作  员   ");
								JLabel jlabel8 = new JLabel("经    手    人");
								JLabel jlabel9 = new JLabel("结算方式    ");

								jlabel1.setForeground(f.BLUE);
								jlabel1.setFont(font);
								jlabel2.setForeground(f.BLUE);
								jlabel2.setFont(font);
								jlabel3.setForeground(f.BLUE);
								jlabel3.setFont(font);
								jlabel4.setForeground(f.BLUE);
								jlabel4.setFont(font);
								jlabel5.setForeground(f.BLUE);
								jlabel5.setFont(font);
								jlabel6.setForeground(f.BLUE);
								jlabel6.setFont(font);
								jlabel7.setForeground(f.BLUE);
								jlabel7.setFont(font);
								jlabel8.setForeground(f.BLUE);
								jlabel8.setFont(font);
								jlabel9.setForeground(f.BLUE);
								jlabel9.setFont(font);
								
								JTextField field1 = new JTextField(13);
								JTextField field2 = new JTextField(13);
								JTextField field3 = new JTextField(13);
								JTextField field4 = new JTextField(13);
								JTextField field5 = new JTextField(13);
								JTextField field6 = new JTextField(13);
								JTextField field7 = new JTextField(13);
								JTextField field8 = new JTextField(13);
								JTextField field9 = new JTextField(13);
								jbutton1.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										bean = new Table_Bean();
										bean.setRkid(field1.getText());
										bean.setPzsA(field2.getText());
										bean.setJeA(field3.getText());
										bean.setYsjlA(field4.getText());
										bean.setProviderIDA(field5.getText());
										bean.setRkidA(field6.getText());
										bean.setCzyA(field7.getText());
										bean.setJsrA(field8.getText());
										bean.setJsfsA(field9.getText());

										Table_All_Method s = new Table_All_Method();
										s.addTable_ElementC(bean);
										List<Table_Bean> er = s.selectTable_ElementC();
 
										Vector<Object> allD = new Vector<Object>();
										for (int i = 0; i < er.size(); i++) {
											Vector<Object> rowAll = new Vector<Object>();
											rowAll.add(er.get(i).getRkid());
											rowAll.add(er.get(i).getPzsA());
											rowAll.add(er.get(i).getJeA());
											rowAll.add(er.get(i).getYsjlA());
											rowAll.add(er.get(i).getProviderIDA());
											rowAll.add(er.get(i).getRkidA());
											rowAll.add(er.get(i).getCzyA());
											rowAll.add(er.get(i).getJsrA());
											rowAll.add(er.get(i).getJsfsA());
											allD.add(rowAll);
										}
										Vector<Object> headAll = new Vector<Object>();
										headAll.add("入库编号");
										headAll.add("品种数量");
										headAll.add("合计金额");
										headAll.add("验收结论");
										headAll.add("供应商编号");
										headAll.add("入库时间");
										headAll.add("操作员");
										headAll.add("经手人");
										headAll.add("结算方式");

										defaultModel4 = new DefaultTableModel(allD,headAll);
										tableD.setRowHeight(25);
										tableD.setModel(defaultModel4);
										tableD.setPreferredScrollableViewportSize(new Dimension(1240, 800));
										jspD.setViewportView(tableD);
										panel4.add(jspD);
										jframe.setVisible(false);

									}
								});

								field1.setFont(fontB);
								field2.setFont(fontB);
								field3.setFont(fontB);
								field4.setFont(fontB);
								field5.setFont(fontB);
								field6.setFont(fontB);
								field7.setFont(fontB);
								field8.setFont(fontB);
								field9.setFont(fontB);

								jpanel.add(jlabel1);
								jpanel.add(field1);
								jpanel.add(jlabel2);
								jpanel.add(field2);
								jpanel.add(jlabel3);
								jpanel.add(field3);
								jpanel.add(jlabel4);
								jpanel.add(field4);
								jpanel.add(jlabel5);
								jpanel.add(field5);
								jpanel.add(jlabel6);
								jpanel.add(field6);
								jpanel.add(jlabel7);
								jpanel.add(field7);
								jpanel.add(jlabel8);
								jpanel.add(field8);
								jpanel.add(jlabel9);
								jpanel.add(field9);
								jpanel.add(jbutton1);
								jpanel.add(jbutton2);
								jframe.setBounds(750, 300, 600, 600);
								jframe.add(jpanel);
								jframe.setSize(400, 500);
								jframe.setVisible(true);
								jframe.setResizable(false);

								jframe.setTitle("添加行元素");

							}

						});
						defaultModel4 = new DefaultTableModel(allD, headD);
						tableD = new JTable(defaultModel4);
						tableD.setEnabled(true);
						tableD.setRowHeight(25);
						tableD.setPreferredScrollableViewportSize(new Dimension(1240, 800));
						jspD = new JScrollPane();
						jspD.setViewportView(tableD);

						panel4.add(jspD);
						repaint();
					} else if (userObject.equals("职务管理")) {
						panel3.removeAll();
						panel4.removeAll();

						label1E = new JLabel("职务名称");
						label2E = new JLabel("部门编号");
						label1E.setForeground(s.BLUE);
						label2E.setForeground(s.BLUE);
						label1E.setFont(font);
						label2E.setFont(font);
						field1E = new JTextField(12);
						field2E = new JTextField(12); 
						field1E.setFont(font);
						field2E.setFont(font);
						button1E = new JButton("搜索");
						button2E = new JButton("添加");
						button3E = new JButton("修改");
						button4E = new JButton("删除");
						panel3.add(label1E);
						panel3.add(field1E);
						panel3.add(label2E);
						panel3.add(field2E);
						panel3.add(button1E);
						panel3.add(button2E);
						panel3.add(button3E);
						panel3.add(button4E);

						Vector<Object> headE = new Vector<Object>();
						headE.add("职务编号");
						headE.add("职务名称");
						headE.add("所属部门编号");
						headE.add("说明");

						Table_All_Method s2 = new Table_All_Method();

						List<Table_Bean> addD2 = s2.selectTable_ElementD();

						allE = new Vector<Object>();

						for (int i = 0; i < addD2.size(); i++) {
							Vector<Object> row = new Vector<Object>();
							row.add(addD2.get(i).getIDB());
							row.add(addD2.get(i).getNameB());
							row.add(addD2.get(i).getDepID());
							row.add(addD2.get(i).getDesc());
							allE.add(row);

						}

						button3E.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								JPanel panelR1 = new JPanel();
								JFrame frameR1 = new JFrame();
								
								Font fontA = new Font("", 30, 40);
								Font fontB = new Font("", 20, 20);
								Font fontC = new Font("", 100, 20);
								Color f = new Color(2);
								JButton buttonR1 = new JButton("确定");
								JButton buttonR2 = new JButton("取消");
								buttonR1.setFont(fontC);
								buttonR2.setFont(fontC);

								JLabel labelR1 = new JLabel("职 务 编 号    ");
								JLabel labelR2 = new JLabel("职 务 名  称   ");
								JLabel labelR3 = new JLabel("所属部门编号");
								JLabel labelR4 = new JLabel("说             明  ");
								
								int row = tableE.getSelectedRow(); 
								
								if(row>-1) {
								
								Object update_database = tableE.getValueAt(row, 0);
								Object update_database1 = tableE.getValueAt(row, 1);
								Object update_database2 = tableE.getValueAt(row, 2);
								Object update_database3 = tableE.getValueAt(row, 3);
								  op = String.valueOf(update_database);
								  op1 = String.valueOf(update_database1);
								  op2 = String.valueOf(update_database2);
								  op3 = String.valueOf(update_database3);
								
								JTextField fieldR1 = new JTextField(op,13);
								JTextField fieldR2 = new JTextField(op1,13);
								JTextField fieldR3 = new JTextField(op2,13);
								JTextField fieldR4 = new JTextField(op3,13);

								labelR1.setForeground(f.BLUE);
								labelR1.setFont(font);
								labelR2.setForeground(f.BLUE);
								labelR2.setFont(font);
								labelR3.setForeground(f.BLUE); 
								labelR3.setFont(font);
								labelR4.setForeground(f.BLUE);
								labelR4.setFont(font);

								fieldR1.setFont(fontB);
								fieldR2.setFont(fontB);
								fieldR3.setFont(fontB);
								fieldR4.setFont(fontB);
								
								buttonR1.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										bean = new Table_Bean();
										bean.setIDB(fieldR1.getText());
										bean.setNameB(fieldR2.getText());
										bean.setDepID(fieldR3.getText());
										bean.setDesc(fieldR4.getText());

										Table_All_Method s = new Table_All_Method();
										s.updateTable_Element5(bean);
								        List<Table_Bean> op = s.selectTable_ElementD();
								        allE = new Vector<Object>();

										for (int i = 0; i < op.size(); i++) {
											Vector<Object> row = new Vector<Object>();
											row.add(op.get(i).getIDB());
											row.add(op.get(i).getNameB());
											row.add(op.get(i).getDepID());
											row.add(op.get(i).getDesc());
											allE.add(row);
											Vector<Object> headAll = new Vector<Object>();
											headAll.add("职 务 编 号");
											headAll.add("职 务 名 称  ");
											headAll.add("所属部门编号");
											headAll.add("说明");
											
											defaultModel5 = new DefaultTableModel(allE,headAll);
											tableE.setRowHeight(25);
											tableE.setModel(defaultModel5);
											tableE.setPreferredScrollableViewportSize(new Dimension(1240, 800));
											jspE.setViewportView(tableE);
											panel4.add(jspE);
											frameR1.setVisible(false);
										}
									}

								});
								

								panelR1.add(labelR1);
								panelR1.add(fieldR1);
								panelR1.add(labelR2);
								panelR1.add(fieldR2);
								panelR1.add(labelR3);
								panelR1.add(fieldR3);
								panelR1.add(labelR4);
								panelR1.add(fieldR4);
								panelR1.add(buttonR1);
								panelR1.add(buttonR2);

								frameR1.add(panelR1);
								frameR1.setBounds(750, 300, 600, 600);
								frameR1.setSize(400, 300);
								frameR1.setVisible(true);
								frameR1.setTitle("修改行界面");
								frameR1.setResizable(false);

							 }
								else {
									
									JOptionPane.showMessageDialog(frame,"未选中修改行","提示",JOptionPane.INFORMATION_MESSAGE);
							   }		
							}

						});
                        
						
						button1E.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								JFrame frame;
								JPanel panel1;
								JTable tableA;
								DefaultTableModel modelA;
								JScrollPane scroll;
								frame = new JFrame();
								panel1 = new JPanel();
								scroll = new JScrollPane();
								String S1 = field1E.getText();
								String S2 = field2E.getText();
								Table_All_Method ss = new Table_All_Method();

								List<Table_Bean> addF = ss.selectTable_Element5(S1, S2);

								Vector<Object> allG = new Vector<Object>();
								for (int i = 0; i < addF.size(); i++) {
									Vector<Object> rowAll = new Vector<Object>();
									rowAll.add(addF.get(i).getIDB());
									rowAll.add(addF.get(i).getNameB());
									rowAll.add(addF.get(i).getDepID());
									rowAll.add(addF.get(i).getDesc());
									allG.add(rowAll);
								}
								Vector<Object> headAll = new Vector<Object>();
								headAll.add("职 务 编 号");
								headAll.add("职 务 名 称  ");
								headAll.add("所属部门编号");
								headAll.add("说明");
								modelA = new DefaultTableModel(allG, headAll);
								tableA = new JTable(modelA);
								tableA.setEnabled(true);
								tableA.setPreferredScrollableViewportSize(new Dimension(780, 600));
								scroll.setViewportView(tableA);
								panel1.add(scroll);
								frame.add(panel1);
								frame.setBounds(750, 300, 600, 600);
								frame.add(panel1);
								frame.setSize(800, 600);
								frame.setVisible(true);

							}

						});

						button4E.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								 int row = tableE.getSelectedRow(); 
                              
								if(row>-1) {
									int  result = JOptionPane.showConfirmDialog(frame,"是否删除这条数据","提示信息",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                if(result == 0) {
								delete_database = tableE.getValueAt(row, 0);
								defaultModel5.removeRow(row);
								Table_All_Method se = new Table_All_Method();
								se.deleteTable_ElementD(delete_database);
								  }
								}
								 else {
									 JOptionPane.showMessageDialog(frame,"未选中删除行","提示",JOptionPane.INFORMATION_MESSAGE);
								 }
							}

						});
					
						button2E.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
							 
							   
								JFrame jframe = new JFrame();
								JPanel jpanel = new JPanel();
								JButton jbutton1, jbutton2;
								Font fontA = new Font("", 30, 40);
								Font fontB = new Font("", 20, 20);
								Font fontC = new Font("", 100, 20);
								Color f = new Color(2);
								jbutton1 = new JButton("确定");
								jbutton2 = new JButton("取消");
								jbutton1.setFont(fontC);
								jbutton2.setFont(fontC);
								JLabel jlabel1 = new JLabel("职 务 编 号     ");
								JLabel jlabel2 = new JLabel("职 务 名 称     ");
								JLabel jlabel3 = new JLabel("所属部门编号 ");
								JLabel jlabel4 = new JLabel("说             明   ");

								jlabel1.setForeground(f.BLUE);
								jlabel1.setFont(font);
								jlabel2.setForeground(f.BLUE);
								jlabel2.setFont(font);
								jlabel3.setForeground(f.BLUE);
								jlabel3.setFont(font);
								jlabel4.setForeground(f.BLUE);
								jlabel4.setFont(font);
								JTextField field1 = new JTextField(13);
								JTextField field2 = new JTextField(13);
								JTextField field3 = new JTextField(13);
								JTextField field4 = new JTextField(13);
								
								jbutton1.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										bean = new Table_Bean(); 
										bean.setIDB(field1.getText());
										bean.setNameB(field2.getText());
										bean.setDepID(field3.getText());
										bean.setDesc(field4.getText());
										Table_All_Method s = new Table_All_Method();
										s.addTable_ElementD(bean);
										List<Table_Bean> er = s.selectTable_ElementD();

										Vector<Object> allG = new Vector<Object>();
										for (int i = 0; i < er.size(); i++) {
											Vector<Object> rowAll = new Vector<Object>();
											rowAll.add(er.get(i).getIDB());
											rowAll.add(er.get(i).getNameB());
											rowAll.add(er.get(i).getDepID());
											rowAll.add(er.get(i).getDesc());
											allG.add(rowAll);
										}
										Vector<Object> headAll = new Vector<Object>();
										headAll.add("职 务 编 号");
										headAll.add("职 务 名 称  ");
										headAll.add("所属部门编号");
										headAll.add("说明");
										
										defaultModel5 = new DefaultTableModel(allG,headAll);
										tableE.setModel(defaultModel5);
										tableE.setRowHeight(25);
										tableE.setPreferredScrollableViewportSize(new Dimension(1240, 800));
										jspE.setViewportView(tableE);
										panel4.add(jspE);
										jframe.setVisible(false);
										
									
									}
								});

								field1.setFont(fontB);
								field2.setFont(fontB);
								field3.setFont(fontB);
								field4.setFont(fontB);

								jpanel.add(jlabel1);
								jpanel.add(field1);
								jpanel.add(jlabel2);
								jpanel.add(field2);
								jpanel.add(jlabel3);
								jpanel.add(field3);
								jpanel.add(jlabel4);
								jpanel.add(field4);
								jpanel.add(jbutton1);
								jpanel.add(jbutton2);
								jframe.setBounds(750, 300, 600, 600);
								jframe.add(jpanel);
								jframe.setSize(400, 300);
								jframe.setVisible(true);
								jframe.setResizable(false);

								jframe.setTitle("添加行元素");
							 }
							

						});

						defaultModel5 = new DefaultTableModel(allE, headE);
						tableE = new JTable(defaultModel5);
						tableE.setEnabled(true);
						tableE.setRowHeight(25);
						tableE.setPreferredScrollableViewportSize(new Dimension(1240, 800));
						jspE = new JScrollPane();
						jspE.setViewportView(tableE);

						panel4.add(jspE);
						repaint();

					 }
				}
				
			}
		});
	   
	
		rootTree.add(childTree1);
		rootTree.add(childTree2);
		rootTree.add(childTree3);
		rootTree.add(childTree4);
		rootTree.add(childTree5); 
		panel2.add(label);
		panel2.add(tree);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		panel4.setBackground(Color.lightGray);
		//frame.setVisible(true);
		//frame.setSize(1380, 900);
		//frame.setTitle("基本档案管理");
	} 

	/*public static void main(String[] args) {
		new Wickket_Method();
	} 
*/
}
