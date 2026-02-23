import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Entity: Patient
class Patient {
    private int id;
    private String name;
    private int age;
    private String illness;
    private String recoveryStatus; // "recovered or not" 

    public Patient(int id, String name, int age, String illness, String recoveryStatus) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.recoveryStatus = recoveryStatus;
    }

    public int getId() { return id; }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Illness: " + illness + " | Status: " + recoveryStatus;
    }
}

// Entity: Doctor
class Doctor {
    private int id;
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Specialization: " + specialization;
    }
}

public class HospitalManagementSystem {

    private static List<Patient> patients = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- HOSPITAL MANAGEMENT SYSTEM ---");
        
        while (true) {
            System.out.println("\n1. Add Patient Details ");
            System.out.println("2. Display List of Patients");
            System.out.println("3. Delete Patient by ID ");
            System.out.println("4. Add Doctor Details");
            System.out.println("5. Display Doctors");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    displayPatients();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    addDoctor();
                    break;
                case 5:
                    displayDoctors();
                    break;
                case 6:
                    System.out.println("Exiting System.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Module: addPatientDetails 
    private static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Illness: ");
        String illness = scanner.next();
        System.out.print("Is patient recovered? (Yes/No): ");
        String status = scanner.next();

        patients.add(new Patient(id, name, age, illness, status));
        System.out.println("Patient added successfully.");
    }

    // Module: Display list of patients 
    private static void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No records found.");
        } else {
            System.out.println("\n--- Patient Records ---");
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }

    // Module: delete patients by id 
    private static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = patients.removeIf(p -> p.getId() == id);
        if (removed) {
            System.out.println("Patient record deleted.");
        } else {
            System.out.println("Patient ID not found.");
        }
    }

    // Module: Add doctor details
    private static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Doctor Name: ");
        String name = scanner.next();
        System.out.print("Enter Specialization: ");
        String spec = scanner.next();
        
        doctors.add(new Doctor(id, name, spec));
        System.out.println("Doctor added successfully.");
    }

    // Module: Display doctor details
    private static void displayDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered.");
        } else {
            System.out.println("\n--- Doctor Records ---");
            for (Doctor d : doctors) {
                System.out.println(d);
            }
        }
    }
}
