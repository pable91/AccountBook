package com.AccountBook.repository;

import com.AccountBook.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select a from Account a where a.active = true and a.email = :email")
    Optional<Account> findActiveByEmail(String email);

    @Query("select a from Account a where a.email = :email")
    Optional<Account> findByEmail(String email);

    @Query("select a from Account a where a.active = true ")
    List<Account> findActiveAll();
}
