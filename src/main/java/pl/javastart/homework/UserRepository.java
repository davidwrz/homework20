package pl.javastart.homework;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("First", "User", 10));
        users.add(new User("Second", "User", 20));
        users.add(new User("Third", "User", 30));
    }

    public List<User> getAll() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }
}
