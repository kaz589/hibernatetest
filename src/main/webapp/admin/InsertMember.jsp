<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>新增的會員資料</h2>
<jsp:useBean id="member" scope="request" class="com.model.Member" />
<table>


<tr><td>會員姓名<td><input type="text" disabled value="<%=member.getFull_name() %>">
<tr><td>使用者名稱<td><input type="text" disabled value="<%=member.getUsername() %>">
<tr><td>加密後的會員密碼<td><input type="text" disabled value="<%=member.getPassword() %>">
<tr><td>會員電子郵件<td><input type="text" disabled value="<%=member.getEmail() %>">
<tr><td>可用里程<td><input type="text" disabled value="<%=member.getTotal_miles() %>">
<tr><td>會員電話號碼<td><input type="text" disabled value="<%=member.getPhone_number() %>">
<tr><td>註冊時間<td><input type="text" disabled value="<%=member.getRegistration_date() %>">
<tr><td>郵件是否驗證<td><input type="text" disabled value="<%=member.isEmail_verified() %>">
<tr><td>電話是否驗證<td><input type="text" disabled value="<%=member.isPhone_verified() %>">
<tr><td>會員等級<td><input type="text" disabled value="<%=member.getMembership_level() %>">


</table>
<a href="http://localhost:8080/FlightTicketingSystem/admin/MemberHomePage.jsp">返回</a>
</div>
</body>
</html>