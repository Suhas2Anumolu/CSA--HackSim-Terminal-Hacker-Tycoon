import java.util.Scanner;

public class GovServer extends Target {
    public GovServer(String name) {
        super(name, 5000, 40);
    }

    @Override
    public boolean hack(int cpuLevel, Scanner input) {
        String password = "";
        for (int i = 0; i < 3; i++) {
            password += (char)('A' + (int)(Math.random() * 26));
        }

        System.out.println("Guess the 3-letter password (A-Z):");

        for (int i = 0; i < cpuLevel; i++) {
            System.out.print("Attempt " + (i+1) + ": ");
            String guess = input.nextLine().toUpperCase();

            if (guess.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
