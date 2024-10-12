package tutorlink.listpackage;

import tutorlink.exceptionspackage.ItemNotFoundException;
import tutorlink.studentpackage.StudentClass;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StudentList extends ItemList {
    private ArrayList<StudentClass> studentArrayList;

    public StudentList() {
        this.studentArrayList = new ArrayList<>();
    }

    public boolean deleteStudent(StudentClass student) {
        return studentArrayList.remove(student);
    }

    public void addStudent(StudentClass student) {
        studentArrayList.add(student);
    }

    public int getNumberOfStudents() {
        return studentArrayList.size();
    }

    public ArrayList<StudentClass> getStudentArrayList() {
        return studentArrayList;
    }

    public StudentList filterList(String name, String matricNumber){
        StudentList filteredList = new StudentList();
        filteredList.studentArrayList = studentArrayList
                .stream()
                .filter(student -> {
                    boolean matchesName = (name == null || student.getName().equalsIgnoreCase(name));
                    boolean matchesMatricNumber = (matricNumber == null || student.getMatricNumber().equals(matricNumber));
                    return matchesName && matchesMatricNumber;
                })
                .collect(Collectors.toCollection(ArrayList::new));
        return filteredList;
    }
}
