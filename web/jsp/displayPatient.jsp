<%-- 
    Document   : displayPatient
    Created on : Feb 11, 2025, 8:08:52 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Patient,java.util.Vector" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Vector<Patient> vectorPatient =(Vector<Patient>) request.getAttribute("vectorPatient");
         String title =(String) request.getAttribute("title"); 
        %>

        <form action="PatientURL" method="get">
            <p>
                Search Name: <input type="text" name="paname" id="">
                <input type="submit" value="Search" name="submit">
                <input type="reset" value="Clear">
                <input type="hidden" name="service" value="listAllPatient">   
            </p>


        </form>

        <p><a href="PatientURL?service=insertPatient">INSERT PATIENT</a></p>

        <table border="1">
            <tr>
                <th>PatientID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Height</th>
                <th>Weight</th>
                <th>AccountID</th>
                <th>Update</th>
                <th>Delete</th>
                
            </tr>



            <% for (Patient patient : vectorPatient) {%>
            <tr>
                <td><%= patient.getPatientID()%></td>
                <td><%= patient.getFirstName()%></td>
                <td><%= patient.getLastName()%></td>
                <td><%= patient.getPhone()%></td>
                <td><%= patient.getEmail()%></td>
                <td><%= patient.getAge()%></td>
                <td><%= patient.getGender()%></td>
                <td><%= patient.getHeight()%></td>
                <td><%= patient.getWeight()%></td>
                <td><%= patient.getAccountID()%></td>
                <td><a href="PatientURL?service=updatePatientByUser&paID=<%=patient.getPatientID()%>">Update</a></td>
                <td><a href="PatientURL?service=deletePatient&paID=<%=patient.getPatientID()%>">Delete</a></td>
               
            </tr>
            <%}%>


        </table   


    </body>
</html>
