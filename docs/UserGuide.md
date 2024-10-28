# TutorLink

## Introduction

**TutorLink** is a streamlined, offline application developed for professors at NUS who manage single-staffed classes. It is designed to simplify the management of class assignments, and other administrative tasks, allowing professors to focus on teaching and curriculum development. By automating repetitive tasks and providing quick access to essential information, TutorLink saves valuable time and reduces the burden of administrative work.

## Quick Start

1. Ensure you have Java 17 or above installed in your Computer.
2. Download the latest .jar file  of `TutorLink` from [here](http://link.to/duke).
3. Copy the file to the folder you want to use as the home folder for your TutorLink.
4. Open a command terminal, cd into the folder you put the jar file in, and use the java -jar TutorLink.jar command to run the application.

Your command terminal should look similar to the one below.
![tutorlink_startup.png](tutorlink_startup.png)
## Features 

### Adding a Student: `add_student`

Adds a student to your class.

- **Format**: `add_student i/MATRIC_NUMBER n/STUDENT_NAME`
- **Parameters**:
    - `STUDENT_NAME`: The full name of the student.
    - `MATRIC_NUMBER`: A unique identifier for the student.

- **Example**:
    - `add_student i/A1234567X n/John Doe ` adds a new student named John Doe with the matric number of A1234567X to the class.

---

### Deleting a Student: `delete_student`

Removes a student from the class. Note that a student can only be deleted using his/her matric number to prevent identification errors.

- **Format**: `delete_student i/MATRIC_NUMBER`
- **Parameters**:
    - `MATRIC_NUMBER`: The unique identifier of the student to be deleted.

- **Example**:
    - `delete_student i/A1234567X` deletes a student with the matric number of A1234567X.

---

### Listing All Students: `list_student`

Displays a list of all students in the class.

- **Format**: `list_student`

- **Example**:
    - `list_student`

---

### Adding a Grade of a Component for a Student: `add_grade`

Records a grade for a specific student in a particular assignment or exam component.
- **Format**: `add_grade i/MATRIC_NUMBER c/COMPONENT  s/SCORE`
- **Parameters**:
    - `MATRIC_NUMBER`: The unique identifier of the student.
    - `COMPONENT`: The assignment or exam component.
    - `SCORE`: The score to be recorded. Note that score cannot exceed the max score of the component.

- **Example**:
    - `add_grade i/A1234567X c/Quiz 1 s/85` adds the grade of Quiz 1 for the student with the matric number of A1234567X with a score of 85.

---

### Deleting a Grade of a Component for a Student: `delete_grade`

Removes a previously recorded grade for a specific student and component.

- **Format**: `delete_grade i/MATRIC_NUMBER c/COMPONENT`
- **Parameters**:
    - `MATRIC_NUMBER`: The unique identifier of the student.
    - `COMPONENT`: The assignment or exam component.

- **Example**:
    - `delete_grade i/A1234567X c/Quiz 1` deletes the grade of Quiz 1 for the student with the matric number of A1234567X.

---

### Listing Grades of a Student: `list_grade`

Views all recorded grades and the final grade for a specific student. If the weightage of the components do not add up to 100% (i.e. the course is still in progress), IP will be returned as the final grade.

- **Format**: `list_grades i/MATRIC_NUMBER`
- **Parameters**:
    - `MATRIC_NUMBER`: The unique identifier of the student.

- **Example**:
    - `list_grade i/A1234567X`

### Adding a Component: `add_component`

Adds a new grading component to the class (e.g., "Homework," "Midterm," "Final Exam").

- **Format**: `add_component c/COMPONENT w/WEIGHT m/MAX_SCORE`
- **Parameters**:
    - `COMPONENT`: The name of the grading component.
    - `WEIGHT`: The weight of the component as a percentage, input as an integer from 0 - 100 (inclusive).
    - `MAX_SCORE`: The max_score of the component.

- **Example**:
    - `add_component c/Quiz 1 w/30 m/50` adds a Quiz 1 component with a weightage of 30%, it has a max score of 50 marks.

---

### Deleting a Component: `delete_component`

Removes an existing grading component from the class.

- **Format**: `delete_component c/COMPONENT`
- **Parameters**:
    - `COMPONENT`: The name of the grading component to delete.

- **Example**:
    - `delete_component c/Quiz 1` deletes Quiz 1 component from the list of components that form the final grade.

---

### Listing Components: `list_component`

Displays all grading components and their respective weights for a class.

- **Format**: `list_component`

- **Example**:
    - `list_component`

---


## FAQ

**Q**: How do I transfer my data to another computer?

**A**: To transfer data, simply copy the `TutorLink` home folder (where the `.jar` file and data files are located) to your new computer. Then, download Java 17 (if not already installed), place the `.jar` file in the copied folder, and run `java -jar TutorLink.jar` from that folder.

---

## Command Summary

| **Command**               | **Description**                                     | **Example**                                 |
|---------------------------|-----------------------------------------------------|---------------------------------------------|
| `add_student`             | Adds a student to the class roster                  | `add_student i/A1234567X n/John Doe`        |
| `delete_student`          | Deletes a student from the class roster             | `delete_student i/A1234567X`                |
| `list_student`            | Lists all students in the class                     | `list_student`                              |
| `add_grade`               | Adds a grade for a student for a specific component | `add_grade i/A1234567X c/Quiz 1 s/85`       |
| `delete_grade`            | Deletes a student's grade for a specific component  | `delete_grade i/A1234567X c/Quiz 1`         |
| `list_grade`              | Lists all grades for a student                      | `list_grade i/A1234567X`                    |
| `add_component`           | Adds a new grading component to the class           | `add_component c/Quiz 1 w/30 m/50`          |
| `delete_component`        | Deletes a grading component from the class          | `delete_component c/Quiz 1`                 |
| `list_component`          | Lists all grading components                        | `list_component`                            |

---

