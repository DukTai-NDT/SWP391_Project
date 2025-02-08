/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class HeathHistory {
    private int PatientID;
	private String Disease;

    public HeathHistory(int PatientID, String Disease) {
        this.PatientID = PatientID;
        this.Disease = Disease;
    }

    public HeathHistory() {
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String Disease) {
        this.Disease = Disease;
    }

    @Override
    public String toString() {
        return "HeathHistory{" + "PatientID=" + PatientID + ", Disease=" + Disease + '}';
    }
        
        

}
