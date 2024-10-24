# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

### Architecture
The high-level design of TutorLink is as depicted in the following **Architecture Diagram**:


**Main Components of the Architecture**

<code>TutorLink</code>: Main class that serves as the main entry point of the application. 
- At app launch, TutorLink initializes components (<code>Parser</code>, <code>Ui</code>, <code>Storage</code>, <code>AppState</code>).
- On app shutdown, it shuts down the components and invokes cleanup methods.

The key classes providing functionality to TutorLink are: 
1. <code>AppState</code>: Stores global variables/resources required by TutorLink at run time.
2. <code>Ui</code>: Collects data (via Strings sent via CLI) from the user and relays information to the user (via printing back to the CLI).
3. <code>Parser</code>: Interprets the raw data from the user; applies data validation and handles necessary exceptions.
4. <code>Storage</code>: Serves as long-term storage of data to be retained even after TutorLink is shut down.

<code>CommandResult</code> represents the result of user input.

### How the architecture components Interact with one another

The sequence diagram below depicts a typical user interaction with <code>TutorLink</code>:


## Product Scope

### Target User Profile

The target users for **TutorLink** are professors at NUS who manage small, single-staffed classes. These professors typically have strong technical expertise but are often overwhelmed by time-consuming administrative tasks that detract from their ability to focus on teaching and curriculum development.

#### Key Characteristics:
- **Time-Constrained**: Professors have limited time for lesson preparation due to the administrative burden of managing grades, assignments, and attendance.
- **Technologically Savvy**: While proficient in using educational platforms, they often find existing tools slow, overly complex, or requiring constant internet connectivity.
- **Desire for Simplicity**: They prefer tools that are easy to use, automate repetitive tasks, and function offline, allowing them to streamline administrative work without unnecessary complexity.

The target user values efficiency, reliability, and simplicity, seeking a solution that reduces administrative workload and enables them to focus more on the core aspects of teaching.

### Value Proposition

**TutorLink** solves the problem of administrative overload by automating routine tasks such as managing assignments, and monitoring student performance. Professors often struggle with time-consuming admin work that takes away from their primary focus: teaching and preparing lessons.

By offering an offline, lightweight solution that simplifies these processes, TutorLink helps professors:
- Save time by automating tedious administrative tasks.
- Access important information quickly, without needing an internet connection.
- Focus on teaching and lesson development instead of being bogged down by admin work.

In contrast to bloated systems, TutorLink is designed to be fast, simple, and effective—freeing up valuable time and enhancing teaching efficiency.

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
