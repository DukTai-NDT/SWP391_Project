/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Patient {
    private int PatientID;
	private String FirstName;
	private String LastName;
	private String Phone;
	private String Email;
	private int Age;
	private double Height;
	private double Weight;
	private int RoleID;

    public Patient(int PatientID, String FirstName, String LastName, String Phone, String Email, int Age, double Height, double Weight, int RoleID) {
        this.PatientID = PatientID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Age = Age;
        this.Height = Height;
        this.Weight = Weight;
        this.RoleID = RoleID;
    }

    public Patient(String FirstName, String LastName, String Phone, String Email, int Age, double Height, double Weight, int RoleID) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Age = Age;
        this.Height = Height;
        this.Weight = Weight;
        this.RoleID = RoleID;
    }

    public Patient() {
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double Height) {
        this.Height = Height;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double Weight) {
        this.Weight = Weight;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    @Override
    public String toString() {
        return "Patient{" + "PatientID=" + PatientID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Phone=" + Phone + ", Email=" + Email + ", Age=" + Age + ", Height=" + Height + ", Weight=" + Weight + ", RoleID=" + RoleID + '}';
    }
        
        
}
