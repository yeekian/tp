package tutorlink.listpackage;

import tutorlink.studentpackage.StudentClass;

import java.util.ArrayList;

public class StudentList extends ItemList {
    private ArrayList<StudentClass> studentArrayList;

    public StudentList() {
        this.studentArrayList = new ArrayList<>();
    }

    public void deleteStudent(StudentClass student) {
        studentArrayList.remove(student);
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
}
