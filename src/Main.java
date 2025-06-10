import java.util.*;

public class Main {
    static Scanner scnr = new Scanner(System.in);
    static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Preparing and Initializing App for Startup.");

        while (running){
            switch(mainMenu()) {
                case 1 -> addNewCustomer();
                case 2 -> accessCurrentCustomer();
                case 3 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }
    
    public static int mainMenu(){
        System.out.println("\n=== JavaBank Main Menu ===");
        System.out.println("1. Create New Customer");
        System.out.println("2. Access Existing Customer");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        return scnr.nextInt();
    }

    public static void addNewCustomer(){
        scnr.nextLine(); //clear input
        System.out.print("Enter customer name: ");
        String name = scnr.nextLine();
        
        String ssn;
        while (true) {
            System.out.print("Enter 9-digit SSN (format: XXX-XX-XXXX): ");
            ssn = scnr.nextLine();
            if (ssn.matches("\\d{3}-\\d{2}-\\d{4}")) break;
            System.out.println("Invalid SSN format. Try again.");
        }

        Customer customer = new Customer(name, ssn);
        Account account = new Account();
        
        customer.addAccount(account);
        customers.add(customer);
        System.out.println("Customer created. Account #: " + account.getAccountNumber());
    }

    public static void accessCurrentCustomer() {
        scnr.nextLine(); // clear buffer
        System.out.print("Enter customer SSN (XXX-XX-XXXX): ");
        String ssn = scnr.nextLine();

        for (Customer c : customers) {
            if (c.getSSN().equals(ssn)) {
                customerSession(c);
                return;
            }
        }

        System.out.println("Customer not found.");
    }

    public static void customerSession(Customer customer) {
        while (true) {
            System.out.println("\nWelcome, " + customer.getName());
            ArrayList<Account> accounts = customer.getAccounts();

            for (int i = 0; i < accounts.size(); i++) {
                System.out.println((i + 1) + ". Account #" + accounts.get(i).getAccountNumber());
            }
            System.out.println((accounts.size() + 1) + ". Open New Account");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an account: ");
            int choice = scnr.nextInt();

            if (choice == 0) return;
            if (choice == accounts.size() + 1) {
                Account newAcc = new Account();
                customer.addAccount(newAcc);
                System.out.println("New account created: " + newAcc.getAccountNumber());
            } else if (choice >= 1 && choice <= accounts.size()) {
                accountMenu(accounts.get(choice - 1));
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

      public static void accountMenu(Account account) {
        while (true) {
            System.out.println("\nAccount: " + account.getAccountNumber());
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            int choice = scnr.nextInt();

            switch (choice) {
                case 1 -> account.getBalance();
                case 2 -> {
                    System.out.print("Deposit amount: ");
                    account.deposit(scnr.nextDouble());
                }
                case 3 -> {
                    System.out.print("Withdrawal amount: ");
                    account.withdraw(scnr.nextDouble());
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}

