package service;

import model.Student;
import model.User;
import repository.UserRepository;

public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public boolean registerStudent(String name, String email,
                                   String password, String studentId,
                                   String course, int year) {

        if (userRepository.emailExists(email)) {

            System.out.println("Email already registered!");
            return false;
        }

        int id = userRepository.generateId();

        Student student = new Student(
                id, name, email, password,
                studentId, course, year
        );

        userRepository.addUser(student);

        System.out.println("Registration successful!");

        return true;
    }

    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.verifyPassword(password)) {

            System.out.println("Login successful!");

            return user;
        }

        System.out.println("Invalid email or password!");

        return null;
    }
}
