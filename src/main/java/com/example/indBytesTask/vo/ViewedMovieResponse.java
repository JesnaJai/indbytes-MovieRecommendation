package com.example.indBytesTask.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViewedMovieResponse {
    @NotNull(message = "id should not be empty")
    private Integer userId;
    private List<MovieList> movieLists;
}
