package com.example.indBytesTask.repo;

import com.example.indBytesTask.entity.Movie;
import com.example.indBytesTask.entity.SelectedMovies;
import com.example.indBytesTask.vo.SelectedMovieListVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    @Query(value = "Select new com.example.indBytesTask.vo.SelectedMovieListVO(m.movieId,m.movieName) from Movie m")
    List<SelectedMovieListVO> getAllMovies();

//    @Query(value = "Select new com.example.indBytesTask.vo.MoviesVo(m.movieName) from Movie m where m.movieName=:movieName")
    @Query(value = "select * from movie where movie_name=:movieName", nativeQuery = true)
    Movie findByMovieName(String movieName);

    void deleteById(int movieId);

}
