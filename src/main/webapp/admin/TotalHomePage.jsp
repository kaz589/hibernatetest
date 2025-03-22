<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="zh-TW">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>主頁</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                background-color: #f4f4f9;
            }

            h1 {
                text-align: center;
                color: #4CAF50;
                margin-top: 40px;
                font-size: 36px;
            }

            .main-content {
                text-align: center;
                margin-top: 50px;
                font-size: 20px;
                color: #333;
            }

            .cta-button {
                display: inline-block;
                padding: 15px 30px;
                background-color: #4CAF50;
                color: white;
                text-decoration: none;
                font-size: 18px;
                border-radius: 5px;
                margin-top: 30px;
                transition: background-color 0.3s ease;
            }

            .cta-button:hover {
                background-color: #45a049;
            }

            /* 響應式設計，對小屏幕進行調整 */
            @media screen and (max-width: 768px) {
                h1 {
                    font-size: 28px;
                }

                .cta-button {
                    padding: 12px 24px;
                }
            }
        </style>
    </head>

    <body>

        <%@ include file="navtest.html" %>

            <div class="content">
                <h1>歡迎來到會員資料處理系統</h1>
                <div class="main-content">
                    <p>這裡是系統的主頁，您可以使用側邊欄導航進行操作。</p>
                </div>
            </div>

    </body>

    </html>