package calculator;

import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {

    public static void main(String[] args) {

        try {
            // Get remote object
            Calculator calc = (Calculator) Naming.lookup(
                    "rmi://localhost/CalculatorService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            double a = sc.nextDouble();

            System.out.print("Enter second number: ");
            double b = sc.nextDouble();

            System.out.println("Choose operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");

            int choice = sc.nextInt();

            double result = 0;

            switch (choice) {
                case 1:
                    result = calc.add(a, b);
                    break;
                case 2:
                    result = calc.subtract(a, b);
                    break;
                case 3:
                    result = calc.multiply(a, b);
                    break;
                case 4:
                    result = calc.divide(a, b);
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }

            System.out.println("Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
