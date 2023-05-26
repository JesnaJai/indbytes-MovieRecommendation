package com.example.indBytesTask.controller;

import com.example.indBytesTask.Response.ResponseVO;
import com.example.indBytesTask.entity.Users;
import com.example.indBytesTask.service.IndBytesService;
import com.example.indBytesTask.vo.*;
import liquibase.pro.packaged.V;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SelectedMovieController {
    private final IndBytesService indBytesService;

    @PostMapping(path = "/selectMovie")
    public ResponseEntity<ResponseVO> SelectMovie(@Valid @RequestBody SelectedMovieVo selectedMovieVo) {
        indBytesService.selectMovie(selectedMovieVo);
        return ResponseEntity.ok().body(ResponseVO.builder()
                .message("SAVED")
                .success(true)
                .statusCode(HttpStatus.OK)
                .build());
    }
    @PostMapping(path = "/create-user")
    public ResponseEntity<ResponseVO> createUsers(@RequestBody @Valid UsersVo usersVo) {
        indBytesService.createUser(usersVo);
        return ResponseEntity.ok().body(ResponseVO.builder()
                .message("User Created")
                .success(true)
                .statusCode(HttpStatus.OK)
                .build());
    }
    @PutMapping(path = "/update-user")
    public ResponseEntity<ResponseVO>updateUser(@RequestBody @Valid UsersVo usersVo, @RequestParam int userId){
        indBytesService.updateUser(usersVo,userId);
        return ResponseEntity.ok().body(ResponseVO.builder()
                .message("User Updated Successfully")
                .success(true)
                .statusCode(HttpStatus.OK)
                .build());
    }
    @PutMapping(path = "/update-movie")
    public ResponseEntity<ResponseVO>updateMovie(@RequestBody @Valid MoviesVo moviesVo, @RequestParam int movieId) {
        indBytesService.updateMovie(moviesVo, movieId);
        return ResponseEntity.ok().body(ResponseVO.builder()
                .message("Movie Updated Successfully")
                .success(true)
                .statusCode(HttpStatus.OK)
                .build());
    }
    @PostMapping("/add-movie")
    public ResponseEntity<ResponseVO>createMovies(@RequestBody @Valid  MoviesVo moviesVo){
        indBytesService.createMovie(moviesVo);
        return ResponseEntity.ok().body(ResponseVO.builder()
                .message("New Movie Added")
                .success(true)
                .statusCode(HttpStatus.OK)
                .build());
    }
    @PostMapping("/list-todays")
    public ResponseEntity<ViewedMovieResponse> viewedMovie(@RequestBody ViewedMovieRequest request){
        return ResponseEntity.ok().body(indBytesService.viewedMovie(request));
    }

    @PostMapping("/movie-list")
    public ResponseEntity<List<SelectedMovieListVO>> movieList(@RequestBody @Valid ViewedMovieRequest request){
        return ResponseEntity.ok().body(indBytesService.movieList(request));
    }
    @GetMapping("/get-all-movie")
    public ResponseEntity<List<SelectedMovieListVO>>getAllMovieS(){
        return ResponseEntity.ok().body(indBytesService.getAllMovies());
    }
    @GetMapping("/get-all-users")
    public ResponseEntity<List<Users>>getAllUsers(){
        return ResponseEntity.ok().body(indBytesService.getAllUsers());
    }
    @DeleteMapping("/delete-user")
    public ResponseEntity<ResponseVO>deleteUser(@RequestBody @Valid Integer userId){
        indBytesService.deleteUser(userId);
        return ResponseEntity.ok().body(ResponseVO.builder()
                .message("Deleted..")
                .success(true)
                .statusCode(HttpStatus.OK)
                .build());

    }
    @DeleteMapping("/delete-movie")
    public ResponseEntity<ResponseVO>deleteMovie(@RequestBody @Valid Integer movieId){
        indBytesService.deleteMovie(movieId);
        return ResponseEntity.ok().body(ResponseVO.builder()
                .message("Deleted..")
                .success(true)
                .statusCode(HttpStatus.OK)
                .build());

    }
}
