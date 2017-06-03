package SuperMarket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Input_Goods_All_method implements Input_Goods_Interface {
	Connection con = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;
	Input_Goods_Bean input_goods_bean = null;
	Database_Connection connection;
 
	private String add_input_goods_sql = "insert into tb_input_goods values(?,?,?,?,?,?,?)";
	private String _select_input_goods_sql = "select * from tb_input_goods where dingdanhao=? and rukushijian=?";
	private String select_input_goods_sql = "select * from tb_input_goods";
	private String update_input_goods_sql = "update tb_input_goods set bianhao=?,dingdanhao=?,cangkubianhao=?,huopinmingcheng=?,rukushijian=?,zhongliang=?,beizhu=? where bianhao=?";
	private String delete_input_goods_sql = "delete from tb_input_goods where bianhao=?";

	public Input_Goods_Bean add_input_goods(Input_Goods_Bean input_goods_bean) {
		int count;
		connection = new Database_Connection();
		con = connection.getConnection();

		try {

			prepStmt = con.prepareStatement(add_input_goods_sql);
			prepStmt.setString(1, input_goods_bean.getBianhao());
			prepStmt.setString(2, input_goods_bean.getDingdanhao());
			prepStmt.setString(3, input_goods_bean.getCangkubiaohao()); 
			prepStmt.setString(4, input_goods_bean.getHuopinmingcheng());
			prepStmt.setString(5, input_goods_bean.getRukushijian());
			prepStmt.setString(6, input_goods_bean.getZhongliang());
			prepStmt.setString(7, input_goods_bean.getBeizhu());

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
		return input_goods_bean;
	}

	public List<Input_Goods_Bean> select_input_goods() {
		List<Input_Goods_Bean> all = new ArrayList<Input_Goods_Bean>();

		try {
			connection = new Database_Connection();
			con = connection.getConnection();
			prepStmt = con.prepareStatement(select_input_goods_sql);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				Input_Goods_Bean input_goods_bean = new Input_Goods_Bean();
				input_goods_bean.setBianhao(rs.getString(1));
				input_goods_bean.setDingdanhao(rs.getString(2));
				input_goods_bean.setCangkubiaohao(rs.getString(3));
				input_goods_bean.setHuopinmingcheng(rs.getString(4));
				input_goods_bean.setRukushijian(rs.getString(5));
				input_goods_bean.setZhongliang(rs.getString(6));
				input_goods_bean.setBeizhu(rs.getString(7));
				all.add(input_goods_bean);

			}
			rs.close();
			prepStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace() + e);
		}

		return all;
	}

	public List<Input_Goods_Bean> select_input_goods(String s,String s1) {
		List<Input_Goods_Bean> all = new ArrayList<Input_Goods_Bean>();

		try {
			connection = new Database_Connection();
			con = connection.getConnection();
			prepStmt = con.prepareStatement(_select_input_goods_sql);
			prepStmt.setString(1, s);
			prepStmt.setString(2, s1);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				Input_Goods_Bean input_goods_bean = new Input_Goods_Bean();
				input_goods_bean.setBianhao(rs.getString(1));
				input_goods_bean.setDingdanhao(rs.getString(2));
				input_goods_bean.setCangkubiaohao(rs.getString(3));
				input_goods_bean.setHuopinmingcheng(rs.getString(4));
				input_goods_bean.setRukushijian(rs.getString(5));
				input_goods_bean.setZhongliang(rs.getString(6));
				input_goods_bean.setBeizhu(rs.getString(7));
				all.add(input_goods_bean);

			}
			rs.close();
			prepStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace() + e);
		}

		return all;
	}
	
	public List<Input_Goods_Bean> update_input_goods(Input_Goods_Bean input_goods_bean) {
		connection = new Database_Connection();
		con = connection.getConnection();
		List<Input_Goods_Bean> all = new ArrayList<Input_Goods_Bean>();
		try {
			prepStmt = con.prepareStatement(update_input_goods_sql);
			prepStmt.setString(1, input_goods_bean.getBianhao());
			prepStmt.setString(2, input_goods_bean.getDingdanhao());
			prepStmt.setString(3, input_goods_bean.getCangkubiaohao());
			prepStmt.setString(4, input_goods_bean.getHuopinmingcheng());
			prepStmt.setString(5, input_goods_bean.getRukushijian());
			prepStmt.setString(6, input_goods_bean.getZhongliang());
			prepStmt.setString(7, input_goods_bean.getBeizhu());
			prepStmt.setString(8, input_goods_bean.getBianhao());
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

	public boolean  delete_input_goods(String s) {
		int count;
		connection = new Database_Connection();
		con = connection.getConnection();
		
		try {
			prepStmt = con.prepareStatement(delete_input_goods_sql);
			prepStmt.setString(1, s);
			count = prepStmt.executeUpdate();
			prepStmt.close();
		} catch (Exception e) {
			System.out.println("错误了");
		}

		return false;
	}



}
