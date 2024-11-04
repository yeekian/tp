# Jin Zihan's Project Portfolio Page

## Project: TutorLink

TutorLink is an offline desktop application to help NUS professors manage class assignments.

### Summary of Contributions

- **Code contributed:** [RepoSense link](
  https://nus-cs2113-ay2425s1.github.io/tp-dashboard/?search=jinzihan2002&breakdown=true)

- **Features implemented:** 
  - Storage function
    - The `StudentStorage`, `ComponentStorage` and `GradeStorage` classes handle the loading and saving of the
    Student, Component and Grade lists into `.txt` data files.
    - This feature allows data from the application to be retained between runs, and automatically saves list data
    after every command execution.
    - The implementation allows corrupted lines in the data files to be ignored, instead of resetting to an empty file.
  - `ComponentList` class
    - This class contains the list of `Components`, as well as add, delete, find and toString methods.
    - The methods will check for validity or existence of the Component to be operated on.
- **Documentation:**
  - Developer Guide:
    - Created sequence diagram and documentation for the Storage classes: 
    [#104](https://github.com/AY2425S1-CS2113-W13-4/tp/pull/104)
- **Project Management:**
  - Assisted with release [`v1.0`](https://github.com/AY2425S1-CS2113-W13-4/tp/releases/tag/v1.0) and the
  migration of outstanding issues to `v2.0`.
