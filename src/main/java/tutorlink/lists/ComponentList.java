package tutorlink.lists;

import tutorlink.component.Component;
import tutorlink.exceptions.ComponentNotFoundException;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComponentList {
    private ArrayList<Component> componentArrayList;

    public ComponentList() {
        this.componentArrayList = new ArrayList<>();
    }

    public ComponentList findComponent(String name) {
        ComponentList filteredList = new ComponentList();
        filteredList.componentArrayList = componentArrayList
                .stream()
                .filter(comp -> comp.getName().contains(name))
                .collect(Collectors.toCollection(ArrayList::new));
        if (filteredList.componentArrayList.isEmpty()) {
            throw new ComponentNotFoundException("No matching component found");
        }
        return filteredList;
    }

    public void addComponent(Component component) {
        componentArrayList.add(component);
    }

    public void deleteComponent(Component component) {
        for (Component comp : componentArrayList) {
            if (comp == component) {
                componentArrayList.remove(comp);
            }
        }
    }

    @Override
    public String toString() {
        return IntStream.range(0, componentArrayList.size())
                .mapToObj(i -> (i + 1) + ": " + componentArrayList.get(i))
                .collect(Collectors.joining("\n\t"));
    }
}
