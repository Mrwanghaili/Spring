package SuperMarket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class Output_Goods_All_method implements Output_Goods_Interface {
	Connection con = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;
	Input_Goods_Bean input_goods_bean = null;
	Database_Connection connection;
 
	private String add_output_goods_sql = "insert into tb_output_goods values(?,?,?,?,?,?)";
	private String _select_output_goods_sql = "select * from tb_output_goods where cangkubianhao=? and chukushijian=?";
	private String select_output_goods_sql = "select * from tb_output_goods";
	private String update_output_goods_sql = "update tb_output_goods set bianhao=?,cangkubianhao=?,huopinmingcheng=?,chukushijian=?,zhongliang=?,beizhu=? where bianhao=?";
	private String delete_output_goods_sql = "delete from tb_output_goods where bianhao=?";

	public Output_Goods_Bean add_output_goods(Output_Goods_Bean output_goods_bean) {
		int count;
		connection = new Database_Connection();
		con = connection.getConnection();

		try {

			prepStmt = con.prepareStatement(add_output_goods_sql);
			prepStmt.setString(1, output_goods_bean.getBianhao());
			prepStmt.setString(2, output_goods_bean.getCangkubianhao()); 
			prepStmt.setString(3, output_goods_bean.getHuopinmingcheng());
			prepStmt.setString(4, output_goods_bean.getChukushijian());
			prepStmt.setString(5, output_goods_bean.getZhongliang());
			prepStmt.setString(6, output_goods_bean.getBeizhu());

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
		return output_goods_bean;
	}

	public List<Output_Goods_Bean> select_output_goods() {
		List<Output_Goods_Bean> all = new ArrayList<Output_Goods_Bean>();

		try {
			connection = new Database_Connection();
			con = connection.getConnection();
			prepStmt = con.prepareStatement(select_output_goods_sql);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				Output_Goods_Bean output_goods_bean = new Output_Goods_Bean();
				output_goods_bean.setBianhao(rs.getString(1));
				output_goods_bean.setCangkubianhao(rs.getString(2));
				output_goods_bean.setHuopinmingcheng(rs.getString(3));
				output_goods_bean.setChukushijian(rs.getString(4));
				output_goods_bean.setZhongliang(rs.getString(5));
				output_goods_bean.setBeizhu(rs.getString(6));
				all.add(output_goods_bean);

			}
			rs.close();
			prepStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace() + e);
		}

		return all;
	}

	public List<Output_Goods_Bean> select_output_goods(String s,String s1) {
		List<Output_Goods_Bean> all = new ArrayList<Output_Goods_Bean>();

		try {
			connection = new Database_Connection();
			con = connection.getConnection();
			prepStmt = con.prepareStatement(_select_output_goods_sql);
			prepStmt.setString(1, s);
			prepStmt.setString(2, s1);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				Output_Goods_Bean output_goods_bean = new Output_Goods_Bean();
				output_goods_bean.setBianhao(rs.getString(1));
				output_goods_bean.setCangkubianhao(rs.getString(2));
				output_goods_bean.setHuopinmingcheng(rs.getString(3));
				output_goods_bean.setChukushijian(rs.getString(4));
				output_goods_bean.setZhongliang(rs.getString(5));
				output_goods_bean.setBeizhu(rs.getString(6));
				all.add(output_goods_bean);

			}
			rs.close();
			prepStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace() + e);
		}

		return all;
	}
	
	public List<Output_Goods_Bean> update_output_goods(Output_Goods_Bean output_goods_bean) {
		connection = new Database_Connection();
		con = connection.getConnection();
		List<Output_Goods_Bean> all = new ArrayList<Output_Goods_Bean>();
		try {
			prepStmt = con.prepareStatement(update_output_goods_sql);
			prepStmt.setString(1, output_goods_bean.getBianhao());
			prepStmt.setString(2, output_goods_bean.getCangkubianhao());
			prepStmt.setString(3, output_goods_bean.getHuopinmingcheng());
			prepStmt.setString(4, output_goods_bean.getChukushijian());
			prepStmt.setString(5, output_goods_bean.getZhongliang());
			prepStmt.setString(6, output_goods_bean.getBeizhu());
			prepStmt.setString(7, output_goods_bean.getBianhao());
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

	public boolean  delete_output_goods(String s) {
		int count;
		connection = new Database_Connection();
		con = connection.getConnection();
		
		try {
			prepStmt = con.prepareStatement(delete_output_goods_sql);
			prepStmt.setString(1, s);
			count = prepStmt.executeUpdate();
			prepStmt.close();
		} catch (Exception e) {
			System.out.println("错误了");
		}

		return false;
	}



}
