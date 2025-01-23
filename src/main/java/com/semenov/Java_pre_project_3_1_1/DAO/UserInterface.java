package com.semenov.Java_pre_project_3_1_1.DAO;


import com.semenov.Java_pre_project_3_1_1.models.User;

import java.util.List;

public interface UserInterface {

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserById(Long id);
}
