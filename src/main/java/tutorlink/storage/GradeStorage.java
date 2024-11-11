package tutorlink.storage;

import tutorlink.component.Component;
import tutorlink.exceptions.InvalidDataFileLineException;
import tutorlink.grade.Grade;
import tutorlink.student.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeStorage extends Storage {
    private final ArrayList<Component> componentList;
    private final ArrayList<Student> studentList;

    public GradeStorage(String filePath, ArrayList<Component> componentList, ArrayList<Student> studentList) {
        super(filePath);
        this.componentList = componentList;
        this.studentList = studentList;
    }

    public ArrayList<Grade> loadGradeList() throws IOException {
        ArrayList<Grade> grades = new ArrayList<>();
        Scanner fileScanner = new Scanner(path);
        while (fileScanner.hasNext()) {
            try {
                Grade newGrade = getGradeFromFileLine(fileScanner.nextLine(), grades);
                grades.add(newGrade);
            } catch (InvalidDataFileLineException e) {
                discardedEntries.add(e.getMessage());
            }
        }
        return grades;
    }

    public void saveGradeList(ArrayList<Grade> grades) throws IOException {
        FileWriter fileWriter = new FileWriter(path.toFile());
        for (Grade grade : grades) {
            fileWriter.write(getFileInputForGrade(grade) + System.lineSeparator());
        }
        fileWriter.close();
    }

    private Grade getGradeFromFileLine(String fileLine, ArrayList<Grade> grades)
            throws InvalidDataFileLineException {
        String componentName;
        String matricNumber;
        double score;
        String[] stringParts = fileLine.split(READ_DELIMITER);

        try {
            componentName = stringParts[0].strip();
            matricNumber = stringParts[1].strip();
            score = Double.parseDouble(stringParts[2].strip());
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new InvalidDataFileLineException(fileLine);
        }

        Component selectedComp = null;
        for (Component comp : componentList) {
            if (comp.getName().equals(componentName)) {
                selectedComp = comp;
                break;
            }
        }

        Student selectedStudent = null;
        for (Student student : studentList) {
            if (student.getMatricNumber().equals(matricNumber)) {
                selectedStudent = student;
                break;
            }
        }

        if (selectedComp == null || selectedStudent == null) {
            throw new InvalidDataFileLineException(fileLine);
        }

        boolean isValidScore = (score >= 0 && score <= selectedComp.getMaxScore());
        Grade newGrade = new Grade(selectedComp, selectedStudent, score);
        if (!isValidScore || grades.contains(newGrade)) {
            throw new InvalidDataFileLineException(fileLine);
        }
        return newGrade;
    }

    private String getFileInputForGrade(Grade grade) {
        String componentName = grade.getComponent().getName();
        String matricNumber = grade.getStudent().getMatricNumber();
        double score = grade.getScore();
        return componentName + WRITE_DELIMITER + matricNumber + WRITE_DELIMITER + score;
    }

}
