/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Appointment;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author quang
 */
public class DAOAppointment extends DBConnection {

    public int addAppointment(Appointment appo) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Appointment]\n"
                + "           ([Date]\n"
                + "           ,[Time]\n"
                + "           ,[DoctorID]\n"
                + "           ,[StaffID]\n"
                + "           ,[PatientID]\n"
                + "           ,[IsConfirm])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        PreparedStatement preState;

        try {
            preState = conn.prepareStatement(sql);
            preState.setString(1, appo.getDate());
            preState.setString(2, appo.getTime());
            preState.setInt(3, appo.getDoctorID());
            preState.setInt(4, appo.getStaffID());
            preState.setInt(5, appo.getPatientID());
            preState.setInt(6, (appo.isIsConfirm() == true ? 1 : 0));
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int deleteAppointment(int AppointmentID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Appointment]\n"
                + "      WHERE AppointmentID = " + AppointmentID + "";

        Statement state;

        try {
            state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateAppointment(Appointment appo) {
        int n = 0;
        String sql = "UPDATE [dbo].[Appointment]\n"
                + "   SET [Date] = ?\n"
                + "      ,[Time] = ?\n"
                + "      ,[DoctorID] = ?\n"
                + "      ,[StaffID] = ?\n"
                + "      ,[PatientID] = ?\n"
                + "      ,[IsConfirm] = ?\n"
                + " WHERE AppointmentID = ?";

        PreparedStatement preState;

        try {
            preState = conn.prepareStatement(sql);
            preState.setString(1, appo.getDate());
            preState.setString(2, appo.getTime());
            preState.setInt(3, appo.getDoctorID());
            preState.setInt(4, appo.getStaffID());
            preState.setInt(5, appo.getPatientID());
            preState.setInt(6, (appo.isIsConfirm() == true ? 1 : 0));
            preState.setInt(7, appo.getAppointmentID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public Vector<Appointment> getAppointment (String sql) {
        Vector<Appointment> vector = new Vector<Appointment>();
        
        Statement state;
        try {
            state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
                    ,ResultSet.CONCUR_UPDATABLE);
            ResultSet re = state.executeQuery(sql);
            while(re.next()){
                int AppointmentID = re.getInt(1);
                String Date = re.getString("Date");
                String Time = re.getString("Time");
                int DoctorID = re.getInt(2);
                int StaffID = re.getInt(3);
                int PatientID = re.getInt(4);
                boolean IsConfirm = (re.getInt("IsConfirm")==1?true:false);
                
                Appointment appo = new Appointment(AppointmentID, Date, Time, DoctorID, StaffID, PatientID, IsConfirm);
                vector.add(appo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return vector;
    }
}
