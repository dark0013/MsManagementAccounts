package com.acampoverde.MsManagementAccounts.infraestructure.in.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

    private Integer idCuenta;
    @NotNull
    @Size(min = 10, max = 20, message = "Account number must be between 10 and 20 characters")
    private String accountNumber;
    @NotNull
    private String accountType;
    @NotNull
    private Double initialBalance;
    @NotNull
    private Boolean status;
    
      private Integer customerId;

}
