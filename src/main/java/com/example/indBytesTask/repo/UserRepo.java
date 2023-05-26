package com.example.indBytesTask.repo;

import com.example.indBytesTask.entity.Users;
import com.example.indBytesTask.vo.SelectedMovieListVO;
import com.example.indBytesTask.vo.UsersVo;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    @Query(value = "select * from users",nativeQuery = true)
//    @Query(value = " Select new com.example.indBytesTask.vo.UsersVo(u.userId,u.userName) from Users u")
    List<Users>getAllUsers();

    void deleteById(int userId);
}
