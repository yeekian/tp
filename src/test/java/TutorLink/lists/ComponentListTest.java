package tutorlink.lists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import tutorlink.component.Assignment;
import tutorlink.component.Component;
import tutorlink.component.Exam;
import tutorlink.exceptions.ComponentNotFoundException;
import tutorlink.exceptions.DuplicateComponentException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComponentListTest {
    private ComponentList componentList;
    private Component comp1;
    private Component comp2;
    private Component comp3;

    @BeforeEach
    void setup() {
        componentList = new ComponentList();
        comp1 = new Assignment("Homework 1", 30, 0.1);
        comp2 = new Assignment("Homework 2", 30, 0.1);
        comp3 = new Exam("Finals", 100, 0.5);
    }

    @Test
    void addComponent_addOneComponent_success() {
        componentList.addComponent(comp1);
        assertEquals(1, componentList.getComponentArrayList().size());
    }

    @Test
    void addComponent_addDuplicateComponent_exceptionThrown() {
        componentList.addComponent(comp1);
        Component duplicateComp = new Assignment("Homework 1", 30, 0.1);
        assertThrows(DuplicateComponentException.class, () -> componentList.addComponent(duplicateComp));
    }

    @Test
    void deleteComponent_deleteOneComponent_success() {
        componentList.addComponent(comp3);
        componentList.deleteComponent(comp3);
        assertEquals(0, componentList.getComponentArrayList().size());
    }

    @Test
    void deleteComponent_deleteUnknownComponent_exceptionThrown() {
        componentList.addComponent(comp2);
        assertThrows(ComponentNotFoundException.class, () -> componentList.deleteComponent(comp1));
    }
}
