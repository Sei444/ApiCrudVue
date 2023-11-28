package com.crudVueDB.crudVue.services.implement;


import com.crudVueDB.crudVue.dto.UserDetailDTO;
import com.crudVueDB.crudVue.entities.UserDetail;
import com.crudVueDB.crudVue.repositories.UserDetailRepository;
import com.crudVueDB.crudVue.services.UserDetailServices;
import com.crudVueDB.crudVue.services.mappers.UserDetailMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailImpl implements UserDetailServices {

    private final UserDetailRepository userDetailRepository;
    private final UserDetailMapper userDetailMapper;

    public UserDetailImpl(UserDetailRepository userDetailRepository,
                                       UserDetailMapper userDetailMapper) {
        this.userDetailRepository = userDetailRepository;
        this.userDetailMapper = userDetailMapper;
    }

    @Override
    public List<UserDetailDTO> listUserDetails() {
        return userDetailRepository.findAll()
                .stream()
                .map(userDetailMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDetailDTO getUserDetail(Integer id) {
        List<UserDetail> listUserDetail = userDetailRepository.findAll();
        UserDetail res = new UserDetail();
        for (UserDetail aux : listUserDetail) {
            if (aux.getId() == id) {
                res=aux;
                break;
            }
        }
        return this.userDetailMapper.toDto(res);
    }


    @Override
    public UserDetailDTO createUserDetail(UserDetailDTO userDetail) {
        return this.userDetailMapper.toDto(
                userDetailRepository.save(this.userDetailMapper.toEntity(userDetail)));
    }

    @Override
    public UserDetailDTO updateUserDetail(Integer id, UserDetailDTO userDetail) {
        UserDetail userDetailRes = userDetailRepository.getReferenceById(id);
        userDetailRes.setFirstName(userDetail.getFirstName());
        userDetailRes.setLastName(userDetail.getLastName());
        userDetailRes.setAge(userDetail.getAge());
        userDetailRes.setBirth_day(LocalDateTime.from((userDetail.getBirth_day())));
        userDetailRes.setUser(userDetail.getUser());
        userDetailRepository.save(userDetailRes);
        return this.userDetailMapper.toDto(userDetailRes);
    }

    @Override
    public Integer deleteUserDetail(Integer id) {
        userDetailRepository.deleteById(id);
        return id;
    }
}
