<%-- 
    Document   : home
    Created on : 27/02/2024, 8:54:15 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <title>List Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            .container {
                max-width: 1200px;
                margin: 20px auto;
                display: flex;
                flex-wrap: wrap;

            }
            .motor {
                width: calc(25% - 20px);
                margin-bottom: 20px;
                padding: 10px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 5px;
                margin-right: 20px;
            }
            .motor img {
                width: 100%;
                height: 265px;
                margin-bottom: 10px;
            }
            .divider {
                text-align: center;
                position: relative;
                margin-bottom: 20px; 
                margin-top: 20px
            }

            .line {
                border: none;
                border-top: 1px solid #000; 
                width: calc(50% - 20px); 
                position: absolute;
                top: 50%;
            }

            .line:first-child {
                left: 20px; 
            }

            .line:last-child {
                right: 20px; 
            }

            .content {
                display: inline-block;
                background-color: #f2f2f2; 
                position: relative;
                font-size: 30px;
                padding: 0 20px; 
                z-index: 1;
                font-weight: 600
            }
            .book{
                margin-top: 13px;
                margin-left: 80px;
                text-align: center;
                border: 1px #61c4ef solid;
                width: 100px;
                background: #61c4ef;
                color: white;
                font-weight: 600;
                font-size: 20px;
                border-radius:  5px;
                cursor: pointer;
            }

        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="divider">
                <hr class="line">
                <span class="content">Danh sách xe</span>
                <hr class="line">
            </div>
            <div class="container" style="margin-top: 20px; margin-bottom: 250px">
            <c:forEach items="${listMotor}" var="motor">
                <div class="motor">
                    <img src="${motor.motorimageurl}" alt="${motor.motorname}">
                    <h2>Xe: ${motor.motorname}</h2>
                    <p style="margin-top:5px">Giá thuê: ${motor.motorprice}</p>

                    <div class="book" onclick="book('${motor.id}')">Thuê xe</div>
                </div>
            </c:forEach>
        </div>
        <jsp:include page="bottom.jsp"></jsp:include>
    </body>
    <script>
        function book(id) {
            //Go to search 
            window.location = "rentServlet?id=" + id;
        }
    </script>
</html>
