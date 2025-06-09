
public class Account {
    
    //initializes private variables
    private final String accountNumber;
    private double balance;

    //sets bank account number using the users input
    public Account(){
       this.accountNumber = AccountNumGenerator.generateAccountNumber();
       this.balance = 0.0;
    }

    //gets bank account number 
    public String getAccountNumber(){
        return accountNumber;
    }

    //set bank balance
    public void deposit(double amount){
        balance = balance + amount;
        getBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        getBalance();
    }

    //gets account balance
    public void getBalance(){
        System.out.println("Your account balance is currently" + balance);
    }
}