/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAODepartment extends DBConnection {

    public int addDepartment(Department other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Department] ([DepartmentName])\n"
                + "VALUES(?)";

        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getDepartmentName());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteDepartment(String DepartmentName) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Department]\n"
                + "      WHERE Department.DepartmentName like '"+DepartmentName+"'";

        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateDepartment(Department other) {
        int n = 0;
        String sql = "UPDATE [dbo].[Department]\n"
                + "   SET [DepartmentName] = ?\n"
                + " WHERE Department.DepartmentID = ?";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getDepartmentName());
            preState.setInt(2, other.getDepartmentID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Department> getDepartment(String sql) {
        Vector<Department> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int DepartmentID = rs.getInt("DepartmentID");
                String DepartmentName = rs.getString("DepartmentName");
                Department department = new Department(DepartmentID, DepartmentName);
                vector.add(department);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
     public static void main(String[] args) {
        DAODepartment dao = new DAODepartment();

//        Department departAdd = new Department("NhaKhoa");
//        int n = dao.addDepartment(departAdd);

//        Department departUpdate = new Department(2, "KhoaNoi");
//        int n = dao.updateDepartment(departUpdate);

//        int n = dao.deleteDepartment("khoanoi");
//        System.out.println(n);

        Vector<Department> vector = dao.getDepartment("select * from Department");
        for (Department department : vector) {
            System.out.println(department);
            
        }
    }
}
