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
public class Payment {
    private int PaymentID;
	private int InvoiceID;
	private String PaymentMethod;
	private String PaymentStatus;
	private Date PaymentDate;

    public Payment(int PaymentID, int InvoiceID, String PaymentMethod, String PaymentStatus, Date PaymentDate) {
        this.PaymentID = PaymentID;
        this.InvoiceID = InvoiceID;
        this.PaymentMethod = PaymentMethod;
        this.PaymentStatus = PaymentStatus;
        this.PaymentDate = PaymentDate;
    }

    public Payment(int InvoiceID, String PaymentMethod, String PaymentStatus, Date PaymentDate) {
        this.InvoiceID = InvoiceID;
        this.PaymentMethod = PaymentMethod;
        this.PaymentStatus = PaymentStatus;
        this.PaymentDate = PaymentDate;
    }

    public Payment() {
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Date PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" + "PaymentID=" + PaymentID + ", InvoiceID=" + InvoiceID + ", PaymentMethod=" + PaymentMethod + ", PaymentStatus=" + PaymentStatus + ", PaymentDate=" + PaymentDate + '}';
    }
        
        
}
