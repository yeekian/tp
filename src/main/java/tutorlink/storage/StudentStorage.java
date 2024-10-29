package tutorlink.storage;

import tutorlink.student.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentStorage extends Storage {
    public StudentStorage(String filePath) {
        super(filePath);
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
        String[] stringParts = fileLine.split(READ_DELIMITER);
        String matricNumber = stringParts[0];
        String name = stringParts[1];
        return new Student(matricNumber, name);
    }

    private String getFileInputForStudent(Student student) {
        return student.getMatricNumber() + WRITE_DELIMITER + student.getName();
    }

}
