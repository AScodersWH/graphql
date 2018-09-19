package com.thoughtworks.test.controller.repository;

import com.thoughtworks.test.controller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findOneById(Integer id);
}
