package SuperMarket;

import java.sql.ResultSet; 
import java.util.List;

public interface Table_Interface {
	public Table_Bean addTable_Element(Table_Bean bean);
	public Table_Bean addTable_ElementA(Table_Bean bean);
	public Table_Bean addTable_ElementB(Table_Bean bean);
	public Table_Bean addTable_ElementC(Table_Bean bean);
	public Table_Bean addTable_ElementD(Table_Bean bean);
    public List<Table_Bean> selectTable_Element();
    public List<Table_Bean> selectTable_ElementA();
    public List<Table_Bean> selectTable_ElementB();
    public List<Table_Bean> selectTable_ElementC();
    public List<Table_Bean> selectTable_ElementD(); 
    public boolean deleteTable_Element(Object bean);
    public boolean deleteTable_ElementA(Object bean);
    public boolean deleteTable_ElementB(Object bean);
    public boolean deleteTable_ElementC(Object bean);
    public boolean deleteTable_ElementD(Object bean);
    public List<Table_Bean> selectTable_Element1(String s1,String s2);
    public List<Table_Bean> selectTable_Element2(String s1,String s2);
    public List<Table_Bean> selectTable_Element3(String s1,String s2);
    public List<Table_Bean> selectTable_Element4(String s1,String s2);
    public List<Table_Bean> selectTable_Element5(String s1,String s2);
    public void updateTable_Element1(Table_Bean bean);
    public void updateTable_Element2(Table_Bean bean);
    public void updateTable_Element3(Table_Bean bean);
    public void updateTable_Element4(Table_Bean bean);
    public void updateTable_Element5(Table_Bean bean);   
  

}
