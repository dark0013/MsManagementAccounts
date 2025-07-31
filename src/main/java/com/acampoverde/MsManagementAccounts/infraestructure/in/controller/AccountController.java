
package com.acampoverde.MsManagementAccounts.infraestructure.in.controller;

import com.acampoverde.MsManagementAccounts.infraestructure.in.dto.AccountDto;
import com.acampoverde.MsManagementAccounts.infraestructure.in.handler.AccountHandler;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountHandler accountHandler;

    public AccountController(AccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> findAllAccount() {
        return new ResponseEntity<>(accountHandler.findAllAccount(), OK);
    }

    @GetMapping("/accountNumber/{accountNumber}")
    public ResponseEntity<AccountDto> findAccountNumberById(@PathVariable String accountNumber){
        return new ResponseEntity<>(accountHandler.findAccountNumberById(accountNumber), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> findAccountById(@PathVariable Integer id){
        return new ResponseEntity<>(accountHandler.findAccountById(id), OK);
    }

    @PostMapping
    public ResponseEntity<AccountDto> saveAccount(@Valid @RequestBody AccountDto account) {
        AccountDto accountDto = accountHandler.saveAccount(account);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(accountDto.getIdCuenta()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<AccountDto> updateAccount(@Valid @RequestBody AccountDto account) {
        return new ResponseEntity<>(accountHandler.updateAccount(account), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Integer id) {
        accountHandler.deleteAccount(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
