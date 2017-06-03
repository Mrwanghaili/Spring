package SuperMarket;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
//import SuperMarket.MyRender;
public class Purchase_Method extends JFrame {
	private JFrame frame, frameA;
	private JPanel panel1, panel2, panelA;
	private JTextField field1, textfieldA, textfieldB, textfieldC, textfieldD, textfieldE, textfieldF, textfieldG;
	private JComboBox<String> comboBox;
	private JLabel label1, label2, label3, labelA, labelB, labelC, labelD, labelE, labelF, labelG;
	private JButton button1, button2, button3, button4, buttonA, buttonB, buttonZ,buttonQ;
	private JScrollPane scrollpane;
    private JTable table;
	private PurchaseTableModel model;
	private String op1, op2, op3, op4, op5, op6, op7;
	private Purchase_Bean purchase_bean;
	private String delete_database;
	public static int count = 0;
	private int row;
	public Purchase_Method(JSplitPane splitpane) {
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

				String itemBox = String.valueOf(comboBox.getSelectedItem());
				Purchase_All_method s = new Purchase_All_method();
				String itemField = field1.getText();
				if(itemField.equals("")||itemBox.equals("请选择输入项")) {
					JOptionPane.showMessageDialog(frame, "请输入查询信息", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				List<Purchase_Bean> all = s.selectPurchase_Element(itemField, itemBox);
				Vector<Object> rowAll = new Vector<Object>();
				for (int i = 0; i < all.size(); i++) { 
					Vector<Object> row = new Vector<Object>();
					row.add(all.get(i).getBianhao());
					row.add(all.get(i).getKehu());
					row.add(all.get(i).getDingdan());
					row.add(all.get(i).getRiqi());
					row.add(all.get(i).getShangpin());
					row.add(all.get(i).getJine());
					row.add(all.get(i).getShuliang());
					rowAll.add(row);

				}

				Vector<Object> head = new Vector<Object>();
				head.add("编 号");
				head.add("客户");
				head.add("订 单 号");
				head.add("交 货 日 期");
				head.add("商 品 名");
				head.add("金 额");
				head.add("数 量");

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
				}
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
				JLabel jlabel2 = new JLabel("供货客户");
				JLabel jlabel3 = new JLabel("订单编号");
				JLabel jlabel4 = new JLabel("交货日期");
				JLabel jlabel5 = new JLabel("商品名称");
				JLabel jlabel6 = new JLabel("商品金额");
				JLabel jlabel7 = new JLabel("商品数量");

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
				jlabel7.setFont(font1);
				jlabel7.setForeground(color.BLUE);
				jbutton1.setFont(font1);
				jbutton2.setFont(font1);
				Purchase_All_method method = new Purchase_All_method();
				int row = table.getSelectedRow();
				if (row > -1) {
					Object update_database1 = table.getValueAt(row, 1);
					Object update_database2 = table.getValueAt(row, 2);
					Object update_database3 = table.getValueAt(row, 3);
					Object update_database4 = table.getValueAt(row, 4);
					Object update_database5 = table.getValueAt(row, 5);
					Object update_database6 = table.getValueAt(row, 6);
					Object update_database7 = table.getValueAt(row, 7);
					op1 = String.valueOf(update_database1);
					op2 = String.valueOf(update_database2);
					op3 = String.valueOf(update_database3);
					op4 = String.valueOf(update_database4);
					op5 = String.valueOf(update_database5);
					op6 = String.valueOf(update_database6);
					op7 = String.valueOf(update_database7);

					JTextField jtextfield1 = new JTextField(op1, 12);
					JTextField jtextfield2 = new JTextField(op2, 12);
					JTextField jtextfield3 = new JTextField(op3, 12);
					JTextField jtextfield4 = new JTextField(op4, 12);
					JTextField jtextfield5 = new JTextField(op5, 12);
					JTextField jtextfield6 = new JTextField(op6, 12);
					JTextField jtextfield7 = new JTextField(op7, 12);

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
					jtextfield7.setFont(font2);
					jtextfield7.setForeground(color.RED);

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
					jpanel1.add(jlabel7);
					jpanel1.add(jtextfield7);
					jpanel1.add(jbutton1);
					jpanel1.add(jbutton2);
					jbutton1.setFont(font1);
					jbutton2.setFont(font1);

					jbutton1.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent arg0) {
							purchase_bean = new Purchase_Bean();
							purchase_bean.setBianhao(jtextfield1.getText());
							purchase_bean.setKehu(jtextfield2.getText());
							purchase_bean.setDingdan(jtextfield3.getText());
							purchase_bean.setRiqi(jtextfield4.getText());
							purchase_bean.setShangpin(jtextfield5.getText());
							purchase_bean.setJine(jtextfield6.getText());
							purchase_bean.setShuliang(jtextfield7.getText());
							Purchase_All_method er = new Purchase_All_method();
							er.updatePurchase(purchase_bean);
							List<Purchase_Bean> op = er.selectPurchase();

							Vector<Object> rowAll = new Vector<Object>();

							for (int i = 0; i < op.size(); i++) {
								Vector<Object> row = new Vector<Object>();
								row.add(op.get(i).getBianhao());
								row.add(op.get(i).getBianhao());
								row.add(op.get(i).getKehu());
								row.add(op.get(i).getDingdan());
								row.add(op.get(i).getRiqi());
								row.add(op.get(i).getShangpin());
								row.add(op.get(i).getJine());
								row.add(op.get(i).getShuliang());
								rowAll.add(row);

							}

							Vector<Object> tableHead = new Vector<Object>();
							tableHead.add("是 否 入 库");
							tableHead.add("编 号");
							tableHead.add("客户");
							tableHead.add("订 单 号");
							tableHead.add("交 货 日 期");
							tableHead.add("商 品 名");
							tableHead.add("金 额");
							tableHead.add("数 量");
 
							//model = new DefaultTableModel(rowAll, tableHead);
							model = new PurchaseTableModel();
							table.setModel(model);
							table.getColumnModel().getColumn(0).setCellEditor(new MyRender()); 
							table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
							table.setPreferredScrollableViewportSize(new Dimension(1350, 800));
							scrollpane.setViewportView(table);
							panel2.add(scrollpane);
							jframe.setVisible(false);
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
						delete_database = (String) table.getValueAt(row, 1);
						Purchase_All_method se = new Purchase_All_method();
						se.delete_Purchase(delete_database);
						List<Purchase_Bean> op = se.selectPurchase();

						Vector<Object> rowAll = new Vector<Object>();

						for (int i = 0; i < op.size(); i++) {
							Vector<Object> Row = new Vector<Object>();
							Row.add(op.get(i).getBianhao());
							Row.add(op.get(i).getBianhao());
							Row.add(op.get(i).getKehu());
							Row.add(op.get(i).getDingdan());
							Row.add(op.get(i).getRiqi());
							Row.add(op.get(i).getShangpin());
							Row.add(op.get(i).getJine());
							Row.add(op.get(i).getShuliang());
							rowAll.add(row);

						}

						Vector<Object> tableHead = new Vector<Object>();
						tableHead.add("是 否 入 库");
						tableHead.add("编 号");
						tableHead.add("客户");
						tableHead.add("订 单 号");
						tableHead.add("交 货 日 期");
						tableHead.add("商 品 名");
						tableHead.add("金 额");
						tableHead.add("数 量");
						model = new PurchaseTableModel();
					    table.setModel(model);  
					    table.getColumnModel().getColumn(0).setCellEditor(new MyRender()); 
					    table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
					    table.setPreferredScrollableViewportSize(new Dimension(1350, 800));
					    scrollpane.setViewportView(table);
						panel2.add(scrollpane);
					}
				} else {   
					JOptionPane.showMessageDialog(frame, "未选中删除行", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
   
		}); 
	
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			    count=1;
				table.setSelectionMode(1);
			    frameA = new JFrame();
				panelA = new JPanel();
				Font fontA = new Font("", 20, 25);
				Font fontB = new Font("", 20, 20);
				Font fontC = new Font("", 100, 20);
				Color f = new Color(2);
				
				labelA = new JLabel("商品编号");
				labelB = new JLabel("供货客户");
				labelC = new JLabel("订单编号");
				labelD = new JLabel("交货日期");
				labelE = new JLabel("商品名称");
				labelF = new JLabel("商品金额");
				labelG = new JLabel("商品数量");

				labelA.setFont(fontA);
				labelA.setForeground(f.BLUE);
				labelB.setFont(fontA);
				labelB.setForeground(f.BLUE);
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
				textfieldB = new JTextField(12);
				textfieldC = new JTextField(12);
				textfieldD = new JTextField(12);
				textfieldE = new JTextField(12);
				textfieldF = new JTextField(12);
				textfieldG = new JTextField(12);

				textfieldA.setFont(fontB);
				textfieldA.setForeground(f.RED);
				textfieldB.setFont(fontB);
				textfieldB.setForeground(f.RED);
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
					
						Purchase_Bean purchase_bean = new Purchase_Bean();
						purchase_bean.setXuanxiang("0");
						purchase_bean.setBianhao(textfieldA.getText());
						purchase_bean.setKehu(textfieldB.getText());
						purchase_bean.setDingdan(textfieldC.getText());
						purchase_bean.setRiqi(textfieldD.getText());
						purchase_bean.setShangpin(textfieldE.getText());
						purchase_bean.setJine(textfieldF.getText());
						purchase_bean.setShuliang(textfieldG.getText());
						Purchase_All_method er = new Purchase_All_method();
						er.addPurchase(purchase_bean);
						Vector<Object> rowAll = new Vector<Object>();
						List<Purchase_Bean> op = er.selectPurchase();
						for (int i = 0; i < op.size(); i++) {
							Vector<Object> row = new Vector<Object>();
							row.add(op.get(i).getXuanze());
							row.add(op.get(i).getBianhao());
							row.add(op.get(i).getKehu());
							row.add(op.get(i).getDingdan());
							row.add(op.get(i).getRiqi());
							row.add(op.get(i).getShangpin());
							row.add(op.get(i).getJine());
							row.add(op.get(i).getShuliang());
							rowAll.add(row);

						}
						model = new PurchaseTableModel();
					    table.setModel(model);  
					    table.getColumnModel().getColumn(0).setCellEditor(new MyRender()); 
					    table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
					    table.setPreferredScrollableViewportSize(new Dimension(1350, 800));
					    scrollpane.setViewportView(table);
						panel2.add(scrollpane);
						
						frameA.setVisible(false);
						
					}

				});

				panelA.add(labelA);
				panelA.add(textfieldA);
				panelA.add(labelB);
				panelA.add(textfieldB);
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
				frameA.setVisible(true);
				
			}

		});
		
		button1.setFont(font1);
		button2.setFont(font1);
		button3.setFont(font1);
		button4.setFont(font1);

		label1 = new JLabel(" 查 询 条 件  ");
		label2 = new JLabel("      ");
		label3 = new JLabel("      ");
		label1.setForeground(color.BLUE);
		label1.setFont(font);
		comboBox = new JComboBox<String>();
		comboBox.addItem("请选择输入项");
		comboBox.addItem("编号");
		comboBox.addItem("客户");
		comboBox.addItem("订单号");
		comboBox.addItem("交货日期");
		comboBox.addItem("商品名");
		comboBox.addItem("金额");
		comboBox.addItem("数量");
		comboBox.setForeground(color.darker());
		comboBox.setFont(font1);
		field1 = new JTextField(10);
		field1.setFont(font2);
		panel1 = new JPanel();
		panel2 = new JPanel();

		frame = new JFrame();
		panel1.add(label1);
		panel1.add(comboBox);
		panel1.add(label2);
		panel1.add(field1);
		panel1.add(button1);
		panel1.add(label3);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);

		scrollpane = new JScrollPane();
		Purchase_All_method er = new Purchase_All_method();
		List<Purchase_Bean> bianli = er.selectPurchase();
		Vector<Object> tableHead = new Vector<Object>();
		tableHead.add("是 否 入 库");
		tableHead.add("编 号");
		tableHead.add("客户");
		tableHead.add("订 单 号");
		tableHead.add("交 货 日 期");
		tableHead.add("商 品 名");
		tableHead.add("金 额");
		tableHead.add("数 量");
		
		Vector<Object> rowAll = new Vector<Object>();
		
		for (int i = 0; i < bianli.size(); i++) {
			Vector<String> row = new Vector<String>();
			row.add(bianli.get(i).getXuanze());
			row.add(bianli.get(i).getBianhao());
			row.add(bianli.get(i).getKehu());
			row.add(bianli.get(i).getDingdan());
			row.add(bianli.get(i).getRiqi());
			row.add(bianli.get(i).getShangpin());
			row.add(bianli.get(i).getJine());
			row.add(bianli.get(i).getShuliang());
			rowAll.add(row);
		} 

		//model = new DefaultTableModel(rowAll, tableHead);
		model  = new PurchaseTableModel();
		table = new JTable(model);
		table.setEnabled(true);
		table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
		table.getColumnModel().getColumn(0).setCellEditor(new MyRender());
		table.setRowHeight(28);
		
		table.setPreferredScrollableViewportSize(new Dimension(1350, 800));
	    
		scrollpane.setViewportView(table);
		panel2.add(scrollpane);
		splitpane.setOrientation(0);
		splitpane.setLeftComponent(panel1);
		splitpane.setRightComponent(panel2);

		splitpane.setDividerLocation(80);
	}
	
	class MyRender extends AbstractCellEditor implements TableCellRenderer, ActionListener, TableCellEditor {
		private int row;
		private static final long serialVersionUID = 1L;
		private JButton button ;
		private Purchase_All_method purchaseDao = new Purchase_All_method();
		@Override
		public Object getCellEditorValue() {
			return null;
		}


		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			button = new JButton();
			
			// value 源于editor
			String text = (value == null) ? "" : value.toString();
			button.setForeground(Color.blue);
			
			// 按钮文字
			button.setText(text);
			
			
			if (text.equals("已入库")){
				button.setEnabled(false);

			}else{
				button.addActionListener(this);
				
			}

			return button;
		}
 
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int row = table.getSelectedRow();
			String id = (String)table.getValueAt(row, 1);
			int result = JOptionPane.showConfirmDialog(frame, "是否要進行入庫", "提示信息", JOptionPane.YES_NO_OPTION);
			if(result == 0) {
				Object[] user = {"食品仓库","日用品仓库","饮料仓库","烟酒仓库"};
				Object selectValue = JOptionPane.showInputDialog(frame, "请选择仓库", "提示信息",JOptionPane.INFORMATION_MESSAGE,null, user,user[0]);
			if(selectValue!=null) {
				purchaseDao.updatePurchase_1(id); 
				List<Purchase_Bean> bianli = purchaseDao.selectPurchase();
				Vector<Object> tableHead = new Vector<Object>();
				tableHead.add("是 否 入 库");
				tableHead.add("编 号");
				tableHead.add("客户");
				tableHead.add("订 单 号");
				tableHead.add("交 货 日 期");
				tableHead.add("商 品 名");
				tableHead.add("金 额");
				tableHead.add("数 量");
				
				Vector<Object> rowAll = new Vector<Object>();
				
				for (int i = 0; i < bianli.size(); i++) {
					Vector<String> rows = new Vector<String>();
					rows.add(bianli.get(i).getXuanze());
					rows.add(bianli.get(i).getBianhao());
					rows.add(bianli.get(i).getKehu());
					rows.add(bianli.get(i).getDingdan());
					rows.add(bianli.get(i).getRiqi());
					rows.add(bianli.get(i).getShangpin());
					rows.add(bianli.get(i).getJine());
					rows.add(bianli.get(i).getShuliang());
					rowAll.add(row);
				}  

				model  = new PurchaseTableModel();
				table = new JTable(model);
				table.setEnabled(true);
				table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
				table.getColumnModel().getColumn(0).setCellEditor(new MyRender());
				table.setRowHeight(28);
				
				table.setPreferredScrollableViewportSize(new Dimension(1350, 800));
			    
				scrollpane.setViewportView(table);
				panel2.add(scrollpane);
				
				
				}
				else {
					System.out.println("用户");
				}
			
			}
			else {
				
			}

		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

			String text = (value == null) ? "" : value.toString();
			button = new JButton();

			button.setText(text);
			if (text.equals("已入库")){
				button.setEnabled(false);
				
			}else{
				button.addActionListener(this);
			}
			return button;
		}
		

	}

	class PurchaseTableModel extends DefaultTableModel{

			private static final long serialVersionUID = 1L;
			private Purchase_All_method dao = new Purchase_All_method();
			private  List<Purchase_Bean> data = null ;
			private int row ;
			
			public PurchaseTableModel() {
				this.data  = dao.selectPurchase();
				this.row = data.size();
			}
			
			public PurchaseTableModel(List<Purchase_Bean> data) {
				this.data  = data;
				this.row = data.size();
			}
			
			
			@Override
			public int getColumnCount() {
				
				return 8;
			}
			
			@Override
			public int getRowCount() {
				return row;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				   Purchase_Bean purchase = data.get(rowIndex);
				   
				if (columnIndex == 0){
					if ( purchase.getXuanze().equals("0")){
						return "未入库";
						}else{
						return "已入库";
						}
					}

				if (columnIndex == 1)
					return purchase.getBianhao();
				if (columnIndex == 2)
					return purchase.getKehu();
				if (columnIndex == 3)
					return purchase.getDingdan();
				if (columnIndex == 4)
					return purchase.getRiqi();
				if (columnIndex == 5)
					return purchase.getShangpin();
				if (columnIndex == 6)
					return purchase.getJine();
				if (columnIndex == 7)
					return purchase.getShuliang();
			
				return null;
			}
			
			@Override
			public String getColumnName(int column) {
				if (column == 0)
					return "是否入库";
				if (column == 1)
					return  "编号";
				if (column == 2)
					return  "客户";
				if (column == 3)
					return  "订单号";
				if (column == 4)
					return  "交货日期";
				if (column == 5)
					return  "商品名";
				if (column == 6)
					return  "金额";
				if (column == 7)
					return  "数量";
				
				return "查询错误";
			}
			
			  public void setData(List<Purchase_Bean> data) {
				
				    this.data = data;
				    data.size();
				    
				    fireTableDataChanged();
				  }
			  
			
			  public boolean isCellEditable(int row, int column) {
				  if (column == 0 && this.getValueAt(row, 0).equals("未入库")){
					  return true;
				  }else{
		          return false;
				  }
		      }
		}


}
	