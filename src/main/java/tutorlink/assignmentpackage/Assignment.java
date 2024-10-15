package tutorlink.assignmentpackage;

import java.util.Objects;

import static tutorlink.coursepackage.Course.PERCENTAGE_MARGIN_OF_ERROR_DOUBLE;

public class Assignment {
    private String assginmentDescription;
    private double receivedScore;
    private double totalScore;
    private double weighting;

    public Assignment(String assginmentDescription, double receivedScore, double totalScore, double weighting) {
        assert (weighting >= (0 - PERCENTAGE_MARGIN_OF_ERROR_DOUBLE) && weighting <= (100 + PERCENTAGE_MARGIN_OF_ERROR_DOUBLE))
                : "Assignment weighting out of range (0 - 100%)";

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
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Assignment that = (Assignment) obj;
        return Objects.equals(assginmentDescription, that.assginmentDescription);
    }

    public double getWeighting() {
        return weighting;
    }
}
