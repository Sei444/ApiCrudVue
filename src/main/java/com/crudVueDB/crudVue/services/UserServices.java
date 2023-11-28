package com.crudVueDB.crudVue.services;

import com.crudVueDB.crudVue.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserServices {

    List<UserDTO> listUsers();
    UserDTO save(UserDTO dto);
    Optional<UserDTO> getUserById(Integer id);


    UserDTO getUser(Integer id);

    UserDTO createUser(UserDTO user);

    UserDTO updateUser(Integer id, UserDTO user);

    void deleteUser(Integer id);
}
