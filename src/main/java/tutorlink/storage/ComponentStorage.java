package tutorlink.storage;

import tutorlink.component.Component;
import tutorlink.exceptions.InvalidDataFileLineException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ComponentStorage is responsible for loading and saving a list of components from and to a file.
 * It extends the Storage class and provides specific implementations for handling Component objects.
 */
public class ComponentStorage extends Storage {

    /**
     * Constructs a ComponentStorage object with the specified file path.
     *
     * @param filePath The path to the file where components are stored.
     */
    public ComponentStorage(String filePath) {
        super(filePath);
    }

    /**
     * Loads a list of components from the file specified by the path.
     *
     * @return An ArrayList of Component objects loaded from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public ArrayList<Component> loadComponentList() throws IOException {
        // Method implementation
    }

    /**
     * Saves a list of components to the file specified by the path.
     *
     * @param components An ArrayList of Component objects to be saved to the file.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public void saveComponentList(ArrayList<Component> components) throws IOException {
        // Method implementation
    }

    /**
     * Parses a line from the file and creates a Component object from it.
     *
     * @param fileLine The line from the file to be parsed.
     * @param components The list of components already loaded, used to check for duplicates.
     * @param totalWeight The total weight of the components already loaded.
     * @return A Component object created from the file line.
     * @throws InvalidDataFileLineException If the file line is invalid or contains incorrect data.
     */
    private Component getComponentFromFileLine(
            String fileLine, ArrayList<Component> components, int totalWeight)
            throws InvalidDataFileLineException {
        // Method implementation
    }

    /**
     * Converts a Component object to a string suitable for writing to the file.
     *
     * @param component The Component object to be converted.
     * @return A string representation of the Component object.
     */
    private String getFileInputForComponent(Component component) {
        // Method implementation
    }
}
    }

}
