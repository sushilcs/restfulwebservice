package com.sky.rest.webservices.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1,"adam", LocalDate.now().minusYears(30)));
        users.add(new User(2,"padam", LocalDate.now().minusYears(25)));
        users.add(new User(3,"sadam", LocalDate.now().minusYears(35)));
        users.add(new User(4,"gadam", LocalDate.now().minusYears(31)));
        users.add(new User(5,"madam", LocalDate.now().minusYears(34)));
        users.add(new User(6,"dadam", LocalDate.now().minusYears(36)));
    }
    public List<User>findAllUsers(){
        return users;
    }
    public int saveUser(User user){
        user.setId(users.size()+1);
        users.add(user);
        return user.getId();
    }

    public User findOne(int id){
        Predicate<User> predicate = user->user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
}
