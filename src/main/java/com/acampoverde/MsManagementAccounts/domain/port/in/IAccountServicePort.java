
package com.acampoverde.MsManagementAccounts.domain.port.in;

import com.acampoverde.MsManagementAccounts.domain.model.Account;
import java.util.List;
import java.util.Optional;


public interface IAccountServicePort {

    List<Account> findAllAccount();

    Account findAccountById(Integer id);

    Account findAccountNumberById(String accountNumber);

    Account saveAccount(Account account);

    Account updateAccount(Account account);

    void deleteAccount(Integer id);
}
