package com.payheretest.model;

import com.payheretest.dto.account.command.AccountAddCommand;
import com.payheretest.dto.account.command.AccountModifyCommand;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    private String email;

    private int money;

    private String content;

    private boolean active;

    public Account(AccountAddCommand command) {
        email = command.getEmail();
        money = command.getMoney();
        content = command.getContent();
        active = true;
    }

    public void modifyAccount(AccountModifyCommand command) {
        content = command.getContent();
        money = command.getMoney();
    }
}
