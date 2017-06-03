/** 
 * 数据库接口类
 * **/   
package SuperMarket;

import java.sql.ResultSet;

public interface Datebase_Interface {
	public  boolean findSuperMarket();
    public boolean deleteSuperMarket();
    public boolean addSuperMarket();
    public boolean updateSuperMarket();
    
}
