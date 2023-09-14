package com.be.service;

import com.be.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    Account findByUsername(String username);
    Account save(Account account);
    void delete(int id);
    List<Account> getAll();
    Account findById(int id);
}
