package tutorlink.studentpackage;

public class StudentClass {
    private String matricNumber;
    private double gpa;

    public StudentClass(String matricNumber) {
        this.matricNumber = matricNumber;
        this.gpa = 5.0; // Default gpa value if not given
    }

    public StudentClass(String matricNumber, double gpa) {
        this.matricNumber = matricNumber;
        this.gpa = gpa;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }
}
