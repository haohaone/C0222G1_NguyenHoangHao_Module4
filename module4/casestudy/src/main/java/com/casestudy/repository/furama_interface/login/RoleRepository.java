package com.casestudy.repository.furama_interface.login;

import com.casestudy.model.login.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    @Query(value = "SELECT * FROM role WHERE role_id = :id", nativeQuery = true)
    Role findByRoleId(@Param("id") int id);
}
