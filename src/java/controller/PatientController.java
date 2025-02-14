/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Patient;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Vector;
import model.DAOPatient;

/**
 *
 * @author Admin
 */
@WebServlet(name = "PatientController", urlPatterns = {"/PatientURL"})
public class PatientController extends HttpServlet {

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
        DAOPatient dao = new DAOPatient();
        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");

            if (service == null) {
                service = "listAllPatient";
            }

            if (service.equals("deletePatient")) {
                dao.deletePatient(Integer.parseInt(request.getParameter("paID")));
                response.sendRedirect("PatientURL");

            }

            if (service.equals("updatePatientByUser")) {
                String submit = request.getParameter("submit");

                if (submit == null) {
                    int paID = Integer.parseInt(request.getParameter("paID"));

                    
                    Vector<Patient> vectorPatient = dao.getPatient("SELECT * FROM Patient WHERE PatientID =" + paID);

                    if (!vectorPatient.isEmpty()) {
                        Patient patient = vectorPatient.get(0);
                        request.setAttribute("patient", patient);
                    }

                    request.getRequestDispatcher("/jsp/updatePatient.jsp").forward(request, response);

                } else {
                    String PatientID = request.getParameter("PatientID");
                    String FirstName = request.getParameter("FirstName");
                    String LastName = request.getParameter("LastName");
                    String Birthday = request.getParameter("Birthday");
                    String Phone = request.getParameter("Phone");
                    String Email = request.getParameter("Email");
                    String Address = request.getParameter("Address");
                    String YourBio = request.getParameter("YourBio");

                    if (FirstName.equals("") || LastName.equals("") || Email.equals("")) {
                        out.print("All fields must not be empty");
                        return;
                    }
                    int patientID = Integer.parseInt(PatientID);
                    LocalDate birthday = LocalDate.parse(Birthday);

                    Patient pa = new Patient(patientID, FirstName, LastName, birthday, Phone, Email, Address, YourBio);
                    int n = dao.updatePatientByUser(pa);

                    response.sendRedirect("PatientURL");
                }
            }

            if (service.equals("insertPatient")) {
                String submit = request.getParameter("submit");
                if (submit == null) {

                    request.getRequestDispatcher("/jsp/insertPatient.jsp").forward(request, response);

                } else {
                    String PatientID = request.getParameter("PatientID");
                    String FirstName = request.getParameter("FirstName");
                    String LastName = request.getParameter("LastName");
                    String Phone = request.getParameter("Phone");
                    String Email = request.getParameter("Email");
                    String Age = request.getParameter("Age");
                    String Gender = request.getParameter("Gender");
                    String Height = request.getParameter("Height");
                    String Weight = request.getParameter("Weight");
                    String AccountID = request.getParameter("AccountID");
                    LocalDate Birthday = LocalDate.parse(request.getParameter("Birthday"));
                    String Address = request.getParameter("Address");
                    String YourBio = request.getParameter("YourBio");

                    if (FirstName.equals("") || LastName.equals("") || Email.equals("")) {
                        out.print("all must not be empety");
                    }

                    int patientID = Integer.parseInt(PatientID);
                    int age = Integer.parseInt(Age);
                    double height = Double.parseDouble(Height);
                    double weight = Double.parseDouble(Weight);
                    int accountID = Integer.parseInt(AccountID);

                    Patient pa = new Patient(patientID, FirstName, LastName, Phone, Email, age, Gender, height, weight, accountID, Birthday, Address, YourBio);
                    int n = dao.addPatient(pa);

                    response.sendRedirect("PatientURL");

                }

            }

            if (service.equals("listAllPatient")) {
                String sql = "SELECT * FROM Patient ";
                String submit = request.getParameter("submit");
                if (submit == null) {

                    sql = "SELECT * FROM Patient";

                } else {
                    String paname = request.getParameter("paname");
                    sql = "SELECT * FROM Patient WHERE LastName LIKE '%" + paname + "%'";

                }

                Vector<Patient> vectorPatient = dao.getPatient(sql);

                RequestDispatcher dispath = request.getRequestDispatcher("/jsp/patient-profile.jsp");

                request.setAttribute("vectorPatient", vectorPatient);

                request.setAttribute("title", "Patient Manager");

                dispath.forward(request, response);
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
