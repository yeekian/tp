package tutorlink.student;

public class Student {
    private String matricNumber;
    private double GPA;

    public Student(String matricNumber) {
        this.matricNumber = matricNumber;
        this.GPA = 5.0; // Default GPA value if not given
    }

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

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
