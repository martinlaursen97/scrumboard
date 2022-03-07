package com.company.storyboard.model;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private long taskId;

    private String name;

    private String description;

    public Task() {

    }

    public Task(Long id, String name, String description) {
        this.taskId = id;
        this.name = name;
        this.description = description;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long id) {
        this.taskId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}