/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAOMedicalProducts;
import entity.MedicalProducts;
import entity.Categories;
import jakarta.servlet.RequestDispatcher;
import java.util.Vector;
import model.DAOCategories;

/**
 *
 * @author quang
 */
@WebServlet(name="MedicalProductController", urlPatterns={"/MedicalProductURL"})
public class MedicalProductController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOMedicalProducts dao = new DAOMedicalProducts();
        DAOCategories daoCat = new DAOCategories();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            String sql = "select * from MedicalProducts";
            String sqlCat = "select * from Categories";
            if(service.equals("listAllProducts")){
                sql = "select * from MedicalProducts";
            }
            
            if (service.equals("categories")) {
                String cid = request.getParameter("cid");
                sql = "select * from MedicalProducts a join Categories b on a.CategoriesID = b.CategoriesID\n"
                        + "where b.CategoriesID = " + cid;
            }
            Vector<MedicalProducts> vector = dao.getMedicalProducts(sql);
            Vector<Categories> vectorCat = daoCat.getCategories(sqlCat);
                request.setAttribute("data", vector);
                request.setAttribute("dataCat", vectorCat);
                request.getRequestDispatcher("/jsp/displayProduct.jsp").forward(request, response);
            
            
            
//            if(service == null) {
//                service = "listAllProducts";
//            }
//            
//            if(service.equals("listAllProducts")){
//                String submit = request.getParameter("submit");
//                sql = "select * from MedicalProducts";
//                if(submit != null){
//                    String pname = request.getParameter("pname");
//                    sql = "select * from MedicalProducts where Name like '%"+pname+"%'";
//                }
//                
//                
//                
//            }
            
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
