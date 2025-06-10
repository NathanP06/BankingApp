import java.util.ArrayList;

public class Customer {
    private final String name;
    private final String ssn;
    private ArrayList<Account> accounts;

    public Customer(String name, String ssn){
        this.name = name;
        this.ssn = ssn;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public String getName(){
        return name;
    }

    public String getSSN(){
        return ssn;
    }

    public String getMaskedSSN(){
        return "***-**-" + ssn.substring(ssn.length() - 4);
    }

}

