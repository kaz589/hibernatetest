<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, com.model.ProductsBean"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料取得失敗</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body >
  
	<%@ include file="/admin/navtest.html"%>
	<div class="content">
	<div align="center">
		<h2>資料取得失敗</h2>
		<% com.model.ProductsBean product = (com.model.ProductsBean) request.getAttribute("product"); %>
				
			<h3>無法取得商品資料，請確認是否正確輸入。</h3>
	
		<a href="/Products/RedeemHomePage.jsp">回到首頁</a>
		
	</div>
	</div>
</body>
</html>