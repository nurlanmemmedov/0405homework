import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        printMenu();
        performCalculation();
        askCalculation();
    }

    public static int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public static int divide(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }

    public static void printMenu() {
        System.out.println("Simple Calculator");
        System.out.println("-----------------");
        System.out.println("Choose an operation: ");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
    }

    public static void performCalculation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter choice (1-4): ");
        int input = sc.nextInt();
        System.out.print("Enter the first number:");
        int firstNumber = sc.nextInt();
        System.out.print("Enter the second number:");
        int secondNumber = sc.nextInt();

        int result = 0;
        switch (input) {
            case 1:
                result = add(firstNumber, secondNumber);
                break;
            case 2:
                result = subtract(firstNumber, secondNumber);
                break;

            case 3:
                result = multiply(firstNumber, secondNumber);
                break;

            case 4:
                result = divide(firstNumber, secondNumber);
                break;
            default:
                System.out.println("Enter correct calculation from menu.");
                performCalculation();
        }

        System.out.println("Result is " + result);
    }

    public static void askCalculation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do u wanna make another calculation? (yes/no): ");
        String answer = sc.next();
        if (answer.equals("yes")) {
            performCalculation();
        } else {
            System.out.println("Goodbye!");
        }
    }
}