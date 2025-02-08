/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Doctor {

    private int DoctorID;
    private String FirstName;
    private String LastName;
    private String Phone;
    private String Email;
    private String Gender;
    private int DepartmentID;
    private String Bio;
    private int AccountID;

    public Doctor(int DoctorID, String FirstName, String LastName, String Phone, String Email, String Gender, int DepartmentID, String Bio, int AccountID) {
        this.DoctorID = DoctorID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Gender = Gender;
        this.DepartmentID = DepartmentID;
        this.Bio = Bio;
        this.AccountID = AccountID;
    }

    public Doctor(String FirstName, String LastName, String Phone, String Email, String Gender, int DepartmentID, String Bio, int AccountID) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Gender = Gender;
        this.DepartmentID = DepartmentID;
        this.Bio = Bio;
        this.AccountID = AccountID;
    }

    public Doctor() {
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int DoctorID) {
        this.DoctorID = DoctorID;
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

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String Bio) {
        this.Bio = Bio;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    @Override
    public String toString() {
        return "Doctor{" + "DoctorID=" + DoctorID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Phone=" + Phone + ", Email=" + Email + ", Gender=" + Gender + ", DepartmentID=" + DepartmentID + ", Bio=" + Bio + ", RoleID=" + AccountID + '}';
    }

}
