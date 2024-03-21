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
                <!--                <div id="menu">
                                    <div class="item">
                                        <input id="search" type="search" name="search"> comment 
                                    </div>
                                    <div class="item">
                                        <input id="searchbutton" type="submit" name="search" value="Search"> comment 
                                    </div>
                                </div>-->
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
                    <a href="home?action=displaynewpost"><button id="btn" class="btn btn-success">New Post</button></a>
                </div>
            </div>
            <c:if test="${requestScope.posts != null}">
                <h3 style="margin-top: 10px">List exist post</h3>
                <table class="table table-striped">
                    <tr>
                        <th style="text-align: center">Title</th>
                        <th style="text-align: center">Time</th>
                        <th style="text-align: center">Action</th>
                    </tr>
                    <c:forEach items="${requestScope.posts}" var="p">
                        <tr>
                            <td style="text-align: center">${p.getTitle()}</td>
                            <td style="text-align: center">${p.getCreatedAt()}</td>
                            <td style="text-align: center">
                                <c:if test="${p.isIsDelete() == true}">
                                    <a href="home?action=managestatuspost&&status=1&&postid=${p.getId()}"><button class="btn btn-primary">Active</button></a>
                                </c:if>
                                <c:if test="${p.isIsDelete() == false}">
                                    <a href="home?action=managestatuspost&&status=0&&postid=${p.getId()}"><button class="btn btn-danger">Unactive</button></a>
                                </c:if>
                                <a href="home?action=displayEditStatusPost&&id=${p.getId()}"><button class="btn btn-outline-success">View</button></a>
                                <a href="home?action=displayEditPost&&id=${p.getId()}"><button class="btn btn-outline-danger">Edit</button></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>              
            </c:if>
            <c:if test="${requestScope.users != null}">
                <h3 style="margin-top: 10px">List exist user</h3>
                <table class="table table-striped">
                    <tr>
                        <th style="text-align: center">Account</th>
                        <th style="text-align: center">Join time</th>
                        <th style="text-align: center">Action</th>
                    </tr>
                    <c:forEach items="${requestScope.users}" var="u">
                        <tr>
                            <td style="text-align: center">${u.getAccount()}</td>
                            <td style="text-align: center">${u.getCreatedAt()}</td>
                            <td style="text-align: center">
                                <a href="home?action=dislpaydetailuser&&account=${u.getAccount()}"><button class="btn btn-outline-success">View</button></a>
                                <c:choose>
                                    <c:when test="${u.isIsDelete() == true}">
                                        <a href="home?action=editstatususer&&status=active&&account=${u.getAccount()}"><button class="btn btn-outline-warning">Active</button></a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="home?action=editstatususer&&status=unactive&&account=${u.getAccount()}"><button class="btn btn-outline-danger">Unactive</button></a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>              
            </c:if>
            <c:if test="${requestScope.categories != null}">
                
                <div class="container d-flex align-items-center justify-content-center" style="height: 100vh;"> 
                    <form action="home?action=newpost" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <h3 style="margin-top: 20px; text-align: center">Add New Post</h3>
                        </div>
                        <div class="form-group">
                            <label for="category">Category</label>
                            <select class="form-control" id="category" name="category">
                                <c:forEach items="${categories}" var="c">
                                    <option value="${c.getId()}">${c.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" class="form-control" id="title" name="title" >
                        </div>
                        <div class="form-group">
                            <p style="margin-top: 40px; color: red">
                            <% if (request.getAttribute("errorTitle") != null) { %>
                            <%= request.getAttribute("errorTitle") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                            </p>
                        </div>
                        <div class="form-group">
                            <label for="content">Content</label>
                            <textarea class="form-control" id="content" rows="3" name="content"></textarea>
                        </div>
                        <div class="form-group">
                            <p style="margin-top: 40px; color: red">
                            <% if (request.getAttribute("errorContent") != null) { %>
                            <%= request.getAttribute("errorContent") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                            </p>
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <input type="text" class="form-control" id="address" name="address" >
                        </div>
                        <div class="form-group">
                            <p style="margin-top: 40px; color: red">
                            <% if (request.getAttribute("errorAddress") != null) { %>
                            <%= request.getAttribute("errorAddress") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                            </p>
                        </div>
                        <div class="form-group">
                            <label for="image">Image</label>
                            <input type="file" class="form-control-file" id="image" name="image" onchange="previewImage()">
                            <img id="preview" src="#" alt="Preview Image" style="max-width: 100%; margin-top: 10px; display: none;">
                        </div>
                        <div class="form-group">
                            <p style="margin-top: 40px; color: red">
                            <% if (request.getAttribute("errorImage") != null) { %>
                            <%= request.getAttribute("errorImage") %>
                            <% } else { %>
                            <%=""%>
                            <% } %>
                            </p>
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </c:if> 
                <script>
// Hàm để xem trước ảnh khi người dùng chọn một tệp tin
            function previewImage() {
                var fileInput = document.getElementById('image');
                var preview = document.getElementById('preview');

                // Kiểm tra xem có tệp tin được chọn không
                if (fileInput.files && fileInput.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        preview.src = e.target.result;
                        preview.style.display = 'block'; // Hiển thị ảnh
                    }

                    reader.readAsDataURL(fileInput.files[0]);
                }
            }
        </script>
    </body>
</html>
