package com.github.peggybrown.speechrank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public class Year {

    private final Long id;
    private final String year;

    public List<Conference> getConferences() {
        return Collections.emptyList();
    }

    public void addConference(Object object) {

    }
}
