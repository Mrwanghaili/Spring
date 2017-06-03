/**
 * 主窗口创建类
 * */
 
package SuperMarket;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import SuperMarket.Input_Goods;

/*窗口创建类*/
public class Mian_Wickket extends JFrame {
	Container container;// 容器全局变量
	JFrame frame;
	JSplitPane splitpane, splitpane1;
	JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;// 面板全局变量
	JPanel panel8, panel9, panel10, panel11, panel12;
	JMenuBar item1;// 菜单栏全局变量
	JMenu Menu; // 菜单项全局变量
	JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11;// 按钮全局变量
	JLabel label;// 标签全局变量
	JLabel a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11;
	static String userU, userP, userUS, userUPA;

	/* 构造方法实现窗口创建 */
	public JSplitPane Mian() {
		item1 = new JMenuBar();
		Icon icon1 = new ImageIcon("a//Archive.png");
		Icon icon2 = new ImageIcon("a//package-x-generic.png");
		Icon icon3 = new ImageIcon("a//086.png");
		Icon icon4 = new ImageIcon("a//081.png");
		Icon icon5 = new ImageIcon("a//administrator.png");
		Icon icon6 = new ImageIcon("a//monitoring.png");
   
		button1 = new JButton();// 创建JButton对象
		button1.setIcon(icon1);
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button2 = new JButton();
		button2.setIcon(icon2);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button3 = new JButton();
		button3.setIcon(icon3);
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		button4 = new JButton();
		button4.setIcon(icon4);
		button4.setContentAreaFilled(false);
		button4.setBorderPainted(false);
		button5 = new JButton();
		button5.setIcon(icon5);
		button5.setContentAreaFilled(false);
		button5.setBorderPainted(false);
		button6 = new JButton();
		button6.setIcon(icon6);
		button6.setContentAreaFilled(false);
		button6.setBorderPainted(false);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (true) {

					new Wickket_Method(splitpane1);

				}
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Purchase_Method(splitpane1);
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Input_Goods(splitpane1);

			}
		});
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Output_Goods(splitpane1);

			}
		});
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Personnel_Management(splitpane1);
			}
		});
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Department_Ren(splitpane1);
			}
		});

		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();
		button10 = new JButton();
		button11 = new JButton();
		button7.setVisible(false);// 使JButton不可视
		button8.setVisible(false);
		button9.setVisible(false);
		button10.setVisible(false);
		button11.setVisible(false);
		Font fontA = new Font("", 20, 20);
		a1 = new JLabel("   基本档案");
		a1.setFont(fontA);
		a2 = new JLabel();
		a3 = new JLabel("   采购订单");
		a3.setFont(fontA);
		a4 = new JLabel();
		a5 = new JLabel("   入库管理");
		a5.setFont(fontA);
		a6 = new JLabel();
		a7 = new JLabel("   出库管理");
		a7.setFont(fontA);
		a8 = new JLabel();
		a9 = new JLabel("   人员管理");
		a9.setFont(fontA);
		a10 = new JLabel();
		a11 = new JLabel("  部门管理");
		a11.setFont(fontA);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel1.setLayout(new GridLayout(1, 11));
		panel2.setLayout(new GridLayout(1, 11));
		panel1.add(button1);
		panel2.add(a1);
		panel1.add(button7);
		panel2.add(a2);
		panel1.add(button2); 
		panel2.add(a3);
		panel1.add(button8);
		panel2.add(a4);
		panel1.add(button3);
		panel2.add(a5);
		panel1.add(button9);
		panel2.add(a6);
		panel1.add(button4);
		panel2.add(a7);
		panel1.add(button10);
		panel2.add(a8);
		panel1.add(button5);
		panel2.add(a9);
		panel1.add(button11);
		panel2.add(a10);
		panel1.add(button6);
		panel2.add(a11);

		panel3.add(panel1);
		panel3.add(panel2);
		panel3.setLayout(new GridLayout(2, 1));

		splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitpane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		frame = new JFrame();
		frame.setJMenuBar(item1);// 把菜单栏放进容器
		bulidMenu();// 创建菜单和添加菜单项方法调用
		splitpane.setDividerSize(0); 
		splitpane.setLeftComponent(panel3);
		splitpane.setRightComponent(splitpane1);
		Icon i = new ImageIcon("a\\2f90c34714bddb854cdc615057c8b33b_1-1512091H106.gif");
		JLabel p = new JLabel(i); 
		JPanel pa = new JPanel();
		pa.add(p); 
		splitpane1.add(pa);
		splitpane.setDividerLocation(120);
		frame.add(splitpane);

		// frame.setBounds(200, 200, 800, 100);
		frame.setSize(1380, 950);
		frame.setTitle("超市管理系统");
		frame.setVisible(true);
		frame.setResizable(false);
		return splitpane1;
	}

	// 创建菜单和和添加菜单项的方法
	public void bulidMenu() {
		JMenu fileMenu = new JMenu("文件");
		JMenu helpMenu = new JMenu("帮助");
		JMenu aboutUs = new JMenu("关于我们");
		JMenu set = new JMenu("设置");
		JMenuItem xinxi = new JMenuItem("超市信息");
		JMenuItem exit = new JMenuItem("退出");
		JMenuItem update = new JMenuItem("修改密码");
		JMenuItem tian = new JMenuItem("添加用户");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		set.add(update);
		set.add(tian);
		aboutUs.add(xinxi);
		fileMenu.add(exit);
		item1.add(fileMenu);
		item1.add(helpMenu);
		item1.add(aboutUs);
		item1.add(set);

		xinxi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Icon icons = new ImageIcon("a//xinxi.jpg");
				JFrame o;
				JPanel s1;
				JLabel e1;
				o = new JFrame();
				s1 = new JPanel();
				e1 = new JLabel(icons);
				s1.add(e1);
				o.add(s1);
				o.setTitle("超市信息");
				o.setVisible(true);
				o.setSize(900, 800);
			}

		});
		update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Container contain;
				JFrame s;
				JLabel label1, label2, label3;
				JTextField textfield;
				JPasswordField passwordFiled;
				JPanel p1, p2, p3;
				JButton button1, button2;
				s = new JFrame();
				Font font1 = new Font("", 50, 30);
				label3 = new JLabel("修    改   用   户   界    面");
				label3.setFont(font1);
				label3.setForeground(Color.RED);
				label1 = new JLabel("修改账户");
				textfield = new JTextField(12);
				label2 = new JLabel("修改密码");
				passwordFiled = new JPasswordField(12);
				button1 = new JButton("完成");
				button2 = new JButton("取消");
				Font font = new Font("", 50, 21);// 创建字体对象
				Color color = new Color(1);
				label1.setForeground(color.BLUE);// 设置前景色
				label2.setForeground(color.BLUE);
				label1.setFont(font);// 设置字体
				label2.setFont(font);
				button1.setPreferredSize(new Dimension(150, 30));
				button2.setPreferredSize(new Dimension(150, 30));
				textfield.setFont(font);// 设置文本域字体
				passwordFiled.setFont(font);
				textfield.setPreferredSize(new Dimension(130, 30));

				button1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						userUS = textfield.getText();
						userUPA = String.valueOf(passwordFiled.getPassword());
						Method_Implement er = new Method_Implement();
						er.updateSuperMarket();
						// System.out.println("结果"+userU+userP);
						s.setVisible(false);

					}

				});

				p1 = new JPanel();
				p2 = new JPanel();
				p3 = new JPanel();
				p2.setBackground(color.GRAY);
				p1.setLayout(new GridLayout(2, 1));
				p2.add(label3);
				p3.add(label1);
				p3.add(textfield);
				p3.add(label2);
				p3.add(passwordFiled);
				p3.add(button1);
				p3.add(button2);
				p1.add(p2);
				p1.add(p3);

				s.add(p1);
				s.setBounds(750, 300, 600, 600);
				s.setSize(380, 400);
				s.setTitle("修改用户");
				s.setVisible(true);
				s.setResizable(false);
			}

		});
		tian.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Container contain;
				JFrame s;
				JLabel label1, label2, label3;
				JTextField textfield;
				JPasswordField passwordFiled;
				JPanel p1, p2, p3;
				JButton button1, button2;
				s = new JFrame();
				Font font1 = new Font("", 50, 30);
				label3 = new JLabel("添   加   用   户   界   面");
				label3.setFont(font1);
				label3.setForeground(Color.RED);
				label1 = new JLabel("添加账户");
				textfield = new JTextField(12);
				label2 = new JLabel("添加密码");
				passwordFiled = new JPasswordField(12);
				button1 = new JButton("完成");
				button2 = new JButton("取消");
				Font font = new Font("", 50, 21);// 创建字体对象
				Color color = new Color(1);
				label1.setForeground(color.BLUE);// 设置前景色
				label2.setForeground(color.BLUE);
				label1.setFont(font);// 设置字体
				label2.setFont(font);
				button1.setPreferredSize(new Dimension(150, 30));
				button2.setPreferredSize(new Dimension(150, 30));
				textfield.setFont(font);// 设置文本域字体
				passwordFiled.setFont(font);
				textfield.setPreferredSize(new Dimension(130, 30));

				button1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						Method_Implement er = new Method_Implement();

						userU = textfield.getText();
						userP = String.valueOf(passwordFiled.getPassword());
						er.addSuperMarket();
						s.setVisible(false);

					}

				});

				p1 = new JPanel();
				p2 = new JPanel();
				p3 = new JPanel();
				p2.setBackground(color.GRAY);
				p1.setLayout(new GridLayout(2, 1));
				p2.add(label3);
				p3.add(label1);
				p3.add(textfield);
				p3.add(label2);
				p3.add(passwordFiled);
				p3.add(button1);
				p3.add(button2);
				p1.add(p2);
				p1.add(p3);

				s.add(p1);
				s.setBounds(750, 300, 600, 600);
				s.setSize(380, 400);
				s.setTitle("添加用户");
				s.setVisible(true);
				s.setResizable(false);
			}

		});

	}

	public static void main(String[] args) {
		new Mian_Wickket().Mian();
	}

}
