<%-- 
    Document   : home_admin
    Created on : Mar 19, 2024, 9:20:00 PM
    Author     : anhph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- comment -->

        <link rel="stylesheet" href="css/home_admin_style.css"/>
        <title>Home Admin</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <a href="url" class="logo">
                    <img src="ImageSystem/logoproject.jpg" alt="Logo"/>
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
                        <c:choose>
                            <c:when test="${sessionScope.user == null}">
                                <a href="home?action=signin"><img id="logouser" src="ImageSystem/user.png" alt="alt"/></a>
                                </c:when>
                                <c:otherwise>
                                <a href="home?action=profile">${sessionScope.user.getAccount()}</a>
                                <a href="home?action=signout"><button class="btn btn-danger">SignOut</button></a>
                            </c:otherwise>    
                        </c:choose>

                    </div>
                </div>
            </div>
            <h3>Admin Manage System</h3>
            <div class="wrapper">
                <div class="left">
                    <a href="home?action=displayallpost"><button id="btn" class="btn btn-primary">Management List Post</button></a>
                    <a href="home?action=displayalluser"><button id="btn" class="btn btn-secondary">Management List User</button></a>
                </div>
            </div>
            <c:if test="${requestScope.posts != null}">
                <table class="table table-striped">
                    <tr>
                        <th>Title</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${requestScope.posts}" var="p">
                        <tr>
                            <td>${p.getTitle()}</td>
                            <td>
                                <a href=""><button>View</button></a>
                                <a href=""><button>Edit</button></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>              
            </c:if>
            <c:if test="${requestScope.users != null}">
                <table class="table table-striped">
                    <tr>
                        <th>Account</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${requestScope.users}" var="u">
                        <tr>
                            <td>${u.getAccount()}</td>
                            <td>
                                <a href=""><button>View</button></a>
                                <a href=""><button>Edit</button></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>              
            </c:if>
    </body>
</html>
