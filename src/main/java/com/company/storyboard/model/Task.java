package com.company.storyboard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private long taskId;

    private String name;

    private String description;

    @Column(name = "pillar_id")
    private long pillarId;

    public Task() {

    }

    public Task(long taskId, String name, String description, long pillarId) {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        this.pillarId = pillarId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
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

    public long getPillarId() {
        return pillarId;
    }

    public void setPillarId(long pillarId) {
        this.pillarId = pillarId;
    }
}