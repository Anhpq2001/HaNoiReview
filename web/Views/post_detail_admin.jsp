<%-- 
    Document   : post_detail_admin
    Created on : Mar 22, 2024, 1:37:29 AM
    Author     : anhph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/post_detail_admin_style.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- comment -->
        <title>Post detail admin</title>
    </head>
    <body>
        <div class="container">
            <div class="title">
                <h1>${post.getTitle()}</h1>
            </div>
            <div class="information">
                <h5>Topic:<i>${post.getCategory().getName()}</i></h5>
                <h5>Time:<i>${post.getCreatedAt()}</i></h5>
            </div>
            <div class="image">
                <img src="${image.getImageUrl()}" width="" height="" alt="alt"/>
            </div>
            <div class="content">
                <p>${post.getContent()}</p>
            </div>
            <div class="comment">
                <h3>This is comment</h3>
                <c:forEach items="${comments}" var="comment">
                    <c:if test="${comment.getParentCommentId() == 0}">
                        <div class="item">
                            <label style="color: blue">${comment.getUser().getAccount()}</label>
                            <input type="text" value="${comment.getContent()}">
                            <c:if test="${comment.isIsDelete() == false}">
                                <a href="home?action=managestatus&&status=0&&commentid=${comment.getId()}&&postid=${post.getId()}"><button class="btn btn-danger">Hide</button></a>
                            </c:if>
                            <c:if test="${comment.isIsDelete() == true}">
                                <a href="home?action=managestatus&&status=1&&commentid=${comment.getId()}&&postid=${post.getId()}"><button class="btn btn-primary">Display</button></a>
                            </c:if>       
                        </div>
                        <c:forEach items="${comments}" var="childComment">
                            <c:if test="${childComment.getParentCommentId() == comment.getId()}">
                                <div style="margin-left: 40px;" class="item">
                                    <label style="color: blue">${childComment.getUser().getAccount()}</label>
                                    <input  type="text" value="${childComment.getContent()}">
                                    <c:if test="${childComment.isIsDelete() == false}">
                                        <a href="home?action=managestatus&&status=0&&commentid=${childComment.getId()}&&postid=${post.getId()}"><button class="btn btn-danger">Hide</button></a>
                                    </c:if>
                                    <c:if test="${childComment.isIsDelete() == true}">
                                        <a href="home?action=managestatus&&status=1&&commentid=${childComment.getId()}&&postid=${post.getId()}"><button class="btn btn-primary">Display</button></a>
                                    </c:if>      
                                </div>
                            </c:if>
                        </c:forEach>
                        <c:if test="${sessionScope.user != null}">
                            <form action="home?action=comment&&parentid=${comment.getId()}&&userid=${sessionScope.user.getId()}&&postid=${post.getId()}" method="post">
                                <div class="item" style="margin-left: 40px;">
                                    <label style="color: blue">${sessionScope.user.getAccount()}</label>
                                    <input type="text" name="comment">
                                    <button type="submit" class="btn btn-secondary">comment</button>
                                </div>
                            </form>
                        </c:if>
                    </c:if>
                </c:forEach>
                <c:if test="${sessionScope.user != null}">
                    <form action="home?action=comment&&parentid=0&&userid=${sessionScope.user.getId()}&&postid=${post.getId()}" method="post">
                        <div class="item">
                            <p>-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
                            <label style="color: blue">${sessionScope.user.getAccount()}</label>
                            <input type="text" name="comment">
                            <button type="submit" class="btn btn-secondary">comment</button>
                        </div>
                    </form>
                </c:if>
            </div>
        </div>
    </body>
</html>
