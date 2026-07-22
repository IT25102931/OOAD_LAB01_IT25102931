import java.util.Scanner;
 
 public class Welcome{
 
  public static void  main(String[] args){
  Scanner scanner = new Scanner(System.in);
  
  //Seeking user's First name
  System.out.print("Enter your First name : ");
  String firstName = scanner.next();

  //Seeking user's Last name
  System.out.print("Enter your Last name : ");
  String lastName = scanner.next();
  
  // Display the corresponding Welcome message
  System.out.println("Welcome " + firstName + " " + lastName + " to the Second Year.");
  }
 }

  
