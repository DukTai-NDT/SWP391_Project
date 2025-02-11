/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import entity.Payment;
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
public class DAOPayment extends DBConnection {

    public int addPayment(Payment other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Payment]\n"
                + "           ([InvoiceID]\n"
                + "           ,[PaymentMethod]\n"
                + "           ,[PaymentStatus]\n"
                + "           ,[PaymentDate])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?";
        PreparedStatement preState;

        try {
            preState = conn.prepareStatement(sql);
            preState.setInt(1, other.getInvoiceID());
            preState.setString(2, other.getPaymentMethod());
            preState.setString(3, other.getPaymentStatus());
            preState.setString(4, other.getPaymentDate());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPayment.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int deletePayment(int PaymentID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Payment]\n"
                + "      WHERE PaymentID = " + PaymentID + "";

        Statement state;

        try {
            state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOPayment.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updatePayment(Payment pay) {
        int n = 0;
        String sql = "UPDATE [dbo].[Payment]\n"
                + "   SET [InvoiceID] = ?\n"
                + "      ,[PaymentMethod] = ?\n"
                + "      ,[PaymentStatus] = ?\n"
                + "      ,[PaymentDate] = ?\n"
                + " WHERE PaymentID = ?";
        PreparedStatement preState;
        
        try {
            preState = conn.prepareStatement(sql);
            preState.setInt(1, pay.getInvoiceID());
            preState.setString(2, pay.getPaymentMethod());
            preState.setString(3, pay.getPaymentStatus());
            preState.setString(4, pay.getPaymentDate());
            preState.setInt(5, pay.getPaymentID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public Vector<Payment> getPayment (String sql) {
        Vector<Payment> vector = new Vector<Payment>();
        
        try {
            Statement state =  conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
                    ,ResultSet.CONCUR_UPDATABLE);
            ResultSet re = state.executeQuery(sql);
            while(re.next()){
                int PaymentID = re.getInt("PaymentID");
                int InvoiceID = re.getInt("InvoiceID");
                String PaymentMethod = re.getString("PaymentMethod");
                String PaymentStatus = re.getString("PaymentStatus");
                String PaymentDate = re.getString("PaymentDate");
                
                Payment pay = new Payment(PaymentID, InvoiceID, PaymentMethod, PaymentStatus, PaymentDate);
                vector.add(pay);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vector;
    }
}
