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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOAccount extends DBConnection {

    public int addAccount(Account other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Account]([Username],[RoleID],[Password])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
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

    public int deleteAccount(int AccountID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Account]\n"
                + "      WHERE Account.AccountID = " + AccountID;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateAccount(Account other) {
        int n = 0;
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [Username] = ?\n"
                + "      ,[RoleID] = ?\n"
                + "      ,[Password] = ?\n"
                + " WHERE Account.AccountID = ?";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getUserName());
            preState.setInt(2, other.getRoleID());
            preState.setString(3, other.getPassword());
            preState.setInt(4,other.getAccountID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;

    }
    
    public Vector<Account> getAccount(String sql){
        Vector<Account> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
              int AccountID = rs.getInt("AccountID");
              String UserName = rs.getString("UserName");
              int RoleID = rs.getInt("RoleID");
              String Password = rs.getString("Password");
              Account account = new Account(AccountID, UserName, RoleID, Password);
              vector.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vector;
    } 
    public static void main(String[] args) {
        DAOAccount dao = new DAOAccount();
        Account accountAdd = new Account("Tainguyenduc", 2, "abcd123");
        int n = dao.addAccount(accountAdd);
        
//    int n = dao.deleteAccount(1);

//          Account accountUpdate = new Account(2, "TaiNguye", 1, "cde123");
//          int n = dao.updateAccount(accountUpdate);
          
//        System.out.println(n);

        Vector<Account> vector = dao.getAccount("SELECT *  FROM [dbo].[Account] ");
        for (Account account : vector) {
            System.out.println(account);
        }
    }
}
