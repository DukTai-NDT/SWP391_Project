<%-- 
    Document   : updatePatient
    Created on : Feb 11, 2025, 8:09:07 AM
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
        Vector<Patient> vectorPatient = (Vector<Patient>)request.getAttribute("vectorPatient");
     
     %>
        
      <form action="PatientURL" method="post">
            <input type="hidden" name="service" value="updatePatient">

     
          <table>
                <caption>
                    UPDATE PATIENT
                </caption>
               
                <tr>
                    <td><label for="PatientID">PatientID</label></td>
                    <td><input type="text" name="PatientID" id="PatientID"  readonly=""></td>
                </tr>
                
               <tr>
                    <td><label for="FirstName">FirstName</label></td>
                    <td><input type="text" name="FirstName" id="FirstName" "></td>
                </tr>
                 <tr>
                    <td><label for="LastName">LastName</label></td>
                    <td><input type="text" name="LastName" id="LastName" ></td>
                </tr>
                 <tr>
                    <td><label for="Phone">Phone</label></td>
                    <td><input type="text" name="Phone" id="Phone"></td>
                </tr>
                 <tr>
                    <td><label for="Email">Email</label></td>
                    <td><input type="text" name="Email" id="Email"></td>
                </tr> <tr>
                    <td><label for="Age">Age</label></td>
                    <td><input type="text" name="Age" id="Age" ></td>
                </tr> <tr>
                    <td><label for="Gender">Gender</label></td>
                    <td><input type="text" name="Gender" id="Gender" ></td>
                </tr> <tr>
                    <td><label for="Height">Height</label></td>
                    <td><input type="text" name="Height" id="Height" ></td>
                </tr> <tr>
                    <td><label for="Weight">Weight</label></td>
                    <td><input type="text" name="Weight" id="Weight"></td>
                </tr> <tr>
                    <td><label for="AccountID">AccountID</label></td>
                    <td><input type="text" name="AccountID" id="AccountID" "></td>
                </tr>
                
                  <tr>
                    <td><input type="submit" name="submit" value="UPDATE PATIENT" /> </td>
                    <td><input type="reset" value="Clear" /> </td>
                </tr>
                
                 
            </table> 
                      
        
        </form>
        
        
    </body>
</html>
