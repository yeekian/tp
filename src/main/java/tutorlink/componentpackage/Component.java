package tutorlink.componentpackage;

public abstract class Component {
    private String name;
    private double maxScore;
    private double weight;

    public Component(String name, double maxScore, double weight) {
        this.name = name;
        this.maxScore = maxScore;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public double getMaxScore() {
        return maxScore;
    }
    public double getWeight() {
        return weight;
    }
}
