package com.be.service;

import com.be.model.Role;
import java.util.List;

public interface IRoleService {
    void save(Role role);
    void delete(int id);
    List<Role> getAll();
}
