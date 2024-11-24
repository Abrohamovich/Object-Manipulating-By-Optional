package app;

import app.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String... args) {
        List<User> users= new ArrayList<>();
        users.add(new User(1,"John", "john@gmail.com"));
        users.add(new User(2,"Jane", "jane@gmail.com"));
        users.add(new User(3,"Jack", "jack@gmail.com"));
        users.add(new User(4,"Carl", "carl@gmail.com"));
        users.add(new User(5,"Sam", "sam@gmail.com"));
        users.add(new User(6,"Dan", "dan@gmail.com"));
        users.add(new User(7,"Tom", "tom@gmail.com"));

        int existingId = 6;
        String existingEmail = "carl@gmail.com";
        int wrongId = -3;
        String wrongEmail = "stern@gmail.com";

        UserRepository userRepository = new UserRepository(users);
        Optional<User> firstById = userRepository.findUserById(existingId);
        if (firstById.isPresent())System.out.println("User by id: " + existingId + " is " +
                firstById.get().getName() +" (email: " + firstById.get().getEmail() + ")" );
        else System.out.println("There is no user matches to this id");

        Optional<User> firstByEmail = userRepository.findUserByEmail(existingEmail);
        if (firstByEmail.isPresent())System.out.println("User by email: " + existingEmail + " is " +
                firstByEmail.get().getName() +" (id: " + firstByEmail.get().getId() + ")" );
        else System.out.println("There is no user matches to this email");

        Optional<List<User>> allUsers = userRepository.findAllUsers();
        if(allUsers.isPresent())System.out.println("Count of users in list: "
                + allUsers.get().size());
        else System.out.println("There are no users in this list");
    }
}
