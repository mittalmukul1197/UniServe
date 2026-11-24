package repository;

import model.MenuItem;
import java.util.ArrayList;

public class MenuRepository {

    private ArrayList<MenuItem> menuList = new ArrayList<>();

    public void addItem(MenuItem item) {

        menuList.add(item);
    }

    public ArrayList<MenuItem> getAllItems() {

        return menuList;
    }

    public MenuItem findById(int id) {

        for (MenuItem item : menuList) {

            if (item.getId() == id) {

                return item;
            }
        }

        return null;
    }

    public void removeItem(int id) {

        MenuItem item = findById(id);

        if (item != null) {

            menuList.remove(item);
        }
    }

    public int generateId() {

        return menuList.size() + 1;
    }
}