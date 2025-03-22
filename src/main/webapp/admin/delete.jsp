<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>員工資料</title>
            <style>
                #button-return {
                    margin-top: 45px;
                    display: block;
                    font-size: 20px;
                }
            </style>
        </head>

        <body style="background-color:#fdf5e6">
            <div align="center">
                <h2>員工資料</h2>
                <jsp:useBean id="member" scope="request" class="com.model.Member" />


                <table>
                    <tr>
                        <td>成功刪除員工</td>

                    </tr>

                </table>
                <a href="http://localhost:8080/FlightTicketingSystem/admin/MemberHomePage.jsp" id="button-return">返回</a>


            </div>
        </body>

        </html>
