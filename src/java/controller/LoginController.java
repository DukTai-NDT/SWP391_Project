/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Account;
import entity.FacebookAccount;
import entity.GoogleAccount;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Random;
import java.util.Vector;
import model.DAOAccount;
import model.DAOFacebookLogin;
import model.DAOGoogleLogin;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginURL"})
public class LoginController extends HttpServlet {

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
        DAOAccount dao = new DAOAccount();
        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            String code = request.getParameter("code");
            if (service == null) {
                service = "google";

            }
//            if(service.equals("loginWithFacebook")&& code != null){
//                DAOFacebookLogin daoFace = new DAOFacebookLogin();
//                String accessToken = daoFace.getToken(code);
//                FacebookAccount faceAcc = daoFace.getUserInfo(accessToken);
//                Vector<String> vectorString = dao.getEmailAccount();
//
//                boolean userExists = false;
//                for (String string : vectorString) {
//                    if (faceAcc.getEmail().equals(string)) {
//                        userExists = true;
//                        break; // Exit loop early if user exists
//                    }
//                }
//
//                if (userExists) {
//                    session.setAttribute("dataUser", faceAcc.getName());
//                    request.getRequestDispatcher("index.jsp").forward(request, response);
//                } else {
//                    int n = dao.addAccount(new Account(faceAcc.getName(), 1002, getRandom(6)));
//                    session.setAttribute("dataUser", faceAcc.getName());
//                    request.getRequestDispatcher("index.jsp").forward(request, response);
//                }
//            }
            if ("google".equals(service) && code != null) {
                DAOGoogleLogin daoGoogle = new DAOGoogleLogin();

                String accessToken = daoGoogle.getToken(code);
                GoogleAccount acc = daoGoogle.getUserInfo(accessToken);
                Vector<Account> vectorAcc = dao.getAccount("Select * from Account");
                Account accountExists = new Account();
                boolean userExists = false;
                for (Account account : vectorAcc) {
                    if (acc.getEmail().equals(account.getEmail())) {
                       accountExists.setUserName(account.getUserName());
                       accountExists.setPassword(account.getPassword());
                       accountExists.setRoleID(account.getRoleID());
                       accountExists.setEmail(account.getEmail());
                        userExists = true;
                        break; // Exit loop early if user exists
                    }
                }

                if (userExists) {
                    session.setAttribute("dataUser", accountExists);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
//                    int n = dao.addAccount(new Account(acc.getName(), 1002, getRandom(6),acc.getEmail()));
//                    session.setAttribute("dataUser", acc.getName());
                    request.setAttribute("message", "Account does not exist yet. You must SignUp");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }

            if (service.equals("login")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    Account account = dao.getLogin(request.getParameter("username"), request.getParameter("password"));
                    if (account == null) {
                        request.setAttribute("message", "Login fail!!!");
                        request.getRequestDispatcher("login.jsp").forward(request, response);

                    } else if (account != null) {
                        if (account.getRoleID() == 1002) {
                            
                            session.setAttribute("dataUser", account);
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        } else if (account.getRoleID() == 1003) {
                            session.setAttribute("dataUser", account);
                            request.getRequestDispatcher("indexAdmin.jsp").forward(request, response);
                        } else if (account.getRoleID() == 1) {
                            session.setAttribute("dataUser", account);
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        } else if (account.getRoleID() == 2) {
                            session.setAttribute("dataUser", account);
                            request.getRequestDispatcher("doctor-dashboard.jsp").forward(request, response);
                        }
                    }
                }
            }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
