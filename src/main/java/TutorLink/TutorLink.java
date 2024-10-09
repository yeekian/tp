package tutorlink;

import java.util.Scanner;

/**
 * Represents the main class containing the entry point for the TutorLink application
 */
public class TutorLink {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo =   "___________      __               .____    .__        __    \n"
                +       "\\__    ___/_ ___/  |_  ___________|    |   |__| ____ |  | __\n"
                +       "  |    | |  |  \\   __\\/  _ \\_  __ \\    |   |  |/    \\|  |/ /\n"
                +       "  |    | |  |  /|  | (  <_> )  | \\/    |___|  |   |  \\    < \n"
                +       "  |____| |____/ |__|  \\____/|__|  |_______ \\__|___|  /__|_ \\\n"
                +       "                                          \\/       \\/     \\/\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
    }
}
