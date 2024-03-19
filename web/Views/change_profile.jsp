<%-- 
    Document   : change_profile
    Created on : Mar 19, 2024, 6:34:44 PM
    Author     : anhph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- comment -->
        <link rel="stylesheet" href="css/change_profile_style.css"/>
        <title>Change Profile</title>
    </head>
    <body>
        <div class="container-fluid">
            <form action="home?action=changeprofile" method="post" class="mx-auto" enctype="multipart/form-data">
                <h4 class="text-center">Change Information</h4>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Avatar</label>
                    <input type="file" class="form-control" id="exampleInputPassword1" name="avatar" >
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">New Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password" value="">
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
                    <input type="password" class="form-control" id="exampleInputPassword1" name="repassword" value="">
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
                    <label for="exampleInputEmail2" class="form-label"> New Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp" name="email" value="">
                </div>
                <div class="mb-3">
                    <p style="margin-top: 40px; color: red">
                        <% if (request.getAttribute("errorEmail") != null) { %>
                        <%= request.getAttribute("errorEmail") %>
                        <% } else { %>
                        <%=""%>
                        <% } %>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>     
            </form>
        </div>
    </body>
</html>
