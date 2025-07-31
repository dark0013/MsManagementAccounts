/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.mapper;

import com.acampoverde.MsManagementAccounts.domain.model.Account;
import com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.entity.AccountEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IAccountRepositoryMapper {

    Account toDomain(AccountEntity account);

    AccountEntity toEntity(Account account);
}
