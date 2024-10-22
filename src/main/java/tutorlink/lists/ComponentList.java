package tutorlink.lists;

import tutorlink.component.Component;
import tutorlink.exceptions.ComponentNotFoundException;
import tutorlink.exceptions.DuplicateComponentException;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Represents a list of components.
 */
public class ComponentList {
    private static final String ERROR_COMPONENT_NOT_FOUND = "Error! No matching component found!";
    private static final String ERROR_DUPLICATE_COMPONENT = "Error! Component already exists in the list!";

    private ArrayList<Component> componentArrayList;

    public ComponentList() {
        this.componentArrayList = new ArrayList<>();
    }

    public ComponentList findComponent(String name) throws ComponentNotFoundException {
        ComponentList filteredList = new ComponentList();
        filteredList.componentArrayList = componentArrayList
                .stream()
                .filter(comp -> comp.getName().contains(name))
                .collect(Collectors.toCollection(ArrayList::new));
        if (filteredList.componentArrayList.isEmpty()) {
            throw new ComponentNotFoundException(ERROR_COMPONENT_NOT_FOUND);
        }
        return filteredList;
    }

    public void addComponent(Component component) throws DuplicateComponentException {
        for (Component comp : componentArrayList) {
            if (comp.equals(component)) {
                throw new DuplicateComponentException(ERROR_DUPLICATE_COMPONENT);
            }
        }
        componentArrayList.add(component);
    }

    public void deleteComponent(Component component) throws ComponentNotFoundException {
        for (Component comp : componentArrayList) {
            if (comp.equals(component)) {
                componentArrayList.remove(comp);
                return;
            }
        }
        throw new ComponentNotFoundException(ERROR_COMPONENT_NOT_FOUND);
    }

    @Override
    public String toString() {
        return IntStream.range(0, componentArrayList.size())
                .mapToObj(i -> (i + 1) + ": " + componentArrayList.get(i))
                .collect(Collectors.joining("\n\t"));
    }
}
