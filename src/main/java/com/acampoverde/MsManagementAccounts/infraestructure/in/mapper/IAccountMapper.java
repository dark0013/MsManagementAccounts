/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.infraestructure.in.mapper;

import com.acampoverde.MsManagementAccounts.domain.model.Account;
import com.acampoverde.MsManagementAccounts.infraestructure.in.dto.AccountDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IAccountMapper {

    Account toDomain(AccountDto account);

    AccountDto toDto(Account account);

}
