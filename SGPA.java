import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int numSubjects;

    void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter the number of subjects: ");
        numSubjects = sc.nextInt();
        
        credits = new int[numSubjects];
        marks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Subjects and Credits:");

        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }

        System.out.println("SGPA: " + calculateSGPA());
    }

    double calculateSGPA() {
        int totalCredits = 0;
        double weightedGradePoints = 0.0;

        for (int i = 0; i < numSubjects; i++) {
            int gradePoints = calculateGradePoints(marks[i]);
            weightedGradePoints += gradePoints * credits[i];
            totalCredits += credits[i];
        }

        return weightedGradePoints / totalCredits;
    }

    int calculateGradePoints(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 45) return 5;
        else if (marks >= 40) return 4;
        else return 0;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.acceptDetails();
        student.displayDetails();
    }
}
