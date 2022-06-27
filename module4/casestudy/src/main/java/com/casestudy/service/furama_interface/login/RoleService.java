package com.casestudy.service.furama_interface.login;

import com.casestudy.model.login.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById(int id);
}
