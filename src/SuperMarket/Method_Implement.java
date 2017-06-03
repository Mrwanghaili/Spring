/**
 * 数据库操作实现类 
 * **/ 

package SuperMarket;
import  SuperMarket.Database_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Method_Implement implements Datebase_Interface {
	 public static String user;
	 public static String password;
	 Connection con = null;
     PreparedStatement prepStmt = null; 
     ResultSet rs = null; 
     Database_Connection connection;
	 String select_sql = "select * from tb_admins";
     String delete_sql = "delete from tb_admins where userName=? ";
	 String add_sql = "insert into tb_admins values(?,?,?,?)";
     String update_sql = "update tb_admins set userName=?,userpassword=?";
	 public  boolean findSuperMarket() {

		 try {    
        	connection = new Database_Connection(); 
        	 con = connection.getConnection();
        	 prepStmt = con.prepareStatement(select_sql);
        	 rs = prepStmt.executeQuery();
        	 while(rs.next()) {
        		 user = rs.getString(1);
        		 password = rs.getString(2);
        		  
        	 } 
        	  rs.close();
        	  prepStmt.close();
        	  con.close();
        }
        catch(Exception e) {
        	System.out.println("错误结果:"+e.getStackTrace()+e);
        }
        
    	return true;
    }
	
	public boolean deleteSuperMarket() {
		int count = -1;
		connection = new Database_Connection();
		con = connection.getConnection();
		try {
			prepStmt = con.prepareStatement(delete_sql);
			prepStmt.setString(1,"admin");
			count = prepStmt.executeUpdate();
			prepStmt.close();
			con.close();
		} catch (SQLException e) {
           System.out.println("错误结果:"+e.getStackTrace());
		}
		
		return false;
	}
	
	public boolean addSuperMarket() {
		int count = -1;
		connection = new Database_Connection();
		con = connection.getConnection();
		try {
			prepStmt = con.prepareStatement(add_sql);
			prepStmt.setString(1, Mian_Wickket.userU);
			prepStmt.setString(2,Mian_Wickket.userP);
			prepStmt.setString(3, "1");
			prepStmt.setString(4, "1");
			count = prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("错误结果:"+e.getStackTrace());
		}
		finally {
			try {
				prepStmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateSuperMarket() {
		connection = new Database_Connection(); 
   	    con = connection.getConnection();
   	    try {
			 prepStmt = con.prepareStatement(update_sql);
			 prepStmt.setString(1, Mian_Wickket.userUS);
			 prepStmt.setString(2, Mian_Wickket.userUPA);
			 System.out.println("结果:"+Mian_Wickket.userUS+Mian_Wickket.userUPA);
			  prepStmt.executeUpdate();
			 prepStmt.close();
			 con.close(); 
   	    } catch (SQLException e) {
		    System.out.println("错误结果:"+e.getStackTrace());
		}
   	   
		return false;
	}
	
	public static void main(String[] args) {
		//new Method_Implement().deleteSuperMarket();
		//new Method_Implement().addSuperMarket();
		new Method_Implement().updateSuperMarket();
	}


}
