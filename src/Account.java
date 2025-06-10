
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
        if(balance - amount > 0){
            balance = balance - amount;
            getBalance();
        }
        else{
            System.out.println("Insufficient Funds: Attempted to withdrawal " + amount + ". Actual Balance: " + balance + ".");
        }
    }

    //gets account balance
    public void getBalance(){
        System.out.println("Your account balance is currently" + balance);
    }
}