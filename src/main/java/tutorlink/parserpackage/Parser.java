package tutorlink.parserpackage;

import tutorlink.commandpackage.studentcommand.AddStudentCommand;
import tutorlink.commandpackage.studentcommand.DeleteStudentCommand;
import tutorlink.listpackage.StudentList;
import tutorlink.studentpackage.StudentClass;
import exception.StudentNotFoundException;

public class Parser {

    /**
     * Finds a student in the provided student list by matriculation number.
     *
     * @param matricNumber the matriculation number of the student to find
     * @param studentList the list of students to search in
     * @return the Student object with the given matriculation number
     * @throws StudentNotFoundException if no student with the given matriculation number is found
     */
    private StudentClass findStudent(String matricNumber, StudentList studentList) throws StudentNotFoundException {
        for (StudentClass a : studentList.getStudentArrayList()) {
            if (a.getMatricNumber().equals(matricNumber)) {
                return a;
            }
        }
        throw new StudentNotFoundException();
    }

    /**
     * Creates an AddStudentCommand for adding a new student.
     *
     * @param matricNumber the matriculation number of the new student
     * @param gpa the gpa of the new student
     * @return an AddStudentCommand object to add the new student
     */
    public AddStudentCommand addStudentCommand(String matricNumber, double gpa) {
        StudentClass newStudent = new StudentClass(matricNumber, gpa);
        AddStudentCommand addStudentCommand = new AddStudentCommand(newStudent);
        return addStudentCommand;
    }

    /**
     * Creates a DeleteStudentCommand for deleting a student with the given matriculation number.
     *
     * @param matricNumber the matriculation number of the student to delete
     * @param studentList the list of students to search for the student
     * @return a DeleteStudentCommand object to delete the student
     */
    public DeleteStudentCommand deleteStudentCommand(String matricNumber, StudentList studentList) {
        try {
            StudentClass selectedStudent = findStudent(matricNumber, studentList);
            DeleteStudentCommand deleteStudentCommand = new DeleteStudentCommand(selectedStudent);
            return deleteStudentCommand;
        } catch (StudentNotFoundException e) {
            System.out.println("Student Not Found.");
        }
        return null; // Return null if the student is not found
    }

}
