package com.example.Task_Manager_Backend.dao;

import com.example.Task_Manager_Backend.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<TaskEntity,String> {
}
