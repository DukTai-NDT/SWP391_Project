/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Patient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class DAOPatient extends DBConnection {

    public int addPatient(Patient other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Patient]\n"
                + "           ([FirstName]\n"
                + "           ,[LastName]\n"
                + "           ,[Phone]\n"
                + "           ,[Email]\n"
                + "           ,[Age]\n"
                + "           ,[Gender]\n"
                + "           ,[Height]\n"
                + "           ,[Weight]\n"
                + "           ,[AccountID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        PreparedStatement preState;

        try {
            preState = conn.prepareStatement(sql);
            preState.setString(1, other.getFirstName());
            preState.setString(2, other.getLastName());
            preState.setString(3, other.getPhone());
            preState.setString(4, other.getEmail());
            preState.setInt(5, other.getAge());
            preState.setString(6, other.getGender());
            preState.setDouble(7, other.getHeight());
            preState.setDouble(8, other.getWeight());
            preState.setInt(9, other.getAccountID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deletePatient(int PatientID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Patient]\n"
                + "      WHERE PatientID = " + PatientID + "";
        Statement state;

        try {
            state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOPatient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updatePatient(Patient patient) {
        int n = 0;
        String sql = "UPDATE [dbo].[Patient]\n"
                + "   SET [FirstName] = ?\n"
                + "      ,[LastName] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Age] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[Height] = ?\n"
                + "      ,[Weight] = ?\n"
                + "      ,[AccountID] = ?\n"
                + " WHERE PatientID = ?";
        
        PreparedStatement preState;
        
        try {
            preState = conn.prepareStatement(sql);
            preState.setString(1, patient.getFirstName());
            preState.setString(2, patient.getLastName());
            preState.setString(3, patient.getPhone());
            preState.setString(4, patient.getEmail());
            preState.setInt(5, patient.getAge());
            preState.setString(6, patient.getGender());
            preState.setDouble(7, patient.getHeight());
            preState.setDouble(8, patient.getWeight());
            preState.setInt(9, patient.getAccountID());
            preState.setInt(10, patient.getPatientID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public Vector<Patient> getPatient (String sql ) {
        Vector<Patient> vector = new Vector<Patient>();
        
        Statement state;
        try {
            state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
                    ,ResultSet.CONCUR_UPDATABLE);
            ResultSet re = state.executeQuery(sql);
            while(re.next()) {
                int PatientID = re.getInt(1);
                String FirstName = re.getString("FirstName");
                String LastName = re.getString("LastName");
                String Phone = re.getString("Phone");
                String Email = re.getString("Email");
                int Age = re.getInt(1);
                String Gender = re.getString("Gender");
                Double Height = re.getDouble(2);
                Double Weight = re.getDouble(2);
                int AccountID = re.getInt(1);
                
                Patient patient = new Patient(PatientID, FirstName, LastName, Phone, Email, Age, Gender, 0, 0, AccountID);
                vector.add(patient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return vector;
    }
}
