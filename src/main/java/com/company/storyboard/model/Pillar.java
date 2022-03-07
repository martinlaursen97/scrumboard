package com.company.storyboard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Pillar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pillar_id")
    private long pillarId;

    private String name;

    @OneToMany
    @JoinColumn(name = "pillar_id")
    private List<Task> tasks;

    public Pillar() {

    }

    public Pillar(long pillarId, String name, List<Task> tasks) {
        this.pillarId = pillarId;
        this.name = name;
        this.tasks = tasks;
    }

    public long getPillarId() {
        return pillarId;
    }

    public void setPillarId(long pillarId) {
        this.pillarId = pillarId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}