import java.util.*;

public class Player {
    private int money;
    private int traceLevel;
    private Target currentTarget;
    private int vpnLevel;
    private int cpuLevel;
    private int storageLevel;
    private Scanner input;

    public Player() {
        money = 1000;
        traceLevel = 0;
        vpnLevel = 1;
        cpuLevel = 1;
        storageLevel = 1;
        input = new Scanner(System.in);
    }

    public boolean isAlive() {
        return traceLevel < 100;
    }

    public void setCurrentTarget(Target t) {
        currentTarget = t;
    }

    public void attemptHack() {
        if (currentTarget == null) {
            System.out.println("You are not connected to any target.");
            return;
        }

        boolean success = currentTarget.hack(cpuLevel, input);
        if (success) {
            int stolen = currentTarget.getReward();
            money += stolen;
            System.out.println("Hack successful! You stole $" + stolen);
        } else {
            System.out.println("Hack failed...");
        }

        increaseTrace(currentTarget.getTraceRisk() - vpnLevel * 2);
    }

    public void increaseTrace(int amount) {
        traceLevel += Math.max(amount, 1);
        System.out.println("Trace Level increased to " + traceLevel + "%");
    }

    public void upgrade(String type) {
        if (type.equals("vpn")) {
            int cost = 500 * vpnLevel;
            if (money >= cost) {
                money -= cost;
                vpnLevel++;
                System.out.println("VPN upgraded to Level " + vpnLevel);
            } else {
                System.out.println("Not enough money.");
            }
        } else if (type.equals("cpu")) {
            int cost = 700 * cpuLevel;
            if (money >= cost) {
                money -= cost;
                cpuLevel++;
                System.out.println("CPU upgraded to Level " + cpuLevel);
            } else {
                System.out.println("Not enough money.");
            }
        } else if (type.equals("storage")) {
            int cost = 300 * storageLevel;
            if (money >= cost) {
                money -= cost;
                storageLevel++;
                System.out.println("Storage upgraded to Level " + storageLevel);
            } else {
                System.out.println("Not enough money.");
            }
        } else {
            System.out.println("Unknown upgrade type.");
        }
    }

    public void showStatus() {
        System.out.println("Money: $" + money);
        System.out.println("Trace Level: " + traceLevel + "%");
        System.out.println("VPN Level: " + vpnLevel);
        System.out.println("CPU Level: " + cpuLevel);
        System.out.println("Storage Level: " + storageLevel);
    }
}
