package tutorlink.parser;

import tutorlink.command.*;

import java.util.HashMap;
import java.util.logging.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Logger LOGGER = Logger.getLogger(Parser.class.getName());

    private static final String EMPTY_INPUT_ERROR_MESSAGE = "Error: Input cannot be empty";
    private static final String UNKNOWN_COMMAND_ERROR_MESSAGE = "Error: Unknown command";

    private String extractCommandWord(String input) {
        String[] words = input.split("\\s+");
        return words[0]; //return the first word
    }


    public Command getCommand(String line) {
        String commandWord = extractCommandWord(line);

        switch (commandWord.toLowerCase()) {
        case AddStudentCommand.COMMAND_WORD:
            return new AddStudentCommand(); // Calls delete command handling method

        case DeleteStudentCommand.COMMAND_WORD:
            return new DeleteStudentCommand(); // Calls add command handling method

        case FindStudentCommand.COMMAND_WORD:
            return new FindStudentCommand(); // Lists all students

        case ListStudentCommand.COMMAND_WORD:
            return new ListStudentCommand(); // Lists all students

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand(); // Lists all students

        default:
            LOGGER.warning(UNKNOWN_COMMAND_ERROR_MESSAGE);
            return null; // or handle unknown command appropriately
        }

    }


    /**
     * Extracts command arguments from the input string based on the given argument prefixes.
     *
     * @param argumentPrefixes an array of valid argument prefixes (e.g., "n/", "i/")
     * @param line the user input containing command arguments
     * @return a HashMap where the keys are the prefixes (e.g., "n/", "i/") and the values are the corresponding arguments
     */
    public HashMap<String, String> getArguments(String[] argumentPrefixes, String line) {
        HashMap<String, String> arguments = new HashMap<>();

        // Build regex pattern dynamically from the provided argument prefixes
        StringBuilder regexBuilder = new StringBuilder("(?i)(");
        for (String prefix : argumentPrefixes) {
            regexBuilder.append(Pattern.quote(prefix)).append("|");
        }
        regexBuilder.setLength(regexBuilder.length() - 1); // Remove the last "|"
        regexBuilder.append(")([^\\s]+)"); // Capture the argument after the prefix

        String regex = regexBuilder.toString();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        // Iterate through all found tags and arguments
        while (matcher.find()) {
            String tag = matcher.group(1).toLowerCase(); // Group 1 is the tag (e.g., n/, i/, etc.)
            String argument = matcher.group(2).trim();   // Group 2 is the argument after the tag
            arguments.put(tag.substring(0, tag.length()), argument); // Store the tag (with '/') as the key, argument as the value
        }

        return arguments;
    }
}
