package menu;

import fetcher.WeatherFetcher;

import java.util.Scanner;

/**
 * The SimpleMenuFactory class is responsible for creating menus with predefined options.
 */
public class SimpleMenuFactory {

    private Scanner scanner;

    /**
     * Constructs a new SimpleMenuFactory with a default scanner for user input.
     */
    public SimpleMenuFactory() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Creates a menu based on the specified type.
     *
     * @param type The type of menu to create.
     * @return The created menu.
     */
    public Menu createMenu(MenuOption type) {
        Menu menu = Menu.getInstance();
        switch (type) {
            case GET_WEATHER_CITY:
                menu.addItem(new MenuItem("Get weather of city", () -> {
                    System.out.print("Enter the city name: ");
                    String cityName = scanner.nextLine();
                    WeatherFetcher.displayWeather(cityName);
                }));
                break;

            case EXIT_MENU:
                menu.addItem(new MenuItem("Exit Menu", () -> {
                    scanner.close();
                    System.exit(0);
                }));
                break;
        }

        return menu;
    }
}
