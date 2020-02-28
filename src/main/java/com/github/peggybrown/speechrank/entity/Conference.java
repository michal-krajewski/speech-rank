package com.github.peggybrown.speechrank.entity;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class Conference {

    private Long id;
    private String name;
    private Year year;

    @Deprecated //Only for DAO access
    public Conference(Long id, String name, Year year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Conference(String name, Year year) {
        this.name = name;
        this.year = year;
    }

    public List<Presentation> getPresentations() {
        return Collections.emptyList();
    }
}
