package com.be.service.impl;

import com.be.model.Role;
import com.be.repository.IRoleRepo;
import com.be.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepo iRoleRepo;
    @Override
    public void save(Role role) {
        iRoleRepo.save(role);
    }

    @Override
    public void delete(int id) {
       iRoleRepo.deleteById(id);
    }

    @Override
    public List<Role> getAll() {
        return (List<Role>) iRoleRepo.findAll();
    }
}
