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

## Important Notes on Commands:
When inputting commands into `TutorLink`, kindly take note of the following:
- Commands with duplicate parameters will be rejected. *i.e* `add_student n/John Doe n/John Doe i/A1234567X`
- Parameters must be separated by at least one space character, otherwise the entire continuous string following a prefix
will be considered a single parameter. *i.e* `add_student i/A1234567X n/John Doei/A1234567X` will be intepreted as adding
a student with the name of `John Doei/A1234567X` and matric number `A1234567X`.
- Parameters can be supplied in any order. *i.e* `add_student n/John i/A1234567X` is the same as `add_student i/A1234567X n/John`
- **IMPORTANT**: Descriptions should **NOT** contain any separator tokens: `|` as this character is used for storage). 
Including these may yield unpredictable results with the `Storage` component. 
- Matric Number (`i/` argument) is case insensitive. Therefore, `A1234567X` is the same as `a1234567x`. Matric numbers 
will be converted to uppercase for storage.
- Similarly, all other will be converted to lowercase for storage.
## Features 

<div style="page-break-after: always;"></div>

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

<div style="page-break-after: always;"></div>

### Finding a Student: `find_student`

Adds a student to your class.

- **Format**: `find_student i/MATRIC_NUMBER n/STUDENT_NAME`
- **Parameters**:
  - `STUDENT_NAME`: The full name of the student.
  - `MATRIC_NUMBER`: A unique identifier for the student.

- **Example**:
  - `find_student i/A1234567X n/John Doe ` find the student named John Doe with the matric number of A1234567X among the list of students and prints out the student information.
---

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

<div style="page-break-after: always;"></div>

### Listing Components: `list_component`

Displays all grading components and their respective weights for a class.

- **Format**: `list_component`

- **Example**:
    - `list_component`

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

<div style="page-break-after: always;"></div>

### Listing Grades: `list_grade`

Views all recorded grades for a specific student or all students, and final percentage calculation. If the weightage of components does not add up to 100% (i.e., the course is still in progress), "IP" (In Progress) will be shown instead of a final percentage.

- **For a Specific Student**:
  - Lists all recorded grades and the final percentage for the specified student. 
  - **Format**: `list_grade i/MATRIC_NUMBER`
  - **Parameters**:
    - `MATRIC_NUMBER`: The unique identifier of the student.
  - **Example**:
    - `list_grade i/A1234567X`


- **For All Students**:
  - Lists all recorded grades for each student in a numbered format, with individual grade details and a final percentage for each student.
  - **Format**: `list_grade`


---

### Exiting the program: `bye`

Exits the program.
- **Format**: `bye`

---
### Saving the data

TutorLink data is saved in the hard disk automatically after every command execution. There is no need to save manually.
Existing data from previous application runs are loaded on startup.

The data from the student, component and grade lists are stored in `studentlist.txt`, `componentlist.txt` and `gradelist.txt`
respectively, located in the `[JAR file location]/data/` directory.

---

<div style="page-break-after: always;"></div>

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: To transfer data, simply copy the `TutorLink` home folder (where the `.jar` file and data files are located) to your new computer. Then, download Java 17 (if not already installed), place the `.jar` file in the copied folder, and run `java -jar TutorLink.jar` from that folder.

**Q**: Can I update data by directly editing the data files?

**A**: Do so at your own risk. If changes to the data file alter its format, invalid file lines will discarded 
during startup, and displayed in the command line for verification. While TutorLink can detect most invalid file entries, 
certain edits can cause unexpected behaviour. Therefore, it is not recommended to edit the data files
unless you are confident you can do so correctly.

---

<div style="page-break-after: always;"></div>

## Command Summary

| **Command**        | **Description**                                              | **Example**                           |
|--------------------|--------------------------------------------------------------|---------------------------------------|
| `add_student`      | Adds a student to the class roster                           | `add_student i/A1234567X n/John Doe`  |
| `delete_student`   | Deletes a student from the class roster                      | `delete_student i/A1234567X`          |
| `list_student`     | Lists all students in the class                              | `list_student`                        |
| `find_student`     | Finds a student in the class roster by name or matric number | `find_student i/A1234567X n/John Doe` |
| `add_component`    | Adds a new grading component to the class                    | `add_component c/Quiz 1 w/30 m/50`    |
| `delete_component` | Deletes a grading component from the class                   | `delete_component c/Quiz 1`           |
| `list_component`   | Lists all grading components                                 | `list_component`                      |
| `add_grade`        | Adds a grade for a student for a specific component          | `add_grade i/A1234567X c/Quiz 1 s/85` |
| `delete_grade`     | Deletes a student's grade for a specific component           | `delete_grade i/A1234567X c/Quiz 1`   |
| `list_grade`       | Lists all grades for a student                               | `list_grade i/A1234567X`              |
| `bye`              | Exits the program                                            | `bye`                                 |

---


