/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Account {

    private int AccountID;
    private String UserName;
    private int RoleID;
    private String Password;

    public Account(int AccountID, String UserName, int RoleID, String Password) {
        this.AccountID = AccountID;
        this.UserName = UserName;
        this.RoleID = RoleID;
        this.Password = Password;
    }

    public Account(String UserName, int RoleID, String Password) {
        this.UserName = UserName;
        this.RoleID = RoleID;
        this.Password = Password;
    }

    public Account() {
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

   

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Account{" + "AccountID=" + AccountID + ", UserName=" + UserName + ", RoleID=" + RoleID + ", Password=" + Password + '}';
    }

   

}
