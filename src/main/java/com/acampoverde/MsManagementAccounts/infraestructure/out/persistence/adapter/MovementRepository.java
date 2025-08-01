/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.adapter;

import com.acampoverde.MsManagementAccounts.domain.model.Movement;
import com.acampoverde.MsManagementAccounts.domain.port.out.IAccountMovementRepositoryPort;
import com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.entity.MovementEntity;
import com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.mapper.IAccountMovementRepositoryMapper;
import com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.mapper.IAccountRepositoryMapper;
import com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.repository.IMovementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alcampoverde
 */
@Repository
public class MovementRepository implements IAccountMovementRepositoryPort {

    private final IMovementRepository movementRepository;
    private final IAccountMovementRepositoryMapper accountMovementRepositoryMapper;

    public MovementRepository(IMovementRepository movementRepository, IAccountMovementRepositoryMapper accountMovementRepositoryMapper) {
        this.movementRepository = movementRepository;
        this.accountMovementRepositoryMapper = accountMovementRepositoryMapper;
    }

    @Override
    public Optional<Movement> findById(Integer id) {
        Optional<MovementEntity> movementEntity = movementRepository.findById(id);
        return movementEntity.map(accountMovementRepositoryMapper::toDomain);

    }

    @Override
    public List<Movement> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Movement save(Movement transaction) {
        MovementEntity movementEntity = accountMovementRepositoryMapper.toEntity(transaction);
        MovementEntity movement = movementRepository.save(movementEntity);
        return accountMovementRepositoryMapper.toDomain(movement);
    }

}
