package SuperMarket;

import java.util.List;

public interface Personnel_Interface {
	public Personnel_Bean add_personnel(Personnel_Bean personnel_bean);

	public List<Personnel_Bean> update_personnel(Personnel_Bean personnel_bean);

	public boolean delete_personnel(String s);

	public List<Personnel_Bean> select_personnel(String s, String s1);
	
	public List<Personnel_Bean> select_personnel();

}