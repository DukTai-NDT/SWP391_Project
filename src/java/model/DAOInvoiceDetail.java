/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.InvoiceDetail;
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
public class DAOInvoiceDetail extends DBConnection {

    public int addInvoiceDetail(InvoiceDetail other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[InvoiceDetail] ([Quantity]  ,[ProductPrice] ,[TreatmentPrice] ,[Total] ,[InvoiceID] ,[MedicationID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedState = conn.prepareStatement(sql);
            preparedState.setInt(1, other.getQuantity());
            preparedState.setDouble(2, other.getProductPrice());
            preparedState.setDouble(3, other.getTreatmentPrice());
            preparedState.setDouble(4, other.getTotal());
            preparedState.setInt(5, other.getInvoiceID());
            preparedState.setInt(6, other.getMedicationID());
            n = preparedState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvoiceDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteInvoiceDetail(int InvoiceDetailID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[InvoiceDetail]\n"
                + "      WHERE InvoiceDetail.InvoiceDetailID = " + InvoiceDetailID;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvoiceDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateInvoiceDetail(InvoiceDetail other) {
        int n = 0;
        String sql = "UPDATE [dbo].[InvoiceDetail]\n"
                + "   SET [Quantity] = ?\n"
                + "      ,[ProductPrice] = ?\n"
                + "      ,[TreatmentPrice] = ?\n"
                + "      ,[Total] = ?\n"
                + "      ,[InvoiceID] = ?\n"
                + "      ,[MedicationID] = ?\n"
                + " WHERE InvoiceDetail.InvoiceDetailID = ?";
        try {
            PreparedStatement preparedState = conn.prepareStatement(sql);
            preparedState.setInt(1, other.getQuantity());
            preparedState.setDouble(2, other.getProductPrice());
            preparedState.setDouble(3, other.getTreatmentPrice());
            preparedState.setDouble(4, other.getTotal());
            preparedState.setInt(5, other.getInvoiceDetailID());
            preparedState.setInt(6, other.getMedicationID());
            preparedState.setInt(7, other.getInvoiceDetailID());
            n = preparedState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvoiceDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<InvoiceDetail> getInvoiceDetail(String sql) {
        Vector<InvoiceDetail> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int InvoiceDetailID = rs.getInt("InvoiceDetailID");
                int Quantity = rs.getInt("Quantity");
                double ProductPrice = rs.getDouble("ProductPrice");
                double TreatmentPrice = rs.getDouble("TreatmentPrice");
                double Total = rs.getDouble("Total");
                int InvoiceID = rs.getInt("InvoiceID");
                int MedicationID = rs.getInt("MedicationID");
                InvoiceDetail invoiceDetail = new InvoiceDetail(InvoiceDetailID, Quantity, ProductPrice, TreatmentPrice, Total, InvoiceID, MedicationID);
                vector.add(invoiceDetail);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOInvoiceDetail.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }
}
