package com.example.taskapi.Service;

import com.example.taskapi.Model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAllUsers();

    UserModel createUser(UserModel userModel);

    UserModel getUserById(Long id);

    UserModel updateUser(Long id, UserModel updatedUserModel);

    void deleteUser(Long id);

    UserModel getUserByUsername(String username);
}
