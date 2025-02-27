/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Cart;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class DAOCart extends DBConnection {

    public Cart getCart(int pid) {
        Cart cart = null;
        String sql = "select MedicationID, Name, Price\n"
                + "from MedicalProducts \n"
                + "where MedicationID = " + pid;
        ResultSet rs;
        try {
            rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) {
                cart = new Cart(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                        0, 0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCart.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cart;
    }
}
