<%-- 
    Document   : rent
    Created on : 27/02/2024, 10:55:52 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            .container1 {
                max-width: 1500px;
                margin: 20px 400px;
                border-radius: 5px;
                align-items: center
            }
            label {
                display: block;
                margin-bottom: 5px;
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
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="divider">
                <hr class="line">
                <span class="content">Thuê xe</span>
                <hr class="line">
            </div>
            <div class="container1" >
                <div style="display: flex">
                    <div style="height: auto;background-color: #da7505c2;width: 40%;padding: 220px 50px">
                        <div style="color: white">
                            <h3 class="uppercase" style="text-align: center;"><span style="">THÔNG TIN LIÊN HỆ</span></h3>
                            <p><span style="font-size: 21px;">Liên hệ với chúng tôi thông qua số điện thoại hoặc hòm thư dưới đây:</span></p>
                            <p><span style="font-size: 21px;">Hotline (24/24H):<strong>&nbsp;0866.435.359</strong></span></p>
                            <p><span style="font-size: 21px;">ĐC:21 Vĩnh Hồ -Đống Đa-Hà Nội</span></p>
                            <p><span style="font-size: 21px;">432-Minh Khai-Hai Bà trưng -Hà Nội</span></p>

                        </div>
                    </div>
                    <div style="background-color: white;padding: 20px">
                        <form action="rentServlet" method="post" id="form">
                            <input style="display: none" type="text" value="${motorGet.id}" name="motorId" required>
                        <input style="font-size: 17px;" type="text" id="name" name="name" placeholder="Nhập họ tên của bạn" required><br>
                        <input style="font-size: 17px;" type="email" id="email" name="email" placeholder="Nhập email của bạn" required><br>
                        <input style="font-size: 17px;" type="tel" id="phone" name="phone" placeholder="Nhập số điện thoại của bạn" pattern="[0-9]*" required><br>
                        <div style="font-size: 21px;font-weight: 600;text-align: center;margin-top: 10px;margin-bottom: 5px" for="date">Chọn ngày bạn muốn thuê:</div>
                        <input style="font-size: 17px;" type="date" id="date" name="rentdate" required><br>
                        <div>
                            <img style="width: 500px; height: auto" src="${motorGet.motorimageurl}" alt="${motorGet.motorname}">
                        </div>
                        <div style="border-color: #CE7A58;background-color: #CE7A58;;margin-left: 135px;margin-top: 10px; border-radius: 7px; border: 1px #CE7A58 solid; height: 35px; width: 240px;cursor: pointer; display: flex; align-items: center; justify-content: center;" onclick="showAlertSubmit()">
                            <div style="color: #1E2F41; font-size: 21px; font-weight: 600; font-family: Arial;color: white;" >Thuê xe</div>
                        </div>
                        <script>
                            function showAlertSubmit() {
                                var name = document.getElementById("name").value;
                                var email = document.getElementById("email").value;
                                var phone = document.getElementById("phone").value;
                                var rentdate = document.getElementById("date").value;
                                if (name === "" || email === "" || phone === "" || rentdate === "") {
                                    alert("Vui lòng điền vào tất cả các trường!");
                                } else {
                                    Swal.fire({
                                        title: "Chúc mừng đăng ký xe thành công",
                                        icon: "success",
                                        showCancelButton: false,
                                        confirmButtonColor: "#3085d6",
                                        confirmButtonText: "Bỏ qua",
                                        allowOutsideClick: false,
                                    }).then((result) => {
                                        if (result.isConfirmed) {
                                            document.getElementById("form").submit();
                                        }
                                    });
                                }
                            }
                        </script>
                    </form>  
                </div> 
            </div>


        </div>
        <div style="margin-top: 300px">
            <jsp:include page="bottom.jsp"></jsp:include>
        </div>

    </body>
</html>
