package com.crudVueDB.crudVue.web.rest.controller;


import com.crudVueDB.crudVue.dto.UserDTO;
import com.crudVueDB.crudVue.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserServices userService;

    public UserController(UserServices userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok().body(userService.listUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> getUserById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(Optional.ofNullable(userService.getUser(id)));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody final UserDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new student cannot already have an id.");
        }

        UserDTO userDB = userService.save(dto);

        return ResponseEntity.created(new URI("/v1/users/" + userDB.getId())).body(userDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> editUser(@RequestBody final UserDTO dto,
                                            @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid user id, null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        return ResponseEntity
                .ok()
                .body(this.userService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> logicalDelete(@PathVariable final Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
