package SuperMarket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Output_Goods extends JFrame {
	private JFrame frame, frameA;
	private JPanel panel1, panel2, panelA;
	private JTextField field1,field2,textfieldA, textfieldB, textfieldC, textfieldD, textfieldE, textfieldF, textfieldG;
	private JLabel label1, label2, labelA, labelB, labelC, labelD, labelE, labelF, labelG;
	private JButton button1, button2, button3, button4, buttonA, buttonB;
	private JSplitPane splitpane;
	private JScrollPane scrollpane; 
	private JTable table;
	private DefaultTableModel model;
	private String op1, op2, op3, op4, op5, op6, op7;
	private Output_Goods_Bean output_goods_bean;
	private String delete_databases;
	public static int count = 0;
	public Output_Goods(JSplitPane splitpane1) {
		Font font = new Font("", 30, 25);
		Font font1 = new Font("", 30, 18);
		Font font2 = new Font("", 30, 22);
		Color color = new Color(2);

		button1 = new JButton("搜索 ");
		button2 = new JButton("添加");
		button3 = new JButton("修改");
		button4 = new JButton("删除");
		
		button1.addActionListener(new ActionListener() {
 
			public void actionPerformed(ActionEvent arg0) {
				JFrame jframe = new JFrame();
				JPanel panelB = new JPanel();
				String itemField = field1.getText();
				String itemField1 = field2.getText();
				Output_Goods_All_method s = new Output_Goods_All_method();
				List<Output_Goods_Bean> all = s.select_output_goods(itemField,itemField1);
				
				Vector<Object> rowAll = new Vector<Object>();
				for (int i = 0; i < all.size(); i++) { 
					Vector<Object> row = new Vector<Object>();
					row.add(all.get(i).getBianhao());
					row.add(all.get(i).getCangkubianhao());
					row.add(all.get(i).getHuopinmingcheng());
					row.add(all.get(i).getChukushijian());
					row.add(all.get(i).getZhongliang());
					row.add(all.get(i).getBeizhu());
					rowAll.add(row);

				}

				Vector<Object> head = new Vector<Object>();
				head.add("编 号");
				head.add("仓库编号");
				head.add("货品名称");
				head.add("出库时间");
				head.add("重量");
				head.add("备注"); 

				DefaultTableModel defaultmodel = new DefaultTableModel(rowAll, head);
				JTable tableB = new JTable(defaultmodel);
				tableB.setEnabled(true);
				tableB.setPreferredScrollableViewportSize(new Dimension(900, 800));
				JScrollPane jsp = new JScrollPane();
				jsp.setViewportView(tableB);
				panelB.add(jsp);
				jframe.add(panelB);
				jframe.setTitle("查询");
				jframe.setVisible(true);
				jframe.setBounds(750, 300, 600, 600);
				jframe.setSize(925, 600);
				
				field1.setText(null);
				field2.setText(null);
				
			}
			
		});
		
		 
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel jpanel1 = new JPanel();
				JFrame jframe = new JFrame();
				JButton jbutton1 = new JButton("确定");
				JButton jbutton2 = new JButton("取消");

				Font font1 = new Font("", 20, 25);
				Font font2 = new Font("", 20, 20);
				Font font3 = new Font("", 100, 20);
				Color color = new Color(2);

				JLabel jlabel1 = new JLabel("商品编号");
				JLabel jlabel2 = new JLabel("仓库编号");
				JLabel jlabel3 = new JLabel("货品名称");
				JLabel jlabel4 = new JLabel("出库时间");
				JLabel jlabel5 = new JLabel("商品重量");
				JLabel jlabel6 = new JLabel("商品备注");

				jlabel1.setFont(font1);
				jlabel1.setForeground(color.BLUE);
				jlabel2.setFont(font1);
				jlabel2.setForeground(color.BLUE);
				jlabel3.setFont(font1);
				jlabel3.setForeground(color.BLUE);
				jlabel4.setFont(font1);
				jlabel4.setForeground(color.BLUE);
				jlabel5.setFont(font1);
				jlabel5.setForeground(color.BLUE);
				jlabel6.setFont(font1);
				jlabel6.setForeground(color.BLUE);
				jbutton1.setFont(font1);
				jbutton2.setFont(font1);
				int row = table.getSelectedRow();
				if (row > -1) {
					Object update_database1 = table.getValueAt(row, 0);
					Object update_database2 = table.getValueAt(row, 1);
					Object update_database3 = table.getValueAt(row, 2);
					Object update_database4 = table.getValueAt(row, 3);
					Object update_database5 = table.getValueAt(row, 4);
					Object update_database6 = table.getValueAt(row, 5);
					op1 = String.valueOf(update_database1);
					op2 = String.valueOf(update_database2);
					op3 = String.valueOf(update_database3);
					op4 = String.valueOf(update_database4);
					op5 = String.valueOf(update_database5);
					op6 = String.valueOf(update_database6);

					JTextField jtextfield1 = new JTextField(op1, 12);
					JTextField jtextfield2 = new JTextField(op2, 12);
					JTextField jtextfield3 = new JTextField(op3, 12);
					JTextField jtextfield4 = new JTextField(op4, 12);
					JTextField jtextfield5 = new JTextField(op5, 12);
					JTextField jtextfield6 = new JTextField(op6, 12);

					jtextfield1.setFont(font2);
					jtextfield1.setForeground(color.RED);
					jtextfield2.setFont(font2); 
					jtextfield2.setForeground(color.RED);
					jtextfield3.setFont(font2);
					jtextfield3.setForeground(color.RED);
					jtextfield4.setFont(font2);
					jtextfield4.setForeground(color.RED);
					jtextfield5.setFont(font2);
					jtextfield5.setForeground(color.RED);
					jtextfield6.setFont(font2);
					jtextfield6.setForeground(color.RED);

					jpanel1.add(jlabel1);
					jpanel1.add(jtextfield1);
					jpanel1.add(jlabel2);
					jpanel1.add(jtextfield2);
					jpanel1.add(jlabel3);
					jpanel1.add(jtextfield3);
					jpanel1.add(jlabel4);
					jpanel1.add(jtextfield4);
					jpanel1.add(jlabel5);
					jpanel1.add(jtextfield5);
					jpanel1.add(jlabel6);
					jpanel1.add(jtextfield6);
					jpanel1.add(jbutton1);
					jpanel1.add(jbutton2);
					jbutton1.setFont(font1);
					jbutton2.setFont(font1);

					jbutton1.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent arg0) {
							output_goods_bean = new Output_Goods_Bean();
							output_goods_bean.setBianhao(jtextfield1.getText());
							output_goods_bean.setCangkubianhao(jtextfield2.getText());
							output_goods_bean.setHuopinmingcheng(jtextfield3.getText());
							output_goods_bean.setChukushijian(jtextfield4.getText());
							output_goods_bean.setZhongliang(jtextfield5.getText());
							output_goods_bean.setBeizhu(jtextfield6.getText());
							Output_Goods_All_method er = new Output_Goods_All_method();
							er.update_output_goods(output_goods_bean);
							List<Output_Goods_Bean> bianli = er.select_output_goods();
 
							Vector<Object> rowAll = new Vector<Object>();

							for (int i = 0; i < bianli.size(); i++) {
								Vector<Object> row = new Vector<Object>();
								row.add(bianli.get(i).getBianhao());
								row.add(bianli.get(i).getCangkubianhao());
								row.add(bianli.get(i).getHuopinmingcheng());
								row.add(bianli.get(i).getChukushijian());
								row.add(bianli.get(i).getZhongliang());
								row.add(bianli.get(i).getBeizhu());
								rowAll.add(row);

							}

							Vector<Object> tableHead = new Vector<Object>();
							tableHead.add("编 号");
							tableHead.add("仓库编号");
							tableHead.add("货品名称");
							tableHead.add("出库时间");
							tableHead.add("重量");
					        tableHead.add("备注"); 

							model = new DefaultTableModel(rowAll, tableHead);
							table.setModel(model);
							table.setPreferredScrollableViewportSize(new Dimension(1350, 800));
							scrollpane.setViewportView(table);
							panel2.add(scrollpane);
						}

					});

					jframe.setBounds(750, 300, 600, 600);
					jframe.add(jpanel1);
					jframe.setTitle("修改信息");
					jframe.setVisible(true);
					jframe.setSize(400, 450);
				} else {
					JOptionPane.showMessageDialog(frame, "未选中修改行", "提示", JOptionPane.INFORMATION_MESSAGE);
				}

			}

		});

		button4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				int row = table.getSelectedRow();
				
				if (row > -1) {
					int result = JOptionPane.showConfirmDialog(frame, "是否删除这条数据", "提示信息", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (result == 0) { 
						delete_databases = (String) table.getValueAt(row, 0);
						System.out.println(delete_databases);
						model.removeRow(row);
						Output_Goods_All_method tt = new Output_Goods_All_method();
						tt.delete_output_goods(delete_databases);
					}
				} else {  
					JOptionPane.showMessageDialog(frame, "未选中删除行", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
   
		}); 
	
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			   // count=1;
				//table.setSelectionMode(1);
			    frameA = new JFrame();
				panelA = new JPanel();
				Font fontA = new Font("", 20, 25);
				Font fontB = new Font("", 20, 20);
				Font fontC = new Font("", 100, 20);
				Color f = new Color(2);
				
				labelA = new JLabel("商品编号");
				labelC = new JLabel("仓库编号");
				labelD = new JLabel("货品名称");
				labelE = new JLabel("出库时间");
				labelF = new JLabel("货品重量");
				labelG = new JLabel("商品备注");

				labelA.setFont(fontA);
				labelA.setForeground(f.BLUE);
				labelC.setFont(fontA);
				labelC.setForeground(f.BLUE);
				labelD.setFont(fontA);
				labelD.setForeground(f.BLUE);
				labelE.setFont(fontA);
				labelE.setForeground(f.BLUE);
				labelF.setFont(fontA);
				labelF.setForeground(f.BLUE);
				labelG.setFont(fontA);
				labelG.setForeground(f.BLUE);

				textfieldA = new JTextField(12);
				textfieldC = new JTextField(12);
				textfieldD = new JTextField(12);
				textfieldE = new JTextField(12);
				textfieldF = new JTextField(12);
				textfieldG = new JTextField(12);

				textfieldA.setFont(fontB);
				textfieldA.setForeground(f.RED);
				textfieldC.setFont(fontB);
				textfieldC.setForeground(f.RED);
				textfieldD.setFont(fontB);
				textfieldD.setForeground(f.RED);
				textfieldE.setFont(fontB);
				textfieldE.setForeground(f.RED);
				textfieldF.setFont(fontB);
				textfieldF.setForeground(f.RED);
				textfieldG.setFont(fontB);
				textfieldG.setForeground(f.RED);
				buttonA = new JButton("确认");
				buttonB = new JButton("取消");
				buttonA.setFont(fontA);
				buttonB.setFont(fontA);
				
				buttonA.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
					
						Output_Goods_Bean output_goods_bean = new Output_Goods_Bean();
						output_goods_bean.setBianhao(textfieldA.getText());
						output_goods_bean.setCangkubianhao(textfieldC.getText());
						output_goods_bean.setHuopinmingcheng(textfieldD.getText());
						output_goods_bean.setChukushijian(textfieldE.getText());
						output_goods_bean.setZhongliang(textfieldF.getText());
						output_goods_bean.setBeizhu(textfieldG.getText());
						Output_Goods_All_method er = new Output_Goods_All_method();
						er.add_output_goods(output_goods_bean);
				   
						Vector<Object> s = new Vector<Object>();
						
						s.add(textfieldA.getText());s.add(textfieldC.getText());
						s.add(textfieldD.getText());s.add(textfieldE.getText());
						s.add(textfieldF.getText());s.add(textfieldG.getText());
					
						model.addRow(s);
					    table.setModel(model);  
					    table.setPreferredScrollableViewportSize(new Dimension(1350, 800));
					    scrollpane.setViewportView(table);
						panel2.add(scrollpane);
						frameA.setVisible(false);
						
					   
					}

				});

				panelA.add(labelA);
				panelA.add(textfieldA);
				panelA.add(labelC);
				panelA.add(textfieldC);
				panelA.add(labelD);
				panelA.add(textfieldD);
				panelA.add(labelE);
				panelA.add(textfieldE);
				panelA.add(labelF);
				panelA.add(textfieldF);
				panelA.add(labelG);
				panelA.add(textfieldG);

				panelA.add(buttonA);
				panelA.add(buttonB);

				frameA.add(panelA);
				frameA.setBounds(750, 300, 600, 600);
				frameA.setTitle("添加元素");
				frameA.setVisible(true);
				frameA.setSize(400, 450);
				frameA.setResizable(false);
				
			}

		});
		
		button1.setFont(font1);
		button2.setFont(font1);
		button3.setFont(font1);
		button4.setFont(font1);
		label1 = new JLabel("仓库   ");
		label1.setForeground(color.BLUE);
		label1.setFont(font);
		field1 = new JTextField(10);
		field1.setFont(font2);
		label2 = new JLabel("   出库时间");
		label2.setForeground(color.BLUE);
		label2.setFont(font);
		field2 = new JTextField(10);
		field2.setFont(font2);
		panel1 = new JPanel();
		panel2 = new JPanel();

		splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		frame = new JFrame();
		panel1.add(label1);
		panel1.add(field1);
		panel1.add(label2);
		panel1.add(field2);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);

		scrollpane = new JScrollPane();
		Output_Goods_All_method er = new Output_Goods_All_method();
		List<Output_Goods_Bean> bianli = er.select_output_goods();
		Vector<Object> tableHead = new Vector<Object>();
		tableHead.add("编 号");
		tableHead.add("仓库编号");
		tableHead.add("货品名称");
		tableHead.add("出库时间");
		tableHead.add("重量");
        tableHead.add("备注"); 		
		Vector<Object> rowAll = new Vector<Object>();
		
		for (int i = 0; i < bianli.size(); i++) {
			Vector<String> row = new Vector<String>();
			row.add(bianli.get(i).getBianhao());
			row.add(bianli.get(i).getCangkubianhao());
			row.add(bianli.get(i).getHuopinmingcheng());
			row.add(bianli.get(i).getChukushijian());
			row.add(bianli.get(i).getZhongliang());
			row.add(bianli.get(i).getBeizhu());
			rowAll.add(row);
		} 

		model = new DefaultTableModel(rowAll, tableHead);
		table = new JTable(model);
		table.setEnabled(true);
		table.setRowHeight(28);
		
		table.setPreferredScrollableViewportSize(new Dimension(1350, 800));
	    
		scrollpane.setViewportView(table);
		panel2.add(scrollpane);
		splitpane1.setOrientation(0);
		splitpane1.setLeftComponent(panel1);
		splitpane1.setRightComponent(panel2);
		splitpane1.setDividerLocation(80);
	}
 

	}