<%-- 
    Document   : edit_post
    Created on : Mar 21, 2024, 10:53:06 AM
    Author     : anhph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/edit_post_style.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- comment -->

        <title>Edit post</title>
    </head>
    <body>
        <div class="container d-flex align-items-center justify-content-center" style="height: 100vh;"> 
            <form action="home?action=editinforpost&&id=${post.getId()}" method="post" enctype="multipart/form-data">
                <div>
                    <h3>Edit information post</h3>
                </div>
                <div class="form-group">
                    <label for="category">Category</label>
                    <select class="form-control" id="category" name="category">
                        <option value="${post.getCategory().getId()}" selected>${post.getCategory().getName()}</option>
                        <c:forEach items="${categories}" var="c">
                            <option value="${c.getId()}">${c.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" class="form-control" id="title" name="tilte" value="${post.getTitle()}">
                </div>
                <div class="form-group">
                    <label for="content">Content</label>
                    <textarea class="form-control" id="content" rows="3" name="content">${post.getContent()}</textarea>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" value="${post.getAddress()}">
                </div>
                <div class="form-group">
                    <label for="image">Image</label>
                    <input type="file" class="form-control-file" id="image" name="image" onchange="previewImage()">
                    <img id="preview" src="${image.getImageUrl()}" alt="Preview Image" style="max-width: 100%; margin-top: 10px; display: none;">
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
        </div>
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
