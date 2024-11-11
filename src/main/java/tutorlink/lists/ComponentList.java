package tutorlink.lists;

import tutorlink.component.Component;
import tutorlink.exceptions.ComponentNotFoundException;
import tutorlink.exceptions.DuplicateComponentException;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Represents a list of components with functionalities to add, delete, find, and retrieve components.
 */
public class ComponentList {

    /**
     * Error message for when a component is not found in the list.
     */
    private static final String ERROR_COMPONENT_NOT_FOUND = "Error! Component %s does not exist in the list!";

    /**
     * Error message for when a duplicate component is added to the list.
     */
    private static final String ERROR_DUPLICATE_COMPONENT = "Error! Component already exists in the list!";

    /**
     * The list of components.
     */
    private ArrayList<Component> componentArrayList;

    /**
     * Constructs an empty ComponentList.
     */
    public ComponentList() {
        this.componentArrayList = new ArrayList<>();
    }

    /**
     * Constructs a ComponentList with the specified list of components.
     *
     * @param componentArrayList the list of components to initialize the ComponentList with
     */
    public ComponentList(ArrayList<Component> componentArrayList) {
        this.componentArrayList = componentArrayList;
    }

    /**
     * Finds components in the list that contain the specified name.
     *
     * @param name the name to search for
     * @return a ComponentList containing the components that match the search criteria
     * @throws ComponentNotFoundException if no components are found with the specified name
     */
    public ComponentList findComponent(String name) throws ComponentNotFoundException {
        // method implementation
    }

    /**
     * Adds a component to the list.
     *
     * @param component the component to add
     * @throws DuplicateComponentException if the component already exists in the list
     */
    public void addComponent(Component component) throws DuplicateComponentException {
        // method implementation
    }

    /**
     * Deletes a component from the list.
     *
     * @param component the component to delete
     * @throws ComponentNotFoundException if the component does not exist in the list
     */
    public void deleteComponent(Component component) throws ComponentNotFoundException {
        // method implementation
    }

    /**
     * Gets the total weighting of all components in the list.
     *
     * @return the total weighting of all components
     */
    public int getTotalWeighting() {
        // method implementation
    }

    /**
     * Returns a string representation of the ComponentList.
     *
     * @return a string representation of the ComponentList
     */
    @Override
    public String toString() {
        // method implementation
    }

    /**
     * Finds all components in the list.
     *
     * @return a list of all components
     */
    public ArrayList<Component> findAllComponents() {
        // method implementation
    }

    /**
     * Gets the list of components.
     *
     * @return the list of components
     */
    public ArrayList<Component> getComponentArrayList() {
        // method implementation
    }

    /**
     * Gets the number of components in the list.
     *
     * @return the number of components in the list
     */
    public int size() {
        // method implementation
    }
}
