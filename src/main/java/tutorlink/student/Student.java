package tutorlink.student;

public class Student {
    private String matricNumber;
    private String name;
    private double gpa;

    public Student(String matricNumber, String name) {
        this.name = name;
        this.matricNumber = matricNumber.toUpperCase();
        this.gpa = 0.0;
    }

    public Student(String matricNumber, String name, double gpa) {
        this.name = name;
        this.matricNumber = matricNumber.toUpperCase();
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return this.name + " (matric no: " + this.matricNumber + ", GPA: " + this.gpa + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        Student s = (Student) obj;
        return this.matricNumber.equals(s.getMatricNumber());
    }
}
