package tutorlink.command;

import java.util.HashMap;
import tutorlink.appstate.AppState;
import tutorlink.commons.Commons;
import tutorlink.component.Component;
import tutorlink.exceptions.ComponentNotFoundException;
import tutorlink.exceptions.DuplicateComponentException;
import tutorlink.exceptions.IllegalValueException;
import tutorlink.exceptions.TutorLinkException;
import tutorlink.lists.ComponentList;
import tutorlink.result.CommandResult;

public class DeleteComponentCommand extends Command{
    public static final String[] ARGUMENT_PREFIXES = {"c/"};
    public static final String COMMAND_WORD = "delete_component";

    @Override
    public CommandResult execute(AppState appState, HashMap<String, String> hashmap) throws TutorLinkException {
        String componentName = hashmap.get(ARGUMENT_PREFIXES[0]);
        if(componentName == null) {
            throw new IllegalValueException(Commons.ERROR_NULL);
        }
        ComponentList componentsToDelete = appState.components.findComponent(componentName);
        if(componentsToDelete.size() == 0) {
            throw new ComponentNotFoundException(String.format(Commons.ERROR_COMPONENT_NOT_FOUND, componentName));
        } else if (componentsToDelete.size() > 1) {
            throw new DuplicateComponentException(String.format(Commons.ERROR_MULTIPLE_QUERY_RESULT,
                    componentName));
        }
        Component toDelete = componentsToDelete.getComponentArrayList().get(0);
        appState.totalWeight -= toDelete.getWeight();
        assert appState.totalWeight >= 0;
        appState.components.deleteComponent(toDelete);
        return new CommandResult(String.format(Commons.DELETE_COMPONENT_SUCCESS, componentName));
    }

    @Override
    public String[] getArgumentPrefixes() {
        return ARGUMENT_PREFIXES;
    }
}
