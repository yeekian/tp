package tutorlink.storage;

import tutorlink.component.Component;
import tutorlink.exceptions.InvalidDataFileLineException;
import tutorlink.grade.Grade;
import tutorlink.student.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * GradeStorage is responsible for loading and saving grade data to and from a file.
 * It extends the Storage class and manages the list of components and students.
 */
public class GradeStorage extends Storage {
    private final ArrayList<Component> componentList;
    private final ArrayList<Student> studentList;

    /**
     * Constructs a GradeStorage object with the specified file path, component list, and student list.
     *
     * @param filePath the path to the file where grade data is stored
     * @param componentList the list of components
     * @param studentList the list of students
     */
    public GradeStorage(String filePath, ArrayList<Component> componentList, ArrayList<Student> studentList) {
        super(filePath);
        this.componentList = componentList;
        this.studentList = studentList;
    }

    /**
     * Loads the list of grades from the file.
     *
     * @return an ArrayList of Grade objects loaded from the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public ArrayList<Grade> loadGradeList() throws IOException {
        // method implementation
    }

    /**
     * Saves the list of grades to the file.
     *
     * @param grades the list of Grade objects to be saved
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public void saveGradeList(ArrayList<Grade> grades) throws IOException {
        // method implementation
    }

    /**
     * Parses a line from the file and creates a Grade object.
     *
     * @param fileLine the line from the file to be parsed
     * @param grades the list of grades already loaded
     * @return a Grade object created from the file line
     * @throws InvalidDataFileLineException if the file line is invalid or contains incorrect data
     */
    private Grade getGradeFromFileLine(String fileLine, ArrayList<Grade> grades)
            throws InvalidDataFileLineException {
        // method implementation
    }

    /**
     * Converts a Grade object to a string format suitable for writing to the file.
     *
     * @param grade the Grade object to be converted
     * @return a string representation of the Grade object
     */
    private String getFileInputForGrade(Grade grade) {
        // method implementation
    }
}
