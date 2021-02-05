package top.skx1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UserJdbc {
	
	Connection conn;
	ResultSet rs;
	Statement stem;
	public void lianjie() {
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//连接数据库
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/h5demo?useSSL=false&serverTimezone=UTC","root", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(conn!=null) {
			System.out.println("数据库连接成功");
		}
		
	}
	
	//找数据
	public ResultSet show() {
		this.lianjie();
		//可以发送执行的sql语句
		try {
			stem = conn.createStatement();
			rs=stem.executeQuery(" select  *  from  user  ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		//rs为数据库表中的承载体
	}

	public void add(String username, String password) {
		// TODO Auto-generated method stub
		this.lianjie();
		try {
			stem.executeUpdate(" insert into user values(0, '"+username+"' , '"+password+"') ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close();		
	}

	private void close() {
		// TODO Auto-generated method stub
		
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stem!=null) {
					stem.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	

}
