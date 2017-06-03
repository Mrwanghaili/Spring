package SuperMarket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Department_Ren_All_method implements Department_Ren_Interface {
	Connection con = null;
	PreparedStatement prepStmt = null; 
	ResultSet rs = null;
	Department_Ren_Bean department_ren_bean = null;
	Database_Connection connection;
 
	private String add_department_ren_sql = "insert into tb_departments values(?,?,?,?,?,?,?,?)";
	private String _select_department_ren_sql = "select * from tb_departments where id=? or named=? or address=? or tel=? or fax=? or mail=? or EmployeeID=? or Itel=?";
	private String select_department_ren_sql = "select * from tb_departments";
	private String update_department_ren_sql = "update tb_departments set id=?,named=?,address=?,tel=?,fax=?,mail=?,EmployeeID=?,Itel=? where id=?";
	private String delete_department_ren_sql = "delete from tb_departments where id=?";
 
	public Department_Ren_Bean add_department_ren(Department_Ren_Bean department_ren_bean) {
		int count;
		connection = new Database_Connection();
		con = connection.getConnection();

		try {

			prepStmt = con.prepareStatement(add_department_ren_sql);
			prepStmt.setString(1, department_ren_bean.getId());
			prepStmt.setString(2, department_ren_bean.getNamed());
			prepStmt.setString(3, department_ren_bean.getAddress()); 
			prepStmt.setString(4, department_ren_bean.getTel());
			prepStmt.setString(5, department_ren_bean.getFax());
			prepStmt.setString(6, department_ren_bean.getMail());
			prepStmt.setString(7, department_ren_bean.getEmployeeID());
			prepStmt.setString(8, department_ren_bean.getItel());
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
		return department_ren_bean;
	}

	public List<Department_Ren_Bean> select_department_ren() {
		List<Department_Ren_Bean> all = new ArrayList<Department_Ren_Bean>();

		try {
			connection = new Database_Connection();
			con = connection.getConnection();
			prepStmt = con.prepareStatement(select_department_ren_sql);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				Department_Ren_Bean department_ren_bean = new Department_Ren_Bean();
				department_ren_bean.setId(rs.getString(1));
				department_ren_bean.setNamed(rs.getString(2));
				department_ren_bean.setAddress(rs.getString(3));
				department_ren_bean.setTel(rs.getString(4));
				department_ren_bean.setFax(rs.getString(5));
				department_ren_bean.setMail(rs.getString(6));
				department_ren_bean.setEmployeeID(rs.getString(7));
				department_ren_bean.setItel(rs.getString(8));
				all.add(department_ren_bean);

			}
			rs.close();
			prepStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace() + e);
		}

		return all;
	}

	public List<Department_Ren_Bean> select_department_ren(String itemBox, String itemField) {
		List<Department_Ren_Bean> alls = new ArrayList<Department_Ren_Bean>();

		try {
			connection = new Database_Connection();
			con = connection.getConnection();

			prepStmt = con.prepareStatement(_select_department_ren_sql);
			if (itemBox.equals("部门编号")) {
				prepStmt.setString(1, itemField);
				prepStmt.setString(2, "部门编号");
				prepStmt.setString(3, "部门编号");
				prepStmt.setString(4, "部门编号");
				prepStmt.setString(5, "部门编号");
				prepStmt.setString(6, "部门编号");
				prepStmt.setString(7, "部门编号");
				prepStmt.setString(8, "部门编号");
			}
			if (itemBox.equals("部门名称")) {
				prepStmt.setString(1, "部门名称");
				prepStmt.setString(2,itemField);
				prepStmt.setString(3, "部门名称");
				prepStmt.setString(4, "部门名称");
				prepStmt.setString(5, "部门名称");
				prepStmt.setString(6, "部门名称");
				prepStmt.setString(7, "部门名称");
				prepStmt.setString(8, "部门名称");
			}
			if (itemBox.equals("部门地址")) {
				prepStmt.setString(1, "部门地址");
				prepStmt.setString(2, "部门地址");
				prepStmt.setString(3, itemField);
				prepStmt.setString(4, "部门地址");
				prepStmt.setString(5, "部门地址");
				prepStmt.setString(6, "部门地址");
				prepStmt.setString(7, "部门地址");
				prepStmt.setString(8, "部门地址");
			}
			if (itemBox.equals("联系电话")) {
				prepStmt.setString(1, "联系电话");
				prepStmt.setString(2, "联系电话");
				prepStmt.setString(3, "联系电话");
				prepStmt.setString(4, itemField);
				prepStmt.setString(5, "联系电话");
				prepStmt.setString(6, "联系电话");
				prepStmt.setString(7, "联系电话");
				prepStmt.setString(8, "联系电话");
			}
			if (itemBox.equals("传真")) {
				prepStmt.setString(1, "交货日期");
				prepStmt.setString(2, "交货日期");
				prepStmt.setString(3, "交货日期");
				prepStmt.setString(4, "交货日期");
				prepStmt.setString(5, itemField);
				prepStmt.setString(6, "交货日期");
				prepStmt.setString(7, "交货日期");
				prepStmt.setString(8, "交货日期");
			}
			if (itemBox.equals("E-mail")) {
				prepStmt.setString(1, "商品名");
				prepStmt.setString(2, "商品名");
				prepStmt.setString(3, "商品名");
				prepStmt.setString(4, "商品名");
				prepStmt.setString(5, "商品名");
				prepStmt.setString(6, itemField);
				prepStmt.setString(7, "商品名");
				prepStmt.setString(8, "商品名");
			}
			if (itemBox.equals("负责人")) {
				prepStmt.setString(1, "金额");
				prepStmt.setString(2, "金额");
				prepStmt.setString(3, "金额");
				prepStmt.setString(4, "金额");
				prepStmt.setString(5, "金额");
				prepStmt.setString(6, "金额");
				prepStmt.setString(7, itemField);
				prepStmt.setString(8, "金额");
				 
			}
			if (itemBox.equals("负责人电话")) {
				prepStmt.setString(1, "数量");
				prepStmt.setString(2, "数量");
				prepStmt.setString(3, "数量");
				prepStmt.setString(4, "数量");
				prepStmt.setString(5, "数量");
				prepStmt.setString(6, "数量");
				prepStmt.setString(7, "数量");
				prepStmt.setString(8, itemField);
			}
			rs = prepStmt.executeQuery();
			while (rs.next()) {

				Department_Ren_Bean department_ren_bean = new Department_Ren_Bean();
				department_ren_bean.setId(rs.getString(1));
				department_ren_bean.setNamed(rs.getString(2));
				department_ren_bean.setAddress(rs.getString(3));
				department_ren_bean.setTel(rs.getString(4));
				department_ren_bean.setFax(rs.getString(5));
				department_ren_bean.setMail(rs.getString(6));
				department_ren_bean.setEmployeeID(rs.getString(7));
				department_ren_bean.setItel(rs.getString(8));
				alls.add(department_ren_bean);
			}
			rs.close(); 
			prepStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace());
		}
		return alls;
	}
	
	public List<Department_Ren_Bean> update_department_ren(Department_Ren_Bean department_ren_bean) {
		connection = new Database_Connection();
		con = connection.getConnection();
		List<Department_Ren_Bean> all = new ArrayList<Department_Ren_Bean>();
		try {
			prepStmt = con.prepareStatement(update_department_ren_sql);
			prepStmt.setString(1, department_ren_bean.getId());
			prepStmt.setString(2, department_ren_bean.getNamed());
			prepStmt.setString(3, department_ren_bean.getAddress()); 
			prepStmt.setString(4, department_ren_bean.getTel());
			prepStmt.setString(5, department_ren_bean.getFax());
			prepStmt.setString(6, department_ren_bean.getMail());
			prepStmt.setString(7, department_ren_bean.getEmployeeID());
			prepStmt.setString(8, department_ren_bean.getItel());
			prepStmt.setString(9, department_ren_bean.getId());
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("错误结果:" + e.getStackTrace());
		} finally { 
			try {
				prepStmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return all;
	}

	public boolean  delete_department_ren(String s) {
		int count;
		connection = new Database_Connection();
		con = connection.getConnection();
		
		try {
			prepStmt = con.prepareStatement(delete_department_ren_sql);
			prepStmt.setString(1, s);
			count = prepStmt.executeUpdate();
			prepStmt.close();
		} catch (Exception e) {
			System.out.println("错误了");
		}
 
		return false;
	}



}
