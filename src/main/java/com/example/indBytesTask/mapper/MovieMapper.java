package com.example.indBytesTask.mapper;

import com.example.indBytesTask.entity.Movie;
import com.example.indBytesTask.entity.Users;
import com.example.indBytesTask.vo.MoviesVo;
import com.example.indBytesTask.vo.UsersVo;

public class MovieMapper {
    public static Movie toMovie(MoviesVo moviesVo){
        return Movie.builder()
                .movieName(moviesVo.getMovieName())
                .build();
    }

    public static Movie toUpdateMovie(Movie movie, MoviesVo moviesVo) {
        movie.setMovieName(moviesVo.getMovieName());
        return movie;

    }
}
