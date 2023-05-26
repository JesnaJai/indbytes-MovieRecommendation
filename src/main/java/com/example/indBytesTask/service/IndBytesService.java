package com.example.indBytesTask.service;

import com.example.indBytesTask.Response.ResponseVO;
import com.example.indBytesTask.entity.Users;
import com.example.indBytesTask.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IndBytesService {

    void selectMovie(SelectedMovieVo selectedMovieVo);

    ViewedMovieResponse viewedMovie(ViewedMovieRequest request);

    List<SelectedMovieListVO> movieList(ViewedMovieRequest request);

    List<SelectedMovieListVO> getAllMovies();

    void createUser(UsersVo usersVo);

    void createMovie(MoviesVo moviesVo);

    void updateUser(UsersVo usersVo,int userId);

    void updateMovie(MoviesVo moviesVo, int movieId);

    List<Users> getAllUsers();

    void deleteUser(int userId);

    void deleteMovie(Integer movieId);
}
