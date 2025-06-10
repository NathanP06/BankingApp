import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        Account account = new Account();
        boolean running = true;

        System.out.println("Preparing and Initializing App for Startup.");

        while (running){
            System.out.println("\nMenu:");
            System.out.println("1. Check Account Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scnr.nextInt();
        

        switch (choice) {
            case 1 -> account.getBalance();
            case 2 -> {
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scnr.nextDouble();
                account.deposit(depositAmount);
                }
            case 3 -> {
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scnr.nextDouble();
                account.withdraw(withdrawAmount);
                }
            case 4 -> {
                running = false;
                System.out.println("Goodbye!");
                }
            default -> System.out.println("Invalid option. Try again.");
        }
    }


        scnr.close();
    }
}
