# Ethan Chua's Project Portfolio Page

## Project: TutorLink
TutorLink is a desktop CLI application designed to help
University professors better manage the grades of students 
reading their course. 

TutorLink keeps a running tally of grades (GPA, overall score) of each 
`Student` by tagging `Components` to each student via a `Grade` object. 

TutorLink provides useful summary statistics of a professor's course that
can be further filtered down for analysis. 

### Summary of Contributions

- `add_student` command:
    -  Allows professors to add a student (with parameters `name` and `matriculation number`)
       to the registry of students in the application.
    - This feature allows professors to input all students in their course into the application.
- `delete_student` command: 
    - Allows professors to delete student using `matric number`
    - This feature allows professors to remove students should they withdraw/drop
    the course.
- `find_student` command: 
    - Allows professors to search for students using
  either `matric number` or `name`.
    - This feature allows professors to quickly search for students in their course.
- `list_student` command: 
    - Allows professors to list all students in their course65
    - This feature gives professors a quick and dirty overview of their students.

- `delete_component` command: 
    - Allows professors to delete a component (exam, assignment, class part etc) from the app
    - This feature allows professors to remove components that are entered incorrectly or are 
no longer part of the course.


- **Code Contribution**: [RepoSense](https://nus-cs2113-ay2425s1.github.io/tp-dashboard/?search=rcpilot1604&breakdown=true)

- Project Management: 
    - Managed `V1.0`. Set up project structure for team [#16](https://github.com/AY2425S1-CS2113-W13-4/tp/pull/16),
[#17](https:Or//github.com/AY2425S1-CS2113-W13-4/tp/pull/17)
    - Setup GitHub Organization and Repo for team
- Enhancement to existing features: 
    - Modified `delete_student` and `delete_component` commands to delete all matching grades: [#81](https://github.com/AY2425S1-CS2113-W13-4/tp/pull/81)
    - Implemented major restructuring/refactoring to codebase: [#25](https://github.com/AY2425S1-CS2113-W13-4/tp/pull/25),
[#52](https://github.com/AY2425S1-CS2113-W13-4/tp/pull/52), 
[#86](https://github.com/AY2425S1-CS2113-W13-4/tp/pull/86)
    - Wrote tests for `GradeList` and `DeleteComponentCommand`
- **Documentation**:
    - User Guide
      - Added documentation for input validation [#101](https://github.com/AY2425S1-CS2113-W13-4/tp/pull/101)
    - Developer Guide
      - Created Overarching Class Diagram: [#36](https://github.com/AY2425S1-CS2113-W13-4/tp/pull/36)
      - Created Class and Sequence Diagram for Architecture: [#65](https://github.com/AY2425S1-CS2113-W13-4/tp/pull/65/files)
      - Created Sequence Diagram for overall logic flow and standardized colour template for DG: [#99](https://github.com/AY2425S1-CS2113-W13-4/tp/pull/99)
    - Community
      - PRs reviewed: [#17](https://github.com/nus-cs2113-AY2425S1/tp/pull/17)