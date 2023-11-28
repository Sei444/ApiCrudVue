package com.crudVueDB.crudVue.web.rest.controller;

import com.crudVueDB.crudVue.dto.UserDetailDTO;
import com.crudVueDB.crudVue.services.UserDetailServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/userDetail")
public class UserDetailController {

    private final UserDetailServices userDetailServices;

    public UserDetailController(UserDetailServices userDetailServices) {
        this.userDetailServices = userDetailServices;
    }

    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> getAllUserDetails() {
        return ResponseEntity.ok().body(userDetailServices.listUserDetails());
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<UserDetailDTO> getUserDetails(@PathVariable("id") Integer userDetailId) {
        return ResponseEntity.ok().body(userDetailServices.getUserDetail(userDetailId));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserDetailDTO> createUserDetail(@RequestBody UserDetailDTO userDetail) throws URISyntaxException {
        return ResponseEntity.created(null).body(userDetailServices.createUserDetail(userDetail));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UserDetailDTO> updateUserDetail(@PathVariable("id") Integer userDetailId,
                                                          @RequestBody UserDetailDTO userDetail) {
        return ResponseEntity.ok().body(userDetailServices.updateUserDetail(userDetailId, userDetail));
    }

    @DeleteMapping(path = "/delete/{id}")
    public Integer deleteUserDetail(@PathVariable("id") Integer userDetailId) {
        userDetailServices.deleteUserDetail(userDetailId);
        return userDetailId;
    }

}