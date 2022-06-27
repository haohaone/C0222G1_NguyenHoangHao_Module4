package com.casestudy.service.imp.login_imp;

import com.casestudy.model.login.Role;
import com.casestudy.repository.furama_interface.login.RoleRepository;
import com.casestudy.service.furama_interface.login.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findByRoleId(id);
    }
}
