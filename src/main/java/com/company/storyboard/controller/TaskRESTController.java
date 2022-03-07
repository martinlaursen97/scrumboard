package com.company.storyboard.controller;

import com.company.storyboard.model.Task;

import com.company.storyboard.repository.TaskRepository;
import com.company.storyboard.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskRESTController {

    @Autowired
    private TaskService taskService;

    @PutMapping("/task/update")
    public ResponseEntity<Task> update(@RequestBody Task task) {
        taskService.save(task);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
