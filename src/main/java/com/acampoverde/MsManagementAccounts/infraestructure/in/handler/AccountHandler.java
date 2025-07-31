/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.infraestructure.in.handler;

import com.acampoverde.MsManagementAccounts.domain.model.Account;
import com.acampoverde.MsManagementAccounts.domain.port.in.IAccountServicePort;
import com.acampoverde.MsManagementAccounts.infraestructure.in.dto.AccountDto;
import com.acampoverde.MsManagementAccounts.infraestructure.in.mapper.IAccountMapper;
import com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.entity.AccountEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;


@Component
public class AccountHandler {

    private final IAccountServicePort AccountService;
    private final IAccountMapper accountMapper;

    public AccountHandler(IAccountServicePort AccountService, IAccountMapper accountMapper) {
        this.AccountService = AccountService;
        this.accountMapper = accountMapper;
    }

    public List<AccountDto> findAllAccount() {
        return AccountService.findAllAccount()
                .stream()
                .map(accountMapper::toDto)
                .toList();
    }

    public AccountDto findAccountById(Integer id) {
        Account account = AccountService.findAccountById(id);
        AccountDto accountDto = accountMapper.toDto(account);
        return accountDto;
    }

    public AccountDto findAccountNumberById(String accountNumber) {
        Account account = AccountService.findAccountNumberById(accountNumber);
        AccountDto accountDto = accountMapper.toDto(account);
        return accountDto;
    }

    public AccountDto saveAccount(AccountDto account) {
        Account accountObj = AccountService.saveAccount(accountMapper.toDomain(account));
        return accountMapper.toDto(accountObj);
    }

    public AccountDto updateAccount(AccountDto account) {
        Account accountObj = AccountService.updateAccount(accountMapper.toDomain(account));
        return accountMapper.toDto(accountObj);
    }
    
    public void deleteAccount(Integer id){
        AccountService.deleteAccount(id);
    }

}
