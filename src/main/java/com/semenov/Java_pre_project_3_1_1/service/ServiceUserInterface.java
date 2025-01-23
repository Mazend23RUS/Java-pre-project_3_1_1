package com.semenov.Java_pre_project_3_1_1.service;


import com.semenov.Java_pre_project_3_1_1.models.User;

import java.util.List;

public interface ServiceUserInterface {

    List<User> getAllUsersList();

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserById(Long id);


}
