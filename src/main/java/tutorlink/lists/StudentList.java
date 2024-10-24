package tutorlink.lists;

import tutorlink.exceptions.DuplicateMatricNumberException;
import tutorlink.exceptions.StudentNotFoundException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.student.Student;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentList {

    //Use Java String formatting to replace %s with matricNumber
    private static final String ERROR_DUPLICATE_MATRIC_NUMBER_ON_ADD =
            "Error! Student with Matric Number, %s, already exists in the list!";
    private static final String TO_STRING_DELIMITER = "\n";
    private ArrayList<Student> studentArrayList;

    public StudentList() {
        this.studentArrayList = new ArrayList<>();
    }

    public boolean deleteStudent(String matricNumber) {
        matricNumber = matricNumber.toUpperCase();
        for (Student student : studentArrayList) {
            if (student.getMatricNumber().equals(matricNumber)) {
                return studentArrayList.remove(student);
            }
        }
        return false;
    }

    public void addStudent(String matricNumber, String name) throws DuplicateMatricNumberException {
        matricNumber = matricNumber.toUpperCase();
        Student student = new Student(matricNumber, name);
        for (Student s : studentArrayList) {
            if (s.getMatricNumber().equals(matricNumber)) {
                String errorMessage = String.format(ERROR_DUPLICATE_MATRIC_NUMBER_ON_ADD, matricNumber);
                throw new DuplicateMatricNumberException(errorMessage);
            }
        }
        studentArrayList.add(student);
    }

    public int size() {
        return studentArrayList.size();
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    @Override
    public String toString() {
        return IntStream.range(0, studentArrayList.size())
                .mapToObj(i -> ("\t" + (i + 1)) + ": " + studentArrayList.get(i)) // 1-based index
                .collect(Collectors.joining(TO_STRING_DELIMITER));
    }

    public StudentList findStudentByMatricNumber(String matricNumber) throws TutorLinkException {
        StudentList filteredList = new StudentList();
        filteredList.studentArrayList = studentArrayList
                .stream()
                .filter(student -> student.getMatricNumber().equals(matricNumber.toUpperCase()))
                .collect(Collectors.toCollection(ArrayList::new));
        if (filteredList.studentArrayList.isEmpty()) {
            throw new StudentNotFoundException("No students with matricNumber " + matricNumber + " found");
        }
        return filteredList;
    }

    public StudentList findStudentByName(String name) throws StudentNotFoundException {
        StudentList filteredList = new StudentList();
        filteredList.studentArrayList = studentArrayList
                .stream()
                .filter(student -> student.getName().contains(name))
                .collect(Collectors.toCollection(ArrayList::new));
        if (filteredList.studentArrayList.isEmpty()) {
            throw new StudentNotFoundException("No students with name " + name + " found");
        }
        return filteredList;
    }
}
