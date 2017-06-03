package SuperMarket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List;

import javax.swing.JOptionPane;

import SuperMarket.Table_Bean; 
public class Table_All_Method extends Table_Bean implements Table_Interface{
	 Connection con = null;
     PreparedStatement prepStmt = null; 
     ResultSet rs = null; 
     Table_Bean bean = null;
     Database_Connection connection;
     String add_table_sql = "insert into tb_providers values(?,?,?,?,?,?,?,?,?,?,?)";
     String add_table_sqlA = "insert into tb_sell_main values(?,?,?,?,?,?,?,?,?)";
     String add_table_sqlB = "insert into tb_products values(?,?,?,?,?,?,?,?,?)";
     String add_table_sqlC = "insert into tb_buy_main values(?,?,?,?,?,?,?,?,?)";
     String add_table_sqlD = "insert into tb_headship values(?,?,?,?)";
  
     String select_table_sql = "select * from tb_providers";
     String select_table_sqlA = "select * from tb_sell_main";
     String select_table_sqlB = "select * from tb_products";
     String select_table_sqlC = "select * from tb_buy_main";
     String select_table_sqlD = "select * from tb_headship";
      
     String select_table_sqlB1 = "select * from tb_providers where named=? and jc=?";
     String select_table_sqlB2 = "select * from tb_sell_main where pzs=? and je=?";
     String select_table_sqlB3 = "select * from tb_products where spname=? and jc=?";
     String select_table_sqlB4 = "select * from tb_buy_main where pzs=? and je=?";
     String select_table_sqlB5 = "select * from tb_headship where named=? and depid=?";
     
     String delete_table_sql = "delete from tb_providers where id=?";
     String delete_table_sqlA = "delete from tb_sell_main where sellid=?"; 
     String delete_table_sqlB = "delete from tb_products where id=?";
     String delete_table_sqlC = "delete from tb_buy_main where rkid=?";
     String delete_table_sqlD = "delete from tb_headship where id=?";
     
     String update_table_sqlA = "update tb_providers set id=?,named=?,jc=?,bianma=?,tel=?,fax=?,lian=?,Itel=?,yh=?,zh=?,mail=? where id=?";
     String update_table_sqlB = "update tb_sell_main set sellid=?,pzs=?,je=?,ysjl=?,khname=?,xsdate=?,czy=?,jsr=?,jsfs=? where sellid=?";
     String update_table_sqlC = "update tb_products set id=?,spname=?,jc=?,dw=?,gg=?,bz=?,pzwh=?,memo=?,providerID=? where id=?";
     String update_table_sqlD = "update tb_buy_main set rkid=?,pzs=?,je=?,ysjl=?,providerID=?,rkdate=?,czy=?,jsr=?,jsfs=? where rkid=?";
     String update_table_sqlE = "update tb_headship set id=?,named=?,depid=?,descd=? where id=?";
     
	public Table_Bean addTable_Element(Table_Bean bean) {
	     int count; 
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 try {
				prepStmt = con.prepareStatement(add_table_sql);
				prepStmt.setString(1,bean.getId());
				prepStmt.setString(2,bean.getName());
				prepStmt.setString(3,bean.getJc());
				prepStmt.setString(4,bean.getBianma());
				prepStmt.setString(5,bean.getTel());
				prepStmt.setString(6,bean.getFax());
				prepStmt.setString(7,bean.getLian());
				prepStmt.setString(8,bean.getLtel());
				prepStmt.setString(9,bean.getYh());
				prepStmt.setString(10,bean.getZh());
				prepStmt.setString(11,bean.getMail());
				//System.out.println("结果"+bean.getId());
				count = prepStmt.executeUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(Wickket_Method.frame,"添加编号重复","添加",JOptionPane.INFORMATION_MESSAGE);
			}
			finally {
				try {
					prepStmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return bean;
		}
	
	public Table_Bean addTable_ElementA(Table_Bean bean) {
	     int count; 
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 try {
				prepStmt = con.prepareStatement(add_table_sqlA);
				prepStmt.setString(1,bean.getSellid());
				prepStmt.setString(2,bean.getPzs());
				prepStmt.setString(3,bean.getJe());
				prepStmt.setString(4,bean.getYsjl());
				prepStmt.setString(5,bean.getKhname());
				prepStmt.setString(6,bean.getXsdate());
				prepStmt.setString(7,bean.getCzy());
				prepStmt.setString(8,bean.getJsr());
				prepStmt.setString(9,bean.getJsfs());
				//System.out.println("结果"+bean.getId());
				count = prepStmt.executeUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(Wickket_Method.frame,"添加编号重复","添加",JOptionPane.INFORMATION_MESSAGE);
			}
			finally {
				try {
					prepStmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return bean;
		}
	
	public Table_Bean addTable_ElementB(Table_Bean bean) {
	     int count; 
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 try {
				prepStmt = con.prepareStatement(add_table_sqlB);
				prepStmt.setString(1,bean.getId1());
				prepStmt.setString(2,bean.getSpname());
				prepStmt.setString(3,bean.getJc1());
				prepStmt.setString(4,bean.getDw());
				prepStmt.setString(5,bean.getGg());
				prepStmt.setString(6,bean.getBz());
				prepStmt.setString(7,bean.getPzwh());
				prepStmt.setString(8,bean.getMemo());
				prepStmt.setString(9,bean.getProviderID());
				count = prepStmt.executeUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(Wickket_Method.frame,"添加编号重复","添加",JOptionPane.INFORMATION_MESSAGE);
			}
			finally {
				try {
					prepStmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return bean;
		}
	
	public Table_Bean addTable_ElementC(Table_Bean bean) {
	     int count; 
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 try {
				prepStmt = con.prepareStatement(add_table_sqlC);
				prepStmt.setString(1,bean.getRkid());
				prepStmt.setString(2,bean.getPzsA());
				prepStmt.setString(3,bean.getJeA());
				prepStmt.setString(4,bean.getYsjlA());
				prepStmt.setString(5,bean.getProviderIDA());
				prepStmt.setString(6,bean.getRkidA());
				prepStmt.setString(7,bean.getCzyA());
				prepStmt.setString(8,bean.getJsrA());
				prepStmt.setString(9,bean.getJsfsA());
				count = prepStmt.executeUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(Wickket_Method.frame,"添加编号重复","添加",JOptionPane.INFORMATION_MESSAGE);
			}
			finally {
				try {
					prepStmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return bean;
		}
	
	public Table_Bean addTable_ElementD(Table_Bean bean) {
	     int count; 
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 try {
				prepStmt = con.prepareStatement(add_table_sqlD);
				prepStmt.setString(1,bean.getIDB());
				prepStmt.setString(2,bean.getNameB());
				prepStmt.setString(3,bean.getDepID());
				prepStmt.setString(4,bean.getDesc());
				count = prepStmt.executeUpdate();
			} catch (SQLException e) { 
				JOptionPane.showMessageDialog(Wickket_Method.frame,"添加编号重复","添加",JOptionPane.INFORMATION_MESSAGE);
			}
			finally {
				try { 
					prepStmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return bean;
		}
	

	public void updateTable_Element1(Table_Bean bean) {
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 try {
				prepStmt = con.prepareStatement(update_table_sqlA);
				prepStmt.setString(1,bean.getId());
				prepStmt.setString(2,bean.getName());
				prepStmt.setString(3,bean.getJc());
				prepStmt.setString(4,bean.getBianma());
				prepStmt.setString(5,bean.getTel());
				prepStmt.setString(6,bean.getFax());
				prepStmt.setString(7,bean.getLian());
				prepStmt.setString(8,bean.getLtel());
				prepStmt.setString(9,bean.getYh());
				prepStmt.setString(10,bean.getZh());
				prepStmt.setString(11,bean.getMail());
				prepStmt.setString(12,bean.getId());
				prepStmt.executeUpdate();
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
		
	}
	
	public void updateTable_Element2(Table_Bean bean) {
		connection = new Database_Connection();
		 con = connection.getConnection();
		 try {
				prepStmt = con.prepareStatement(update_table_sqlB);
				prepStmt.setString(1,bean.getSellid());
				prepStmt.setString(2,bean.getPzs());
				prepStmt.setString(3,bean.getJe());
				prepStmt.setString(4,bean.getYsjl());
				prepStmt.setString(5,bean.getKhname());
				prepStmt.setString(6,bean.getXsdate());
				prepStmt.setString(7,bean.getCzy());
				prepStmt.setString(8,bean.getJsr());
				prepStmt.setString(9,bean.getJsfs());
				prepStmt.setString(10,bean.getSellid());
				prepStmt.executeUpdate();
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
	
	} 

	public void updateTable_Element3(Table_Bean bean) {
		 int count; 
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 try {
				prepStmt = con.prepareStatement(update_table_sqlC);
				prepStmt.setString(1,bean.getId1());
				prepStmt.setString(2,bean.getSpname());
				prepStmt.setString(3,bean.getJc1());
				prepStmt.setString(4,bean.getDw());
				prepStmt.setString(5,bean.getGg());
				prepStmt.setString(6,bean.getBz());
				prepStmt.setString(7,bean.getPzwh());
				prepStmt.setString(8,bean.getMemo());
				prepStmt.setString(9,bean.getProviderID());
				prepStmt.setString(10,bean.getId1());
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
	} 
 

	public void updateTable_Element4(Table_Bean bean) {
		 int count; 
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 try {
				prepStmt = con.prepareStatement(update_table_sqlD);
				prepStmt.setString(1,bean.getRkid());
				prepStmt.setString(2,bean.getPzsA()); 
				prepStmt.setString(3,bean.getJeA());
				prepStmt.setString(4,bean.getYsjlA());
				prepStmt.setString(5,bean.getProviderIDA());
				prepStmt.setString(6,bean.getRkidA());
				prepStmt.setString(7,bean.getCzyA());
				prepStmt.setString(8,bean.getJsrA());
				prepStmt.setString(9,bean.getJsfsA());
				prepStmt.setString(10,bean.getRkid());
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
		
	} 


	public void updateTable_Element5(Table_Bean bean) {
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 try {
				prepStmt = con.prepareStatement(update_table_sqlE);
				prepStmt.setString(1,bean.getIDB());
				prepStmt.setString(2,bean.getNameB());
				prepStmt.setString(3,bean.getDepID());
				prepStmt.setString(4,bean.getDesc());
                prepStmt.setString(5,bean.getIDB()); 
				
				prepStmt.executeUpdate();
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
		
	} 

	public List<Table_Bean> selectTable_Element() {
		 List<Table_Bean> all = new ArrayList<Table_Bean>();
		 
		try {    
        	connection = new Database_Connection(); 
        	 con = connection.getConnection();
        	 prepStmt = con.prepareStatement(select_table_sql);
        	 rs = prepStmt.executeQuery();
        	 while(rs.next()) {
                Table_Bean bean = new Table_Bean();
                bean.setId(rs.getString(1));
                bean.setName(rs.getString(2)); 
                bean.setJc(rs.getString(3)); 
                bean.setBianma(rs.getString(4)); 
                bean.setTel(rs.getString(5)); 
                bean.setFax(rs.getString(6)); 
                bean.setLian(rs.getString(7)); 
                bean.setLtel(rs.getString(8)); 
                bean.setYh(rs.getString(9)); 
                bean.setZh(rs.getString(10)); 
                bean.setMail(rs.getString(11)); 
                all.add(bean);                  
        	    
        	 }	 
        	 rs.close();
        	 prepStmt.close();
        	 con.close();
        	  
        } 
        catch(Exception e) {
        	System.out.println("错误结果:"+e.getStackTrace()+e);
        }
        
		return all;
	}
	
	public List<Table_Bean> selectTable_ElementA() {
		 List<Table_Bean> all1 = new ArrayList<Table_Bean>();
		 
		try {    
       	connection = new Database_Connection(); 
       	 con = connection.getConnection();
       	 prepStmt = con.prepareStatement(select_table_sqlA);
       	 rs = prepStmt.executeQuery();
       	 while(rs.next()) {
       		 
               Table_Bean bean = new Table_Bean();
               bean.setSellid(rs.getString(1));
               bean.setPzs(rs.getString(2)); 
               bean.setJe(rs.getString(3)); 
               bean.setYsjl(rs.getString(4)); 
               bean.setKhname(rs.getString(5)); 
               bean.setXsdate(rs.getString(6)); 
               bean.setCzy(rs.getString(7)); 
               bean.setJsr(rs.getString(8)); 
               bean.setJsfs(rs.getString(9)); 
               all1.add(bean);                  
       	    
       	 }	 
       	 rs.close();
       	 prepStmt.close();
       	 con.close();
       	  
       } 
       catch(Exception e) {
       	System.out.println("错误结果:"+e.getStackTrace()+e);
       }
       
		return all1;
	}
	
	public List<Table_Bean> selectTable_ElementB() {
		 List<Table_Bean> all2 = new ArrayList<Table_Bean>();
		 
		try {    
       	connection = new Database_Connection(); 
       	 con = connection.getConnection();
       	 prepStmt = con.prepareStatement(select_table_sqlB);
       	 rs = prepStmt.executeQuery();
       	 while(rs.next()) {
       		 
               Table_Bean bean = new Table_Bean();
               bean.setId1(rs.getString(1));
               bean.setSpname(rs.getString(2)); 
               bean.setJc1(rs.getString(3)); 
               bean.setDw(rs.getString(4)); 
               bean.setGg(rs.getString(5)); 
               bean.setBz(rs.getString(6)); 
               bean.setPzwh(rs.getString(7)); 
               bean.setMemo(rs.getString(8)); 
               bean.setProviderID(rs.getString(9)); 
               all2.add(bean);                  
       	    
       	 }	 
       	 rs.close();
       	 prepStmt.close();
       	 con.close();
       	  
       } 
       catch(Exception e) {
       	System.out.println("错误结果:"+e.getStackTrace()+e);
       }
       
		return all2;
	}
	
	
	public List<Table_Bean> selectTable_ElementC() {
		 List<Table_Bean> all3 = new ArrayList<Table_Bean>();
		 
		try {    
       	connection = new Database_Connection(); 
       	 con = connection.getConnection();
       	 prepStmt = con.prepareStatement(select_table_sqlC);
       	 rs = prepStmt.executeQuery();
       	 while(rs.next()) {
       		 
               Table_Bean bean = new Table_Bean();
               bean.setRkid(rs.getString(1));
               bean.setPzsA(rs.getString(2)); 
               bean.setJeA(rs.getString(3)); 
               bean.setYsjlA(rs.getString(4)); 
               bean.setProviderIDA(rs.getString(5)); 
               bean.setRkidA(rs.getString(6)); 
               bean.setCzyA(rs.getString(7)); 
               bean.setJsrA(rs.getString(8)); 
               bean.setJsfsA(rs.getString(9)); 
               all3.add(bean);                  
       	    
       	 }	 
       	 rs.close();
       	 prepStmt.close();
       	 con.close();
       	  
       } 
       catch(Exception e) {
       	System.out.println("错误结果:"+e.getStackTrace()+e);
       }
       
		return all3;
	}
	
	public List<Table_Bean> selectTable_ElementD() {
		 List<Table_Bean> all4 = new ArrayList<Table_Bean>();
		 
		try {    
       	  connection = new Database_Connection(); 
       	 con = connection.getConnection();
       	 prepStmt = con.prepareStatement(select_table_sqlD);
       	 rs = prepStmt.executeQuery();
       	 while(rs.next()) {
       		 
               Table_Bean bean = new Table_Bean();
               bean.setIDB(rs.getString(1));
               bean.setNameB(rs.getString(2)); 
               bean.setDepID(rs.getString(3)); 
               bean.setDesc(rs.getString(4)); 
               all4.add(bean);                  
       	    
       	 }	 
       	 rs.close();
       	 prepStmt.close();
       	 con.close();
       	  
       } 
       catch(Exception e) {
       	System.out.println("错误结果:"+e.getStackTrace()+e);
       }
       
		return all4;
	}
	
	public boolean deleteTable_Element(Object s) {
		 int count;
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 
		 try {
			 prepStmt = con.prepareStatement(delete_table_sql); 
			
			 prepStmt.setString(1,String.valueOf(s));
			 count = prepStmt.executeUpdate();
			 prepStmt.close();
			 prepStmt.close(); 
		 }
		 catch(Exception e) {
			System.out.println("错误了"); 
		 }
		
		
		return false;
	}
	
	public boolean deleteTable_ElementA(Object s) {
		 int count;
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 
		 try {
			 prepStmt = con.prepareStatement(delete_table_sqlA); 
			
			 prepStmt.setString(1,String.valueOf(s));
			 count = prepStmt.executeUpdate();
			 prepStmt.close();
			 prepStmt.close(); 
		 }
		 catch(Exception e) {
			System.out.println("错误了"); 
		 }
		
		
		return false;
	}
	
	public boolean deleteTable_ElementB(Object s) {
		 int count;
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 
		 try {
			 prepStmt = con.prepareStatement(delete_table_sqlB); 
			
			 prepStmt.setString(1,String.valueOf(s));
			 count = prepStmt.executeUpdate();
			 prepStmt.close();
			 prepStmt.close(); 
		 }
		 catch(Exception e) {
			System.out.println("错误了"); 
		 }
		
		
		return false;
	}
	
	public boolean deleteTable_ElementC(Object s) {
		 int count;
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 
		 try {
			 prepStmt = con.prepareStatement(delete_table_sqlC); 
			
			 prepStmt.setString(1,String.valueOf(s));
			 count = prepStmt.executeUpdate();
			 prepStmt.close();
			 prepStmt.close(); 
		 }
		 catch(Exception e) {
			System.out.println("错误了"); 
		 }
		
		
		return false;
	}
	
	public boolean deleteTable_ElementD(Object s) {
		 int count;
		 connection = new Database_Connection();
		 con = connection.getConnection();
		 
		 try {
			 prepStmt = con.prepareStatement(delete_table_sqlD); 
			
			 prepStmt.setString(1,String.valueOf(s));
			 count = prepStmt.executeUpdate();
			 prepStmt.close();
			 prepStmt.close(); 
		 }
		 catch(Exception e) {
			System.out.println("错误了"); 
		 }
		
		
		return false;
	}
	
	 public List<Table_Bean> selectTable_Element1(String s1,String s2) {
		 List<Table_Bean> all4 = new ArrayList<Table_Bean>();
		 
			try {    
	       	  connection = new Database_Connection(); 
	       	 con = connection.getConnection();
	       	 prepStmt = con.prepareStatement(select_table_sqlB1);
	       	 prepStmt.setString(1,s1);
             prepStmt.setString(2,s2);
	       	 rs = prepStmt.executeQuery();
	       	 while(rs.next()) {
	       		 
	               Table_Bean bean = new Table_Bean();
	                bean.setId(rs.getString(1));
	                bean.setName(rs.getString(2)); 
	                bean.setJc(rs.getString(3)); 
	                bean.setBianma(rs.getString(4)); 
	                bean.setTel(rs.getString(5)); 
	                bean.setFax(rs.getString(6)); 
	                bean.setLian(rs.getString(7)); 
	                bean.setLtel(rs.getString(8)); 
	                bean.setYh(rs.getString(9)); 
	                bean.setZh(rs.getString(10)); 
	                bean.setMail(rs.getString(11)); 
	               all4.add(bean);                  
	       	    
	       	 }	 
	       	 rs.close();
	       	 prepStmt.close();
	       	 con.close();
	       	  
	       } 
	       catch(Exception e) {
	       	System.out.println("错误结果:"+e.getStackTrace()+e);
	       }
	       
			return all4;
	 }
	 
	 public List<Table_Bean> selectTable_Element2(String s1,String s2) {
		 List<Table_Bean> all4 = new ArrayList<Table_Bean>();
		 
			try {    
	       	  connection = new Database_Connection(); 
	       	 con = connection.getConnection();
	       	 prepStmt = con.prepareStatement(select_table_sqlB2);
	       	 prepStmt.setString(1,s1);
             prepStmt.setString(2,s2);
	       	 rs = prepStmt.executeQuery();
	       	 while(rs.next()) {
	       		 
	               Table_Bean bean = new Table_Bean();
	               bean.setSellid(rs.getString(1));
	               bean.setPzs(rs.getString(2)); 
	               bean.setJe(rs.getString(3)); 
	               bean.setYsjl(rs.getString(4)); 
	               bean.setKhname(rs.getString(5)); 
	               bean.setXsdate(rs.getString(6)); 
	               bean.setCzy(rs.getString(7)); 
	               bean.setJsr(rs.getString(8)); 
	               bean.setJsfs(rs.getString(9)); 
	               all4.add(bean);                  
	       	    
	       	 }	 
	       	 rs.close();
	       	 prepStmt.close();
	       	 con.close();
	       	  
	       } 
	       catch(Exception e) {
	       	System.out.println("错误结果:"+e.getStackTrace()+e);
	       }
	       
			return all4;
	 }
	 
	 public List<Table_Bean> selectTable_Element3(String s1,String s2) {
		 List<Table_Bean> all4 = new ArrayList<Table_Bean>();
		 
			try {    
	       	  connection = new Database_Connection(); 
	       	 con = connection.getConnection();
	       	 prepStmt = con.prepareStatement(select_table_sqlB3);
	       	 prepStmt.setString(1,s1);
             prepStmt.setString(2,s2);
	       	 rs = prepStmt.executeQuery();
	       	 while(rs.next()) {
	       		 
	               Table_Bean bean = new Table_Bean();
	               bean.setId1(rs.getString(1));
	               bean.setSpname(rs.getString(2)); 
	               bean.setJc1(rs.getString(3)); 
	               bean.setDw(rs.getString(4)); 
	               bean.setGg(rs.getString(5)); 
	               bean.setBz(rs.getString(6)); 
	               bean.setPzwh(rs.getString(7)); 
	               bean.setMemo(rs.getString(8)); 
	               bean.setProviderID(rs.getString(9)); 
	               all4.add(bean);                  
	       	    
	       	 }	 
	       	 rs.close();
	       	 prepStmt.close();
	       	 con.close();
	       	  
	       } 
	       catch(Exception e) {
	       	System.out.println("错误结果:"+e.getStackTrace()+e);
	       }
	       
			return all4;
	 }
	 
	 public List<Table_Bean> selectTable_Element4(String s1,String s2) {
		 List<Table_Bean> all4 = new ArrayList<Table_Bean>();
		 
			try {    
	       	  connection = new Database_Connection(); 
	       	 con = connection.getConnection();
	       	 prepStmt = con.prepareStatement(select_table_sqlB4);
	       	 prepStmt.setString(1,s1);
             prepStmt.setString(2,s2);
	       	 rs = prepStmt.executeQuery();
	       	 while(rs.next()) {
	       		 
	               Table_Bean bean = new Table_Bean();
	               bean.setRkid(rs.getString(1));
	               bean.setPzsA(rs.getString(2)); 
	               bean.setJeA(rs.getString(3)); 
	               bean.setYsjlA(rs.getString(4)); 
	               bean.setProviderIDA(rs.getString(5)); 
	               bean.setRkidA(rs.getString(6)); 
	               bean.setCzyA(rs.getString(7)); 
	               bean.setJsrA(rs.getString(8)); 
	               bean.setJsfsA(rs.getString(9)); 
	               all4.add(bean);                  
	       	    
	       	 }	 
	       	 rs.close();
	       	 prepStmt.close();
	       	 con.close();
	       	  
	       } 
	       catch(Exception e) {
	       	System.out.println("错误结果:"+e.getStackTrace()+e);
	       }
	       
			return all4;
	 }
	 
	 public List<Table_Bean> selectTable_Element5(String s1,String s2) {
		
		 List<Table_Bean> all4 = new ArrayList<Table_Bean>();
		 
			try {    
	       	  connection = new Database_Connection(); 
	       	 con = connection.getConnection();
	       	 prepStmt = con.prepareStatement(select_table_sqlB5);
	       	 prepStmt.setString(1,s1);
             prepStmt.setString(2,s2);
	       	 rs = prepStmt.executeQuery();
	       	 while(rs.next()) {
	       		 
	               Table_Bean bean = new Table_Bean();
	              
	               bean.setIDB(rs.getString(1));
	               bean.setNameB(rs.getString(2)); 
	               bean.setDepID(rs.getString(3)); 
	               bean.setDesc(rs.getString(4));
	              
	               all4.add(bean);                  
	       	   
	       	 }	 
	       	 rs.close();
	       	 prepStmt.close();
	       	 con.close();
	       	 System.out.println("111"+s1+s2);
	       } 
	       catch(Exception e) {
	       	System.out.println("错误结果:"+e.getStackTrace()+e);
	       }
	       
			return all4;
	 }
	
  
}
