package service;

import model.Category;
import model.MenuItem;
import repository.MenuRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MenuService {

    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {

        this.menuRepository = menuRepository;
    }

    public void addFood(String name, double price, Category category) {

        int id = menuRepository.generateId();

        MenuItem item = new MenuItem(
                id, name, price, category, true
        );

        menuRepository.addItem(item);

        System.out.println("Food item added successfully!");
    }

    public void displayMenu() {

        ArrayList<MenuItem> menu = menuRepository.getAllItems();

        System.out.println("\n========== FOOD MENU ==========");

        for (MenuItem item : menu) {

            if (item.isAvailable()) {

                System.out.println(item);
            }
        }
    }

    public void searchFood(String name) {

        ArrayList<MenuItem> menu = menuRepository.getAllItems();

        boolean found = false;

        for (MenuItem item : menu) {

            if (item.getName().toLowerCase()
                    .contains(name.toLowerCase())
                    && item.isAvailable()) {

                System.out.println(item);
                found = true;
            }
        }

        if (!found) {

            System.out.println("Food item not found!");
        }
    }

    public void sortByPrice() {

        ArrayList<MenuItem> menu = menuRepository.getAllItems();

        Collections.sort(menu, new Comparator<MenuItem>() {

            @Override
            public int compare(MenuItem a, MenuItem b) {

                return Double.compare(a.getPrice(), b.getPrice());
            }
        });

        displayMenu();
    }

    public MenuItem findFoodById(int id) {

        return menuRepository.findById(id);
    }

    public void removeFood(int id) {

        MenuItem item = menuRepository.findById(id);

        if (item != null) {

            menuRepository.removeItem(id);

            System.out.println("Food item removed!");
        }
        else {

            System.out.println("Invalid food ID!");
        }
    }

    public void updatePrice(int id, double price) {

        MenuItem item = menuRepository.findById(id);

        if (item != null) {

            item.setPrice(price);

            System.out.println("Price updated!");
        }
        else {

            System.out.println("Food item not found!");
        }
    }
}
