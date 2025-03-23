<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品刪除</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div align="center">
		<h2>商品刪除</h2>
		<% com.model.ProductsBean product = (com.model.ProductsBean) request.getAttribute("product"); %>
				<% if(product!=null){ %>
		<table>
			<tr>
				<td>已刪除編號為：<input type="text" value="<%= product.getProduct_id() %>">的商品
				
				
		</table>
		<% }else{%>
			 <p>無法取得商品資料，請確認是否正確輸入商品ID。</p>
		<% } %>
	</div>
</body>
</html>