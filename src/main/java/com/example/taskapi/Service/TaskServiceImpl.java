package com.example.taskapi.Service;

import com.example.taskapi.Model.TaskModel;
import com.example.taskapi.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public TaskModel createTask(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    @Override
    public TaskModel getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public TaskModel updateTask(Long id, TaskModel updatedTaskModel) {
        TaskModel existingTaskModel = taskRepository.findById(id).orElse(null);
        if (existingTaskModel != null) {
            existingTaskModel.setTitle(updatedTaskModel.getTitle());
            existingTaskModel.setDescription(updatedTaskModel.getDescription());
            return taskRepository.save(existingTaskModel);
        }
        return null;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
