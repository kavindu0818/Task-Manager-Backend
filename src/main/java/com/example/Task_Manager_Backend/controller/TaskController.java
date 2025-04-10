package com.example.Task_Manager_Backend.controller;


import com.example.Task_Manager_Backend.dto.TaskDto;
import com.example.Task_Manager_Backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto) {
        TaskDto task = taskService.addTask(taskDto); // Assuming taskService.addTask() saves and returns a Task
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDto>> getAllTask() {
        List<TaskDto>  booking = taskService.getAllTask();
        if (booking.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
        try {
            System.out.println("mama print karna thanta awooooo");
            taskService.deleteTask(id);
            return ResponseEntity.ok("booking deleted successfully.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error deleting booking: " + ex.getMessage());
        }
    }

    @PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateTask(@PathVariable String id, @RequestBody TaskDto taskDto) {
        try {
            TaskDto updatedTask = taskService.updateTask(taskDto);
            return ResponseEntity.ok(updatedTask);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error updating task: " + ex.getMessage());
        }
    }
    
}
