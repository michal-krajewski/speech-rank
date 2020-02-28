package com.github.peggybrown.speechrank.dto;

import com.github.peggybrown.speechrank.entity.Conference;
import lombok.Data;

@Data
public class YearsConferenceDto {
    private Long id;
    private String name;
    private int presentations;

    public YearsConferenceDto(Conference c) {
        id = c.getId();
        name = c.getName();
        presentations = c.getPresentations().size();

    }
}
