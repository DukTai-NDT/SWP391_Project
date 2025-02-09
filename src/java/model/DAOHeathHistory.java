/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import entity.HeathHistory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class DAOHeathHistory extends DBConnection {

    public int addHeathHistory(HeathHistory heath) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Health_History]\n"
                + "           ([PatientID]\n"
                + "           ,[Disease])\n"
                + "     VALUES\n"
                + "           ?\n"
                + "           ,?";

        PreparedStatement preState;

        try {
            preState = conn.prepareStatement(sql);
            preState.setInt(1, heath.getPatientID());
            preState.setString(2, heath.getDisease());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOHeathHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;

    }

    public int deleteHeathHistory(int HistoryID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Health_History]\n"
                + "      WHERE HistoryID =  " + HistoryID + "";

        Statement state;

        try {
            state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOHeathHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateHeathHistory(HeathHistory heath) {
        int n = 0;
        String sql = "UPDATE [dbo].[Health_History]\n"
                + "   SET [PatientID] = ?\n"
                + "      ,[Disease] = ?\n"
                + " WHERE HistoryID = ?";
        
        PreparedStatement preState;
        try {
            preState = conn.prepareStatement(sql);
            preState.setInt(1, heath.getPatientID());
            preState.setString(2, heath.getDisease());
            preState.setInt(3,heath.getHistoryID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOHeathHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public Vector<HeathHistory> getHeathHistory (String sql) {
        Vector<HeathHistory> vector =  new Vector<HeathHistory>();
        
        try {
            Statement state =  conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
                    ,ResultSet.CONCUR_UPDATABLE);
            ResultSet re = state.executeQuery(sql);
            while(re.next()){
                int HistoryID = re.getInt(1);
                int PatientID = re.getInt(2);
                String Disease = re.getString("Disease");
                
                HeathHistory heath = new HeathHistory(HistoryID, PatientID, Disease);
                vector.add(heath);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOHeathHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vector;
    }
}
