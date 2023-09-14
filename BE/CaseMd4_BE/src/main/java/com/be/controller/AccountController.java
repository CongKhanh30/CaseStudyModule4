package com.be.controller;

import com.be.model.Account;
import com.be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiAccount")
public class AccountController {
    @Autowired
    IAccountService iAccountService;

    @PostMapping("/creatAccount")
    public ResponseEntity<Account> save(@RequestBody Account account) {
        return new ResponseEntity<>(iAccountService.save(account), HttpStatus.OK);
    }
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAll() {
        List<Account> accounts = iAccountService.getAll();
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/{idAccount}")
    @ResponseBody
    public ResponseEntity<Account> getAccount(@PathVariable int idAccount) {
        Account account = iAccountService.findById(idAccount);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
