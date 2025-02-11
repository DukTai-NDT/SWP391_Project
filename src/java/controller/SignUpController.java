/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Account;
import entity.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import model.DAOAccount;
import model.DAOPatient;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpURL"})
public class SignUpController extends HttpServlet {

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
        DAOPatient daoPatient = new DAOPatient();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if (service.equals("signup")) {
                String FirstName = request.getParameter("FirstName");
                String LastName = request.getParameter("LastName");
                String UserName = request.getParameter("UserName");
                String Email = request.getParameter("Email");
                String Password = request.getParameter("Password");
                
                Vector<Patient> vector = new Vector<>();
                int cnt = 0;
                for (Patient patient : vector) {
                    if(patient.getEmail().equals(Email)){
                        cnt ++;
                    }
                }
                if(cnt !=0){
                    request.setAttribute("accountExist", "Account already exist!!!");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                }else{
                    int n = dao.addAccount(new Account(UserName, 1002, Password));
                    if(n == 0){
                        request.setAttribute("accountFail", "Can not to signup !!!");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                    }else{
                        Patient patient = new Patient(FirstName, LastName, null, Email, 0, null, 0, 0, dao.getLastAccountID());
                        int x =daoPatient.addPatient(patient);
                        response.sendRedirect("LoginURL?service=login");
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
