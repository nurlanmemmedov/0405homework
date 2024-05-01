import java.util.Scanner;

public class ShoppingPlatform {

    public static Scanner scanner = new Scanner(System.in);
    public static Seller[] sellers = new Seller[10];
    public static Product[] products = new Product[10];
    public static Seller loggedInSeller = null;
    public static double totalAmount = 0;
    public static double profit = 0;

    public static void main(String[] args) {
        sellers[0] = new Seller("admin", "Admin123!", "Admin admin", 30, true);
        products[0] = new Product("Magnum", "129417261273", 100, 2.7, 3.5);

        startApp();
    }

    public static void startApp() {
        authenticate();
        showMenu();
    }


    public static void authenticate() {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        for (Seller seller : sellers) {
            if (seller != null && seller.username.equals(username) && seller.password.equals(password)) {
                loggedInSeller = seller;
            }
        }

        if (loggedInSeller == null) {
            System.out.println("Invalid credentials! try again!");
            authenticate();
        }
    }

    public static void showMenu() {
        if (loggedInSeller.isAdmin) {
            processAdminMenu();
        } else {
            processSellerMenu();
        }
    }

    public static void processSellerMenu() {
        System.out.println("1. Satis et");
        System.out.println("2. Logout");
        System.out.print("Make a choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> sellProduct();
            case 2 -> {
                loggedInSeller = null;
                startApp();
            }
            default -> {
                System.out.println("Incorrect choice, select one of the choices from below menu!");
                processSellerMenu();
            }
        }
    }

    public static void processAdminMenu() {
        System.out.println("Today's profit is: " + profit);
        System.out.println("Today's total selling amount: " + totalAmount);
        System.out.println();
        System.out.println();
        System.out.println("1. Yeni satici elave et");
        System.out.println("2. Saticini sil");
        System.out.println("3. Product elave et");
        System.out.println("4. Satis et");
        System.out.println("5. Logout");
        System.out.print("Make a choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> addNewSeller();
            case 2 -> removeSeller();
            case 3 -> addProduct();
            case 4 -> sellProduct();
            case 5 -> {
                loggedInSeller = null;
                startApp();
            }
            default -> {
                System.out.println("Incorrect choice, select one of the choices from below menu!");
                processAdminMenu();
            }
        }
    }

    public static void sellProduct() {
        System.out.print("Enter the code of the product: ");
        String code = scanner.next();

        Product product = null;
        for (Product p : products) {
            if (p != null && p.code.equals(code) && p.count > 0) {
                product = p;
            }
        }

        if (product == null) {
            System.out.println("There is not any product with given code!");
            sellProduct();
        }

        System.out.println("The amount of the product is: " + product.amount);
        System.out.print("Enter the count of the product to sell: ");
        int count = scanner.nextInt();
        if (count > product.count) {
            System.out.println("Unfortunately! we only have " + product.count + " " + product.name);
            System.out.print("Do you want to change the desired count to " + product.count);
            String answer = scanner.next();
            if (answer.equals("yes")) {
                count = product.count;
            } else {
                sellProduct();
            }
        }
        System.out.println("You should get " + count * product.amount + " manats from customer");

        System.out.print("Do you confirm the sell? (yes or not): ");
        String answer = scanner.next();

        if (answer.equals("yes")) {
            totalAmount += count * product.amount;
            profit += count * (product.amount - product.price);
            product.count -= count;
        }

        System.out.print("Would u like to make another sell? (yes or not) ");
        String answ = scanner.next();

        if (answ.equals("yes")) {
            sellProduct();
        } else {
            showMenu();
        }
    }

    public static void addNewSeller() {
        System.out.println("Enter the seller's name: ");
        String name = scanner.next();
        System.out.println("Enter the seller's username: ");
        String username = scanner.next();
        System.out.println("Enter the seller's password: ");
        String password = scanner.next();
        System.out.println("Enter the seller's age: ");
        int age = scanner.nextInt();
        System.out.println("Enter 1(yes) or 0(no) to submit if the seller is admin or not: ");
        int isAdminInput = scanner.nextInt();
        boolean isAdmin = isAdminInput == 1;

        Seller seller = new Seller(username, password, name, age, isAdmin);

        boolean isFull = true;
        for (int i = 0; i < sellers.length; i++) {
            if (sellers[i] == null) {
                isFull = false;
                sellers[i] = seller;
                break;
            }
        }

        if (isFull) {
            Seller[] newArr = new Seller[sellers.length * 2];
            for (int i = 0; i < sellers.length; i++) {
                newArr[i] = sellers[i];
            }
            newArr[sellers.length] = seller;
            sellers = newArr;
        }

        System.out.print("Would u like to add another seller? (yes or not) ");
        String answer = scanner.next();

        if (answer.equals("yes")) {
            addNewSeller();
        } else {
            processAdminMenu();
        }
    }

    public static void removeSeller() {

    }

    public static void addProduct() {

    }
}
