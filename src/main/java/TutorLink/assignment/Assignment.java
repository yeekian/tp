package tutorlink.assignment;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Assignment that = (Assignment) obj;
        return Objects.equals(assginmentDescription, that.assginmentDescription);
    }
}
