package tutorlink.resultpackage;

import tutorlink.listpackage.ItemList;

public class CommandResult {

    private static final String LINE_SEPARATOR = "\n\t";

    public final String message;
    public final ItemList returnedList;

    public CommandResult(String message) {
        this.message = message;
        this.returnedList = null;
    }

    public CommandResult(String message, ItemList returnedList) {
        this.message = message;
        this.returnedList = returnedList;
    }

    @Override
    public String toString() {
        return message + LINE_SEPARATOR + (returnedList == null ? "" : returnedList.toString());
    }
}
