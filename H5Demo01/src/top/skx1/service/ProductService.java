package top.skx1.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import top.skx1.jdbc.ProductJdbc;
import top.skx1.model.Product;

public class ProductService {

	ProductJdbc pj=new ProductJdbc();
	
	public List<Product> show() {
		// TODO Auto-generated method stub
		ResultSet rs =pj.show();
		List<Product> list =new ArrayList<Product>();
		try {
			while (rs.next()) {
				int id= rs.getInt("id");
				String product_name= rs.getString("product_name");
				int product_prices=rs.getInt("product_prices");
				int product_stock=rs.getInt("product_stock");
				
				Product product = new Product(id, product_name, product_prices, product_stock);
				
				list.add(product);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public void delete(String id) {
		pj.delete(id);
	}
	public void add(String product_name, String product_prices, String product_stock) {
		pj.add( product_name,  product_prices,  product_stock);
		
	}
	public Product toupdate(String id) {
		ResultSet rs = pj.show();
		try {
			while (rs.next()) {
				int db_id = rs.getInt("id");
				if(id.equals(db_id+"")){
					String product_name = rs.getString("product_name");
					int product_stock = rs.getInt("product_stock");
					int product_prices = rs.getInt("product_prices");
					Product product = new Product(db_id, product_name, product_prices, product_stock);
					return product;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public void update(String id, String product_name, String product_prices, String product_stock) {
		pj.update( id,  product_name,  product_prices,  product_stock);
	}
	public List<Product> find(String id, String product_name, String product_stock) {
		//select  * from product  where id = ？and   product_name="" and   product_stock=？
		String sql ="";
		int sum =0;
		if(id!=""){
			if(sum!=0){
				 sql+=" and ";
				 sql+="id="+id;
			}
			else{
				 sql+="id="+id;
				 sum++;
			}
		}
	    if(product_name!=""){
	    	if(sum!=0){
	    		sql+=" and ";
	    		sql +="product_name='"+product_name+"'";
			  }
	    	else{
	    		sql +="product_name='"+product_name+"'";
	    		sum++;
	    	}
		}
	    if(product_stock!=""){
		   if(sum!=0){
	    		sql+=" and ";
	    		sql +="product_stock='"+product_stock+"'";
			  }
	    	else{
	    		sql +="product_stock='"+product_stock+"'";
	    		sum++;
	    	}
		}
	    
	    System.out.println(sql);
	    
	    ResultSet rs =pj.find(sql);
	    List<Product>  list =  new ArrayList<Product>();
		try {
			while (rs.next()) {
				int db_id = rs.getInt("id");
				String db_product_name = rs.getString("product_name");
				int db_product_stock = rs.getInt("product_stock");
				int db_product_prices = rs.getInt("product_prices");
				Product product = new Product(db_id, db_product_name, db_product_stock, db_product_prices); 
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
}
