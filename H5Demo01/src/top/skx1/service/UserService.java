package top.skx1.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import top.skx1.jdbc.UserJdbc;

public class UserService {
	UserJdbc  uj  = new UserJdbc();
	public String login(String username, String password) {
		 ResultSet rs = uj.show();
		 try {
			while (rs.next()) {
				 String db_username = rs.getString("username");
				 if(db_username.equals(username)){
					 String db_password = rs.getString("password");
					 if(db_password.equals(password)){
						 return  username;
					 }
				 }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return null;
	}
	public void register(String username, String password) {
		uj.add(username ,password);
	}

}
