package com.crudVueDB.crudVue.dto;


import com.crudVueDB.crudVue.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class UserDetailDTO {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private Integer age;

    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate birth_day;

    @Getter
    @Setter
    public User user;

    public UserDetailDTO(){

    }

}
