package SuperMarket;

import java.util.List;

public interface Input_Goods_Interface { 
	public Input_Goods_Bean add_input_goods(Input_Goods_Bean purchase_bean);
	public List<Input_Goods_Bean> select_input_goods();
	public List<Input_Goods_Bean> update_input_goods(Input_Goods_Bean purchase_bean);
	public boolean delete_input_goods(String s);
	public List<Input_Goods_Bean> select_input_goods(String s,String s1); 
}
