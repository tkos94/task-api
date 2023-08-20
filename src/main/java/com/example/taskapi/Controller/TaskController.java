package com.example.taskapi.Controller;

import com.example.taskapi.Model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.taskapi.Repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    @PreAuthorize("permitAll")
    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel taskModel) {
        TaskModel createdTaskModel = taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTaskModel);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public TaskModel getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public TaskModel updateTask(@PathVariable Long id, @RequestBody TaskModel updatedTaskModel) {
        TaskModel existingTaskModel = taskRepository.findById(id).orElse(null);
        if (existingTaskModel != null) {
            existingTaskModel.setTitle(updatedTaskModel.getTitle());
            existingTaskModel.setDescription(updatedTaskModel.getDescription());
            return taskRepository.save(existingTaskModel);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
