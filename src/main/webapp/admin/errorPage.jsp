<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>錯誤頁面</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }
        .container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 90%;
            max-width: 500px;
        }
        h2 {
            color: #e74c3c;
            font-size: 2em;
            margin-bottom: 20px;
        }
        p {
            color: #555;
            font-size: 1.1em;
            margin-bottom: 30px;
        }
        a {
            font-size: 1.2em;
            color: #3498db;
            text-decoration: none;
            border: 2px solid #3498db;
            padding: 10px 20px;
            border-radius: 5px;
            transition: all 0.3s ease;
        }
        a:hover {
            background-color: #3498db;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>發生錯誤</h2>
        <p>
            <%= request.getParameter("error") %>
        </p>
        <a href="login.html">返回登入頁面</a>
    </div>
</body>
</html>








