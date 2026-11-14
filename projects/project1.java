import java.math.BigInteger;
import java.util.Scanner;

public class RadixConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("   NUMBER SYSTEM CONVERTER (RADIX)");
        System.out.println("=========================================");

        while (running) {
            System.out.println("\nSelect SOURCE Number System:");
            int sourceBase = chooseBase(scanner);

            System.out.println("\nSelect TARGET Number System:");
            int targetBase = chooseBase(scanner);

            System.out.print("\nEnter the number to convert: ");
            String inputNumber = scanner.next().trim().toUpperCase();

            try {
                // Parse the string input from the source base into a BigInteger
                BigInteger number = new BigInteger(inputNumber, sourceBase);

                // Convert from BigInteger to the target base string
                String result = number.toString(targetBase).toUpperCase();

                System.out.println("-----------------------------------------");
                System.out.println("RESULT: " + inputNumber + " (Base " + sourceBase + ") = " 
                                   + result + " (Base " + targetBase + ")");
                System.out.println("-----------------------------------------");

            } catch (NumberFormatException e) {
                System.out.println("\n[ERROR] Invalid input '" + inputNumber + "' for Base " + sourceBase + ".");
            }

            System.out.print("\nDo you want to perform another conversion? (Y/N): ");
            String choice = scanner.next().trim();
            if (!choice.equalsIgnoreCase("Y")) {
                running = false;
                System.out.println("\nThank you for using the Radix Converter!");
            }
        }

        scanner.close();
    }

    /**
     * Helper method to display a menu and return the corresponding radix/base.
     */
    private static int chooseBase(Scanner scanner) {
        while (true) {
            System.out.println("  [1] Binary (Base 2)");
            System.out.println("  [2] Octal (Base 8)");
            System.out.println("  [3] Decimal (Base 10)");
            System.out.println("  [4] Hexadecimal (Base 16)");
            System.out.print("Choice (1-4): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: return 2;   // Binary
                    case 2: return 8;   // Octal
                    case 3: return 10;  // Decimal
                    case 4: return 16;  // Hexadecimal
                    default:
                        System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
                }
            } else {
                System.out.println("Invalid input. Enter a number between 1 and 4.");
                scanner.next(); // consume invalid token
            }
        }
    }
}