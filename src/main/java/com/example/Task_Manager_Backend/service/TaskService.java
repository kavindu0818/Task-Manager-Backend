package com.example.Task_Manager_Backend.service;

import com.example.Task_Manager_Backend.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto);

    List<TaskDto> getAllTask();

    void deleteTask(String id);

    TaskDto updateTask(TaskDto taskDto);
}
