package tutorlink.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutorlink.component.Assignment;
import tutorlink.component.Exam;
import tutorlink.exceptions.DuplicateGradeException;
import tutorlink.exceptions.GradeNotFoundException;
import tutorlink.grade.Grade;
import tutorlink.lists.GradeList;
import tutorlink.student.Student;
import tutorlink.component.Component;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GradeListTest {

    private GradeList gradeList;
    private Grade grade1;
    private Grade grade2;

    @BeforeEach
    void setup() {
        gradeList = new GradeList();

        // Create two sample grades for testing
        Student student1 = new Student("A1234567B", "John Doe");
        Student student2 = new Student("A7654321B", "Jane Smith");

        Component component1 = new Assignment("Homework", 100, 0.2);
        Component component2 = new Exam("Exam", 100, 0.5);

        grade1 = new Grade(component1, student1, 90.0);
        grade2 = new Grade(component2, student2, 85.0);
    }

    @Test
    void add_success() throws DuplicateGradeException {
        gradeList.addGrade(grade1);
        assertEquals(1, gradeList.toString().split("\n").length); // Ensure it is added
    }

    @Test
    void add_duplicateGradeException() throws DuplicateGradeException {
        gradeList.addGrade(grade1);
        assertThrows(DuplicateGradeException.class, () -> gradeList.addGrade(grade1));
    }

    @Test
    void delete_success() throws DuplicateGradeException {
        gradeList.addGrade(grade1);
        assertTrue(gradeList.deleteGrade(grade1.getStudent().getMatricNumber(), grade1.getComponent().getName()));
        assertEquals(0, gradeList.toString().length()); // Ensure it's removed
    }

    @Test
    void delete_notFound() {
        assertFalse(gradeList.deleteGrade("A9999999B", "nonexistentComponent"));
    }

    @Test
    void find_success() throws Exception {
        gradeList.addGrade(grade1);
        gradeList.addGrade(grade2);

        GradeList result = gradeList.findGrade("A1234567B", "Homework");
        assertEquals(1, result.toString().split("\n").length);
        String stringResult = result.toString();
        assertTrue(stringResult.contains("John Doe"));
    }

    @Test
    void find_notFound() {
        assertThrows(GradeNotFoundException.class, () -> gradeList.findGrade("A9999999B", "nonexistentComponent"));
    }

    @Test
    void testToString() throws DuplicateGradeException {
        gradeList.addGrade(grade1);
        gradeList.addGrade(grade2);
        String expectedString = "1: " + grade1.toString() + "\n\t2: " + grade2.toString();
        assertEquals(expectedString, gradeList.toString());
    }
}
