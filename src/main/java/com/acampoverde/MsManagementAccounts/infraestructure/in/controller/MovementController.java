/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.infraestructure.in.controller;

import com.acampoverde.MsManagementAccounts.infraestructure.in.dto.MovementDto;
import com.acampoverde.MsManagementAccounts.infraestructure.in.handler.MovementHandler;
import java.util.List;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/movementtransaction")
public class MovementController {

    private final MovementHandler MovementTransaction;

    public MovementController(MovementHandler MovementTransaction) {
        this.MovementTransaction = MovementTransaction;
    }

    @GetMapping
    public ResponseEntity<List<MovementDto>> fincAllTransaction() {
        return new ResponseEntity<>(MovementTransaction.findAll(), OK);
    }
}
