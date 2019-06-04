package com.example.applogin.BusinessLogic;


import android.content.Context;

import com.example.applogin.DataAccess.Models.Account;
import com.example.applogin.DataAccess.Repositories.AccountRepository;

public class SendMoneyController {
    Account account1;
    Account account2;
    Context context;
    AccountRepository accountRepository;

    public boolean sendMoney(String account1Id, String account2Id, long amount) {
        accountRepository = new AccountRepository(context);
        account1 = accountRepository.getAccountById(account1Id);
        account2 = accountRepository.getAccountById(account2Id);

        if (amount <= account1.getBalance()&& account2 != null) {
            accountRepository.update("balance", (account1.getBalance() - amount), account1.getAccountNum());
            accountRepository.update("balance", (account2.getBalance() + amount), account2.getAccountNum());
            return true;
        } else {
            return false;
        }
    }
}
