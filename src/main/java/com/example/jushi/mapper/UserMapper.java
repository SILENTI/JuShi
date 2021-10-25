package com.example.jushi.mapper;

import com.example.jushi.model.User;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();
}