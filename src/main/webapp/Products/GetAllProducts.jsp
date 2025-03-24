<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, com.model.ProductsBean"
    pageEncoding="UTF-8" %>
    <%! @SuppressWarnings("unchecked") %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>商品資料</title>
           <link rel="stylesheet" href="style.css">
        </head>

        <body >
      
	<%@ include file="/admin/navtest.html"%>
	<div class="content">
           
                <h2>商品資料</h2>
          <div class="link-container">
           <a href="http://localhost:8080/FlightTicketingSystem/Products/InsertProduct.jsp" class="link">新增一件商品</a> 
			
		</div>
		<div class="main-content">
                <table border="1">
                    <tr >
                        <th>編號
                        <th>類別
                        <th>名稱
                        <th>描述
                        <th>兌換所需里程
                        <th>庫存
                        <th>圖片檔案
                        <th>修改
                        <th>刪除
                        
                        
                            <% List<ProductsBean> products=(ArrayList<ProductsBean>)request.getAttribute("products");
                                    for(ProductsBean product : products){ %>
                    <tr>
                        <td>
                            <%= product.getProduct_id() %>
                        <td>
                            <%= product.getCategory_id() %>
                        <td>
                            <%= product.getProduct_name() %>
                        <td>
                            <%= product.getProduct_desc() %>
                        <td>
                            <%= product.getNeedmiles() %>
                        <td>
                            <%= product.getQuantity() %>
                        <td>
                            <%= product.getProduct_image() %>
                         <td>    
                    <form action="GetUpdate" method="post"  >
                   		 <input type="hidden" name="product_id" value="<%= product.getProduct_id() %>">
                     		<button type="submit">修改</button>
                    </form>  
                        <td> 
                      <form id="deleteform" action="DeleteProduct" method="post" >
                    	<input type="hidden" name="product_id" value="<%= product.getProduct_id() %>">
                  		 <button type="button" onclick="confirmDelete(this)">刪除</button>
                      </form> 
                      </td>
                                <% } %>
                </table>
                
		
               
            </div>
            
             <h3>共<%= products.size() %>筆商品資料</h3>
            </div>
            <script>
            function confirmDelete(button){
            	if(confirm('確定要刪除這項商品嗎?'))
            		{
            		button.closest('form').submit();
            		}
            }
            </script>
        </body>

        </html>