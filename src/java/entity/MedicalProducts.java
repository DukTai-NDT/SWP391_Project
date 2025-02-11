/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class MedicalProducts {
    private int MedicationID;
	private String Name;
	private double Price;
	private double Quantity;
	private String Description;
	private String MfgDate;
	private String ExpDate;
	private int CategoriesID;
        private String Image;

    public MedicalProducts(int MedicationID, String Name, double Price, double Quantity, String Description, String MfgDate, String ExpDate, int CategoriesID, String Image) {
        this.MedicationID = MedicationID;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Description = Description;
        this.MfgDate = MfgDate;
        this.ExpDate = ExpDate;
        this.CategoriesID = CategoriesID;
        this.Image = Image;
    }

    public MedicalProducts(String Name, double Price, double Quantity, String Description, String MfgDate, String ExpDate, int CategoriesID, String Image) {
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Description = Description;
        this.MfgDate = MfgDate;
        this.ExpDate = ExpDate;
        this.CategoriesID = CategoriesID;
        this.Image = Image;
    }

    public MedicalProducts() {
    }

    public int getMedicationID() {
        return MedicationID;
    }

    public void setMedicationID(int MedicationID) {
        this.MedicationID = MedicationID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getMfgDate() {
        return MfgDate;
    }

    public void setMfgDate(String MfgDate) {
        this.MfgDate = MfgDate;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String ExpDate) {
        this.ExpDate = ExpDate;
    }

    public int getCategoriesID() {
        return CategoriesID;
    }

    public void setCategoriesID(int CategoriesID) {
        this.CategoriesID = CategoriesID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    

    @Override
    public String toString() {
        return "MedicalProducts{" + "MedicationID=" + MedicationID + ", Name=" + Name + ", Price=" + Price + ", Quantity=" + Quantity + ", Description=" + Description + ", MfgDate=" + MfgDate + ", ExpDate=" + ExpDate + ", CategoriesID=" + CategoriesID + '}';
    }
        
        
}
