<%-- 
    Document   : newMotor
    Created on : Mar 11, 2024, 11:49:41 PM
    Author     : datng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            .container1 {
                max-width: 500px;
                margin: 20px 700px;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
                align-items: center
            }
            label {
                display: block;
                margin-bottom: 5px;
                font-size: 21px
            }
            input[type="text"], input[type="email"], input[type="tel"], input[type="date"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
                box-sizing: border-box;
            }
            input[type="file"] {
                margin-bottom: 10px;
            }
            input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                border: none;
                color: #fff;
                border-radius: 3px;
                cursor: pointer;
            }
            input[type="submit"]:hover {
                background-color: #0056b3;
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
        </style>
        <script>
            
            form {
            max - width: 400px;
            margin: 0 auto;
            font - family: Arial, sans - serif;
            }

            label {
            font - weight: bold;
            }

            input {
            width: 100 % ;
            padding: 8px;
            margin - bottom: 10px;
            box - sizing: border - box;
            }

            button {
            width: 100 % ;
            padding: 10px;
            background - color: #007bff; 
            color: #fff; 
            border: none;
            cursor: pointer;
            }

            button:hover {
            background - color: #0056b3; 
            }
        </script>
    </head>
    <body>
        <script>
            function validateForm() {
            var name = document.getElementById("name").value;
            var price = document.getElementById("price").value;
            var img = document.getElementById("img").value;
            if (name === "" || price === "" || img === "") {
            alert("Vui lòng điền đầy đủ thông tin cho tất cả các trường!");
            return false;
            }
            }
        </script>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="divider">
                <hr class="line">
                <span class="content">Tạo mới xe</span>
                <hr class="line">
            </div>
            <div class="container1" >
                <form action="newMotor" method="post" id="form" onsubmit="return validateForm()">
                    <label>Tên xe:</label>
                    <input style="width: 420px;height: 30px;margin-top:5px;font-size: 17px" value="${name}" name="name" id="name">
                <label style="margin-top: 8px">Giá xe:</label>
                <input style="width: 420px;height: 30px;margin-top:5px;font-size: 17px" value="${price}" name="price" id="price">
                <label style="margin-top: 8px">Ảnh xe:</label>
                <input style="width: 420px;height: 30px;margin-top:5px;font-size: 17px" value="${img}" name="img" id="img">

                <input style=";margin-top:15px;font-size: 21px" type="submit" value="Tạo mới"><br>
                <% if (request.getAttribute("error") != null) { %>
                <label style="margin-bottom: 20px; color: red"><%= request.getAttribute("error") %></label><br>
                <% } %>
            </form>
        </div>
        <div style="margin-top: 300px">
            <jsp:include page="bottom.jsp"></jsp:include>
        </div>

    </body>
</html>
