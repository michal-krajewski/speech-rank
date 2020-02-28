package com.github.peggybrown.speechrank.dto;

import com.github.peggybrown.speechrank.entity.Year;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class YearDto {
    String year;
    List<YearsConferenceDto> conferences;

    public YearDto(Year y) {
        year = y.getYear();
        conferences = y.getConferences().stream().map(YearsConferenceDto::new).collect(Collectors.toList());
    }
}
