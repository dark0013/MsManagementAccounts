/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.mapper;

import com.acampoverde.MsManagementAccounts.domain.model.Movement;
import com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.entity.MovementEntity;
import org.mapstruct.Mapper;

/**
 *
 * @author alcampoverde
 */
@Mapper(componentModel = "spring")
public interface IAccountMovementRepositoryMapper {

    Movement toDomain(MovementEntity account);

    MovementEntity toEntity(Movement account);
}
