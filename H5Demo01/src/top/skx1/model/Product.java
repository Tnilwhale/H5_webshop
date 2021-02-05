package top.skx1.model;

public class Product {
	
	int id;
	String product_name;
	int product_prices;
	int product_stock;
	public Product(int id, String product_name, int product_prices, int product_stock) {
		
		this.id = id;
		this.product_name = product_name;
		this.product_prices = product_prices;
		this.product_stock = product_stock;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_prices() {
		return product_prices;
	}
	public void setProduct_prices(int product_prices) {
		this.product_prices = product_prices;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	
	

}
