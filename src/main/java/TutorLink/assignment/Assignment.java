package tutorlink.assignment;

public class Assignment {
    private String assginmentDescription;
    private double receivedScore;
    private double totalScore;
    private double weighting;

    public Assignment(String assginmentDescription, double receivedScore, double totalScore, double weighting) {
        this.assginmentDescription = assginmentDescription;
        this.receivedScore = receivedScore;
        this.totalScore = totalScore;
        this.weighting = weighting;
    }

    public double getWeightedScore() {
        return (receivedScore / totalScore) * weighting;
    }
}
