<%-- 
    Document   : signin
    Created on : Mar 10, 2024, 2:13:07 PM
    Author     : anhph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/signin_style.css" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- comment -->
        <title>Signin</title>
    </head>
    <body>
        <div class="container-fluid">
            <form action="user?action=signin" method="post" class="mx-auto">
                <h4 class="text-center">SignIn</h4>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Account</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="account">
                    <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
                    <div><a href="user?action=forgetpassword">Forget password?</a></div>
                </div>
                <div class="mb-3">
                    <p style="margin-top: 40px; color: red">
                            <% if (request.getAttribute("errorMessage") != null) { %>
                            <%= request.getAttribute("errorMessage") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                </div>
                <button type="submit" class="btn btn-primary">Signin</button>
                <a href="home?action=signup">Don't account?</a>
            </form>
        </div>
    </body>
</html>
