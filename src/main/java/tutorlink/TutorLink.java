package tutorlink;

import tutorlink.appstate.AppState;
import tutorlink.command.Command;
import tutorlink.component.Component;
import tutorlink.exceptions.StorageOperationException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.grade.Grade;
import tutorlink.result.CommandResult;
import tutorlink.storage.ComponentStorage;
import tutorlink.storage.GradeStorage;
import tutorlink.storage.StudentStorage;
import tutorlink.student.Student;
import tutorlink.ui.Ui;
import tutorlink.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.FileHandler;

/**
 * Represents the main class containing the entry point for the TutorLink application
 */
public class TutorLink {
    private static final String STUDENT_FILE_PATH = "./data/studentlist.txt";
    private static final String COMPONENT_FILE_PATH = "./data/componentlist.txt";
    private static final String GRADE_FILE_PATH = "./data/gradelist.txt";

    private static final Ui ui = new Ui();
    private static final Parser parser = new Parser();
    private static final AppState appState = new AppState();
    private static StudentStorage studentStorage;
    private static ComponentStorage componentStorage;
    private static GradeStorage gradeStorage;

    private static final Logger LOGGER = Logger.getLogger(TutorLink.class.getName());


    /**
     * Main entry-point for TutorLink
     */
    public static void main(String[] args) {

        setUpLogger();
        LOGGER.log(Level.INFO, "Test log message successful");

        ui.displayWelcomeMessage();

        try {
            studentStorage = new StudentStorage(STUDENT_FILE_PATH);
            componentStorage = new ComponentStorage(COMPONENT_FILE_PATH);

            ArrayList<Student> initialStudentList = studentStorage.loadStudentList();
            appState.students.setStudentArrayList(initialStudentList);

            ArrayList<Component> initialComponentList = componentStorage.loadComponentList();
            appState.components.setComponentArrayList(initialComponentList);

            gradeStorage = new GradeStorage(GRADE_FILE_PATH, initialComponentList, initialStudentList);
            ArrayList<Grade> initialGradeList = gradeStorage.loadGradeList();
            appState.grades.setGradeArrayList(initialGradeList);

        } catch (IOException | StorageOperationException e) {
            System.out.println("File storage error encountered: " + e.getMessage());
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                String line = ui.getUserInput();

                Command currentCommand = parser.getCommand(line);
                HashMap<String, String> arguments = parser.getArguments(currentCommand.getArgumentPrefixes(), line);

                CommandResult res = currentCommand.execute(appState, arguments);

                ui.displayResult(res);

                if (currentCommand.isExit()) {
                    try {
                        studentStorage.saveStudentList(appState.students.getStudentArrayList());
                        componentStorage.saveComponentList(appState.components.getComponentArrayList());
                        gradeStorage.saveGradeList(appState.grades.getGradeArrayList());
                    } catch (IOException e) {
                        System.out.println("File storage error encountered: " + e.getMessage());
                        throw new RuntimeException(e);
                    }
                    break;
                }
            } catch (TutorLinkException e) {
                ui.displayException(e);
            }
        }
    }

    private static void setUpLogger() {
        LogManager.getLogManager().reset();
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.WARNING);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        rootLogger.addHandler(ch);

        try {
            FileHandler fh = new FileHandler("myLogger.log");
            fh.setLevel(Level.FINE);
            rootLogger.addHandler(fh);
        } catch (IOException e) {
            //ignore
            rootLogger.log(Level.SEVERE, "File logger not working", e);
        }
    }
}
