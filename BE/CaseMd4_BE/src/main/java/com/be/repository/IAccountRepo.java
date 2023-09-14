package com.be.repository;

import com.be.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepo extends PagingAndSortingRepository<Account, Integer> {
    List<Account> findAllByUsernameContaining(String username);

    @Query(value = "select a from Account a where a.username like concat('%',:name,'%')")
    List<Account> findAllByUsernameHQL(@Param("name") String username);

    Account findByUsername(String username);
    Account findById(int id);
}
