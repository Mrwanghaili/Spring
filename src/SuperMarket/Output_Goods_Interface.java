package SuperMarket;

import java.util.List;

public interface Output_Goods_Interface { 
	public Output_Goods_Bean add_output_goods(Output_Goods_Bean purchase_bean);
	public List<Output_Goods_Bean> select_output_goods();
	public List<Output_Goods_Bean> update_output_goods(Output_Goods_Bean purchase_bean);
	public boolean delete_output_goods(String s);
	public List<Output_Goods_Bean> select_output_goods(String s,String s1); 
}
 