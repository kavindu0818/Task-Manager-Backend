package com.example.Task_Manager_Backend.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class TaskDto {
    
 private Long id; 
 private String title; 
 private String description; 
 private String status; 
 private LocalDateTime createdAt;

 public TaskDto() {
 }

 public TaskDto(Long id, String title, String description, String status, LocalDateTime createdAt) {
  this.id = id;
  this.title = title;
  this.description = description;
  this.status = status;
  this.createdAt = createdAt;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public String getStatus() {
  return status;
 }

 public void setStatus(String status) {
  this.status = status;
 }

 public LocalDateTime getCreatedAt() {
  return createdAt;
 }

 public void setCreatedAt(LocalDateTime createdAt) {
  this.createdAt = createdAt;
 }
}
