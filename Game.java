import java.util.*;

public class Game {
    private Player player;
    private Scanner input;
    private ArrayList<Target> targets;

    public Game() {
        player = new Player();
        input = new Scanner(System.in);
        targets = new ArrayList<>();

        // Add servers to hack
        targets.add(new BankServer("bank_server1"));
        targets.add(new BankServer("bank_server2"));
        targets.add(new GovServer("gov_server1"));
    }

    public void start() {
        System.out.println("=== HackSim: Terminal Hacker Tycoon ===");
        System.out.println("Type 'help' for a list of commands.");

        while (player.isAlive()) {
            System.out.print("\n> ");
            String command = input.nextLine();

            handleCommand(command);
        }

        System.out.println("\nYOU GOT CAUGHT. GAME OVER.");
    }

 private void handleCommand(String command) {
    if (command.equals("help")) {
        System.out.println("Commands:");
        System.out.println("connect [server]");
        System.out.println("attempt hack");
        System.out.println("upgrade [vpn/cpu/storage]");
        System.out.println("status");
        System.out.println("list targets");
    } else if (command.equals("list targets")) {
        listTargets();
    } else if (command.startsWith("connect")) {
        String[] parts = command.split(" ");
        if (parts.length >= 2) {
            connectToTarget(parts[1]);
        } else {
            System.out.println("Specify a target.");
        }
    } else if (command.equals("attempt hack")) {
        player.attemptHack();
    } else if (command.startsWith("upgrade")) {
        String[] parts = command.split(" ");
        if (parts.length >= 2) {
            player.upgrade(parts[1]);
        } else {
            System.out.println("Specify upgrade type.");
        }
    } else if (command.equals("status")) {
        player.showStatus();
    } else {
        System.out.println("Unknown command.");
    }
}


    private void connectToTarget(String targetName) {
        for (Target t : targets) {
            if (t.getName().equals(targetName)) {
                player.setCurrentTarget(t);
                System.out.println("Connected to " + targetName);
                return;
            }
        }
        System.out.println("Target not found.");
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.start();
    }
private void listTargets() {
    System.out.println("Available Targets to Hack:");
    for (Target t : targets) {
        System.out.println("- " + t.getName());
    }
}

}

