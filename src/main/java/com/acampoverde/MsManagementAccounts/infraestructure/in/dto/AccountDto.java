package com.acampoverde.MsManagementAccounts.infraestructure.in.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

    private Integer idCuenta;
    private String accountNumber;
    private String accountType;
    private Double initialBalance;
    private Boolean status;

}
