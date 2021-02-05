<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

  <script type="text/javascript">
  
  layui.use('table',function (){
	    var table=layui.table;
	   table.init('demo' ,{
		    height: 315 , //设置高度
		    limit:5,
		    page:true,
		    totalRow: true
		    
	   });
	});
  
  </script>


</head>
<body>


  <div class="layui-form-item">
    <form action="product_find">
    <label class="layui-form-label" style="display: inline-block; width: 100px">按产品编号</label>
    <div class="layui-input-inline">
      <input type="text" id="find_id" name="id" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
    <label class="layui-form-label" style="display: inline-block; width: 100px">按产品名称</label>
    <div class="layui-input-inline">
      <input type="text" id="find_name" name="product_name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
     <label class="layui-form-label" style="display: inline-block; width: 100px">按产品库存</label>
    <div class="layui-input-inline">
      <input type="text" id="find_stock"  name="product_stock" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
    <input type="button"  onclick="find()" class="btn btn-inverse-success btn-fw"  value="查询">    
   </form>
  </div>
    
     
          <button type="button" onclick="toadd()" class="btn btn-inverse-success btn-fw">添加</button>
                    <table   lay-filter="demo">
                     <thead>
                          <tr>
                            <th lay-data="{field:'id', width:200}">编号</th>
                            <th lay-data="{field:'product_name', width:200 ,templet: '#usernameTpl'}">产品名称</th>
                            <th lay-data="{field:'product_prices', width:150 ,sort: true ,totalRow: true ,edit: 'text'}">产品价格</th>
                            <th lay-data="{field:'product_stock', width:150 ,sort: true ,edit: 'text'}">产品库存</th>
                            <th lay-data="{field:'caozuo', minWidth:180}">操作</th>
                          </tr> 
                     </thead>
                      <tbody>
                        <c:forEach items="${requestScope.products}" var="product">
                         <tr>
                          <td>${product.id}</td>
                          <td>${product.product_name}</td>
                          <td>${product.product_prices}</td>
                          <td>${product.product_stock}</td>
                            <td>
                             <a href="javascript:del('${product.id}')">删除</a>                                              
                             &nbsp; &nbsp;&nbsp;&nbsp;                                             
                               <a href="javascript:toupdate('${product.id}')">修改</a>  
                            </td>
                          </tr>
                        </c:forEach>
                      </tbody>
                    </table>

<script type="text/html" id="usernameTpl">
  <a href="/?table-demo-id={{d.id}}" style="color: #da8cff" class="layui-table-link" target="_blank">{{ d.product_name }}</a>
</script>
</body>
</html>