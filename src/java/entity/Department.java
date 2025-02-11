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
        private String Description;
        private String Icon;

    public Department(int DepartmentID, String DepartmentName, String Description,String Icon) {
        this.DepartmentID = DepartmentID;
        this.DepartmentName = DepartmentName;
        this.Description = Description;
        this.Icon = Icon;
    }

    public Department(String DepartmentName, String Description,String Icon) {
        this.DepartmentName = DepartmentName;
        this.Description = Description;
        this.Icon = Icon;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String Icon) {
        this.Icon = Icon;
    }

    @Override
    public String toString() {
        return "Department{" + "DepartmentID=" + DepartmentID + ", DepartmentName=" + DepartmentName + ", Description=" + Description + ", Icon=" + Icon + '}';
    }
    
    
    
    
        
        
}
