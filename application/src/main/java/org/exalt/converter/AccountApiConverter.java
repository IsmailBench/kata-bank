package org.exalt.converter;

import lombok.experimental.UtilityClass;
import org.exalt.dto.AccountResponse;
import org.exalt.model.intf.Account;

@UtilityClass
public class AccountApiConverter {

    public static AccountResponse toAccountResponse(Account account){
        return new AccountResponse(account.getName(), account.getBalance());
    }
}
