<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>員工資料</title>
</head>

<body style="background-color:#fdf5e6">
    <div align="center">
        <h2>員工資料</h2>
        <jsp:useBean id="member" scope="request" class="com.model.Member" />


        <p style="color: red;">查無此會員！</p>

        <form method="post" action="/FlightTicketingSystem/admin/delete.html" id="return">

            <input type="submit" value="返回刪除頁面" id="returnBtn" />
        </form>






    </div>







</body>

</html>
