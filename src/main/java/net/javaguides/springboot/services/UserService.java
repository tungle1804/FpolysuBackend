package net.javaguides.springboot.services;


public interface UserService {

    //Check trùng email
    public Boolean existsByEmail(String email);
}
