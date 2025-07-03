package EncapsulationPolymorphismInterfaceAndAbstractClass_OOPS;

import java.util.*;

// MedicalRecord interface
interface MedicalRecord {
    void addRecord(String record);

    void viewRecords();
}

// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    private List<String> medicalHistory;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    // Getters (Encapsulation)
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    protected List<String> getMedicalHistory() {
        return medicalHistory;
    }

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + (diagnosis != null ? diagnosis : "Not Diagnosed"));
    }

    // Abstract method
    public abstract double calculateBill();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int daysAdmitted, double dailyCharge) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    public void addRecord(String record) {
        getMedicalHistory().add(record);
        System.out.println("InPatient Record Added: " + record);
    }

    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private int consultations;
    private double consultationFee;

    public OutPatient(int id, String name, int age, int consultations, double consultationFee) {
        super(id, name, age);
        this.consultations = consultations;
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultations * consultationFee;
    }

    public void addRecord(String record) {
        getMedicalHistory().add(record);
        System.out.println("OutPatient Record Added: " + record);
    }

    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// Main class
public class HospitalPatientManagement {
    // Polymorphic processing
    public static void processPatients(List<Patient> patientList) {
        for (Patient p : patientList) {
            System.out.println("\n--- Patient Details ---");
            p.getPatientDetails();
            System.out.printf("Total Bill: ₹%.2f\n", p.calculateBill());

            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }
        }
    }

    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient in1 = new InPatient(101, "Aditi", 30, 5, 2000);
        in1.setDiagnosis("Pneumonia");
        in1.addRecord("Admitted to Ward A");
        in1.addRecord("Antibiotic Treatment");

        OutPatient out1 = new OutPatient(102, "Rohan", 25, 2, 500);
        out1.setDiagnosis("Fever");
        out1.addRecord("Prescribed Paracetamol");
        out1.addRecord("Follow-up in 1 week");

        patients.add(in1);
        patients.add(out1);

        processPatients(patients);
    }
}

// Hospital Patient Management
// Description: Design a system to manage patients in a hospital:
// Create an abstract class Patient with fields like patientId, name, and age.
// Add an abstract method calculateBill() and a concrete method
// getPatientDetails().
// Extend it into subclasses InPatient and OutPatient, implementing
// calculateBill() with different billing logic.
// Implement an interface MedicalRecord with methods addRecord() and
// viewRecords().
// Use encapsulation to protect sensitive patient data like diagnosis and
// medical history.
// Use polymorphism to handle different patient types and display their billing
// details dynamically.
