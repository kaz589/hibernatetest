<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>GetUpdate</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@ include file="/admin/navtest.html"%>



	<div class="content">
	<h2>修改資料</h2>
	<jsp:useBean id="product" scope="request" class="com.model.ProductsBean" />

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
                </table>
            </div>	
			<form method="post" action="../UpdateById">
				帶入商品編號：<input type="text" readonly name="product_id" placeholder="(系統帶入編號)<%=product.getProduct_id() %>"value="<%=product.getProduct_id() %>"/><br>
				輸入類別編號：<input  type="text" name="category_id" value=" <%= product.getCategory_id() %>"/><br>
				輸入商品名稱：<input type="text" name="product_name" value="<%= product.getProduct_name() %>"/><br>
				輸入商品描述：<input type="text" name="product_desc" value="<%= product.getProduct_desc() %>" /><br>
				兌換所需里程：<input  type="text" name="needmiles" value="<%= product.getNeedmiles() %>"/><br>
				輸入商品庫存：<input  type="text" name="quantity" value="<%= product.getQuantity() %>"/><br>
				商品圖片檔名：<input type="text" name="product_image" value=" <%= product.getProduct_image() %>"/><br>
				<input type="submit" value="確定修改" />
			</form>

		</div>
	</body>
</html>
