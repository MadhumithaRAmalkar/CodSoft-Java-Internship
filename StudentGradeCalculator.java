import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            // Ask the user for the number of subjects
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            // Array to store the marks for each subject
            int[] marks = new int[numSubjects];

            // Get the marks for each subject from the user
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                marks[i] = scanner.nextInt();
            }

            // Calculate the total marks
            int totalMarks = 0;
            for (int mark : marks) {
                totalMarks += mark;
            }

            // Calculate the average percentage
            double averagePercentage = (double) totalMarks / numSubjects;

            // Determine the grade based on the average percentage
            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // Display the results to the user
            System.out.println("\n--- Results ---");
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);

            // Close the scanner
            scanner.close();
        }
    }


