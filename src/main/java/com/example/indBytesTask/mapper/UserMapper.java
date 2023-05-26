package com.example.indBytesTask.mapper;

import com.example.indBytesTask.entity.Users;
import com.example.indBytesTask.vo.UsersVo;

public class UserMapper
{
    public static Users toUsers(UsersVo usersVo){
        return Users.builder()
                .userName(usersVo.getUserName())
                .build();
    }
    public static Users toUpdateUser(Users user,UsersVo usersVo){
        user.setUserName(usersVo.getUserName());
        return user;
    }

}
