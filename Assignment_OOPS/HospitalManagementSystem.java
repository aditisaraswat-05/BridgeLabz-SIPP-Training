package Assignment_OOPS;

public class HospitalManagementSystem {

    // Patient class definition
    static class Patient {
        // Static variable shared by all patients
        static String hospitalName = "City Care Hospital";

        // Static variable to count total patients
        static int totalPatients = 0;

        // aStatic method to get total patients admitted
        static void getTotalPatients() {
            System.out.println("Total Patients Admitted: " + totalPatients);
        }

        // Instance variables
        private String name;
        private int age;
        private String ailment;
        private final String patientID; // Final: unique and cannot be changed

        // Constructor using 'this' to initialize values
        public Patient(String name, int age, String ailment, String patientID) {
            this.name = name;
            this.age = age;
            this.ailment = ailment;
            this.patientID = patientID;
            totalPatients++;
        }

        // Method to display patient details using instanceof
        public void displayDetails() {
            if (this instanceof Patient) {
                System.out.println("Patient Name   : " + name);
                System.out.println("Age            : " + age);
                System.out.println("Ailment        : " + ailment);
                System.out.println("Patient ID     : " + patientID);
                System.out.println("Hospital Name  : " + hospitalName);
            } else {
                System.out.println("Object is not a valid Patient.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Creating Patient objects
        Patient p1 = new Patient("Sana Ali", 32, "Flu", "P001");
        Patient p2 = new Patient("Rohan Mehra", 45, "Diabetes", "P002");

        // Display details of each patient
        System.out.println("\nPatient 1 Details:");
        p1.displayDetails();

        System.out.println("\nPatient 2 Details:");
        p2.displayDetails();

        // Show total number of patients
        System.out.println();
        Patient.getTotalPatients();

        // instanceof check with an invalid object
        Object fakePatient = new String("Not a real patient");
        if (fakePatient instanceof Patient) {
            ((Patient) fakePatient).displayDetails();
        } else {
            System.out.println("\nObject is not an instance of Patient.");
        }
    }
}

// Sample Program 7: Hospital Management System
// Create a Patient class with the following features:
// Static:
// ○ A static variable hospitalName shared among all patients.
// ○ A static method getTotalPatients() to count the total patients admitted.
// This:
// ○ Use this to initialize name, age, and ailment in the constructor.
// Final:
// ○ Use a final variable patientID to uniquely identify each patient.
// Instanceof:
// ○ Check if an object is an instance of the Patient class before displaying
// its details.
