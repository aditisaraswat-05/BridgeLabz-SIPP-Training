package Java_Generics;

import java.util.*;

// Abstract class for different job roles
abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract String getRoleName();

    public abstract List<String> getRequiredSkills();
}

// Software Engineer Role
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name) {
        super(name);
    }

    @Override
    public String getRoleName() {
        return "Software Engineer";
    }

    @Override
    public List<String> getRequiredSkills() {
        return Arrays.asList("Java", "Data Structures", "OOP");
    }
}

// Data Scientist Role
class DataScientist extends JobRole {
    public DataScientist(String name) {
        super(name);
    }

    @Override
    public String getRoleName() {
        return "Data Scientist";
    }

    @Override
    public List<String> getRequiredSkills() {
        return Arrays.asList("Python", "Machine Learning", "Statistics");
    }
}

// Product Manager Role
class ProductManager extends JobRole {
    public ProductManager(String name) {
        super(name);
    }

    @Override
    public String getRoleName() {
        return "Product Manager";
    }

    @Override
    public List<String> getRequiredSkills() {
        return Arrays.asList("Communication", "Leadership", "Product Thinking");
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void printResume() {
        System.out.println("Candidate: " + jobRole.getCandidateName());
        System.out.println("Applying for: " + jobRole.getRoleName());
        System.out.println("Required Skills: " + jobRole.getRequiredSkills());
    }
}

// Screening utility with wildcard
class ScreeningUtil {
    public static void screenResumes(List<? extends JobRole> resumes) {
        System.out.println("Screening Resumes...");
        for (JobRole role : resumes) {
            System.out.println("Candidate: " + role.getCandidateName());
            System.out.println("Role: " + role.getRoleName());
            System.out.println("Skills Needed: " + role.getRequiredSkills());
            System.out.println();
        }
    }
}

// Main class
public class ResumeSystem {
    public static void main(String[] args) {
        List<Resume<? extends JobRole>> allResumes = new ArrayList<>();

        Resume<SoftwareEngineer> r1 = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> r2 = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> r3 = new Resume<>(new ProductManager("Charlie"));

        // Collecting job roles into one list for screening
        List<JobRole> jobRoleList = new ArrayList<>();
        jobRoleList.add(r1.getJobRole());
        jobRoleList.add(r2.getJobRole());
        jobRoleList.add(r3.getJobRole());

        // Screening resumes
        ScreeningUtil.screenResumes(jobRoleList);
    }
}

// 5. AI-Driven Resume Screening System
// Concepts: Generic Classes, Generic Methods, Bounded Type Parameters,
// Wildcards
// Problem Statement:
// Develop an AI-Driven Resume Screening System that can process resumes for
// different job roles like Software Engineer, Data Scientist, and Product
// Manager while ensuring type safety.
// Hints:
// Create an abstract class JobRole (SoftwareEngineer, DataScientist,
// ProductManager).
// Implement a generic class Resume<T extends JobRole> to process resumes
// dynamically.
// Use a wildcard method (List<? extends JobRole>) to handle multiple job roles
// in the screening pipeline.
