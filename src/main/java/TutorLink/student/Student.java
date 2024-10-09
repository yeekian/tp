package TutorLink.student;

public class Student {
    private String matricNumber;
    private double GPA;

    public Student(String matricNumber, double GPA) {
        this.matricNumber = matricNumber;
        this.GPA = GPA;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public double getGPA() {
        return GPA;
    }
}
