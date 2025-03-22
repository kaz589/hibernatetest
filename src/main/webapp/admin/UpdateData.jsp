<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>即將修改的會員資料</h2>
<form method="post" action="UpdateData">
	<jsp:useBean id="member" scope="request" class="com.model.Member"/>
	<table>
	<tr><td>會員編號<td><input type="text" value="<%=member.getMember_id()%>" name="member_id" readonly>
	<tr><td>修改會員姓名<td><input type="text" value="<%=member.getFull_name() %>" name="full_name">
	<tr><td>使用者名稱<td><input type="text" value="<%=member.getUsername() %>"name="username" readonly>
	<tr><td>加密後的會員密碼<td><input type="text" value="<%=member.getPassword() %>" name="password">
	<tr><td>輸入修改會員電子郵件<td><input type="email" value="<%=member.getEmail() %>" name="email">
	<tr><td>輸入修改可用里程<td><input type="text" value="<%=member.getTotal_miles() %>" name="total_miles">
	<tr><td>輸入修改會員電話號碼<td><input type="text" value="<%=member.getPhone_number() %>" name="phone_number">
	<tr><td>輸入修改註冊時間<td><input type="date" value="<%=member.getRegistration_date() %>" name="registration_date">
	<tr><td>輸入修改會員等級<td><input type="text" value="<%=member.getMembership_level() %>" name="membership_level">
	<tr><td>輸入修改郵件是否驗證<td><input type="checkbox" value="<%=member.isEmail_verified() %>" name="email_verified">
	<tr><td>輸入修改電話是否驗證<td><input type="checkbox" value="<%=member.isPhone_verified() %>" name="phone_verified">
	<input type="submit" value="確定" />
</form>



</table>
</div>
</body>
</html>