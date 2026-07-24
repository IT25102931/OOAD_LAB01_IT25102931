import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {

        // first I'm  creating a Scanner object to read the user inputs
        Scanner input = new Scanner(System.in);

        // now asking the user for the first name
        System.out.print("Enter your First Name: ");
        String firstName = input.nextLine();

        // and after that asking the user for the last name
        System.out.print("Enter your Last Name: ");
        String lastName = input.nextLine();

        // displaying the welcome message with  combining user's first name and last name
        System.out.println("Welcome to the Second Year " + firstName + " " + lastName + " ");

    }
}
