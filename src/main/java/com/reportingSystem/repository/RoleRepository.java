package com.reportingSystem.repository;

import com.reportingSystem.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Integer> {

    RoleModel findRoleModelByRoleName(String roleName);
}
