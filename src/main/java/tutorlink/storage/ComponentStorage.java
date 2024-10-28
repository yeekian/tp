package tutorlink.storage;

import tutorlink.component.Assignment;
import tutorlink.component.ClassParticipation;
import tutorlink.component.Component;
import tutorlink.component.Exam;

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
        String componentType = stringParts[0];
        String name = stringParts[1];
        double maxScore = Double.parseDouble(stringParts[2]);
        double weight = Double.parseDouble(stringParts[3]);
        switch (componentType) {
        case "P":
            return new ClassParticipation(name, maxScore, weight);
        case "A":
            return new Assignment(name, maxScore, weight);
        case "E":
            return new Exam(name, maxScore, weight);
        default:
            throw new RuntimeException();
        }
    }

    private String getFileInputForComponent(Component component) {
        String convertedString = "";
        if (component instanceof ClassParticipation) {
            convertedString += "P | ";
        } else if (component instanceof Assignment) {
            convertedString += "A | ";
        } else if (component instanceof Exam) {
            convertedString += "E | ";
        }
        convertedString += component.getName() + WRITE_DELIMITER + component.getMaxScore()
                + WRITE_DELIMITER + component.getWeight();
        return convertedString;
    }

}
