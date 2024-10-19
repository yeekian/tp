package tutorlink.uipackage;

import tutorlink.exceptionspackage.TutorLinkException;
import tutorlink.resultpackage.CommandResult;

import java.util.Scanner;

public class Ui {
    private Scanner in = new Scanner(System.in);
    private final String LOGO = "___________      __               .____    .__        __    \n"
            + "\\__    ___/_ ___/  |_  ___________|    |   |__| ____ |  | __\n"
            + "  |    | |  |  \\   __\\/  _ \\_  __ \\    |   |  |/    \\|  |/ /\n"
            + "  |    | |  |  /|  | (  <_> )  | \\/    |___|  |   |  \\    < \n"
            + "  |____| |____/ |__|  \\____/|__|  |_______ \\__|___|  /__|_ \\\n"
            + "                                          \\/       \\/     \\/\n";
    private final String HALF_BREAK_LINE = "-------------------------";
    private final String FULL_BREAK_LINE = "--------------------------------------------------";

    public Ui() {
    }

    public String getUserInput() {
        return in.nextLine();
    }

    public void displayWelcomeMessage() {
        System.out.println(LOGO);
        System.out.println(FULL_BREAK_LINE);
        System.out.println("Hello! I'm TutorLink\nWhat can I do for you?");
        System.out.println(FULL_BREAK_LINE);
    }

    public void displayResult(CommandResult result) {
        System.out.println(HALF_BREAK_LINE + "   Result   " + HALF_BREAK_LINE);
        System.out.println(result.toString());
        System.out.println(FULL_BREAK_LINE);
    }

    public void displayException(TutorLinkException error) {
        System.out.println(HALF_BREAK_LINE + "   Error   " + HALF_BREAK_LINE);
        System.out.println(error.getMessage());
        System.out.println(FULL_BREAK_LINE);
    }
}
