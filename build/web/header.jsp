<%-- 
    Document   : header
    Created on : 27/02/2024, 8:44:59 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
        <style>
            header {
                background-color: #333;
                color: #fff;
                padding: 10px 0;
                text-align: center;
                display: flex;
                justify-content: space-between;
                padding: 0 20px;
                align-items: center;
            }
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 0;
            }

            /* Thiết lập header */
            header {
                background-color: #333;
                color: #fff;
                padding: 20px;
                text-align: center;
            }

            h1 {
                cursor: pointer;
            }

            nav ul {
                list-style-type: none;
                padding: 0;
            }

            nav ul li {
                display: inline;
                margin-right: 20px;
            }

            nav ul li:last-child {
                margin-right: 0;
            }

            nav ul li a {
                font-size: 19px;
                color: #fff;
                text-decoration: none;
            }

            nav ul li a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <header>
            <h1 onclick="window.location = 'homeServlet'">
                Thuê xe máy Việt - Nhật
            </h1>
            <nav>
                <ul>
                    <c:if test="${account == null}">
                        <li><a href="register.jsp">Đăng kí</a></li>
                        <li><a href="login.jsp">Đăng nhập</a></li>
                        </c:if>
                        <c:if test="${account != null}">
                        <li><a href="listRentServlet?mod=1">Danh sách thuê</a></li>
                        <li><a href="logoutServlet">Đăng xuất</a></li>
                        <c:if test="${account.getId() == 2}">
                            <li><a href="newMotor">Tạo mới xe máy</a></li>
                        </c:if>
                        </c:if>
                </ul>
            </nav>
        </header>
    </body>
</html>
