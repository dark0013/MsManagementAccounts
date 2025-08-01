/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.application.exception;

/**
 *
 * @author alcampoverde
 */
public class AccountMovementNotFoundException  extends RuntimeException{

    public AccountMovementNotFoundException(String message){
        super(message);
    }
    
}
