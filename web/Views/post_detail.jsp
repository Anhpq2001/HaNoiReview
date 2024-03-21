<%-- 
    Document   : post_detail
    Created on : Mar 10, 2024, 11:49:42 AM
    Author     : anhph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/post_detail_style.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- comment -->

        <title>Post Detail</title>
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
                        </div>
                        <c:forEach items="${comments}" var="childComment">
                            <c:if test="${childComment.getParentCommentId() == comment.getId()}">
                                <div style="margin-left: 40px;" class="item">
                                    <label style="color: blue">${childComment.getUser().getAccount()}</label>
                                    <input  type="text" value="${childComment.getContent()}">
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
