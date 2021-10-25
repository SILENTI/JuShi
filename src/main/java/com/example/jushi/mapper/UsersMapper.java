package com.example.jushi.mapper;

import com.example.jushi.model.Users;
import java.util.List;

public interface UsersMapper {
    int insert(Users record);

    List<Users> selectAll();
}