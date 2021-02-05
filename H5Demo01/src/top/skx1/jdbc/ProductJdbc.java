package top.skx1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductJdbc {

	Connection conn;
	Statement stem;
	ResultSet rs;
	 public  void  lianjie (){
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 //getConnection链接数据库的一个方法
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/h5demo?useSSL=false&serverTimezone=UTC", "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 if(conn!=null){
			 System.out.println("数据库链接成功"); 
		 }
	 }
	
	 public  ResultSet  show(){
		 this.lianjie();
		 //Statement 可以发送执行 sql语句
		  try {
			stem = conn.createStatement();
			  rs = stem.executeQuery("  select   * from  product ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	 }


	private void close() {
		try {
			if(rs!=null){
				rs.close();
			}
			if(stem!=null){
				stem.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		this.lianjie();
		try {
			stem=conn.createStatement();
			stem.executeUpdate(" delete from  product where  id ='"+id+"'  ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.close();
		
	}

	public void add(String product_name, String product_prices, String product_stock) {
		this.lianjie();
		try {
			stem=conn.createStatement();
			stem.executeUpdate(" insert  into product  values(0,'"+product_name+"','"+product_prices+"','"+product_stock+"')  ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.close();
		
	}

	public void update(String id, String product_name, String product_prices, String product_stock) {
		this.lianjie();
		try {
			stem=conn.createStatement();
			stem.executeUpdate("update product set product_name='"+product_name+"' , product_prices='"+product_prices+"', product_stock='"+product_stock+"'  where id='"+id+"'  ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.close();
	}

	public ResultSet find(String sql) {
		 this.lianjie();
		 //Statement 可以发送执行 sql语句
		  try {
			stem = conn.createStatement();
			  rs = stem.executeQuery("  select   * from  product where  "+sql+" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
