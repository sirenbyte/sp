package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/")
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable("id") Long id){
        return taskService.getById(id);
    }
    @PostMapping("/")
    public void create(@RequestBody @Valid Task task){
        taskService.create(task);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        taskService.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updateById(@PathVariable("id") Long id,@RequestBody Task task){
        taskService.updateById(id,task);
    }
    @PutMapping("/done/{id}")
    public void done(@PathVariable("id") Long id){
        taskService.done(id);
    }
}
