package tutorlink.storage;

import tutorlink.component.Component;
import tutorlink.exceptions.InvalidDataFileLineException;

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
        int totalWeight = 0;
        Scanner fileScanner = new Scanner(path);
        while (fileScanner.hasNext()) {
            try {
                Component newComponent = getComponentFromFileLine(fileScanner.nextLine(), components, totalWeight);
                totalWeight += newComponent.getWeight();
                components.add(newComponent);
            } catch (InvalidDataFileLineException e) {
                discardedEntries.add(e.getMessage());
            }
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

    private Component getComponentFromFileLine(
            String fileLine, ArrayList<Component> components, int totalWeight)
            throws InvalidDataFileLineException {
        String[] stringParts = fileLine.split(READ_DELIMITER);
        String name;
        double maxScore;
        int weight;
        try {
            name = stringParts[0].strip();
            maxScore = Double.parseDouble(stringParts[1].strip());
            weight = Integer.parseInt(stringParts[2].strip());
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new InvalidDataFileLineException(fileLine);
        }

        boolean isValidMaxScore = (maxScore >= 0);
        boolean isValidWeight = (weight >= 0 && (weight + totalWeight) <= 100);
        Component newComponent = new Component(name, maxScore, weight);
        if (!isValidMaxScore || !isValidWeight || components.contains(newComponent)) {
            throw new InvalidDataFileLineException(fileLine);
        }
        return newComponent;
    }

    private String getFileInputForComponent(Component component) {
        String convertedString = component.getName() + WRITE_DELIMITER + component.getMaxScore()
                + WRITE_DELIMITER + component.getWeight();
        return convertedString;
    }

}
