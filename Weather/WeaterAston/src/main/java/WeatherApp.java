import menu.Menu;
import menu.MenuOption;
import menu.SimpleMenuFactory;

import java.io.IOException;

/**
 * The WeatherApp class serves as the entry point for the weather application.
 */
public class WeatherApp {

    /**
     * The main method that initializes the menu and runs the weather application.
     *
     * @param args Command-line arguments (not used in this application).
     * @throws IOException If an I/O error occurs during the execution of the application.
     */
    public static void main(String[] args) throws IOException {

        Menu menu = Menu.getInstance();


        SimpleMenuFactory menuBuilder = new SimpleMenuFactory();

        menuBuilder.createMenu(MenuOption.GET_WEATHER_CITY);
        menuBuilder.createMenu(MenuOption.EXIT_MENU);

        menu.run();
    }
}
