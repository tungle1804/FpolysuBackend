package net.javaguides.springboot.services;


import net.javaguides.springboot.entity.User;

import java.util.List;

public interface UserService {

    //Check trùng email
    public Boolean existsByEmail(String email);

    public List<User> getUserByRole();

    public boolean createUser(User user);


}
