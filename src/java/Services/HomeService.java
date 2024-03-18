/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.Category;
import Models.CategoryDAO;
import Models.Comment;
import Models.CommentDAO;
import Models.Image;
import Models.ImageDAO;
import Models.Post;
import Models.PostDAO;
import Models.User;
import Models.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhph
 */
public class HomeService {

    UserDAO userDAO = new UserDAO();
    PostDAO postDAO = new PostDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    ImageDAO imageDAO = new ImageDAO();
    CommentDAO commentDAO = new CommentDAO();

    public void displayHome(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            List<Post> posts = new ArrayList<>();
            List<User> users = new ArrayList<>();
            List<Image> images = new ArrayList<>();
            List<Category> categories = new ArrayList<>();
            List<Comment> comments = new ArrayList<>();
            if (Objects.isNull(user)) {
                // hien thi trang home cua user chua dang nhap
                posts = postDAO.getAll();
                images = imageDAO.getAll();
                categories = categoryDAO.getAll();
                comments = commentDAO.getAll();
                request.setAttribute("posts", posts);
//                request.setAttribute("comments", comments);
//                request.setAttribute("images", images);
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
            }
            if (user.isIsAdmin() == true) {
                // hiển thị trang home của admin
            }
            if (user.isIsAdmin() == false) {
                // hiển thị trang home của user có đăng nhập
                request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayAllPost(HttpServletRequest request, HttpServletResponse response) {
        // cho phep admin xem danh sach cac bai post
    }

    public void displayAllUser(HttpServletRequest request, HttpServletResponse response) {
        // cho phep admin xem danh sach cac user da dang nhap
    }

    public void displaySignIn(HttpServletRequest request, HttpServletResponse response) {
        try {
            // chuyển được thông báo lỗi qua trang jsp
            request.getRequestDispatcher("/Views/signin.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayProfile(HttpServletRequest request, HttpServletResponse response) {
        // nguoi dung co the xem profile cua ho
    }

    public void insertComment(HttpServletRequest request, HttpServletResponse response) {
        // them comment khi nguoi dung comment
    }

    public void insertPost(HttpServletRequest request, HttpServletResponse response) {
        // them post khi admin muon them post moi
    }

    public void manageUser(HttpServletRequest request, HttpServletResponse response) {
        // cho phep admin thay doi trang thai nguoi dung(vo hieu hoa hay khong)
    }

    public void managePost(HttpServletRequest request, HttpServletResponse response) {
        // cho phep admin chinh sua cac noi dung trong bai viet
        // an hoac comment them duoi account admin
    }

}
