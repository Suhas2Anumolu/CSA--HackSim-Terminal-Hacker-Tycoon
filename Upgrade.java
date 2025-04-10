public class Upgrade {
    private String name;
    private int cost;

    public Upgrade(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
