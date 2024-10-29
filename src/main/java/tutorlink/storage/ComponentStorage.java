package tutorlink.storage;

import tutorlink.component.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ComponentStorage extends Storage {
    public ComponentStorage(String filePath) {
        super(filePath);
    }

    public ArrayList<Component> loadComponentList() throws IOException {
        ArrayList<Component> components = new ArrayList<>();
        Scanner fileScanner = new Scanner(path);
        while (fileScanner.hasNext()) {
            components.add(getComponentFromFileLine(fileScanner.nextLine()));
        }
        return components;
    }

    public void saveComponentList(ArrayList<Component> components) throws IOException {
        FileWriter fileWriter = new FileWriter(path.toFile());
        for (Component comp : components) {
            fileWriter.write(getFileInputForComponent(comp) + System.lineSeparator());
        }
        fileWriter.close();
    }

    private Component getComponentFromFileLine(String fileLine) {
        String[] stringParts = fileLine.split(READ_DELIMITER);
        String name = stringParts[0];
        double maxScore = Double.parseDouble(stringParts[1]);
        double weight = Double.parseDouble(stringParts[2]);
        return new Component(name, maxScore, weight);
    }

    private String getFileInputForComponent(Component component) {
        String convertedString = component.getName() + WRITE_DELIMITER + component.getMaxScore()
                + WRITE_DELIMITER + component.getWeight();
        return convertedString;
    }

}
