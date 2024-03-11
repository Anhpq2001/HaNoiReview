/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhph
 */
public class HomeService {
     
    public void displayHome(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            String choice = session.getAttribute("user").toString();
            if(choice.equals(true)){
                // hien thi trang home cua admin
            }else if(choice.equals("false")){
                // hien thi trang home cua user da dang nhap
            }else{
                // hien thi trang home cua user chua dang nhap
                
            }
            request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
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
