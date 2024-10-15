package tutorlink.coursepackage;

import org.junit.jupiter.api.Test;
import tutorlink.assignmentpackage.Assignment;
import tutorlink.exceptionspackage.InvalidWeightingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseTest {

    @Test
    public void isCompletedCourse_totalWeightingEmpty_fail() throws InvalidWeightingException {
        Course course = new Course("CS2113", 4);

        assertEquals(false, course.isCompletedCourse());
    }

    @Test
    public void isCompletedCourse_totalWeightingFilled_success() throws InvalidWeightingException {
        Course course = new Course("CS2113", 4);

        assertEquals(false, course.isCompletedCourse());

        Assignment assignment1 = new Assignment("Assignment1", 60, 75, 50);
        Assignment assignment2 = new Assignment("Assignment2", 60, 75, 20);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        assertEquals(false, course.isCompletedCourse());

        Assignment assignment3 = new Assignment("Assignment3", 60, 75, 30);
        course.addAssignment(assignment3);

        assertEquals(true, course.isCompletedCourse());
    }

    @Test
    public void isCompletedCourse_totalWeightingExceed_exceptionThrown() throws InvalidWeightingException {
        Course course = new Course("CS2113", 4);

        assertEquals(false, course.isCompletedCourse());

        Assignment assignment1 = new Assignment("Assignment1", 60, 75, 50);
        Assignment assignment2 = new Assignment("Assignment2", 60, 75, 20);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        assertEquals(false, course.isCompletedCourse());

        Assignment assignment3 = new Assignment("Assignment3", 60, 75, 30);
        course.addAssignment(assignment3);

        assertEquals(true, course.isCompletedCourse());

        Assignment assignment4 = new Assignment("Assignment4", 60, 75, 30);
        course.addAssignment(assignment4);

        assertThrows(InvalidWeightingException.class, course::isCompletedCourse);
    }

}

