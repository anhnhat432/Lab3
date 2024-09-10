<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="vi">
    <head>
         <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Footer Example</title>
        <style>
            /* Reset CSS */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            /* Footer Styles */
            footer {
                background-color: #333;
                color: #fff;
                padding: 50px 0px 10px 0px;
                position: fixed;
                left: 0;
                bottom: 0;
                width: 100%;
            }

            .container {
                max-width: 1200px;
                margin: 0px auto;
                display: flex;
                flex-wrap: wrap;
            }

            .column {
                flex: 1 1 300px;
                margin-right: 20px;
                width: 200px
            }

            .column:last-child {
                margin-right: 0;
            }

            h3 {
                font-size: 1.5rem;
                margin-bottom: 15px;
            }



            ul {
                list-style-type: none;
                padding: 0;
            }

            ul li {
                margin-bottom: 5px;
            }

            a {
                color: #fff;
                text-decoration: none;
            }

            a:hover {
                text-decoration: underline;
            }

            .copyright {
                text-align: center;
                /*padding-top: 10px;*/
                font-size: 1.1rem;
                margin-top: 20px
            }

        </style>
    </head>
    <body>
        <footer>
            <div class="container">
                <div class="column">
                    <h3>Về Chúng Tôi</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget dolor in nisi fermentum maximus. Nulla facilisi.</p>
                </div>
                <div class="column">
                    <h3>Liên Hệ</h3>
                    <p>Email: info@example.com</p>
                    <p>Điện thoại: +123456789</p>
                    <p>Địa chỉ: 123 Ecommerce St, Thành phố, Quốc gia</p>
                </div>
                <div class="column">
                    <h3>Liên kết Nhanh</h3>
                    <ul>
                        <li><a href="#">Trang Chủ</a></li>
                        <li><a href="#">Sản Phẩm</a></li>
                        <li><a href="#">Về Chúng Tôi</a></li>
                        <li><a href="#">Liên Hệ</a></li>
                    </ul>
                </div>

            </div>
            <div class="copyright">
                <p>&copy; 2024 MotorRentWeb của tôi. Đã đăng ký Bản quyền
.</p>
            </div>
        </footer>
    </body>
</html>
