package app;

import app.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    protected List<User> users;

    public UserRepository(List<User> users) {
        this.users = new ArrayList<User>(users);
    }

    public Optional<User> findUserById(int id){
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public Optional<User> findUserByEmail(String email){
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public Optional<List<User>> findAllUsers(){
        return Optional.of(new ArrayList<>(users));
    }
}
