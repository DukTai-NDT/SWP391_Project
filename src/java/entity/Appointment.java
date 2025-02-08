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
public class Appointment {
    private int AppointmentID;
	private Date Date;
	private String Time;
	private int DoctorID;
	private int StaffID;
	private int PatientID;
	private boolean IsConfirm;

    public Appointment(int AppointmentID, Date Date, String Time, int DoctorID, int StaffID, int PatientID, boolean IsConfirm) {
        this.AppointmentID = AppointmentID;
        this.Date = Date;
        this.Time = Time;
        this.DoctorID = DoctorID;
        this.StaffID = StaffID;
        this.PatientID = PatientID;
        this.IsConfirm = IsConfirm;
    }

    public Appointment(Date Date, String Time, int DoctorID, int StaffID, int PatientID, boolean IsConfirm) {
        this.Date = Date;
        this.Time = Time;
        this.DoctorID = DoctorID;
        this.StaffID = StaffID;
        this.PatientID = PatientID;
        this.IsConfirm = IsConfirm;
    }

    public Appointment() {
    }

    public int getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(int AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int DoctorID) {
        this.DoctorID = DoctorID;
    }

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public boolean isIsConfirm() {
        return IsConfirm;
    }

    public void setIsConfirm(boolean IsConfirm) {
        this.IsConfirm = IsConfirm;
    }

    @Override
    public String toString() {
        return "Appointment{" + "AppointmentID=" + AppointmentID + ", Date=" + Date + ", Time=" + Time + ", DoctorID=" + DoctorID + ", StaffID=" + StaffID + ", PatientID=" + PatientID + ", IsConfirm=" + IsConfirm + '}';
    }
                
                
                
}
