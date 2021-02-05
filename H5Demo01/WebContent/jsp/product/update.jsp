<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

  <script type="text/javascript">
   function close_layer(){
	   var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	   parent.layer.close(index); //再执行关闭
   }
  
  
  </script>
</head>
<body>


          
          <form action="product_update">
          <input type="hidden" name="id" value="${product.id}">
        产品名称  <input type="text" name="product_name" value="${product.product_name}"  />  <br><br>
        产品价格       <input type="text"  name="product_prices" value="${product.product_prices}" /><br><br> 
              <%-- <input type="hidden" id="sex" value="${product.product_stock}"> --%>
        产品库存       <input type="text"  name="product_stock" value="${product.product_stock}" /><br><br>  
                <input type="submit" onclick="close_layer()" value="确认修改">
          </form>
          
          
<!--     <script type="text/javascript">
         var sex=document.getElementById("sex").value;
         if(sex=="男"){
         document.getElementById("sex_nan").checked=true;
         }
         else{
          document.getElementById("sex_nv").checked=true;
        	 
         }
          </script> -->
          

</body>
</html>