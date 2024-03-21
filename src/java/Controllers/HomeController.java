/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Services.HomeService;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 *
 * @author anhph
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50)
public class HomeController extends HttpServlet {

    HomeService homeService = new HomeService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Objects.isNull(action)) {
            action = "";
        }
        switch (action) {
            case "":
                homeService.displayHome(request, response);
                break;
            case "signin":
                homeService.displaySignIn(request, response);
                break;
            case "signup":
                homeService.displaySignup(request, response);
                break;
            case "signout":
                homeService.signout(request, response);
                break;
            case "profile":
                homeService.displayProfile(request, response);
                break;
            case "changeprofile":
                homeService.displayChangProfile(request, response);
                break;
            case "displayalluser":
                homeService.displayAllUser(request, response);
                break;
            case "displayallpost":
                homeService.displayAllPost(request, response);
                break;
            case "displaynewpost":
                homeService.displayNewPost(request, response);
                break;
            case "displayEditPost":
                homeService.displayEditPost(request, response);
                break;
            case "filter":
                homeService.filter(request, response);
                break;
            case "editstatususer":
                homeService.editStatusUser(request, response);
                break;
            case "dislpaydetailuser":
                homeService.dislpayDetailUser(request, response);
                break;
            case "postdetail":
                homeService.displayPostDetail(request, response);
                break;
            case "displayEditStatusPost":
                homeService.displayEditStatusPost(request, response);
                break;
            case "managestatus":
                homeService.manageStatusComment(request, response);
                break;
            case "managestatuspost":
                homeService.manageStatusPost(request, response);
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Objects.isNull(action)) {
            action = "";
        }
        switch (action) {
            case "signin":
                homeService.signIn(request, response);
                break;
            case "signup":
                homeService.signUp(request, response);
                break;
            case "changprofile":
                homeService.changProfile(request, response);
                break;
            case "comment":
                homeService.insertComment(request, response);
                break;
            case "newpost":
                homeService.insertPost(request, response);
                break;
            case "editinforpost":
                homeService.editInforPost(request, response);
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
