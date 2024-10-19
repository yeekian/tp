package tutorlink.listpackage;

import tutorlink.exceptionspackage.ItemNotFoundException;
import tutorlink.exceptionspackage.TutorLinkException;
import tutorlink.studentpackage.Student;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentList extends ItemList {
    private ArrayList<Student> studentArrayList;

    public StudentList() {
        this.studentArrayList = new ArrayList<>();
    }

    public boolean deleteStudent(String matricNumber, String name) {
        Student student = new Student(matricNumber, name);
        return studentArrayList.remove(student);
    }

    public void addStudent(String matricNumber, String name) {
        Student student = new Student(matricNumber, name);
        studentArrayList.add(student);
    }

    public int getNumberOfStudents() {
        return studentArrayList.size();
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    @Override
    public String toString() {
        return IntStream.range(0, studentArrayList.size())
                .mapToObj(i -> (i + 1) + ": " + studentArrayList.get(i)) // 1-based index
                .collect(Collectors.joining("\n\t"));
    }

    public StudentList findStudentByMatricNumber(String matricNumber) throws TutorLinkException {
        StudentList filteredList = new StudentList();
        filteredList.studentArrayList = studentArrayList
                .stream()
                .filter(student -> student.getMatricNumber().equals(matricNumber))
                .collect(Collectors.toCollection(ArrayList::new));
        if(filteredList.studentArrayList.isEmpty()) {
            throw new ItemNotFoundException("No students with matricNumber " + matricNumber + " found");
        }
        return filteredList;
    }

    public StudentList findStudentByName(String name) throws ItemNotFoundException {
        StudentList filteredList = new StudentList();
        filteredList.studentArrayList = studentArrayList
                .stream()
                .filter(student -> student.getName().equals(name))
                .collect(Collectors.toCollection(ArrayList::new));
        if(filteredList.studentArrayList.isEmpty()) {
            throw new ItemNotFoundException("No students with name " + name + " found");
        }
        return filteredList;
    }
}
