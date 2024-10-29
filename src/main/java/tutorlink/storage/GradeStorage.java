package tutorlink.storage;

import tutorlink.component.Component;
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

    public ArrayList<Grade> loadGradeList()
            throws IOException {
        ArrayList<Grade> grades = new ArrayList<>();
        Scanner fileScanner = new Scanner(path);
        while (fileScanner.hasNext()) {
            String[] stringParts = fileScanner.nextLine().split(READ_DELIMITER);
            String componentName = stringParts[0];
            String matricNumber = stringParts[1];
            double score = Double.parseDouble(stringParts[2]);

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

            if (selectedComp != null && selectedStudent != null) {
                Grade newGrade = new Grade(selectedComp, selectedStudent, score);
                grades.add(newGrade);
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

    private String getFileInputForGrade(Grade grade) {
        String componentName = grade.getComponent().getName();
        String matricNumber = grade.getStudent().getMatricNumber();
        double score = grade.getScore();
        return componentName + WRITE_DELIMITER + matricNumber + WRITE_DELIMITER + score;
    }

}
