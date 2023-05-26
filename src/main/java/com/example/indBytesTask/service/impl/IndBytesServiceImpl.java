package com.example.indBytesTask.service.impl;

import com.example.indBytesTask.configuration.ApiExceptionHandler;
import com.example.indBytesTask.entity.Movie;
import com.example.indBytesTask.entity.Users;
import com.example.indBytesTask.mapper.MovieMapper;
import com.example.indBytesTask.mapper.SelectedMovieMapper;
import com.example.indBytesTask.mapper.UserMapper;
import com.example.indBytesTask.repo.MovieRepo;
import com.example.indBytesTask.repo.SelectedMovieRepo;
import com.example.indBytesTask.repo.UserRepo;
import com.example.indBytesTask.service.IndBytesService;
import com.example.indBytesTask.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class IndBytesServiceImpl implements IndBytesService {

    private final SelectedMovieRepo selectedMovieRepo;
    private final MovieRepo movieRepo;
    private final UserRepo userRepo;

    @Override
    public void selectMovie(SelectedMovieVo selectedMovieVo) {
        validateRequest(selectedMovieVo);
        selectedMovieRepo.save(SelectedMovieMapper.toSelectedMovies(selectedMovieVo));
    }
    @Override
    public void createUser(UsersVo usersVo){
        if(usersVo.getUserName()== null ){
            throw new ApiExceptionHandler("name.empty","username cannot be empty");
        }
        userRepo.save(UserMapper.toUsers(usersVo));
}

    @Override
    public void createMovie(MoviesVo moviesVo) {
        if(moviesVo.getMovieName()==null){
            throw new ApiExceptionHandler("movie.empty","movieName cannot be empty");
        }
        movieRepo.save(MovieMapper.toMovie(moviesVo));
    }
    @Override
    public void deleteUser(int userId) {
        if(!userRepo.existsById(userId)){
            throw new ApiExceptionHandler("id.invalid","invalid id");
        }
        userRepo.deleteById(userId);
    }

    @Override
    public void deleteMovie(Integer movieId) {
        if(!movieRepo.existsById(movieId)){
            throw new ApiExceptionHandler("id.invalid","invalid id");
        }
        movieRepo.deleteById(movieId);
    }

    @Override
    public void updateUser(UsersVo usersVo,int userId) {
        if(!userRepo.existsById(userId)){
            throw new ApiExceptionHandler("id.invalid","invalid id");
        }
        Users users=userRepo.findById(userId).orElse(null);
        assert users != null;
        userRepo.save(UserMapper.toUpdateUser(users,usersVo));
    }

    @Override
    public void updateMovie(MoviesVo moviesVo, int movieId) {
        if(!movieRepo.existsById(movieId)){
            throw new ApiExceptionHandler("id.invalid","invalid id");
        }
        if (Objects.nonNull(movieRepo.findByMovieName(moviesVo.movieName))) {
            throw new ApiExceptionHandler("movieName.exist","Movie name already exist");
          }

        Movie movies=movieRepo.findById(movieId).orElse(null);


        assert movies != null;
        movieRepo.save(MovieMapper.toUpdateMovie(movies,moviesVo));
    }



    @Override
    public ViewedMovieResponse viewedMovie(ViewedMovieRequest request) {
        if (!userRepo.existsById(request.getUserId())) {
            throw new ApiExceptionHandler("id.invalid", "User Id invalid");
        }

       return SelectedMovieMapper.viewedMovie(selectedMovieRepo.viewedMovie(request.getUserId(),
                LocalDate.now()), request.getUserId());
    }

    @Override
    public List<SelectedMovieListVO> movieList(ViewedMovieRequest request) {
        return selectedMovieRepo.movieList(request.getUserId());
    }
    @Override
    public List<SelectedMovieListVO>getAllMovies(){
        return movieRepo.getAllMovies();
    }
    @Override
    public List<Users>getAllUsers() {
        return userRepo.getAllUsers();
    }



    private void validateRequest(SelectedMovieVo selectedMovieVo) {
        if (!userRepo.existsById(selectedMovieVo.userId)) {
            throw new ApiExceptionHandler("id.invalid", "User Id invalid");
        }
        if (!movieRepo.existsById(selectedMovieVo.movieId)) {
            throw new ApiExceptionHandler("id.invalid", "Movie Id invalid");
        }
        if (Objects.nonNull(selectedMovieRepo.isWatched(selectedMovieVo.userId, selectedMovieVo.movieId))) {
            throw new ApiExceptionHandler("WATCHED", "THIS MOVIE IS ALREADY WATCHED");
        }
    }
}
