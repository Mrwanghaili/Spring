package SuperMarket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Purchase_All_method implements Purchase_Interface {
	Connection con = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;
	Purchase_Bean purchase_bean = null;
	Database_Connection connection;

	private String add_Purchase_sql = "insert into Purchaseorder values(?,?,?,?,?,?,?,?)";
	private String select_Purchase_sql = "select * from Purchaseorder";
	private String update_Purchase_sql = "update Purchaseorder set bianhao=?,kehu=?,dingdan=?,riqi=?,shangpin=?,jine=?,shuliang=? where bianhao=?";
	private String delete_Purchase_sql = "delete from Purchaseorder where bianhao=?";
	private String _select_Purchase_sql = "select * from Purchaseorder where xuanze=? or bianhao=? or kehu=? or dingdan=? or riqi=? or shangpin=? or jine=? or shuliang=?";
	private String update_sql = "update Purchaseorder set xuanze=? where bianhao=?";
	public Purchase_Bean addPurchase(Purchase_Bean purchase_bean) {
		int count;
		connection = new Database_Connection();
		con = connection.getConnection();

		try {

			prepStmt = con.prepareStatement(add_Purchase_sql);
			prepStmt.setString(1, purchase_bean.getXuanze());
			prepStmt.setString(2, purchase_bean.getBianhao());
			prepStmt.setString(3, purchase_bean.getKehu());
			prepStmt.setString(4, purchase_bean.getDingdan());
			prepStmt.setString(5, purchase_bean.getRiqi());
			prepStmt.setString(6, purchase_bean.getShangpin());
			prepStmt.setString(7, purchase_bean.getJine());
			prepStmt.setString(8, purchase_bean.getShuliang());

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
		return purchase_bean;
	}

	public List<Purchase_Bean> selectPurchase() {
		List<Purchase_Bean> all = new ArrayList<Purchase_Bean>();

		try {
			connection = new Database_Connection();
			con = connection.getConnection();
			prepStmt = con.prepareStatement(select_Purchase_sql);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				Purchase_Bean purchase_bean = new Purchase_Bean();
				purchase_bean.setXuanxiang(rs.getString(1));
				purchase_bean.setBianhao(rs.getString(2));
				purchase_bean.setKehu(rs.getString(3));
				purchase_bean.setDingdan(rs.getString(4));
				purchase_bean.setRiqi(rs.getString(5));
				purchase_bean.setShangpin(rs.getString(6));
				purchase_bean.setJine(rs.getString(7));
				purchase_bean.setShuliang(rs.getString(8));
				all.add(purchase_bean);

			}
			rs.close();
			prepStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace() + e);
		}

		return all;
	}
 
	public List<Purchase_Bean> updatePurchase(Purchase_Bean purchase_bean) {
		connection = new Database_Connection();
		con = connection.getConnection();
		List<Purchase_Bean> all = new ArrayList<Purchase_Bean>();
		try {
			prepStmt = con.prepareStatement(update_Purchase_sql);
			prepStmt.setString(1, purchase_bean.getBianhao());
			prepStmt.setString(2, purchase_bean.getKehu());
			prepStmt.setString(3, purchase_bean.getDingdan());
			prepStmt.setString(4, purchase_bean.getRiqi());
			prepStmt.setString(5, purchase_bean.getShangpin());
			prepStmt.setString(6, purchase_bean.getJine());
			prepStmt.setString(7, purchase_bean.getShuliang());
			prepStmt.setString(8, purchase_bean.getBianhao());
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("错误结果:" + e.getStackTrace());
			System.out.println("是摆");
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
	
	public List<Purchase_Bean> updatePurchase_1(String row) {
		connection = new Database_Connection();
		con = connection.getConnection();
		List<Purchase_Bean> all = new ArrayList<Purchase_Bean>();
		try {
			prepStmt = con.prepareStatement(update_sql);
			prepStmt.setString(1,"1");
			prepStmt.setString(2,row);  
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("错误结果:" + e.getStackTrace());
			System.out.println("是摆");
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
	

	public boolean delete_Purchase(String s) {
		int count;
		connection = new Database_Connection();
		con = connection.getConnection();

		try {
			prepStmt = con.prepareStatement(delete_Purchase_sql);

			prepStmt.setString(1, s);
			count = prepStmt.executeUpdate();
			prepStmt.close();
			prepStmt.close();
		} catch (Exception e) {
			System.out.println("错误了");
		}

		return false;
	}

	public List<Purchase_Bean> selectPurchase_Element(String itemField, String itemBox) {
		List<Purchase_Bean> alls = new ArrayList<Purchase_Bean>();

		try {
			connection = new Database_Connection();
			con = connection.getConnection();

			prepStmt = con.prepareStatement(_select_Purchase_sql);
			if (itemBox.equals("编号")) {
				prepStmt.setString(1, "编号");
				prepStmt.setString(2, itemField);
				prepStmt.setString(3, "编号");
				prepStmt.setString(4, "编号");
				prepStmt.setString(5, "编号");
				prepStmt.setString(6, "编号");
				prepStmt.setString(7, "编号");
				prepStmt.setString(8, "编号");
			}
			if (itemBox.equals("客户")) {
				prepStmt.setString(1, "客户");
				prepStmt.setString(2, "客户");
				prepStmt.setString(3, itemField);
				prepStmt.setString(4, "客户");
				prepStmt.setString(5, "客户");
				prepStmt.setString(6, "客户");
				prepStmt.setString(7, "客户");
				prepStmt.setString(8, "客户");
			}
			if (itemBox.equals("订单号")) {
				prepStmt.setString(1, "订单号");
				prepStmt.setString(2, "订单号");
				prepStmt.setString(3, "订单号");
				prepStmt.setString(4, itemField);
				prepStmt.setString(5, "订单号");
				prepStmt.setString(6, "订单号");
				prepStmt.setString(7, "订单号");
				prepStmt.setString(8, "订单号");
			}
			if (itemBox.equals("交货日期")) {
				prepStmt.setString(1, "交货日期");
				prepStmt.setString(2, "交货日期");
				prepStmt.setString(3, "交货日期");
				prepStmt.setString(4, "交货日期");
				prepStmt.setString(5, itemField);
				prepStmt.setString(6, "交货日期");
				prepStmt.setString(7, "交货日期");
				prepStmt.setString(8, "交货日期");
			}
			if (itemBox.equals("商品名")) {
				prepStmt.setString(1, "商品名");
				prepStmt.setString(2, "商品名");
				prepStmt.setString(3, "商品名");
				prepStmt.setString(4, "商品名");
				prepStmt.setString(5, "商品名");
				prepStmt.setString(6, itemField);
				prepStmt.setString(7, "商品名");
				prepStmt.setString(8, "商品名");
			}
			if (itemBox.equals("金额")) {
				prepStmt.setString(1, "金额");
				prepStmt.setString(2, "金额");
				prepStmt.setString(3, "金额");
				prepStmt.setString(4, "金额");
				prepStmt.setString(5, "金额");
				prepStmt.setString(6, "金额");
				prepStmt.setString(7, itemField);
				prepStmt.setString(8, "金额");
				
			}
			if (itemBox.equals("数量")) {
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

				Purchase_Bean purchase = new Purchase_Bean();
				purchase.setBianhao(rs.getString(2));
				purchase.setKehu(rs.getString(3));
				purchase.setDingdan(rs.getString(4));
				purchase.setRiqi(rs.getString(5));
				purchase.setShangpin(rs.getString(6));
				purchase.setJine(rs.getString(7));
				purchase.setShuliang(rs.getString(8));
				alls.add(purchase);
			}
			rs.close();
			prepStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("错误结果:" + e.getStackTrace() + e);
		}

		return alls;
	}

}
