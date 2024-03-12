<%-- 
    Document   : home
    Created on : Mar 10, 2024, 11:15:50 AM
    Author     : anhph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/home_style.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- comment -->

        <title>Home</title>
    </head>
    <body>  
        <div id="wrapper">
            <div id="header">
                <a href="url" class="logo">
                    <img src="../ImageSystem/logoproject.jpg" alt="Logo"/>
                </a>
                <div id="menu">
                    <div class="item">
                        <input id="search" type="search" name="search"><!-- comment -->
                    </div>
                    <div class="item">
                        <input id="searchbutton" type="submit" name="search" value="Search"><!-- comment -->
                    </div>
                </div>
                <div id="actions">
                    <div class="item">
                        <img id="logouser" src="../ImageSystem/user.png" alt="alt"/>
                    </div>
                </div>
            </div>
            <div id="banner">
                <div class="box-left">
                    <h2>
                        <span>HÀ NỘI</span>
                        <br>
                        <span>DANH LAM THẮNG CẢNH</span>
                    </h2>
                    <p>Địa chỉ được quốc tế công nhận là nơi đáng sống trên thế giới, nơi hội tụ của danh lam thắng cảnh, và văn hóa phương đông hàng ngàn năm</p>
                </div>
            </div>
            <div id="category">
                <div id="menu2">
                    <div class="item">
                        <a href="">Lịch sử</a>
                    </div>
                    <div class="item">
                        <a href="">Chính trị</a>
                    </div>
                    <div class="item">
                        <a href="">Văn hóa</a>
                    </div>
                    <div class="item">
                        <a href="">Nghệ thuật</a>
                    </div>
                </div>
            </div>
            <div id="content">
                <div class="contentitem"><p>Báo Hà Nội</p></div>
                <div class="contentitem"><p>Báo Thành Phố HCM</p></div>
                <div class="contentitem"><p>Báo Quân</p></div>
                <div class="contentitem"><p>Báo Đà Nẵng</p></div>
                <div class="contentitem"><p>Báo Du Lịch</p></div>
            </div>
            <div id="footer">
                <div class="box">
                    <div class="logo">
                        <img src="../ImageSystem/logo.jpg" alt="">
                    </div>
                    <p>Trang web cung cấp đánh giá về các địa điểm du lịch ở Hà Nội</p>
                </div>
                <div class="infor">
                    <p>SĐT: 0376964301</p>
                    <p>FACEBOOK: <a href="https://www.facebook.com/profile.php?id=100011386881850">Admin</a></p>
                    <p>Email: admin@gmail.com</p>
                </div>
            </div>
        </div>    
    </body>
</html>
