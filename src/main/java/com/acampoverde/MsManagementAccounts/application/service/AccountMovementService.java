/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.application.service;

import com.acampoverde.MsManagementAccounts.application.exception.AccountMovementNotFoundException;
import com.acampoverde.MsManagementAccounts.application.exception.AccountNotFoundException;
import com.acampoverde.MsManagementAccounts.domain.model.Account;
import com.acampoverde.MsManagementAccounts.domain.model.Movement;
import com.acampoverde.MsManagementAccounts.domain.port.in.IAccountMovementServicePort;
import com.acampoverde.MsManagementAccounts.domain.port.out.IAccountMovementRepositoryPort;
import com.acampoverde.MsManagementAccounts.domain.port.out.IAccountRepositoryPort;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author alcampoverde
 */
public class AccountMovementService implements IAccountMovementServicePort {

    private final IAccountMovementRepositoryPort accountMovementRepository;
    private final IAccountRepositoryPort accountRepository;

    public AccountMovementService(IAccountMovementRepositoryPort accountMovementRepository, IAccountRepositoryPort accountRepository) {
        this.accountMovementRepository = accountMovementRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Movement findById(Integer id) {
        Movement movement = accountMovementRepository.findById(id).orElseThrow(() -> new AccountMovementNotFoundException("Movement not found with id: " + id));
        return movement;
    }

    @Override
    public List<Movement> findAll() {
        List<Movement> movements = accountMovementRepository.findAll();
        if (movements == null || movements.isEmpty()) {
            throw new AccountNotFoundException("No movements found");
        }
        return movements;
    }

    @Override
    public Movement save(Movement movement) {
        Account account = accountRepository.findAccountById(movement.getAccountId()).orElseThrow(() -> new AccountNotFoundException("NO ACCOUNT FOUND"));

        if (account == null) {
            throw new RuntimeException("Cuenta no encontrada con ID: " + movement.getAccountId());
        }

        Double currentBalance = account.getInitialBalance();
        Double movementValue = movement.getBalance();

        // Verificar si es retiro
        if ("RETIRO".equalsIgnoreCase(movement.getMovementType())) {
            if (movementValue > currentBalance) {
                throw new RuntimeException("Saldo no disponible");
            }
            currentBalance -= movementValue;
            movement.setBalance(-movementValue); // Guardar como negativo
        } else if ("DEPOSITO".equalsIgnoreCase(movement.getMovementType())) {
            currentBalance += movementValue;
        } else {
            throw new RuntimeException("Tipo de movimiento no válido: " + movement.getMovementType());
        }

        // Actualizar saldo de la cuenta
        account.setInitialBalance(currentBalance);
        accountRepository.saveAccount(account);

        // Establecer el nuevo saldo y fecha en el movimiento
        movement.setBalance(currentBalance);
        movement.setDate(LocalDateTime.now());

        return accountMovementRepository.save(movement);
    }

}
