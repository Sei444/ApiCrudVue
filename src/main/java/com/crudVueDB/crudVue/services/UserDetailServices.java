package com.crudVueDB.crudVue.services;

import com.crudVueDB.crudVue.dto.UserDetailDTO;
import com.crudVueDB.crudVue.entities.UserDetail;

import java.util.List;

public interface UserDetailServices {
    List<UserDetailDTO> listUserDetails();

    UserDetailDTO getUserDetail(Integer id);

    

    UserDetailDTO createUserDetail(UserDetailDTO userDetail);

    UserDetailDTO updateUserDetail(Integer id, UserDetailDTO userDetail);

    Integer deleteUserDetail(Integer id);
}
