import java.util.Scanner;

class GradesCalculator {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numSubjects = getNumberOfSubjects(scanner);

            if (numSubjects <= 0) {
                System.out.println("Invalid number of subjects. Exiting program.");
                return;
            }

            int totalMarks = calculateTotalMarks(scanner, numSubjects);
            scanner.close();

            double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

            displayResults(totalMarks, averagePercentage);
        }
    }

    private static int getNumberOfSubjects(Scanner scanner) {
        System.out.println("Enter the number of subjects:");
        return scanner.nextInt();
    }

    private static int calculateTotalMarks(Scanner scanner, int numSubjects) {
        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100. Exiting program.");
                System.exit(0);
            }

            totalMarks += marks;
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    private static void displayResults(int totalMarks, double averagePercentage) {
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);

        char grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
