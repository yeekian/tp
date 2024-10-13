package tutorlink;

import tutorlink.commandpackage.Command;
import tutorlink.consolepackage.Console;
import tutorlink.exceptionspackage.MissingNextLineException;
import tutorlink.resultpackage.CommandResult;
import tutorlink.uipackage.Ui;
import tutorlink.parserpackage.Parser;

/**
 * Represents the main class containing the entry point for the TutorLink application
 */
public class TutorLink {
    private static final Ui ui = new Ui();
    private static final Parser parser = new Parser();

    /** Main entry-point for TutorLink */
    public static void main(String[] args) {
        Console.printWelcomeMessage();
        while(true) {
            try {
                String line = ui.collectUserInput();
                Command command = parser.parse(line);
                CommandResult commandResult = command.execute();
                Console.displayCommandResult(commandResult);

            } catch (MissingNextLineException e) {
                Console.printMessage(e.getMessage());
            }
        }
    }
}
