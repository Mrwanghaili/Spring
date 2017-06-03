/**
 * 数据库连接类
 * 
 * **/

package SuperMarket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
 /*数据库连接类*/
public class Database_Connection {
	String dbdriver = "com.mysql.jdbc.Driver";
	String dbur1 = "jdbc:mysql://127.0.0.1:3306/SupermarketDB";
	String root = "root";
	String password = "249544";
	Connection oneConnection = null;
	/*数据库连接方法*/ 
	public Connection getConnection() {
		try{     
			Class.forName(dbdriver);
			System.out.println("driver success!!!");
			oneConnection = DriverManager.getConnection(dbur1,root,password);
		    System.out.println("Connection success!!!");
	
		}
		catch(ClassNotFoundException e) {
			System.out.println("driver failure");
			
		} 
		catch(SQLException e) {
			System.out.println("connection failure");
		}
		return oneConnection;
	}
	  /*关闭数据库方法*/		
	public void closeConnection() {
		if(oneConnection != null) {
			try {
				oneConnection.close();
				System.out.println("close database success!");
			}
			catch(SQLException e) {
				System.out.println("close failure");
				
			}
			 
		}
		
	}

	public static void main(String[] args) {
		
		 Database_Connection s = new Database_Connection();
		 s.getConnection();//调用getConnection()方法,实现数据库的链接
		 //s.closeConnection();
	}

}
