 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Doctor;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAODoctor extends DBConnection {

    public int addDoctor(Doctor other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Doctor]\n"
                + "           ([FirstName] ,[LastName] ,[Phone] ,[Email] ,[Gender] ,[DepartmentID] ,[Bio] ,[AccountID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getFirstName());
            preState.setString(2, other.getLastName());
            preState.setString(3, other.getPhone());
            preState.setString(4, other.getEmail());
            preState.setString(5, other.getGender());
            preState.setInt(6, other.getDepartmentID());
            preState.setString(7, other.getBio());
            preState.setInt(8, other.getAccountID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAODoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteDoctor(int DoctorID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Doctor]\n"
                + "      WHERE Doctor.DoctorID = " + DoctorID;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAODoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateDoctor(Doctor other) {
        int n = 0;
        String sql = "UPDATE [dbo].[Doctor]\n"
                + "   SET [FirstName] = ?\n"
                + "      ,[LastName] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[DepartmentID] = ?\n"
                + "      ,[Bio] = ?\n"
                + "      ,[AccountID] = ?\n"
                + " WHERE Doctor.DoctorID = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, other.getFirstName());
            preparedStatement.setString(2, other.getLastName());
            preparedStatement.setString(3, other.getPhone());
            preparedStatement.setString(4, other.getEmail());
            preparedStatement.setString(5, other.getGender());
            preparedStatement.setInt(6, other.getDepartmentID());
            preparedStatement.setString(7, other.getBio());
            preparedStatement.setInt(8, other.getAccountID());
            preparedStatement.setInt(9, other.getDoctorID());
            n = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAODoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Doctor> getDoctor(String sql) {
        Vector<Doctor> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int DoctorID = rs.getInt("DoctorID");
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                String Phone = rs.getString("Phone");
                String Email = rs.getString("Email");
                String Gender = rs.getString("Gender");
                int DepartmentID = rs.getInt("DepartmentID");
                String Bio = rs.getString("Bio");
                int AccountID = rs.getInt("AccountID");
                Doctor doctor = new Doctor(DoctorID, FirstName, LastName, Phone, Email, Gender, DepartmentID, Bio, AccountID);
                vector.add(doctor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODoctor.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }
    
    public static void main(String[] args) {
        DAODoctor dao = new DAODoctor();
        
//    Doctor doctorAdd = new Doctor("John2", "Doe", "123-456-7880", "john2doe@example.com", "Female", 1, "Experienced cardiologist with over 10 years in the field.", 3);
//   int n = dao.addDoctor(doctorAdd);

//    Doctor doctorUpdate = new Doctor(2, "John3", "Doe", "123-456-7880", "john3doe@example.com", "Female", 1, "Experienced cardiologist with over 10 years in the field.", 3);
//            int n = dao.updateDoctor(doctorUpdate);

int n = dao.deleteDoctor(4);
        System.out.println(n);
        
        Vector<Doctor> vector = dao.getDoctor("Select * from Doctor");
        for (Doctor doctor : vector) {
            System.out.println(doctor);
        }
        
    }
}
