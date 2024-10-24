package tutorlink.lists;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import tutorlink.exceptions.DuplicateGradeException;
import tutorlink.exceptions.GradeNotFoundException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.grade.Grade;

/**
 * Represents a list of grades.
 */
public class GradeList {
    private static final String ERROR_DUPLICATE_GRADE_ON_ADD = "Error! Grade (%s, %s) already exists in the list!";
    private static final String ERROR_NO_GRADE_FOUND = "Error! Grade (%s, %s) does not exist in the list!";
    private ArrayList<Grade> gradeArrayList;

    public GradeList() {
        this.gradeArrayList = new ArrayList<>();
    }

    public boolean deleteGrade(String matricNumber, String componentDescription) {
        matricNumber = matricNumber.toUpperCase();
        componentDescription = componentDescription.toLowerCase();
        for (Grade grade : gradeArrayList) {
            if (grade.getStudent().getMatricNumber().equals(matricNumber)
                    && grade.getComponent().getName().equals(componentDescription)) {
                return gradeArrayList.remove(grade);
            }
        }
        return false;
    }

    public void addGrade(Grade grade) throws DuplicateGradeException {
        for (Grade gradeToCompare : gradeArrayList) {
            if (grade.equals(gradeToCompare)) {
                throw new DuplicateGradeException(ERROR_DUPLICATE_GRADE_ON_ADD);
            }
        }
        gradeArrayList.add(grade);
    }

    @Override
    public String toString() {
        return IntStream.range(0, gradeArrayList.size())
                .mapToObj(i -> (i + 1) + ": " + gradeArrayList.get(i)) // 1-based index
                .collect(Collectors.joining("\n\t"));
    }

    public GradeList findGrade(String matricNumber, String componentDescription) throws TutorLinkException {
        GradeList filteredList = new GradeList();
        filteredList.gradeArrayList = gradeArrayList
                .stream()
                .filter(grade -> grade.getStudent().getMatricNumber().equals(matricNumber.toUpperCase())
                        && grade.getComponent().getName().equals(componentDescription.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
        if (filteredList.gradeArrayList.isEmpty()) {
            throw new GradeNotFoundException(String.format(ERROR_NO_GRADE_FOUND, matricNumber, componentDescription));
        }
        return filteredList;
    }

    public double calculateStudentGPA(String matricNumber) {
        ArrayList<Grade> studentGrades = gradeArrayList
                .stream()
                .filter(grade -> grade.getStudent().getMatricNumber().equals(matricNumber.toUpperCase()))
                .collect(Collectors.toCollection(ArrayList::new));

        if (studentGrades.isEmpty()) {
            return 0.0;
        }

        return studentGrades
                .stream()
                .mapToDouble(grade -> grade.getScore() * grade.getComponent().getWeight())
                .sum();
    }
}
