package com.example.taskapi.Service;

import com.example.taskapi.Model.TaskModel;

import java.util.List;

public interface TaskService {
    List<TaskModel> getAllTasks();

    TaskModel createTask(TaskModel taskModel);

    TaskModel getTaskById(Long id);

    TaskModel updateTask(Long id, TaskModel updatedTaskModel);

    void deleteTask(Long id);
}
