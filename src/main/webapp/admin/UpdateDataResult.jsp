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
<h2>修改完的會員資料</h2>

<jsp:useBean id="member" scope="request" class="com.model.Member" />


<table>
<tr><td>會員編號<td><input type="text" value="<%=member.getMember_id()%>" name="member_id" readonly>
<tr><td>修改後會員姓名<td><input type="text" value="<%=member.getFull_name() %>" name="full_name"readonly>
<tr><td>使用者名稱<td><input type="text" value="<%=member.getUsername() %>"name="username"readonly>
<tr><td>加密後的會員密碼<td><input type="text" value="<%=member.getPassword() %>" name="password"readonly>
<tr><td>修改後會員電子郵件<td><input type="text" value="<%=member.getEmail() %>" name="email"readonly>
<tr><td>修改後會員可用里程<td><input type="text" value="<%=member.getTotal_miles() %>" name="total_miles"readonly>
<tr><td>修改後會員電話號碼<td><input type="text" value="<%=member.getPhone_number()%>" name="phone_number" readonly>
<tr><td>修改後會員註冊時間<td><input type="text" value="<%=member.getRegistration_date() %>" name="registration_date"readonly>
<tr><td>修改後會員郵件是否驗證<td><input type="text" value="<%=member.isEmail_verified() %>"name="email_verified"readonly>
<tr><td>修改後會員電話是否驗證<td><input type="text" value="<%=member.isPhone_verified() %>" name="phone_verified"readonly>
<tr><td>修改後會員等級<td><input type="text" value="<%=member.getMembership_level() %>" name="membership_level"readonly>



</table>

<a href="http://localhost:8080/FlightTicketingSystem/admin/MemberHomePage.jsp" id="button-return">返回</a>
</div>
</body>
</html>