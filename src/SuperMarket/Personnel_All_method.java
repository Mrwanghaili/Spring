package SuperMarket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Personnel_All_method implements Personnel_Interface {
	Connection con = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;
	Personnel_Bean personnel_bean = null;
	Database_Connection connection;

	private String add_personnel_sql = "insert into tb_person values(?,?,?,?,?,?,?,?,?,?)";
	private String _select_personnel_sql = "select * from tb_person where bumen =? and xingming=?";
	private String update_personnel_sql = "update tb_person set id=?,xingming=?,nianling=?,xingbie=?,zhiwu=?,bumen=?,weixin=?,dianhua=?,shouji=?,mail=? where id=?";
	private String delete_personnel_sql = "delete from tb_person where id=?";
	private String select_personnel_sql = "select * from tb_person";
	public Personnel_Bean add_personnel(Personnel_Bean personnel_bean) {
		int count;
		connection = new Database_Connection();
		con = connection.getConnection();

		try {

			prepStmt = con.prepareStatement(add_personnel_sql);
			prepStmt.setString(1, personnel_bean.getId());
			prepStmt.setString(2, personnel_bean.getXingming());
			prepStmt.setString(3, personnel_bean.getNianling());
			prepStmt.setString(4, personnel_bean.getXingbie());
			prepStmt.setString(5, personnel_bean.getZhiwu());
			prepStmt.setString(6, personnel_bean.getBumen());
			prepStmt.setString(7, personnel_bean.getWeixin());
			prepStmt.setString(8, personnel_bean.getDianhua());
			prepStmt.setString(9, personnel_bean.getShouji());
			prepStmt.setString(10, personnel_bean.getMail());
			
			count = prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("结果错误" + e.getStackTrace());
		} finally {
			try {
				prepStmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personnel_bean;
	}

	public List<Personnel_Bean> select_personnel(String item1, String item2) {
		List<Personnel_Bean> all = new ArrayList<Personnel_Bean>();

		try {
			connection = new Database_Connection();
			con = connection.getConnection();
			prepStmt = con.prepareStatement(_select_personnel_sql);
			
			prepStmt.setString(1, item1);
			prepStmt.setString(2, item2); 	
			
			  rs = prepStmt.executeQuery();
			while (rs.next()) {
				Personnel_Bean personnel_bean = new Personnel_Bean();
				personnel_bean.setId(rs.getString(1));
				personnel_bean.setXingming(rs.getString(2));
				personnel_bean.setNianling(rs.getString(3));
				personnel_bean.setXingbie(rs.getString(4));
				personnel_bean.setZhiwu(rs.getString(5));
				personnel_bean.setBumen(rs.getString(6));
				personnel_bean.setWeixin(rs.getString(7));
				personnel_bean.setDianhua(rs.getString(8));
				personnel_bean.setShouji(rs.getString(9));
				personnel_bean.setMail(rs.getString(10));
				all.add(personnel_bean);
			}
			rs.close();
			prepStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace() + e);
		}

		return all;
	}

	public List<Personnel_Bean> select_personnel() {
		List<Personnel_Bean> all = new ArrayList<Personnel_Bean>();

		try {
			connection = new Database_Connection();
			con = connection.getConnection();
			prepStmt = con.prepareStatement(select_personnel_sql);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				Personnel_Bean personnel_bean = new Personnel_Bean();
				personnel_bean.setId(rs.getString(1));
				personnel_bean.setXingming(rs.getString(2));
				personnel_bean.setNianling(rs.getString(3));
				personnel_bean.setXingbie(rs.getString(4));
				personnel_bean.setZhiwu(rs.getString(5));
				personnel_bean.setBumen(rs.getString(6));
				personnel_bean.setWeixin(rs.getString(7));
				personnel_bean.setDianhua(rs.getString(8));
				personnel_bean.setShouji(rs.getString(9));
				personnel_bean.setMail(rs.getString(10));
				all.add(personnel_bean);
			}
			rs.close();
			prepStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace() + e);
		}
		return all;
	}
	
	public List<Personnel_Bean> update_personnel(Personnel_Bean personnel_bean) {
		connection = new Database_Connection();
		con = connection.getConnection();
		List<Personnel_Bean> all = new ArrayList<Personnel_Bean>();
		try {
			
			prepStmt = con.prepareStatement(update_personnel_sql);
			
			prepStmt.setString(1, personnel_bean.getId());
			prepStmt.setString(2, personnel_bean.getXingming());
			prepStmt.setString(3, personnel_bean.getNianling());
			prepStmt.setString(4, personnel_bean.getXingbie());
			prepStmt.setString(5, personnel_bean.getZhiwu());
			prepStmt.setString(6, personnel_bean.getBumen());
			prepStmt.setString(7, personnel_bean.getWeixin());
			prepStmt.setString(8, personnel_bean.getDianhua());
			prepStmt.setString(9, personnel_bean.getShouji());
			prepStmt.setString(10, personnel_bean.getMail());
			prepStmt.setString(11, personnel_bean.getId());
			prepStmt.executeUpdate(); 
			
		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace().toString());
		} finally { 
			try {
				prepStmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return all;
	}

	public boolean delete_personnel(String s) {
		int count;
		connection = new Database_Connection();
		con = connection.getConnection();
		
		try {
			prepStmt = con.prepareStatement(delete_personnel_sql);
			prepStmt.setString(1, s);
			System.out.println(s);
			count = prepStmt.executeUpdate();
			prepStmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("错误了");
		}

		return true;
	}
}