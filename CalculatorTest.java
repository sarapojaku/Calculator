import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Simple Calculator ---");
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            System.out.print("Choose operation (+, -, *, /): ");
            char op = scanner.next().charAt(0);

            Calculator calc = null;

            switch (op) {
                case '+':
                    calc = new Addition(num1, num2);
                    break;
                case '-':
                    calc = new Subtraction(num1, num2);
                    break;
                case '*':
                    calc = new Multiplication(num1, num2);
                    break;
                case '/':
                    calc = new Division(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operator!");
            }

            if (calc != null) {
                try {
                    System.out.println("Result: " + calc.calculate());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            System.out.print("\nDo you want to calculate again? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (choice.equals("no")) {
                running = false;
            }
        }

        System.out.println("Calculator closed.");
        scanner.close();
    }
}