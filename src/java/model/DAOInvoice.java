/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Invoice;
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
public class DAOInvoice extends DBConnection {

    public int addInvoice(Invoice other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Invoice] ([PatientID] ,[Amount] ,[Total])\n"
                + "     VALUES (?,?,?)";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setInt(1, other.getPatientID());
            preState.setDouble(2, other.getAmount());
            preState.setDouble(3, other.getTotal());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteInvoice(int InvoiceID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Invoice]\n"
                + "      WHERE Invoice.InvoiceID = " + InvoiceID;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateInvoice(Invoice other) {
        int n = 0;
        String sql = "UPDATE [dbo].[Invoice]\n"
                + "   SET [PatientID] = ?\n"
                + "      ,[Amount] = ?\n"
                + "      ,[Total] = ?\n"
                + " WHERE Invoice.InvoiceID = ?";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setInt(1, other.getPatientID());
            preState.setDouble(2, other.getAmount());
            preState.setDouble(3, other.getTotal());
            preState.setInt(4, other.getInvoiceID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Invoice> getInvoice(String sql) {
        Vector<Invoice> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int InvoiceID = rs.getInt("InvoiceID");
                int PatientID = rs.getInt("PatientID");
                double Amount = rs.getDouble("Amount");
                double Total = rs.getDouble("Total");
                Invoice invoice = new Invoice(InvoiceID, PatientID, Amount, Total);
                vector.add(invoice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }
}
