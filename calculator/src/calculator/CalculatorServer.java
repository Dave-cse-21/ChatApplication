package calculator;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {

    public static void main(String[] args) {

        try {
            // Start RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Create calculator object
            Calculator calc = new CalculatorImpl();

            // Bind object to registry
            Naming.rebind("rmi://localhost/CalculatorService", calc);

            System.out.println("Calculator RMI Server is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
