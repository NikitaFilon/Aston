package menu;

import java.io.IOException;

/**
 * The MenuItem class represents an item in a menu, consisting of a name and an associated action.
 */
public class MenuItem {

    private String name;
    private Action action;

    /**
     * Constructs a new MenuItem with the specified name and action.
     *
     * @param name   The name of the menu item.
     * @param action The action associated with the menu item.
     */
    public MenuItem(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    /**
     * Gets the name of the menu item.
     *
     * @return The name of the menu item.
     */
    public String getName() {
        return name;
    }

    /**
     * Executes the action associated with the menu item.
     *
     * @throws IOException If an I/O error occurs while executing the action.
     */
    public void execute() throws IOException {
        action.action();
    }
}
