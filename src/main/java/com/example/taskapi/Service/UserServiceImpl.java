package com.example.taskapi.Service;

import com.example.taskapi.Model.UserModel;
import com.example.taskapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    @Override
    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel updateUser(Long id, UserModel updatedUserModel) {
        UserModel existingUserModel = userRepository.findById(id).orElse(null);
        if (existingUserModel != null) {
            existingUserModel.setUsername(updatedUserModel.getUsername());
            existingUserModel.setPassword(passwordEncoder.encode(updatedUserModel.getPassword()));
            return userRepository.save(existingUserModel);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
