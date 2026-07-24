import java.util.Scanner;

public class Marks {

    // first I decided to create static variables so all the methods can access them easily
    static int n; // number of students
    static int[][] marks; // rows = students, columns = 3 subjects - initalisng -  with 2D array
    static String[] subjects = {"Mathematics", "Chemistry", "Physics"}; // asigning
    static Scanner input = new Scanner(System.in); // to take user inputs

    public static void main(String[] args) {

        System.out.print("Enter the number of students: ");
        n = input.nextInt();
        input.nextLine(); // clearing the leftover newline from nextInt()

        // creating the 2D array, all marks start as 0
        marks = new int[n][3];

        System.out.println("\n===== Student Marks Management System =====");
        printMenu();

        boolean running = true;

        // main loop keeps running until the user types exit
        while (running) {
            System.out.print("\nEnter command: ");
            String[] parts = input.nextLine().trim().split(" ");

            switch (parts[0]) {
                case "add":
                    addMarks(parts);
                    break;
                case "update":
                    updateMark(parts);
                    break;
                case "average_s":
                    subjectAverage(parts);
                    break;
                case "average":
                    studentAverage(parts);
                    break;
                case "total":
                    studentTotal(parts);
                    break;
                case "grades":
                    showGrades();
                    break;
                case "menu":
                    printMenu();
                    break;
                case "exit":
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command! Type menu to see all commands.");
            }
        }
    }

    // shows all the commands the user can type
    static void printMenu() {
        System.out.println("Commands:");
        System.out.println("  add [studentID]                 - add marks for a student");
        System.out.println("  update [studentID] [subjectID]  - update one mark of a student");
        System.out.println("  average_s [subjectID]           - average mark of a subject");
        System.out.println("  average [studentID]             - average mark of a student");
        System.out.println("  total [studentID]               - total mark of a student");
        System.out.println("  grades                          - grade summary of all students");
        System.out.println("  menu                            - show this menu again");
        System.out.println("  exit                            - close the program");
    }

    // checks if the student ID is inside the valid range (1 to n)
    static boolean isValidStudent(int studentID) {
        if (studentID < 1 || studentID > n) {
            System.out.println("Invalid student ID! It must be between 1 and " + n);
            return false;
        }
        return true;
    }

    // checks if the subject ID is inside the valid range (1 to 3)
    static boolean isValidSubject(int subjectID) {
        if (subjectID < 1 || subjectID > 3) {
            System.out.println("Invalid subject ID! It must be between 1 and 3");
            return false;
        }
        return true;
    }

    // add command - enter marks for all 3 subjects of one student
    static void addMarks(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: add [studentID]");
            return;
        }
        int studentID = Integer.parseInt(parts[1]);
        if (!isValidStudent(studentID)) {
            return;
        }

        System.out.println("Entering marks for student " + studentID);
        for (int j = 0; j < 3; j++) {
            System.out.print("Enter " + subjects[j] + " mark: ");
            marks[studentID - 1][j] = input.nextInt();
        }
        input.nextLine(); // clearing the leftover newline
        System.out.println("Marks added successfully for student " + studentID);
    }

    // update command - change one subject mark of a student
    static void updateMark(String[] parts) {
        if (parts.length < 3) {
            System.out.println("Usage: update [studentID] [subjectID]");
            return;
        }
        int studentID = Integer.parseInt(parts[1]);
        int subjectID = Integer.parseInt(parts[2]);
        if (!isValidStudent(studentID) || !isValidSubject(subjectID)) {
            return;
        }

        System.out.print("Enter the new " + subjects[subjectID - 1] + " mark for student " + studentID + ": ");
        marks[studentID - 1][subjectID - 1] = input.nextInt();
        input.nextLine(); // clearing the leftover newline
        System.out.println("Mark updated successfully.");
    }

    // average_s command - average of one subject across all students
    static void subjectAverage(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: average_s [subjectID]");
            return;
        }
        int subjectID = Integer.parseInt(parts[1]);
        if (!isValidSubject(subjectID)) {
            return;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += marks[i][subjectID - 1];
        }
        double average = (double) sum / n;
        System.out.printf("Average mark for %s = %.2f\n", subjects[subjectID - 1], average);
    }

    // average command - average mark of one student for the 3 subjects
    static void studentAverage(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: average [studentID]");
            return;
        }
        int studentID = Integer.parseInt(parts[1]);
        if (!isValidStudent(studentID)) {
            return;
        }

        int sum = 0;
        for (int j = 0; j < 3; j++) {
            sum += marks[studentID - 1][j];
        }
        double average = sum / 3.0;
        System.out.printf("Average mark of student %d = %.2f\n", studentID, average);
    }

    // total command - total mark of one student for the 3 subjects
    static void studentTotal(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: total [studentID]");
            return;
        }
        int studentID = Integer.parseInt(parts[1]);
        if (!isValidStudent(studentID)) {
            return;
        }

        int sum = 0;
        for (int j = 0; j < 3; j++) {
            sum += marks[studentID - 1][j];
        }
        System.out.println("Total mark of student " + studentID + " = " + sum);
    }

    // returns the grade for a given mark (question 3 criteria)
    static String getGrade(int mark) {
        if (mark >= 90) {
            return "Grade A";
        } else if (mark >= 80) {
            return "Grade B";
        } else if (mark >= 70) {
            return "Grade C";
        } else if (mark >= 60) {
            return "Grade D";
        } else {
            return "Fail";
        }
    }

    // grades command - shows the grades of all students in a table
    static void showGrades() {
        System.out.println("\n------------------------------ Grades Summary ---------------------------------");
        System.out.printf("%-10s %-13s %-13s %-13s\n", "Student", "Mathematics", "Chemistry", "Physics");
        System.out.println("---------------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-13s %-13s %-13s\n",
                    (i + 1),
                    getGrade(marks[i][0]),
                    getGrade(marks[i][1]),
                    getGrade(marks[i][2]));
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}
