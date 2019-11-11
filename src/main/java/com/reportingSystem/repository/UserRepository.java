package com.reportingSystem.repository;

import com.reportingSystem.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findUserModelByUserId(int id);

    UserModel findUserModelByUsername(String username);

    UserModel findUserModelByEmail(String email);

}
