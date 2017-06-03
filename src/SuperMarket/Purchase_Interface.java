package SuperMarket;

import java.util.List;

public interface Purchase_Interface {  
	public Purchase_Bean addPurchase(Purchase_Bean purchase_bean);
	public List<Purchase_Bean> selectPurchase();
	public List<Purchase_Bean> updatePurchase(Purchase_Bean purchase_bean);
	public boolean delete_Purchase(String s);
	public List<Purchase_Bean> selectPurchase_Element(String itemField,String itemBox); 
	public List<Purchase_Bean> updatePurchase_1(String row); 

}
