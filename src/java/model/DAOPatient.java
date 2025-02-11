package model;

import entity.Patient;
import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPatient extends DBConnection {

    public int addPatient(Patient other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Patient] "
                + "([FirstName], [LastName], [Phone], [Email], [Age], [Gender], [Height], [Weight], [AccountID], [Birthday], [Address]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getFirstName());
            preState.setString(2, other.getLastName());
            preState.setString(3, other.getPhone());
            preState.setString(4, other.getEmail());
            preState.setInt(5, other.getAge());
            preState.setString(6, other.getGender());
            preState.setDouble(7, other.getHeight());
            preState.setDouble(8, other.getWeight());
            preState.setInt(9, other.getAccountID());
            preState.setDate(10, Date.valueOf(other.getBirthday())); 
            preState.setString(11, other.getAddress());

            n = preState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deletePatient(int PatientID) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Patient] WHERE PatientID = ?";
        
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setInt(1, PatientID);
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPatient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updatePatient(Patient patient) {
        int n = 0;
        String sql = "UPDATE [dbo].[Patient] SET "
                + "FirstName = ?, LastName = ?, Phone = ?, Email = ?, Age = ?, Gender = ?, "
                + "Height = ?, Weight = ?, Birthday = ?, Address = ? "
                + "WHERE PatientID = ?";

        if (conn == null) {
            System.out.println("Database connection is null!");
            return 0;
        }

        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, patient.getFirstName());
            preState.setString(2, patient.getLastName());
            preState.setString(3, patient.getPhone());
            preState.setString(4, patient.getEmail());
            preState.setInt(5, patient.getAge());
            preState.setString(6, patient.getGender());
            preState.setDouble(7, patient.getHeight());
            preState.setDouble(8, patient.getWeight());
            preState.setDate(9, Date.valueOf(patient.getBirthday())); 
            preState.setString(10, patient.getAddress());
            preState.setInt(11, patient.getPatientID());

            System.out.println("Executing Update: " + preState.toString()); 

            n = preState.executeUpdate();

            if (n > 0) {
                System.out.println("Update successful!");
            } else {
                System.out.println("Update failed! No patient found with ID " + patient.getPatientID());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQL Error: " + ex.getMessage());
        }

        return n;
    }

    public Vector<Patient> getPatient(String sql) {
        Vector<Patient> vector = new Vector<>();

        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet re = state.executeQuery(sql);
            while (re.next()) {
                int PatientID = re.getInt("PatientID");
                String FirstName = re.getString("FirstName");
                String LastName = re.getString("LastName");
                String Phone = re.getString("Phone");
                String Email = re.getString("Email");
                int Age = re.getInt("Age");
                String Gender = re.getString("Gender");
                Double Height = re.getDouble("Height");
                Double Weight = re.getDouble("Weight");
                int AccountID = re.getInt("AccountID");
                LocalDate Birthday = re.getDate("Birthday").toLocalDate(); 
                String Address = re.getString("Address");

                Patient patient = new Patient(PatientID, FirstName, LastName, Phone, Email, Age, Gender, Height, Weight, AccountID, Birthday, Address, "");
                vector.add(patient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPatient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOPatient dao = new DAOPatient();

        // Kiểm thử cập nhật Patient có ID = 16
        int x = dao.updatePatient(new Patient(16, "Nguyen", "Ba Quang", "1234", "bok@gmail.com",
                12, "MALE", 190, 80, 1, LocalDate.of(2012, 5, 20), "Hanoi", "This is my bio."));

        if (x > 0) {
            System.out.println("Update successful!");
        } else {
            System.out.println("Update failed!");
        }
    }
}
