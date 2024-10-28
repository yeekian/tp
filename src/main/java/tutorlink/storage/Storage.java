package tutorlink.storage;

import tutorlink.exceptions.StorageOperationException;
import tutorlink.student.Student;

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

    private Student getStudentFromFileLine (String fileLine) {
        String[] stringParts = fileLine.split(" \\| ");
        String matricNumber = stringParts[0];
        String name = stringParts[1];
        return new Student(matricNumber, name);
    }

}
