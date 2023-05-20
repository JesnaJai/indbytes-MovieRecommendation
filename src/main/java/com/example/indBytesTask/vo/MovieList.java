package com.example.indBytesTask.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieList{
    private Integer movieId;
    private String movieName;
    private LocalDate date;
}
