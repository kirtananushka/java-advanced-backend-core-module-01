package com.tananushka.javabackendcore.bankimpl;

import com.tananushka.javabackendcore.bankapi.Bank;
import com.tananushka.javabackendcore.dto.BankCard;
import com.tananushka.javabackendcore.dto.BankCardType;
import com.tananushka.javabackendcore.dto.User;
import org.springframework.stereotype.Service;

@Service
public class RetailBank implements Bank {

   @Override
   public BankCard createBankCard(User user, BankCardType bankCardType) {
      return BankCardFactory.createBankCard("RETAIL", user, bankCardType);
   }
}
