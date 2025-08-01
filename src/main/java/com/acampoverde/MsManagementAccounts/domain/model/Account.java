
package com.acampoverde.MsManagementAccounts.domain.model;

import java.util.List;


public class Account {

    private Integer idCuenta;
    private String accountNumber;
    private String accountType;
    private Double initialBalance;
    private Boolean status;
    
     private Integer customerId;

    private List<Movement> movements;

    public Account() {
    }

    
    public Account(Integer idCuenta, String accountNumber, String accountType, Double initialBalance, Boolean status, Integer customerId) {
        this.idCuenta = idCuenta;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.status = status;
        this.customerId = customerId;
    }

    public Account(Integer idCuenta, String accountNumber, String accountType, Double initialBalance, Boolean status, Integer customerId, List<Movement> movements) {
        this.idCuenta = idCuenta;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.status = status;
        this.customerId = customerId;
        this.movements = movements;
    }
    
    

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }
    
    

    
}
