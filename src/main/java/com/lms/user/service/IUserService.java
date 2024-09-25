package com.lms.user.service;

import com.lms.user.dto.LoginDTO;
import com.lms.user.dto.UserDTO;

public interface IUserService {

    UserDTO login(LoginDTO loginDTO);

    String createUser(UserDTO userDTO);
}
