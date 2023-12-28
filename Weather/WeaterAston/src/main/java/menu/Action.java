package menu;

import java.io.IOException;

/**
 * The Action interface represents an action that can be performed in the menu system.
 */
public interface Action {

    /**
     * Performs the specific action.
     *
     * @throws IOException If an I/O error occurs while performing the action.
     */
    void action() throws IOException;
}
