<%@ page import="java.util.List, java.util.ArrayList" %>
    <%@ page import="com.model.Member" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>會員資料</title>

                <style>
                    .container {
                        width: 90%;
                        margin: auto;
                        padding: 10px 50px 10px 220px;
                        
                    }
                </style>

            </head>

            <body style="background-color:#fdf5e6">
                <%@include file="navtest.html" %>
                    <div class="container" align="center">
                        <h2>會員資料</h2>
                        <table border="1">
                            <tr style="background-color:#a8fefa">
                                <th>會員編號
                                <th>會員姓名
                                <th>使用者名稱
                                <th>加密後的會員密碼
                                <th>會員電子郵件
                                <th>可用里程
                                <th>會員電話號碼
                                <th>註冊時間
                                <th>郵件是否驗證
                                <th>電話是否驗證
                                <th>會員等級
                                <th>修改
                                <th>刪除
                                    <% List<Member> members = (ArrayList<Member>
                                            )request.getAttribute("members");
                                            for(Member member:members){
                                            %>
                            <tr>
                                <td>
                                    <%=member.getMember_id() %>
                                <td>
                                    <%=member.getFull_name() %>
                                <td>
                                    <%=member.getUsername() %>
                                <td>
                                    <%=member.getPassword() %>
                                <td>
                                    <%=member.getEmail() %>
                                <td>
                                    <%=member.getTotal_miles() %>
                                <td>
                                    <%=member.getPhone_number() %>
                                <td>
                                    <%=member.getRegistration_date() %>
                                <td>
                                    <%=member.isEmail_verified() %>
                                <td>
                                    <%=member.isPhone_verified() %>
                                <td>
                                    <%=member.getMembership_level() %>
                                <td><a href="http://localhost:8080/FlightTicketingSystem/GetUpdateData?member_id=<%=member.getMember_id() %>"
                                        id="update">修改</a>
                                <td><a href="http://localhost:8080/FlightTicketingSystem/DeleteMember?member_id=<%=member.getMember_id() %>"
                                        id="insert">刪除</a>
                                    <% }%>





                        </table>
                    </div>


            </body>

            </html>