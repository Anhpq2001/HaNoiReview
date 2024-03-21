<%-- 
    Document   : displaydetailuser
    Created on : Mar 21, 2024, 3:01:41 PM
    Author     : anhph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- comment -->
        <link rel="stylesheet" href="css/displaydetailuser_style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="left">
                <c:if test="${account.getAvatarUrl() == null}">
                    <img src="ImageSystem/user.png" alt="user" width="100">
                </c:if>
                <c:if test="${account.getAvatarUrl() != null}">
                    <img src="${account.getAvatarUrl()}" alt="user" width="100">
                </c:if>
            </div>
            <div class="right">
                <div class="info">
                    <h3>Information</h3>
                    <div class="info_data">
                        <div class="data">
                            <h4>Account</h4>
                            <p><input type="text" name="account" disabled value="${account.getAccount()}"></p>
                        </div>
                        <div class="data">
                            <h4>Password</h4>
                            <p><input type="text" name="password" value="${account.getPassword()}" disabled></p>
                        </div>
                        <div class="data">
                            <h4>Email</h4>
                            <p><input type="text" name="email" value="${account.getEmail()}" disabled></p>
                        </div>
                        <div class="data">
                            <h4>Join Time</h4>
                            <p><input type="date" name="createdAt" disabled value="${account.getCreatedAt()}"></p>
                        </div>
                        <div class="data">
                            <a href="home?action=displayalluser"><button class="btn btn-primary">Close</button></a>
                            <!--                            <a href="home?action=changeprofile"><button class="btn btn-warning">Edit Profile</button></a>-->
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
