package com.crudVueDB.crudVue.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;


@ToString
public class UserDTO {

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private LocalDateTime createAt;
    @Getter
    @Setter
    private UserDetailDTO userDetailDTO;


    public UserDTO() {

    }
}
