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

    @OneToOne
    @JoinColumn(name = "pillar_id")
    @JsonBackReference
    private Pillar pillar;

    public Task() {

    }

    public Task(long taskId, String name, String description, Pillar pillar) {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        this.pillar = pillar;
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

    public Pillar getPillar() {
        return pillar;
    }

    public void setPillar(Pillar pillar) {
        this.pillar = pillar;
    }
}