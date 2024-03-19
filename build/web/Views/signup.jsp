<%-- 
    Document   : signup
    Created on : Mar 18, 2024, 2:30:21 PM
    Author     : anhph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- comment -->
        <link rel="stylesheet" href="css/signup_style.css"/>
        <title>SignUp</title>
    </head>
    <body>
        <div class="container-fluid">
            <form action="home?action=signup" method="post" class="mx-auto">
                <h4 class="text-center">SignUp</h4>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Account</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="account" value="${account}">
                </div>
                <div class="mb-3">
                    <p style="margin-top: 40px; color: red">
                            <% if (request.getAttribute("errorAccount") != null) { %>
                            <%= request.getAttribute("errorAccount") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password" value="${password}">
                </div>
                <div class="mb-3">
                    <p style="margin-top: 40px; color: red">
                            <% if (request.getAttribute("errorPassword") != null) { %>
                            <%= request.getAttribute("errorPassword") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="repassword" value="${rePassword}">
                </div>
                <div class="mb-3">
                    <p style="margin-top: 40px; color: red">
                            <% if (request.getAttribute("errorRePassword") != null) { %>
                            <%= request.getAttribute("errorRePassword") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail2" class="form-label">Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp" name="email" value="${email}">
                </div>
                <div class="mb-3">
                    <p style="margin-top: 40px; color: red">
                            <% if (request.getAttribute("errorEmail") != null) { %>
                            <%= request.getAttribute("errorEmail") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                </div>
                <div class="mb-3">
                    <p style="margin-top: 40px; color: blue">
                            <% if (request.getAttribute("successful") != null) { %>
                            <%= request.getAttribute("successful") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                </div>
                <button type="submit" class="btn btn-primary">Register</button>     
                <a href="home?action=signin" >SignIn</a>
            </form>
        </div>
    </body>
</html>
