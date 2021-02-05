package top.skx1.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.skx1.model.Product;
import top.skx1.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(name="ProductServlet" , urlPatterns={"/product_find","/product_update","/product_toupdate","/product_show" ,"/product_delete" ,"/product_add"})
public class ProductServlet extends HttpServlet {
	HttpServletRequest request;
	HttpServletResponse response;
	
	ProductService ps = new ProductService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  this.request=request;
	  this.response=response;
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=utf-8");
	  String uri = request.getRequestURI();
	  
	  if(uri.contains("product_show")){
		  this.show();
	  }
	  if(uri.contains("product_delete")){
		  this.delete();
	  }
	  
	  if(uri.contains("product_add")){
		  this.add();
	  }
	  if(uri.contains("product_toupdate")){
		  this.toupdate();
	  }
	  if(uri.contains("product_update")){
		  this.update();
	  }
	  if(uri.contains("product_find")){
		  this.find();
	  }
	}

	private void find() throws ServletException, IOException {
		String id = request.getParameter("id");
		String product_name = request.getParameter("product_name");
		String product_stock = request.getParameter("product_stock");
		
		System.out.println(id+product_name+product_stock);
		
		List<Product> list =ps.find(id,product_name,product_stock);
		request.setAttribute("products", list);
		request.getRequestDispatcher("jsp/product/show.jsp").forward(request, response);
	}

	private void update() {
		String id = request.getParameter("id");
		String product_name = request.getParameter("product_name");
		String product_prices = request.getParameter("product_prices");
		String product_stock = request.getParameter("product_stock");
		ps.update(id,product_name,product_prices,product_stock);
	}

	private void toupdate() throws ServletException, IOException {
		String id = request.getParameter("id");
		Product product=ps.toupdate(id);
		request.setAttribute("product", product);
		request.getRequestDispatcher("jsp/product/update.jsp").forward(request, response);
}

	private void add() {
		String product_name = request.getParameter("product_name");
		String product_prices = request.getParameter("product_prices");
		String product_stock = request.getParameter("product_stock");
		ps.add(product_name,product_prices,product_stock);
	}

	private void delete() throws ServletException, IOException {
		String id = request.getParameter("id");
		ps.delete(id);
		this.show();
	}

	private void show() throws ServletException, IOException {
		//可用map，实体类映射数据库表
		List<Product> list =ps.show();
		request.setAttribute("products", list);
		request.getRequestDispatcher("jsp/product/show.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");
	
	}

}
