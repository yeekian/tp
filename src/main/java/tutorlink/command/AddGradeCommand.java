package tutorlink.command;

import tutorlink.appstate.AppState;
import tutorlink.commons.Commons;
import tutorlink.component.Component;
import tutorlink.exceptions.ComponentNotFoundException;
import tutorlink.exceptions.DuplicateComponentException;
import tutorlink.exceptions.DuplicateMatricNumberException;
import tutorlink.exceptions.IllegalValueException;
import tutorlink.exceptions.StudentNotFoundException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.grade.Grade;
import tutorlink.lists.ComponentList;
import tutorlink.lists.StudentList;
import tutorlink.result.CommandResult;
import tutorlink.student.Student;
import java.util.HashMap;

import static tutorlink.lists.StudentList.STUDENT_NOT_FOUND;

public class AddGradeCommand extends Command {
    public static final String[] ARGUMENT_PREFIXES = {"i/", "c/", "s/"};
    public static final String COMMAND_WORD = "add_grade";
    private static final String ERROR_DUPLICATE_GRADE_ON_ADD = "Error! Grade (%s, %s) already exists in the list!";

    @Override
    public CommandResult execute(AppState appstate, HashMap<String, String> hashmap) throws TutorLinkException {
        String matricNumber = hashmap.get(ARGUMENT_PREFIXES[0]);
        String componentDescription = hashmap.get(ARGUMENT_PREFIXES[1]);
        String scoreNumber = hashmap.get(ARGUMENT_PREFIXES[2]);
        if (matricNumber == null || componentDescription == null || scoreNumber == null) {
            throw new IllegalValueException(Commons.ERROR_NULL);
        }

        Component component = findComponentFromComponents(appstate, componentDescription);

        assert component != null : "Component object should not be null after this point";

        Student student = findStudentFromStudents(appstate, matricNumber);

        assert student != null : "Student object should not be null after this point";

        //Convert scoreNumber to double
        try {
            double score = convertScoreToValidDouble(scoreNumber, component);

            //create a new grade object
            Grade grade = new Grade(component, student, score);

            appstate.grades.addGrade(grade);
        } catch (NumberFormatException e) {
            throw new IllegalValueException(Commons.ERROR_INVALID_SCORE);
        }

        return new CommandResult(String.format(Commons.ADD_GRADE_SUCCESS, scoreNumber, componentDescription,
                matricNumber));
    }

    private static double convertScoreToValidDouble(String scoreNumber, Component component) {
        double score = Double.parseDouble(scoreNumber);

        if (score < 0.0 || score > component.getMaxScore()) {
            throw new IllegalValueException(Commons.ERROR_INVALID_SCORE);
        }
        return score;
    }

    private static Student findStudentFromStudents(AppState appstate, String matricNumber) {
        //Get Student student object using String matricNumber
        StudentList studentFilteredList = appstate.students.findStudentByMatricNumber(matricNumber);

        Student student;
        if (studentFilteredList.size() == 1) {
            student = studentFilteredList.getStudentArrayList().get(0);
        } else if (studentFilteredList.size() == 0) {
            throw new StudentNotFoundException(String.format(STUDENT_NOT_FOUND, matricNumber));
        } else {
            String errorMessage = String.format(Commons.ERROR_DUPLICATE_STUDENT, matricNumber);
            throw new DuplicateMatricNumberException(errorMessage);
        }
        return student;
    }

    private static Component findComponentFromComponents(AppState appstate, String componentDescription) {
        //Get component object using String componentDescription
        ComponentList componentFilteredList = appstate.components.findComponent(componentDescription.toUpperCase());
        Component component;
        if (componentFilteredList.size() == 1) {
            component = componentFilteredList.getComponentArrayList().get(0);
        } else if (componentFilteredList.size() == 0) {
            throw new ComponentNotFoundException(String.format(Commons.ERROR_COMPONENT_NOT_FOUND,
                    componentDescription));
        } else {
            String errorMessage = String.format(Commons.ERROR_DUPLICATE_COMPONENT, componentDescription);
            throw new DuplicateComponentException(errorMessage);
        }
        return component;
    }

    @Override
    public String[] getArgumentPrefixes() {
        return ARGUMENT_PREFIXES;
    }
}
