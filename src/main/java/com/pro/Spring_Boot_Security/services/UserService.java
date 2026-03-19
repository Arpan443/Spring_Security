package com.pro.Spring_Boot_Security.services;

import com.pro.Spring_Boot_Security.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    List<User> list= new ArrayList<>();
    public UserService() {
       list.add( new User("Arpan","abv12","arpan@gmail.com"));
        list.add( new User("Jerry","je12","jerry@gmail.com"));
        list.add( new User("Ram","rm12","ra,@gmail.com"));


    }
 //get all user
    public List<User> getUsers(){
        return this.list;
    }

    //get the single users
    public User getUser(String username ){
        return this.list.stream().filter(user -> user.getName().equals(username)).findAny().get();

    }
    public User addUser(User user){
        this.list.add(user);
        return user;
    }


}
