<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert Product</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@ include file="/admin/navtest.html"%>



	<div class="content">
<h2>新增資料</h2>

<form method="post" action="InsertProduct">

	輸入類別編號：<input type="text" name="category_id" /><br>
	輸入商品名稱：<input type="text" name="product_name" /><br>
	輸入商品描述：<input type="text" name="product_desc" /><br>
	兌換所需里程：<input type="text" name="needmiles" /><br>
	輸入商品庫存：<input type="text" name="quantity" /><br>
	商品圖片檔名：<input type="text" name="product_image" /><br>
	<input type="submit" value="確定新增" />
	
	
</form>
備註：商品編號由系統自動產生<br>
</div>
</body>
</html>
