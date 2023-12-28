package menu;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Menu class represents a simple menu system.
 */
public class Menu implements Closeable {

    private List<MenuItem> items;
    private static Menu instance;
    private Scanner scanner;

    /**
     * Private constructor to ensure the singleton pattern.
     */
    private Menu() {
        items = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Gets the instance of the Menu class. If the instance doesn't exist, it creates one.
     *
     * @return The instance of the Menu class.
     */
    public static synchronized Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    /**
     * Adds a menu item to the menu.
     *
     * @param item The menu item to add.
     */
    public void addItem(MenuItem item) {
        items.add(item);
    }

    /**
     * Displays the menu options.
     */
    public void display() {
        System.out.println("Menu:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName());
        }
    }

    /**
     * Runs the menu item associated with the specified index.
     *
     * @param index The index of the menu item to run.
     * @throws IOException If an I/O error occurs while running the menu item.
     */
    public void runItem(int index) {
        if (index >= 1 && index <= items.size()) {
            try {
                items.get(index - 1).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid menu item.");
        }
    }

    /**
     * Runs the menu continuously, allowing the user to select options until the program is closed.
     *
     * @return The Menu instance.
     * @throws IOException If an I/O error occurs while running the menu.
     */
    public Menu run() {
        while (true) {
            display();
            try {
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                runItem(choice);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Closes the resources associated with the Menu, specifically the Scanner.
     */
    @Override
    public void close() {
        scanner.close();
    }
}
