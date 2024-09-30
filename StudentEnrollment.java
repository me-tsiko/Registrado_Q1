import java.util.Scanner;

public class StudentEnrollment {

    // Method to compute total enrollment fee
    public static double computeFee(int totalUnits, double feePerUnit) {
        return totalUnits * feePerUnit;
    }

    // Main method to handle input and output
    public static void main(String[] args) {
        // Constants
        final int MAX_SUBJECTS = 10;
        final double FEE_PER_UNIT = 1000.0;
        
        // Variables
        String studentName;
        String course;
        String courseCode;
        int numSubjects;
        int[] units = new int[MAX_SUBJECTS];
        int totalUnits = 0;
        double totalFee;
        double payment;
        
        // Scanner for input
        Scanner input = new Scanner(System.in);
        
        // Input student details
        System.out.println("Enter student's name: ");
        studentName = input.nextLine();
        
        System.out.println("Enter course: ");
        course = input.nextLine();
        
        System.out.println("Enter course code: ");
        courseCode = input.nextLine();
        
        // Input number of subjects
        System.out.println("Enter number of subjects (maximum 10): ");
        numSubjects = input.nextInt();
        
        if (numSubjects > MAX_SUBJECTS) {
            System.out.println("Error: Maximum number of subjects is 10.");
            return;
        }

        // Input units for each subject and compute total units
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter number of units for subject " + (i + 1) + ": ");
            units[i] = input.nextInt();
            totalUnits += units[i];  // Accumulate total units
        }
        
        // Compute total fee
        totalFee = computeFee(totalUnits, FEE_PER_UNIT);
        
        // Display student name and total fee
        System.out.println("\nStudent's Name: " + studentName);
        System.out.println("Total Enrollment Fee: " + totalFee);
        
        // Ask for payment amount
        System.out.println("Enter payment amount: ");
        payment = input.nextDouble();
        
        // Check payment status and display the appropriate message
        if (payment == totalFee) {
            System.out.println("Fully Paid");
        } else if (payment < totalFee) {
            System.out.println("Partial Payment: " + payment);
        } else {
            System.out.println("Overpaid. Refund: " + (payment - totalFee));
        }
        
        // Close scanner
        input.close();
    }
}