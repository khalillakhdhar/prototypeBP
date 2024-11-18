package com.elitech.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.dto.UserDTO;


public interface UserService {
UserDTO createUser(UserDTO userDTO);
UserDTO updateUser(long id,UserDTO userDTO);
UserDTO getUserById(long id);
Page<UserDTO> getAllUsers(Pageable pageable);
void deleteUser(long id);
}
