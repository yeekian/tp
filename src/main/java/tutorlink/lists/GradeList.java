package tutorlink.lists;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import tutorlink.exceptions.DuplicateGradeException;
import tutorlink.exceptions.GradeNotFoundException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.student.Student;

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
            if (grade.getMatricNumber().equals(matricNumber) && grade.getComponentDescription().equals(componentDescription)) {
                return studentArrayList.remove(grade);
            }
        }
        return false;
    }

    public void addGrade(Grade grade) throws DuplicateGradeException {
        for (Grade gradeToCompare : gradeArrayList) {
            if (grade == gradeToCompare) {
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
                .filter(grade -> grade.getMatricNumber().equals(matricNumber.toUpperCase())
                && grade.getComponentDescription().equals(componentDescription.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
        if (filteredList.gradeArrayList.isEmpty()) {
            throw new GradeNotFoundException(String.format(ERROR_NO_GRADE_FOUND, matricNumber, componentDescription));
        }
        return filteredList;
    }

}
