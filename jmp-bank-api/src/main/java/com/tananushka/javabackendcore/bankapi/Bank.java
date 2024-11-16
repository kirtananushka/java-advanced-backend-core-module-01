package com.tananushka.javabackendcore.bankapi;

import com.tananushka.javabackendcore.dto.BankCard;
import com.tananushka.javabackendcore.dto.BankCardType;
import com.tananushka.javabackendcore.dto.User;

public interface Bank {
   BankCard createBankCard(User user, BankCardType bankCardType);
}
