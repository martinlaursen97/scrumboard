package com.company.storyboard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "board_id")
    private List<Pillar> pillars;

    public Board() {

    }

    public Board(long id, String name, List<Pillar> pillars) {
        this.id = id;
        this.name = name;
        this.pillars = pillars;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pillar> getPillars() {
        return pillars;
    }

    public void setPillars(List<Pillar> pillars) {
        this.pillars = pillars;
    }
}
