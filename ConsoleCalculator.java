import java.util.Scanner;

public class ConsoleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepCalculating = true;

        System.out.println("--- Java Console Calculator ---");

        while (true) {
            System.out.print("\nEnter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /) or type 'exit' to quit: ");
            String operator = scanner.next();

            if (operator.equalsIgnoreCase("exit")) {
                keepCalculating = false;
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result = 0;
            boolean validOperation = true;

            switch (operator) {
                case "+":
                    result = add(num1, num2);
                    break;
                case "-":
                    result = subtract(num1, num2);
                    break;
                case "*":
                    result = multiply(num1, num2);
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                        validOperation = false;
                    } else {
                        result = divide(num1, num2);
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator.");
                    validOperation = false;
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }
        }
        scanner.close();
    }

    // Arithmetic Methods
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}