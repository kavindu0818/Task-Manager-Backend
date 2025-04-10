package com.example.Task_Manager_Backend.service.impl;

import com.example.Task_Manager_Backend.dao.TaskDao;
import com.example.Task_Manager_Backend.dto.TaskDto;
import com.example.Task_Manager_Backend.entity.TaskEntity;
import com.example.Task_Manager_Backend.service.TaskService;
import com.example.Task_Manager_Backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private Mapping mapping;

    @Autowired
    private TaskDao taskDao;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        TaskEntity taskEntity = mapping.toTaskEntity(taskDto);

        System.out.println("mama service impl ekata awoo" + taskEntity);
        TaskEntity savedCar = taskDao.save(taskEntity);

        if (savedCar == null) {
            throw new RuntimeException("Car not saved");
        }

        return mapping.toTaskDTO(savedCar);
    }


    @Override
    public List<TaskDto> getAllTask() {
        List<TaskEntity> carEntities = taskDao.findAll();
        return carEntities.stream()
                .map(mapping::toTaskDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTask(String id) {
        if (taskDao.existsById(id)) {
            taskDao.deleteById(id);
        } else {
            throw new RuntimeException("Car not found");
        }

    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Optional<TaskEntity> existingTask= taskDao.findById(String.valueOf(taskDto.getId()));

        if (existingTask.isPresent()) {
            TaskEntity updatedTask = existingTask.get();
            updatedTask.setTitle(taskDto.getTitle());
            updatedTask.setTitle(taskDto.getDescription());
            updatedTask.setTitle(taskDto.getStatus());
            updatedTask.setTitle(taskDto.getCreatedAt().toString());


            TaskEntity savedTask = taskDao.save(updatedTask);
            return mapping.toTaskDTO(savedTask);
        }
        throw new RuntimeException("Task not found");
    }
}
