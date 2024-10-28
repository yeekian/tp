package tutorlink.storage;

import tutorlink.component.Assignment;
import tutorlink.component.ClassParticipation;
import tutorlink.component.Component;
import tutorlink.component.Exam;
import tutorlink.exceptions.StorageOperationException;
import tutorlink.grade.Grade;
import tutorlink.student.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public final Path path;

    public Storage(String filePath) throws StorageOperationException {
        path = Paths.get(filePath);
        try {
            Files.createDirectories(path.getParent());
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            throw new StorageOperationException("Error while creating file: " + path);
        }
    }

    public ArrayList<Student> loadStudentList() throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        Scanner fileScanner = new Scanner(path);
        while (fileScanner.hasNext()) {
            students.add(getStudentFromFileLine(fileScanner.nextLine()));
        }
        return students;
    }

    public void saveStudentList(ArrayList<Student> students) throws IOException {
        FileWriter fileWriter = new FileWriter(path.toFile());
        for (Student student : students) {
            fileWriter.write(getFileInputForStudent(student) + System.lineSeparator());
        }
        fileWriter.close();
    }

    private Student getStudentFromFileLine(String fileLine) {
        String[] stringParts = fileLine.split(" \\| ");
        String matricNumber = stringParts[0];
        String name = stringParts[1];
        return new Student(matricNumber, name);
    }

    private String getFileInputForStudent(Student student) {
        return student.getMatricNumber() + " | " + student.getName();
    }

    public ArrayList<Component> loadComponentList() throws IOException {
        ArrayList<Component> components = new ArrayList<>();
        Scanner fileScanner = new Scanner(path);
        while (fileScanner.hasNext()) {
            components.add(getComponentFromFileLine(fileScanner.nextLine()));
        }
        return components;
    }

    public void saveComponentList(ArrayList<Component> components) throws IOException {
        FileWriter fileWriter = new FileWriter(path.toFile());
        for (Component comp : components) {
            fileWriter.write(getFileInputForComponent(comp) + System.lineSeparator());
        }
        fileWriter.close();
    }

    private Component getComponentFromFileLine(String fileLine) {
        String[] stringParts = fileLine.split(" \\| ");
        String componentType = stringParts[0];
        String name = stringParts[1];
        double maxScore = Double.parseDouble(stringParts[2]);
        double weight = Double.parseDouble(stringParts[3]);
        switch (componentType) {
        case "P":
            return new ClassParticipation(name, maxScore, weight);
        case "A":
            return new Assignment(name, maxScore, weight);
        case "E":
            return new Exam(name, maxScore, weight);
        default:
            throw new RuntimeException();
        }
    }

    private String getFileInputForComponent(Component component) {
        String convertedString = "";
        if (component instanceof ClassParticipation) {
            convertedString += "P | ";
        } else if (component instanceof Assignment) {
            convertedString += "A | ";
        } else if (component instanceof Exam) {
            convertedString += "E | ";
        }
        convertedString += component.getName() + " | " + component.getMaxScore() + " | " + component.getWeight();
        return convertedString;
    }
    public void saveGradeList(ArrayList<Grade> grades) throws IOException {
        FileWriter fileWriter = new FileWriter(path.toFile());
        for (Grade grade : grades) {
            fileWriter.write(getFileInputForGrade(grade));
        }
        fileWriter.close();
    }

    private String getFileInputForGrade(Grade grade) {
        String componentName = grade.getComponent().getName();
        String matricNumber = grade.getStudent().getMatricNumber();
        double score = grade.getScore();
        return componentName + " | " + matricNumber + " | " + score;
    }
}
