package com.example.indBytesTask.repo;

import com.example.indBytesTask.entity.SelectedMovies;
import com.example.indBytesTask.vo.SelectedMovieListVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SelectedMovieRepo extends JpaRepository<SelectedMovies,Integer> {

    @Query(value = "select s from SelectedMovies s where s.userId=:userId and movieId=:movieId")
    SelectedMovies isWatched(Integer userId,Integer movieId);

    @Query(value = "select new com.example.indBytesTask.vo.SelectedMovieListVO(sm.movieId,m.movieName) " +
            "from SelectedMovies sm join Movie m on m.movieId=sm.movieId where sm.userId=:userId and sm.date=:date")
    List<SelectedMovieListVO> viewedMovie(Integer userId, LocalDate date);

    @Query(value ="SELECT new com.example.indBytesTask.vo.SelectedMovieListVO(m.movieId,m.movieName) FROM Movie m LEFT JOIN SelectedMovies s ON m.movieId = s.movieId AND " +
            "s.userId = :userId WHERE s.movieId IS NULL")
    List<SelectedMovieListVO> movieList(Integer userId);


}
