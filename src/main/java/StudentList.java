import java.util.ArrayList;
import java.util.Arrays;

public class StudentList {
    private Integer numberOfStudents;
    private Student[] studentList = new Student[0];
    ArrayList<Student> studentArrayList = new ArrayList<>(Arrays.asList(studentList));

    public StudentList() {
        this.numberOfStudents = 0;
    }

    public void deleteStudent(Student student){
        studentArrayList.remove(student);
    }

    public void addStudent(Student student){
        studentArrayList.add(student);
    }
}
