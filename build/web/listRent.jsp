<%-- 
    Document   : listRent
    Created on : 27/02/2024, 11:30:01 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            .container {
                max-width: 1200px;
                margin: 20px auto;
                padding: 0 20px;
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

            table {
                font-family: 'Arial';
                margin: 25px auto;
                border-collapse: collapse;
                border: 1px solid #eee;
                border-bottom: 2px solid #676767;
                box-shadow: 0px 0px 20px rgba(0,0,0,0.10),
                    0px 10px 20px rgba(0,0,0,0.05),
                    0px 20px 20px rgba(0,0,0,0.05),
                    0px 30px 20px rgba(0,0,0,0.05);
                tr {
                    &:hover {
                        background: #f4f4f4;

                        td {
                            color: #555;
                        }
                    }
                }
                th, td {
                    color: #999;
                    border: 1px solid #eee;
                    padding: 12px 35px;
                    border-collapse: collapse;
                }
                th {
                    background:#676767;
                    color: #fff;
                    text-transform: uppercase;
                    font-size: 15px;
                    &.last {
                        border-right: none;
                    }
                }
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
         <div class="divider">
                    <hr class="line">
                    <span class="content">Danh sách thuê xe</span>
                    <hr class="line">
                </div>
         <div class="container" style="margin-bottom: 230px;z-index: 1">
                <table>
                    <thead>
                        <tr>
                            <th>Tên</th>
                            <th>Email</th>
                            <th>Số điện thoại</th>
                            <th>Thời gian thuê</th>
                            <th>Ảnh xe</th>
                             <c:if test="${account.getId() == 2}">
                                 <th>Xóa</th>
                                <th>Chỉnh sửa</th>
                            </c:if>
                            
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="rent" items="${listRent}">
                          <tr>
                            <td>${rent.namerent}</td>
                            <td>${rent.email}</td>
                            <td>${rent.phonenumber}</td>
                            <td>${rent.rentdate}</td>
                            <td>
                                <img style="width: 80px; height: auto" src="${rent.url}" alt="${rent.url}">
                            </td>
                            <c:if test="${account.getId() == 2}">
                                <td> <a style="color: red" href="listRentServlet?mod=2&id=${rent.id}">Xóa</a></td>
                                <td> <a style="color: blue" href="update?id=${rent.id}">Chỉnh sửa</a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <jsp:include page="bottom.jsp"></jsp:include>
    </body>
</html>
