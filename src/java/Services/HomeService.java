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
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    Validate validate = new Validate();

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
                request.setAttribute("posts", posts);
                request.setAttribute("images", images);
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
            }
            if (user.isIsAdmin() == true) {
                // hiển thị trang home của admin
                request.getRequestDispatcher("/Views/home_admin.jsp").forward(request, response);
            }
            if (user.isIsAdmin() == false) {
                // hiển thị trang home của user có đăng nhập
                posts = postDAO.getAll();
                images = imageDAO.getAll();
                categories = categoryDAO.getAll();
                request.setAttribute("posts", posts);
                request.setAttribute("images", images);
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayAllPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            // cho phep admin xem danh sach cac bai post da dang
            List<Post> posts = postDAO.getAll();
            request.setAttribute("posts", posts);
            request.setAttribute("users", null);
            request.setAttribute("categories", null);
            request.getRequestDispatcher("/Views/home_admin.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayAllUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            // cho phep admin xem danh sach cac user da dang nhap
            List<User> users = userDAO.getAll();
            request.setAttribute("users", users);
            request.setAttribute("posts", null);
            request.setAttribute("categories", null);
            request.getRequestDispatcher("/Views/home_admin.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            // nguoi dung co the xem profile cua ho
            request.getRequestDispatcher("/Views/profile.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertComment(HttpServletRequest request, HttpServletResponse response) {
        // them comment khi nguoi dung comment
    }

    public void insertPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            // them post khi admin muon them post moi
            // Lấy thông tin từ request
            String category = request.getParameter("category");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String address = request.getParameter("address");
            Part filePart = request.getPart("image");
            String fileName = filePart.getSubmittedFileName();
            for (Part part : request.getParts()) {
                part.write("C:\\Users\\anhph\\OneDrive\\Desktop\\ReviewHaNoiTour\\web\\ImageSystem\\" + fileName);
            }
            String parthImage = "ImageSystem/" + fileName;
            // Tạo một đối tượng Post mới và đặt các thuộc tính
            Post post = new Post();
            post.setTitle(title);
            post.setContent(content);
            post.setAddress(address);
            post.setCategory(categoryDAO.getOne(Integer.parseInt(category)));
            post.setCreatedAt(validate.getCurrentDate());
            postDAO.insert(post);
            Image image = new Image();
            image.setPost(postDAO.getOneByTitle(title)); // doi tuong dang bị null
            image.setImageUrl(parthImage);
            imageDAO.insert(image);
            displayAllPost(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void displayPostDetail(HttpServletRequest request, HttpServletResponse response) {
        try {
            String posiId = request.getParameter("id");
            Post post = postDAO.getOne(Integer.parseInt(posiId));
            Image image = imageDAO.getOneByPostId(Integer.parseInt(posiId));
            request.setAttribute("post", post);
            request.setAttribute("image", image);
            request.getRequestDispatcher("/Views/post_detail.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void signout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false); // false để không tạo session mới nếu không tồn tại
        if (session != null) {
            session.invalidate(); // Xóa session hiện tại
        }
        try {
            response.sendRedirect("home");
        } catch (IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displaySignup(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/Views/signup.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void signIn(HttpServletRequest request, HttpServletResponse response) {
        String errorMessage;
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = userDAO.getOneByAccountAndPassword(account, password);
        if (Objects.isNull(user)) {
            errorMessage = "Account or Password incorect!";
            request.setAttribute("errorMessage", errorMessage);
            try {
                request.getRequestDispatcher("/Views/signin.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            try {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("home");
            } catch (IOException ex) {
                Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void signUp(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("repassword");
        String email = request.getParameter("email");
        String errorAccount = "";
        String errorPassword = "";
        String errorRePassword = "";
        String errorEmail = "";
        String successful = "";
        if (account.isEmpty() || Objects.isNull(account) == true) {
            errorAccount = "Account is empty!";
        }
        if (password.isEmpty() || Objects.isNull(password) == true) {
            errorPassword = "Password is empty!";
        }
        if (rePassword.isEmpty() || Objects.isNull(rePassword) == true) {
            errorRePassword = "Confirm password is empty!";
        }
        if (email.isEmpty() || Objects.isNull(email) == true) {
            errorEmail = "Email is empty!";
        }
        if (validate.isExist(account) == true) {
            errorAccount = "Account is exsit!";
        }
        if (validate.isNotPassword(password) == true) {
            errorPassword = "Password is must from 8 to 16 digits!";
        }
        if (validate.isNotDuplicate(password, rePassword) == true) {
            errorRePassword = "Must duplicate password!";
        }
        if (validate.isNotEmail(email) == false) {
            errorEmail = "Must format abc@gmail.com!";
        }
        if (errorAccount.equals("") && errorPassword.equals("") && errorRePassword.equals("") && errorEmail.equals("")) {
            // todo khi khong co loi thi thuc hien
            User user = new User();
            user.setAccount(account);
            user.setPassword(password);
            user.setEmail(email);
            user.setCreatedAt(validate.getCurrentDate());
            userDAO.insert(user);
            successful = "Register successfully!";
        }
        request.setAttribute("errorAccount", errorAccount);
        request.setAttribute("errorPassword", errorPassword);
        request.setAttribute("errorRePassword", errorRePassword);
        request.setAttribute("errorEmail", errorEmail);
        request.setAttribute("successful", successful);
        request.setAttribute("account", account);
        request.setAttribute("password", password);
        request.setAttribute("rePassword", rePassword);
        request.setAttribute("email", email);
        try {
            request.getRequestDispatcher("/Views/signup.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changProfile(HttpServletRequest request, HttpServletResponse response) {
        try {
            Part file = request.getPart("avatar");
            String avartarFileName = file.getSubmittedFileName();
            String uploadParth = "C:/Users/anhph/OneDrive/Desktop/ReviewHaNoiTour/web/ImageSystem/" + avartarFileName;
            FileOutputStream fos = new FileOutputStream(uploadParth);
            InputStream is = file.getInputStream();
            byte[] data = new byte[is.available()];
            is.read();
            fos.write(data);
            fos.close();
        } catch (IOException | ServletException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayChangProfile(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/Views/change_profile.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayNewPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Category> categories = categoryDAO.getAll();
            request.setAttribute("posts", null);
            request.setAttribute("users", null);
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/Views/home_admin.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayEditPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id_raw = request.getParameter("id");
            int id = Integer.parseInt(id_raw);
            Post post = postDAO.getOne(id);
            Image image = imageDAO.getOneByPostId(id);
            List<Category> categories = categoryDAO.getAll();
            request.setAttribute("post", post);
            request.setAttribute("image", image);
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/Views/edit_post.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editInforPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String category = request.getParameter("category");
            String title = request.getParameter("tilte");
            String content = request.getParameter("content");
            String address = request.getParameter("address");
            String postId = request.getParameter("id");
            Part filePart = request.getPart("image");
            String fileName = filePart.getSubmittedFileName();
            for (Part part : request.getParts()) {
                part.write("C:\\Users\\anhph\\OneDrive\\Desktop\\ReviewHaNoiTour\\web\\ImageSystem\\" + fileName);
            }
            String parthImage = "ImageSystem/" + fileName;
            // good case update post
            Post post = new Post();
            post.setId(Integer.parseInt(postId));
            post.setCategory(categoryDAO.getOne(Integer.parseInt(category)));
            post.setTitle(title);
            post.setContent(content);
            post.setAddress(address);
            post.setUpdatedAt(validate.getCurrentDate());
            postDAO.update(post);
            
            // good case update urlimage
            Image image = new Image();
            image.setImageUrl(parthImage);
            imageDAO.updateByPostId(Integer.parseInt(postId), image);
            displayAllPost(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void editStatusUser(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String status = request.getParameter("status");
        User user = new User();
        if(status.equals("active")){
            user.setIsDelete(false);
        }
        if(status.equals("unactive")){
            user.setIsDelete(true);
        }
        userDAO.updateIsDeleteByAccount(user, account);
        displayAllUser(request, response);
    }

    public void filter(HttpServletRequest request, HttpServletResponse response) {
        try {
            String idCategory = request.getParameter("id");
            List<Category> categories = categoryDAO.getAll();
            List<Post> posts = postDAO.getAllByCategoryId(Integer.parseInt(idCategory));
            List<Image> images = imageDAO.getAll();
            request.setAttribute("categories", categories);
            request.setAttribute("posts", posts);
            request.setAttribute("images", images);
            request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dislpayDetailUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            String account = request.getParameter("account");
            User user = userDAO.getOneByAccount(account);
            request.setAttribute("account", user);
            request.getRequestDispatcher("/Views/displaydetailuser.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
