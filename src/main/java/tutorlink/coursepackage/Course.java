package tutorlink.coursepackage;

import tutorlink.exceptionspackage.InvalidWeightingException;
import tutorlink.listpackage.AssignmentList;
import tutorlink.listpackage.AttendanceList;
import tutorlink.assignmentpackage.Assignment;

public class Course {
    public static final double PERCENTAGE_MARGIN_OF_ERROR_DOUBLE = 0.5;
    private String courseID;
    private int courseMCs;
    private LetterGrade grade;
    private AssignmentList assignments;
    private AttendanceList attendances;


    public Course(String courseID, int courseMCs) {
        this.courseID = courseID;
        this.courseMCs = courseMCs;
        this.grade = LetterGrade.IP;
        assignments = new AssignmentList();
        attendances = new AttendanceList();
    }

    @Override
    public String toString() {
        return this.courseID + ", MCs: " + this.courseMCs + ", Grade: " + this.grade;
    }

    public void addAssignment(Assignment assignment) {
        assignments.addAssignment(assignment);
    }

    public void deleteAssignment(Assignment assignment) {
        assignments.deleteAssignment(assignment);
    }

    public AssignmentList getAssignments() {
        return assignments;
    }

    public String getCourseID() {
        return courseID;
    }

    /**
     * Determines if the course is completed by checking if the total weight of all assignments
     * sums up to approximately 100%. The method uses a margin of error for floating-point precision.
     *
     * @return {@code true} if the total assignment weight is within the acceptable range of 100%,
     *         {@code false} otherwise.
     * @throws InvalidWeightingException if the total assignment weight exceeds 100% plus the
     *         defined margin of error.
     */
    public Boolean isCompletedCourse() throws InvalidWeightingException {
        double totalCompletedWeighting = 0;
        for (Assignment a : assignments.getAssignmentArrayList()) {
            totalCompletedWeighting += a.getWeighting();
        }

        // If the total weight exceeds 100% + margin, throw an exception
        if (totalCompletedWeighting > (100 + PERCENTAGE_MARGIN_OF_ERROR_DOUBLE)) {
            throw new InvalidWeightingException();
        }

        // Check if the total weightage is close to 100% within a margin of error (0.5%)
        return Math.abs(totalCompletedWeighting - 100) <= PERCENTAGE_MARGIN_OF_ERROR_DOUBLE;
    }


    public LetterGrade getLetterGrade() throws InvalidWeightingException {
        try {
            LetterGrade finalGrade;
            if (!isCompletedCourse()) {
                return LetterGrade.IP; // Return In Progress if not all assignments graded
            }

            double totalScore = 0;

            for (Assignment a : assignments.getAssignmentArrayList()) {
                totalScore += a.getWeightedScore();
            }

            assert (totalScore >= (0 - PERCENTAGE_MARGIN_OF_ERROR_DOUBLE)
                    && totalScore <= (100 - PERCENTAGE_MARGIN_OF_ERROR_DOUBLE)) : "totalScore out of range (0 - 100%)";

            // Determine grade based on average score
            if (totalScore >= 90) {
                finalGrade = LetterGrade.A_plus;
            } else if (totalScore >= 85) {
                finalGrade = LetterGrade.A;
            } else if (totalScore >= 80) {
                finalGrade = LetterGrade.A_minus;
            } else if (totalScore >= 75) {
                finalGrade = LetterGrade.B_plus;
            } else if (totalScore >= 70) {
                finalGrade = LetterGrade.B;
            } else if (totalScore >= 65) {
                finalGrade = LetterGrade.B_minus;
            } else if (totalScore >= 60) {
                finalGrade = LetterGrade.C_plus;
            } else if (totalScore >= 55) {
                finalGrade = LetterGrade.C;
            } else if (totalScore >= 50) {
                finalGrade = LetterGrade.D_plus;
            } else if (totalScore >= 45) {
                finalGrade = LetterGrade.D;
            } else {
                finalGrade = LetterGrade.F;
            }

            this.grade = finalGrade;
            return finalGrade;
        } catch (InvalidWeightingException e) {
            System.out.println("Invalid weighting detected, check that sum of all weightages are between 0 and 100%");
        }
        return null;
    }
}
