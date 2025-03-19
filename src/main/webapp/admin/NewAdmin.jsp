<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>新增的管理員資料</h2>
<jsp:useBean id="admin" scope="request" class="com.model.Admin" />
<table>


<tr><td>管理員姓名<td><input type="text" disabled value="<%=admin.getFull_name() %>">
<tr><td>使用者名稱<td><input type="text" disabled value="<%=admin.getUsername() %>">
<tr><td>管理員密碼<td><input type="text" disabled value="<%=admin.getPassword() %>">
<tr><td>管理員電子郵件<td><input type="text" disabled value="<%=admin.getEmail() %>">

<tr><td>管理員電話號碼<td><input type="text" disabled value="<%=admin.getPhone_number() %>">
<tr><td>註冊時間<td><input type="text" disabled value="<%=admin.getRegistration_date() %>">




</table>
<a href="http://localhost:8080/FlightTicketingSystem/topic2/login.html">返回登入頁面</a>
</div>
</body>
</html>