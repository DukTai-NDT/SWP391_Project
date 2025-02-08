/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Invoice {
    private int InvoiceID;
	private int PatientID;
	private double Amount;
	private double Total;

    public Invoice(int InvoiceID, int PatientID, double Amount, double Total) {
        this.InvoiceID = InvoiceID;
        this.PatientID = PatientID;
        this.Amount = Amount;
        this.Total = Total;
    }

    public Invoice(int PatientID, double Amount, double Total) {
        this.PatientID = PatientID;
        this.Amount = Amount;
        this.Total = Total;
    }

    public Invoice() {
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    @Override
    public String toString() {
        return "Invoice{" + "InvoiceID=" + InvoiceID + ", PatientID=" + PatientID + ", Amount=" + Amount + ", Total=" + Total + '}';
    }
        
        
}
