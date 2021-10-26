package com.example.jushi.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public interface UserService {


    Boolean judegUser ( String userName , String passWord , Model model) ;

}
