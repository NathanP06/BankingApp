import java.util.ArrayList;

public class Customer {
    private String name;
    private String ssn;
    private ArrayList<Account> accounts;

    public Customer(String name, String ssn){
        this.name = name;
        this.ssn = ssn;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public String getSSN(){
        return ssn;
    }

    public String getMaskedSSN(){
        return "***-**-" + ssn.substring(ssn.length() - 4);
    }

}

