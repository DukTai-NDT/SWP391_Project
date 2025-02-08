/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class InvoiceDetail {
    private int InvoiceDetailID;
	private int Quantity;
	private double ProductPrice;
	private double TreatmentPrice;
	private double Total;
	private int InvoiceID;
	private int MedicationID;

    public InvoiceDetail(int InvoiceDetailID, int Quantity, double ProductPrice, double TreatmentPrice, double Total, int InvoiceID, int MedicationID) {
        this.InvoiceDetailID = InvoiceDetailID;
        this.Quantity = Quantity;
        this.ProductPrice = ProductPrice;
        this.TreatmentPrice = TreatmentPrice;
        this.Total = Total;
        this.InvoiceID = InvoiceID;
        this.MedicationID = MedicationID;
    }

    public InvoiceDetail(int Quantity, double ProductPrice, double TreatmentPrice, double Total, int InvoiceID, int MedicationID) {
        this.Quantity = Quantity;
        this.ProductPrice = ProductPrice;
        this.TreatmentPrice = TreatmentPrice;
        this.Total = Total;
        this.InvoiceID = InvoiceID;
        this.MedicationID = MedicationID;
    }

    public InvoiceDetail() {
    }

    public int getInvoiceDetailID() {
        return InvoiceDetailID;
    }

    public void setInvoiceDetailID(int InvoiceDetailID) {
        this.InvoiceDetailID = InvoiceDetailID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public double getTreatmentPrice() {
        return TreatmentPrice;
    }

    public void setTreatmentPrice(double TreatmentPrice) {
        this.TreatmentPrice = TreatmentPrice;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    public int getMedicationID() {
        return MedicationID;
    }

    public void setMedicationID(int MedicationID) {
        this.MedicationID = MedicationID;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" + "InvoiceDetailID=" + InvoiceDetailID + ", Quantity=" + Quantity + ", ProductPrice=" + ProductPrice + ", TreatmentPrice=" + TreatmentPrice + ", Total=" + Total + ", InvoiceID=" + InvoiceID + ", MedicationID=" + MedicationID + '}';
    }
        
        
}
