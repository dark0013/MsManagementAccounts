/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.domain.port.in;

import com.acampoverde.MsManagementAccounts.domain.model.Movement;
import java.util.List;

/**
 *
 * @author alcampoverde
 */
public interface IAccountMovementServicePort {

    Movement findById(Integer id);

    List<Movement> findAll();

    Movement save(Movement transaction);
}
