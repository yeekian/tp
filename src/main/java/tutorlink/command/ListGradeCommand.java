package tutorlink.command;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Comparator;

import tutorlink.appstate.AppState;
import tutorlink.result.CommandResult;
import tutorlink.grade.Grade;

public class ListGradeCommand extends Command {

    public static final String COMMAND_WORD = "list_grade";
    private static final String MESSAGE_NO_GRADES = "No grades have been recorded yet.";

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> hashMap) {
        ArrayList<Grade> grades = appState.grades.getGradeArrayList();

        if (grades.isEmpty()) {
            return new CommandResult(MESSAGE_NO_GRADES);
        }

        Map<String, ArrayList<Grade>> gradesByStudent = grades.stream()
                .collect(Collectors.groupingBy(
                        grade -> grade.getStudent().getMatricNumber(),
                        TreeMap::new,
                        Collectors.toCollection(ArrayList::new)
                ));

        StringBuilder output = new StringBuilder("List of All Grades:\n\n");

        gradesByStudent.forEach((matricNumber, studentGrades) -> {
            output.append(String.format("Student %s:\n", matricNumber));

            studentGrades.stream()
                    .sorted(Comparator.comparing(grade -> grade.getComponent().getName()))
                    .forEach(grade -> output.append(String.format("%-15s: %.2f\n",
                            grade.getComponent().getName(),
                            grade.getScore())));

            output.append("\n");
        });

        return new CommandResult(output.toString());
    }

    @Override
    public String[] getArgumentPrefixes() {
        return null;
    }
}