
package com.acampoverde.MsManagementAccounts.application.exception;


public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message){
        super(message);
    }
}
