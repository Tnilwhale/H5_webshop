package top.skx1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.skx1.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet( name="UserServlet" , urlPatterns={"/login1","/register1"} )
@MultipartConfig
public class UserServlet extends HttpServlet {
	UserService us  = new UserService();
	HttpServletRequest request;
	HttpServletResponse response;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("我是get");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.request=request;
		 this.response=response;
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");		
		//得到全路径
		StringBuffer url = request.getRequestURL();
		//得到项目相对请求路径
		String uri = request.getRequestURI();
		System.out.println(uri);
		if(uri.contains("/login1")){
			this.login();
		}
		if(uri.contains("/register1")){
			this.register();
		}
	}
	
	
	private void register() throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		us.register(username,password);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	
	
	private void login() throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("用户名:"+username+"密码:"+password);
		username=us.login(username,password);
		if(username!=null){
			//登录成功去首页
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			//登录失败依然在登录页
			request.setAttribute("err", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			PrintWriter out=response.getWriter();
			out.write("<script>");
			out.write("alert('用户名或密码错误')");
			out.write("</script>");
		}
	}
}
