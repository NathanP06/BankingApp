import java.util.Random;

public class AccountNumGenerator {
        public static String generateAccountNumber(){
        Random rand = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < 10; i++){
            accountNumber.append(rand.nextInt(10));
        }
        return accountNumber.toString();
    }
}
