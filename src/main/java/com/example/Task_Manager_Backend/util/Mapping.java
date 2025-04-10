package com.example.Task_Manager_Backend.util;

import com.example.Task_Manager_Backend.dto.TaskDto;
import com.example.Task_Manager_Backend.entity.TaskEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

   @Autowired
   private ModelMapper modelMapper;


    public TaskEntity toTaskEntity(TaskDto taskDto) {
        return modelMapper.map(taskDto, TaskEntity.class);
    }

    public TaskDto toTaskDTO(TaskEntity taskEntity) {
        return modelMapper.map(taskEntity, TaskDto.class);
    }

    public List<TaskEntity> asTaskList(List<TaskDto> taskDtos) {
        return modelMapper.map(taskDtos, new TypeToken<List<TaskEntity>>() {}.getType());
    }

    public List<TaskDto> asTaskEntityList(List<TaskEntity> taskEntityList) {
        return modelMapper.map(taskEntityList, new TypeToken<List<TaskDto>>() {}.getType());
    }
}
