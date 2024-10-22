package tutorlink.grade;

import tutorlink.component.Component;
import tutorlink.student.Student;

public class Grade {
    private double score;
    private Component component;
    private Student student;

    public Grade(Component component, Student student, double score) {
        this.component = component;
        this.student = student;
        this.score = score;
    }

    public String getGradeMatricNumber(Student student) {
        return student.getMatricNumber();
    }

    public String getGradeComponentDescription(Student student) {
        return student.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Grade grade) {
            return this.score == grade.score
                    && this.component.equals(grade.component)
                    && this.student.equals(grade.student);
        }
        return false;
    }
}
