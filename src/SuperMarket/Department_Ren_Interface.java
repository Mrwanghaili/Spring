package SuperMarket;

import java.util.List; 

public interface Department_Ren_Interface { 
	public Department_Ren_Bean add_department_ren(Department_Ren_Bean purchase_bean);
	public List<Department_Ren_Bean> select_department_ren();
	public List<Department_Ren_Bean> update_department_ren(Department_Ren_Bean purchase_bean);
	public boolean delete_department_ren(String s);
	public List<Department_Ren_Bean> select_department_ren(String s,String s1); 
}
