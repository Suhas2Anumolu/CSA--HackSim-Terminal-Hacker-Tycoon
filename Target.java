import java.util.Scanner;

public abstract class Target {
    protected String name;
    protected int reward;
    protected int traceRisk;

    public Target(String name, int reward, int traceRisk) {
        this.name = name;
        this.reward = reward;
        this.traceRisk = traceRisk;
    }

    public String getName() {
        return name;
    }

    public int getReward() {
        return reward;
    }

    public int getTraceRisk() {
        return traceRisk;
    }

    public abstract boolean hack(int cpuLevel, Scanner input);
}
