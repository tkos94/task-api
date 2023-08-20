package com.example.taskapi;

import com.example.taskapi.Model.TaskModel;
import com.example.taskapi.Model.UserModel;
import com.example.taskapi.Model.UserRoleModel;
import com.example.taskapi.Repository.TaskRepository;
import com.example.taskapi.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class InitialDataLoader {

    @Bean
    CommandLineRunner initDatabase(TaskRepository taskRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            taskRepository.save(new TaskModel("Task 1", "Description 1", LocalDateTime.now()));
            taskRepository.save(new TaskModel("Task 2", "Description 2", LocalDateTime.now()));

            // Usuários com autoridade ADMIN
            userRepository.save(new UserModel("admin1", passwordEncoder.encode("admin_password"), UserRoleModel.ADMIN));
            userRepository.save(new UserModel("admin2", passwordEncoder.encode("admin_password"), UserRoleModel.ADMIN));

            // Usuários com autoridade USER
            userRepository.save(new UserModel("user1", passwordEncoder.encode("user_password"), UserRoleModel.USER));
            userRepository.save(new UserModel("user2", passwordEncoder.encode("user_password"), UserRoleModel.USER));
        };
    }
}
