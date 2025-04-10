import java.util.Scanner;

public class BankServer extends Target {
    public BankServer(String name) {
        super(name, 2000, 20); // reward, trace risk
    }

    @Override
    public boolean hack(int cpuLevel, Scanner input) {
        String password = "" + (int)(Math.random() * 9000 + 1000); // 4-digit
        System.out.println("Guess the 4-digit password:");

        for (int i = 0; i < cpuLevel + 1; i++) {
            System.out.print("Attempt " + (i+1) + ": ");
            String guess = input.nextLine();

            if (guess.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
