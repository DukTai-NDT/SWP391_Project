/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Account;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class DAOAccount extends DBConnection{
    public int addAccount(Account other){
        int n = 0;
        String sql = "INSERT INTO [dbo].[Account]([Username],[RoleID],[Password])\n" +
"     VALUES\n" +
"           (?,?,?)";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getUserName());
            preState.setInt(2, other.getRoleID());
            preState.setString(3, other.getPassword());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
   
}
