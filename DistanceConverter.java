/* Name: Mosammat Muna Project : Java Final Capstone Project
   Objective - Program ask user to enter a distance in meters and ask to choice a convert option. 
   Program convert distance to kilometers ,inches or feet depending on user's selection. */
   
package week18;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
    	
    	String currentDirectory = System.getProperty("user.dir");	// Get working directory.
		System.out.println("Working Directory " + currentDirectory);

		String username = System.getProperty("user.name");	// Get user name
		System.out.println("Programmer: "+ username);

		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy @ hh:mm");	// Format date and time.
		Date date = new Date();
		System.out.println("Java Final Project " + formatter.format(date) + '\n' );
	
		Scanner keyboard = new Scanner(System.in);	// Create a Scanner object for user input.
		
		System.out.print("Enter your name: ");	// Get user name
		String name = keyboard .nextLine();
		System.out.println("Hello, "+name); 
       
	     // Get distance from user
        double meters = 0.0;
        while (meters <= 0) {
            try {
                System.out.print("Enter a distance in meters: ");
                meters = keyboard.nextDouble();
                if (meters <= 0) {
                    throw new Exception("Error: Distance must be a positive number.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                keyboard.nextLine();
            }
        }

        // Display menu and get user's choice
        int choice = 0;
        do {
            menu();
            choice = getChoice(keyboard);
            // Perform conversion based on user's selection
            switch (choice) {
                case 1:
                    showKilometers(meters);
                    System.out.println();
                    break;
                case 2:
                    showInches(meters);
                    System.out.println();
                    break;
                case 3:
                    showFeet(meters);
                    System.out.println();
                    break;
                case 4:
                    break;// exit loop
            }
        } while (choice != 4);

        System.out.println("Bye!");
        return;
    }
    // Displays menu of selections
    public static void menu() {
        System.out.println("1. Convert to kilometers");
        System.out.println("2. Convert to inches");
        System.out.println("3. Convert to feet");
        System.out.println("4. Quit the program");
        System.out.println();
    }
    // Ask user to enter their choice and returns value
    public static int getChoice(Scanner scanner) {
        int choice = 0;
        // Loop until user enters a valid selection (1-4 inclusive)
        while (choice < 1 || choice > 4) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
         // If the selection is invalid(outside the range) consider invalid and reset choice 
            if (choice < 1 || choice > 4) {
                System.out.print("Invalid selection.");
                choice = 0;
            }
        }
        return choice;
    }

    // Converts distance from meters to kilometers and displays result
    public static void showKilometers(double meters) {
        double kilometers = meters * 0.001; 
        System.out.printf("%.1f meters is %.2f kilometers.", meters, kilometers);
        System.out.println();
    }

    // Converts distance from meters to inches and displays result
    public static void showInches(double meters) {
        double inches = meters * 39.37;
        System.out.printf("%.1f meters is %.1f inches.", meters, inches);
        System.out.println();
    }

    // Converts distance from meters to feet and displays result
    public static void showFeet(double meters) {
        double feet = meters * 3.281;
        System.out.printf("%.1f meters is %.2f feet.", meters, feet);
        System.out.println();
    }
}
