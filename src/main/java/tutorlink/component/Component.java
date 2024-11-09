package tutorlink.component;

//@@author TrungBui32
public class Component {
    private String name;
    private double maxScore;
    private int weight;

    public Component(String name, double maxScore, int weight) {
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

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Component comp) {
            return comp.getName().toUpperCase().equals(this.getName().toUpperCase());
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " (maxScore: " + maxScore + ", weight: " + weight + "%)";
    }
}
