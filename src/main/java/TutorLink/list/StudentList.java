package TutorLink.list;

import TutorLink.list.List;
import tutorlink.student.Student;
import java.util.ArrayList;

public class StudentList extends List {
    private ArrayList<Student> studentArrayList;

    public StudentList() {
        this.studentArrayList = new ArrayList<>();
    }

    public void deleteStudent(Student student) {
        studentArrayList.remove(student);
    }

    public void addStudent(Student student) {
        studentArrayList.add(student);
    }

    public int getNumberOfStudents() {
        return studentArrayList.size();
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }
}
