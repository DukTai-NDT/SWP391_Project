/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.MedicalProducts;
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
public class DAOMedicalProducts extends DBConnection {

    public int addMedicalProducts(MedicalProducts medical) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[MedicalProducts]\n"
                + "           ([Name]\n"
                + "           ,[Price]\n"
                + "           ,[Quantity]\n"
                + "           ,[Description]\n"
                + "           ,[MfgDate]\n"
                + "           ,[ExpDate]\n"
                + "           ,[CategoriesID])\n"
                + "           ,[Image])"
                + "     VALUES\n"
                + "           (?\n"
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
            preState.setString(1, medical.getName());
            preState.setDouble(2, medical.getPrice());
            preState.setDouble(3, medical.getQuantity());
            preState.setString(4, medical.getDescription());
            preState.setString(5, medical.getMfgDate());
            preState.setString(6, medical.getExpDate());
            preState.setInt(7, medical.getCategoriesID());
            preState.setString(8, medical.getImage());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOMedicalProducts.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int deleteMedicalProducts(int MedicationID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[MedicalProducts]\n"
                + "      WHERE MedicationID = " + MedicationID + "";

        Statement state;

        try {
            state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOMedicalProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateMedicalProducts(MedicalProducts medical) {
        int n = 0;
        String sql = "UPDATE [dbo].[MedicalProducts]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Price] = ?\n"
                + "      ,[Quantity] = ?\n"
                + "      ,[Description] = ?\n"
                + "      ,[MfgDate] = ?\n"
                + "      ,[ExpDate] = ?\n"
                + "      ,[CategoriesID] = ?\n"
                + "      ,[Image] = ?\n"
                + " WHERE MedicationID = ?";

        PreparedStatement preState;

        try {
            preState = conn.prepareStatement(sql);
            preState.setString(1, medical.getName());
            preState.setDouble(2, medical.getPrice());
            preState.setDouble(3, medical.getQuantity());
            preState.setString(4, medical.getDescription());
            preState.setString(5, medical.getMfgDate());
            preState.setString(6, medical.getExpDate());
            preState.setInt(7, medical.getCategoriesID());
            preState.setString(8, medical.getImage());
            preState.setInt(9, medical.getMedicationID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOMedicalProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<MedicalProducts> getMedicalProducts(String sql) {
        Vector<MedicalProducts> vector = new Vector<MedicalProducts>();

        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet re = state.executeQuery(sql);
            while (re.next()) {
                int MedicationID = re.getInt("MedicationID");
                String Name = re.getString("Name");
                double Price = re.getDouble("Price");
                double Quantity = re.getDouble("Quantity");
                String Description = re.getString("Description");
                String MfgDate = re.getString("MfgDate");
                String ExpDate = re.getString("ExpDate");;
                int CategoriesID = re.getInt("CategoriesID");
                String Image = re.getString("Image");
                
                MedicalProducts medical = new MedicalProducts(MedicationID, Name, Price, Quantity, Description, MfgDate, ExpDate, CategoriesID, Image);
                vector.add(medical);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOMedicalProducts.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public static void main(String[] args) {
        DAOMedicalProducts dao = new DAOMedicalProducts();
        Vector<MedicalProducts> vector = dao.getMedicalProducts("select * from MedicalProducts");
        for (MedicalProducts medical : vector){
            System.out.println(medical);
            medical.getName();
        }
        
    }

}
