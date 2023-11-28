package com.crudVueDB.crudVue.services.implement;


import com.crudVueDB.crudVue.dto.UserDTO;
import com.crudVueDB.crudVue.entities.User;
import com.crudVueDB.crudVue.repositories.UserRepository;
import com.crudVueDB.crudVue.services.UserServices;
import com.crudVueDB.crudVue.services.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServicesImpl(UserRepository userRepository,
                            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO dto) {
        User userRes = userRepository.save(userMapper.toEntity(dto));
        userRes.setUserName(dto.getUsername());
        userRes.setPassword(dto.getPassword());
        userRes.setId(dto.getId());
        userRes.setCreateAt(dto.getCreateAt());
        userRes.setEmail(dto.getEmail());
        userRepository.save(userRes);
        return this.userMapper.toDto(userRes);
    }

    @Override
    public Optional<UserDTO> getUserById(Integer id) {
        return Optional.empty();
    }

    @Override
    public UserDTO getUser(Integer id) {
        List<User> listUser = userRepository.findAll();
        User res = new User();
        for (User aux : listUser) {
            if (aux.getId() == id) {
                res=aux;
                break;
            }
        }
        return this.userMapper.toDto(res);
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return this.userMapper.toDto(
                userRepository.save(this.userMapper.toEntity(user)));
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO user) {
        User userRes = userRepository.getReferenceById(id);
        userRes.setUserName(user.getUsername());
        userRes.setPassword(user.getPassword());
        userRes.setId(user.getId());
        userRes.setCreateAt(user.getCreateAt());
        userRes.setEmail(user.getEmail());
        userRepository.save(userRes);
        return this.userMapper.toDto(userRes);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }
}
