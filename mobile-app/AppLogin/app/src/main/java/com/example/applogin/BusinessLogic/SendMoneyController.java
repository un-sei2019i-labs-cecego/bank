package com.example.applogin.BusinessLogic;


import android.content.Context;

import com.example.applogin.DataAccess.Models.Account;
import com.example.applogin.DataAccess.Repositories.AccountRepository;
import com.example.applogin.DataAccess.Repositories.TransactionRepository;

public class SendMoneyController {
    Account account1;
    Account account2;
    Context context;
    AccountRepository accountRepository;
    TransactionRepository transactionRepository;
    public SendMoneyController(Context context) {
        this.context = context;
    }

    public boolean sendMoney(String account1Id, String account2Id, long amount) {
        accountRepository = new AccountRepository(context);
        transactionRepository = new TransactionRepository(context);
        account1 = accountRepository.getAccountById(account1Id);
        account2 = accountRepository.getAccountById(account2Id);

        if (amount <= account1.getBalance()&& account2 != null) {
            accountRepository.update("balance", (account1.getBalance() - amount), account1.getAccountNum());
            accountRepository.update("balance", (account2.getBalance() + amount), account2.getAccountNum());
            transactionRepository.createTransaction(account1.getAccountNum(),account2.getAccountNum(),"transferencia",amount);
            return true;
        } else {
            return false;
        }
    }
}
