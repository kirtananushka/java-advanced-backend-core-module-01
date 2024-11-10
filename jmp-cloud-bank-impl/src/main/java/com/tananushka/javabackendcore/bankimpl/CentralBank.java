package com.tananushka.javabackendcore.bankimpl;

import com.tananushka.javabackendcore.bankapi.Bank;
import com.tananushka.javabackendcore.dto.BankCard;
import com.tananushka.javabackendcore.dto.BankCardType;
import com.tananushka.javabackendcore.dto.CreditBankCard;
import com.tananushka.javabackendcore.dto.DebitBankCard;
import com.tananushka.javabackendcore.dto.User;
import com.tananushka.javabackendcore.utils.SimpleCardNumberGenerator;
import org.springframework.stereotype.Service;

@Service
public class CentralBank implements Bank {
   @Override
   public BankCard createBankCard(User user, BankCardType bankCardType) {
      String cardNumber = SimpleCardNumberGenerator.generateCardNumber();

      return switch (bankCardType) {
         case CREDIT -> CreditBankCard.builder()
               .number("CENTRAL-CREDIT-" + cardNumber)
               .user(user)
               .build();
         case DEBIT -> DebitBankCard.builder()
               .number("CENTRAL-DEBIT-" + cardNumber)
               .user(user)
               .build();
      };
   }
}
