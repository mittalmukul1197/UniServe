package repository;

import model.User;
import java.util.HashMap;

public class UserRepository {

    private HashMap<Integer, User> users = new HashMap<>();

    public void addUser(User user) {

        users.put(user.getId(), user);

    }

    public User findByEmail(String email) {

        for (User user : users.values()) {

            if (user.getEmail().equalsIgnoreCase(email)) {

                return user;
            }
        }

        return null;
    }

    public boolean emailExists(String email) {

        return findByEmail(email) != null;
    }

    public int generateId() {

        return users.size() + 1;
    }
}
