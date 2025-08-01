/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.infraestructure.in.mapper;

import com.acampoverde.MsManagementAccounts.domain.model.Movement;
import com.acampoverde.MsManagementAccounts.infraestructure.in.dto.MovementDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMovementMapper {

    MovementDto toDto(Movement transaction);

    Movement toDomain(MovementDto transaction);
}
