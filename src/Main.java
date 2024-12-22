import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add order");
            System.out.println("2. Deliver next order");
            System.out.println("3. Deliver specific order");
            System.out.println("4. Show orders");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    board.add(name);
                    break;
                case 2:
                    Order nextOrder = board.deliver();
                    if (nextOrder != null) {
                        System.out.println("Delivered: " + nextOrder);
                    } else {
                        System.out.println("No orders to deliver.");
                    }
                    break;
                case 3:
                    System.out.print("Enter order number: ");
                    int number = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Order specificOrder = board.deliver(number);
                    if (specificOrder != null) {
                        System.out.println("Delivered: " + specificOrder);
                    } else {
                        System.out.println("Order not found.");
                    }
                    break;
                case 4:
                    board.draw();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

