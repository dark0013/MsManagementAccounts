/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.infraestructure.in.handler;

import com.acampoverde.MsManagementAccounts.domain.model.Movement;
import com.acampoverde.MsManagementAccounts.domain.port.in.IAccountMovementServicePort;
import com.acampoverde.MsManagementAccounts.infraestructure.in.dto.MovementDto;
import com.acampoverde.MsManagementAccounts.infraestructure.in.mapper.IMovementMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MovementHandler {

    private final IAccountMovementServicePort movimentService;
    private final IMovementMapper movementMapper;

    public MovementHandler(IAccountMovementServicePort movimentService, IMovementMapper movementMapper) {
        this.movimentService = movimentService;
        this.movementMapper = movementMapper;
    }

    public MovementDto findById(Integer id) {
        Movement movementObj = movimentService.findById(id);
        return movementMapper.toDto(movementObj);
    }

    public List<MovementDto> findAll() {
        return movimentService.findAll()
                .stream()
                .map(movementMapper::toDto)
                .collect(Collectors.toList());
    }

    public MovementDto save(MovementDto transaction) {
        Movement movement = movementMapper.toDomain(transaction);
        Movement movementObj = movimentService.save(movement);
        return movementMapper.toDto(movementObj);
    }
}
