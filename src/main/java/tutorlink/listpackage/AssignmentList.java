package tutorlink.listpackage;

import tutorlink.assignmentpackage.Assignment;

import java.util.ArrayList;

public class AssignmentList extends ItemList {
    private int numberOfAssignments;
    private ArrayList<Assignment> assignmentArrayList;

    public AssignmentList() {
        this.numberOfAssignments = 0;
        this.assignmentArrayList = new ArrayList<>();
    }

    public void deleteAssignment(Assignment assignment){
        assignmentArrayList.remove(assignment);
    }

    public void addAssignment(Assignment assignment){
        assignmentArrayList.add(assignment);
    }
}
