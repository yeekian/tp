package listpackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutorlink.assignmentpackage.Assignment;
import tutorlink.listpackage.AssignmentList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignmentListTest {

    private AssignmentList assignmentList;
    private Assignment assignment1;
    private Assignment assignment2;

    @BeforeEach
    void setUp() {
        assignmentList = new AssignmentList();
        assignment1 = new Assignment("Assignment 1",1,1,1);
        assignment2 = new Assignment("Assignment 2",1,2,1);
    }

    @Test
    void testAddAssignment() {
        // Initially, the list should be empty
        assertTrue(assignmentList.assignmentArrayList.isEmpty());

        // Add an assignment
        assignmentList.addAssignment(assignment1);

        // Check that the assignment was added
        assertFalse(assignmentList.assignmentArrayList.isEmpty());
        assertEquals(1, assignmentList.assignmentArrayList.size());
        assertEquals(assignment1, assignmentList.assignmentArrayList.get(0));
    }

    @Test
    void testDeleteAssignment() {
        // Add an assignment first
        assignmentList.addAssignment(assignment1);
        assertEquals(1, assignmentList.assignmentArrayList.size());

        // Now delete the assignment
        assignmentList.deleteAssignment(assignment1);

        // Check that the assignment was removed
        assertEquals(0, assignmentList.assignmentArrayList.size());
    }

    @Test
    void testDeleteNonExistentAssignment() {
        // Initially, the list should be empty
        assertTrue(assignmentList.assignmentArrayList.isEmpty());

        // Attempt to delete a non-existent assignment
        assignmentList.deleteAssignment(assignment1);

        // The size should still be zero
        assertEquals(0, assignmentList.assignmentArrayList.size());
    }
}
