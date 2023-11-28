package com.crudVueDB.crudVue.repositories;

import com.crudVueDB.crudVue.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}