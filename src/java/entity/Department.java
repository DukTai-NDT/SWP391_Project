/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Department {
    private int DepartmentID;
	private String DepartmentName;

    public Department(int DepartmentID, String DepartmentName) {
        this.DepartmentID = DepartmentID;
        this.DepartmentName = DepartmentName;
    }

    public Department(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public Department() {
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    @Override
    public String toString() {
        return "Department{" + "DepartmentID=" + DepartmentID + ", DepartmentName=" + DepartmentName + '}';
    }
        
        
}
