package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public Task getById(Long id){
        return taskRepository.getById(id);
    }

    public void create(Task task){
        taskRepository.save(task);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }

    public void updateById(Long id,Task task){
        Task old = taskRepository.getById(id);
        old.setTask_name(task.getTask_name());
        old.setDeadline(task.getDeadline());
        old.setPriority(task.getPriority());
        old.setDescription(task.getDescription());
        old.setProcess(task.isProcess());
        taskRepository.save(old);
    }
    public void done(Long id){
        Task task = taskRepository.getById(id);
        task.setProcess(!task.isProcess());
        taskRepository.save(task);
    }
}
