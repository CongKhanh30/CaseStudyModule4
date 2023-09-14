package com.be.service.impl;

import com.be.model.Account;
import com.be.repository.IAccountRepo;
import com.be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepo iAccountRepo;
    public List<Account> getAll(){
        return (List<Account>) iAccountRepo.findAll();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add((GrantedAuthority) account.getRole());
        return new User(username,account.getPassword(),roles);
    }
    @Override
    public Account findByUsername(String username) {
        return iAccountRepo.findByUsername(username);
    }

    @Override
    public Account save(Account account) {
        return iAccountRepo.save(account);
    }

    @Override
    public void delete(int id) {
        iAccountRepo.deleteById(id);
    }
    public Account findById(int id){
        return iAccountRepo.findById(id);
    }
}
