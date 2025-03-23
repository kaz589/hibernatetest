<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-TW">


<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Redeem System</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	
	<%@ include file="/admin/navtest.html"%>




	<div class="content">
		<h2>贈品管理系統</h2>
		<form method="post" action="GetByName">
		輸入商品名稱 : <input type="text" name="product_name" /><p>
	
		<input type="submit" value="查詢" />
	</form>
			<a href="http://localhost:8080/FlightTicketingSystem/InsertProduct.jsp" class="link">新增一件商品</a> 
			<a href="http://localhost:8080/FlightTicketingSystem/GetAllProducts" class="link">顯示全部商品</a>
		</div>
		

	


</body>

</html>