/**
 * 登录窗口类
 * 
 * **/
package SuperMarket;  
import SuperMarket.Mian_Wickket;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension; 
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import SuperMarket.Method_Implement;
public class SuperMarket_Login extends JFrame{
	private Container container;//容器全局变量
	private JFrame frame;
	private JPanel panel1,panel2,panel3;//面板全局变量
	private JTextField field1;//文本域区局变量
	private JPasswordField passwordfield2;//密码域全局变量      
	private JLabel label1,label2,label4,er;//标签全局变量
	private JButton button1,button2;//按钮全局变量
	private JRadioButton radia1,radia2,radia3;
	public SuperMarket_Login() {
		container = this.getContentPane();//得到容器
		frame = new JFrame(); 
		panel1 = new JPanel();//创建面板对象
		panel1.setLayout(new GridLayout(2,1));//设置网格布局管理器
		panel2 = new JPanel();
		panel3 = new JPanel();   
		label1 = new JLabel("登陆用户"); //创建标签对象
		label2 = new JLabel("登陆密码");
		Font font = new Font("",50,21);//创建字体对象
		Font font1 = new Font("",10,20);
		Color s = new Color(1);
		label1.setForeground(s.BLUE);//设置前景色
		label2.setForeground(s.BLUE);
		label1.setFont(font);//设置字体
		label2.setFont(font);
		label1.setPreferredSize(new Dimension(100,40));//优先改变标签字体大小
		label2.setPreferredSize(new Dimension(100,40));
		label4 = new JLabel(new ImageIcon("a//45c43f60f1a3757912c7a3be4e30f4e3_111158uige0xxix6sxg4is.jpg","超市管理系统"));	
		field1 = new JTextField(12);//创建文本域对象
		passwordfield2 = new JPasswordField(12);//创建密码域对象
		field1.setFont(font1);//设置文本域字体   
		passwordfield2.setFont(font1);
		field1.setPreferredSize(new Dimension(130,30));//设置文本域大小
		passwordfield2.setPreferredSize(new Dimension(130,30));
		button1 = new JButton("登录");//创建按钮对象
		button2 = new JButton("取消");
		button1.setPreferredSize(new Dimension(150,30));
		button2.setPreferredSize(new Dimension(150,30));
		 
	    radia1 = new JRadioButton("记住密码");
	    radia2 = new JRadioButton("忘记密码");
	    radia3 = new JRadioButton("记住账号");
		  
		/*监听登录(e1)按钮*/
		button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  
            	   String s1 = field1.getText(); 
            	   String s2 = String.valueOf(passwordfield2.getPassword());  
             	   Method_Implement s = new Method_Implement();
                   boolean t =  s.findSuperMarket();
	               if(t) {
	            	  if(s1.equals(s.user) && s2.equals(s.password)) {
	            		  new Mian_Wickket().Mian();
	            		  frame.setVisible(false);
	            	  }
	            	  else {
	                      Color r = new Color(2);
	                      er.setForeground(r.RED);
	            		  er.setVisible(true);         		

	            	  }
	               }
			}   
		});  
		/*监听取消(e2)按钮*/ 
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				field1.setText("");
			    passwordfield2.setText("");
			}
			 
		});
		panel2.add(label4); 
		panel3.add(label1); panel3.add(field1);
		panel3.add(label2); panel3.add(passwordfield2);
		panel3.add(radia1); panel3.add(radia2);panel3.add(radia3); 
		panel3.add(button1); panel3.add(button2);
		er = new JLabel("输入密码或账号错误");
		panel3.add(er); 
		er.setVisible(false);
		panel1.add(panel2); panel1.add(panel3);
		
		frame.add(panel1); 
		frame.setBounds(750,300 ,600 ,600);//设置窗口出现位置
		frame.setTitle("超市管理系统");
		frame.setSize(380,450);  
		frame.setVisible(true);
		frame.setResizable(false);
       
	}
	public static void main(String args[]) {
		new SuperMarket_Login();
	}
}
