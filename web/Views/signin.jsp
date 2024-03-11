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
        <link rel="stylesheet" href="../css/signin_style.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <title>Signin</title>
    </head>
    <body>
        <form action="user?action=signin" method="post">
            Account:<input type="text" name="account"><br><!-- comment -->
            Password:<input type="password" name="password"><br><!-- comment -->
            <p style="margin-top: 40px; color: red">
                            <% if (request.getAttribute("errorMessage") != null) { %>
                            <%= request.getAttribute("errorMessage") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                        </p>
            <input type="submit" value="Sign In">
        </form>
    </body>
</html>
