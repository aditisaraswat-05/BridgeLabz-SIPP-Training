import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter operation (+, -, *, /): ");

        String operator = sc.next();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        double result;

        switch (operator) {
            case "+":
                result = num1 + num2;
                System.out.println(result);
                break;

            case "-":
                result = num1 - num2;
                System.out.println(result);
                break;

            case "*":
                result = num1 * num2;
                System.out.println(result);
                break;

            case "/":
                result = num1 / num2;
                System.out.println("Result: " + result);
                break;

            default:
                System.out.println("Invalid operator");
        }

        sc.close();
    }
}

// Calculator using switch case
