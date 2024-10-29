//@@author TrungBui32
package tutorlink.component;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ComponentTest {
    private Component assignment;
    private Component exam;

    @BeforeEach
    void setup() {
        assignment = new Component("Assignment 1", 50.0, 0.3);
        exam = new Component("Final Exam", 100.0, 0.4);
    }

    @Test
    void constructor_validInputs_success() {
        assertEquals("Assignment 1", assignment.getName());
        assertEquals(50.0, assignment.getMaxScore());
        assertEquals(0.3, assignment.getWeight());
    }

    @Test
    void equals_sameComponent_returnsTrue() {
        Component duplicateAssignment = new Component("Assignment 1", 50.0, 0.3);
        assertEquals(assignment, duplicateAssignment);
    }

    @Test
    void equals_differentComponent_returnsFalse() {
        Component differentAssignment = new Component("Assignment 2", 50.0, 0.3);
        assertNotEquals(assignment, differentAssignment);
        assertNotEquals(assignment, exam);
        assertNotEquals(assignment, null);
        assertNotEquals(assignment, "not a component");
    }
}
