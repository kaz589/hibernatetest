
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
       
    	
    
<!DOCTYPE html>
<html lang="zh-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員資料處理</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@400;700&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: 'Noto Sans TC', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #4CAF50;
            margin-top: 30px;
            font-size: 36px;
        }

        #selAll,
        #insert {
            display: block;
            text-align: center;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            padding: 15px 30px;
            font-size: 20px;
            border-radius: 5px;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }

        #selAll:hover,
        #insert:hover {
            background-color: #45a049;
        }

        #search {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 30px;
        }

        #search input[type="text"] {
            padding: 10px;
            font-size: 18px;
            width: 300px;
            border: 2px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
            transition: border-color 0.3s ease;
        }

        #search input[type="text"]:focus {
            border-color: #4CAF50;
            outline: none;
        }

        #search input[type="submit"] {
            padding: 10px 20px;
            font-size: 18px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        #search input[type="submit"]:hover {
            background-color: #45a049;
        }

        #search input[type="submit"]:focus {
            outline: none;
        }

        .container {
        width: 60%;
        margin: auto;
        padding: 10px;
        
      }

        /* Responsive design */
        @media screen and (max-width: 768px) {
            #selAll,
            #insert {
                font-size: 18px;
                padding: 12px 24px;
            }

            #search input[type="text"] {
                width: 80%;
            }

            #search input[type="submit"] {
                font-size: 16px;
                padding: 10px 18px;
            }
        }
    </style>

</head>

<body>

	<%@include file="navtest.html" %>

    <div class="container">
        <h1>會員資料處理</h1>

        <!-- Get All Members Link -->
        <a href="http://localhost:8080/FlightTicketingSystem/GetAllMembersJNDI" id="selAll">取得全部會員資料</a>

        <!-- Search Form -->
        <form method="post" action="http://localhost:8080/FlightTicketingSystem/GetEmpFuzzy" id="search">
            <label for="Fuzzy" style="font-size: 18px; color: #333;">輸入會員姓名:</label>
            <input type="text" name="Fuzzy" id="Fuzzy" />
            <input type="submit" value="確定" />
        </form>

        <!-- Add New Member Link -->
        <a href="http://localhost:8080/FlightTicketingSystem/admin/InsertMember.html" id="insert">新增會員資料</a>
    </div>

    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

    <script>
        // Additional JS functionality can go here
        $('#search').css('color', 'red');

        $('#searchBtn').click(function () {
            console.log('123');
        });
    </script>
    

</body>

</html>