package tutorlink.commandpackage;

import tutorlink.coursepackage.LetterGrade;
import tutorlink.exceptionspackage.CourseNotFoundException;
import tutorlink.exceptionspackage.IllegalValueException;
import tutorlink.exceptionspackage.InvalidWeightingException;
import tutorlink.exceptionspackage.StudentNotFoundException;
import tutorlink.coursepackage.Course;
import tutorlink.listpackage.CourseList;
import tutorlink.resultpackage.CommandResult;
import tutorlink.studentpackage.StudentClass;

public class GetCourseGradeStudentCommand extends Command {

    private String courseID;
    private String studentName;

    public GetCourseGradeStudentCommand(String courseID, String name) {
        this.courseID = courseID;
        this.studentName = name;
    }

    private StudentClass findStudent() throws StudentNotFoundException {
        for (StudentClass student : students.getStudentArrayList()) {
            if (student.getName().equals(this.studentName)) {
                return student;
            }
        }

        throw new StudentNotFoundException();
    }


    private Course findCourse(CourseList courses, String courseID) throws CourseNotFoundException {
        for (Course course : courses.getCourseArrayList()) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }

        throw new CourseNotFoundException();
    }

    @Override
    public CommandResult execute () {

        try {
            StudentClass student = findStudent();
            CourseList courses = student.getCourses();
            Course course = findCourse(courses, courseID);

            LetterGrade grade = course.getLetterGrade();
            //Get the grade of the course
            return new CommandResult(grade.toString());

        } catch (StudentNotFoundException e) {
            System.out.println("Student not found");
        } catch (CourseNotFoundException e) {
            System.out.println("Course not found");
        } catch (InvalidWeightingException e) {
            System.out.println("Invalid weighting in course");
        }

        throw new IllegalValueException("Error getting course grade for student");
    }
}
