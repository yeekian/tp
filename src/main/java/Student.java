public class Student {
    private String matricNumber;
    private double GPA;

    public Student(String matricNumber) {
        this.matricNumber = matricNumber;
        this.GPA = 0.0;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public double getGPA() {
        return GPA;
    }

    public void setMatricNumber(String matricNumber) {
        this.matricNumber = matricNumber;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
