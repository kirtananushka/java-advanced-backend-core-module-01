package com.tananushka.javabackendcore.bankimpl;

import com.tananushka.javabackendcore.dto.BankCard;
import com.tananushka.javabackendcore.dto.BankCardType;
import com.tananushka.javabackendcore.dto.CreditBankCard;
import com.tananushka.javabackendcore.dto.DebitBankCard;
import com.tananushka.javabackendcore.dto.User;
import com.tananushka.javabackendcore.utils.CardNumberGenerator;

import java.util.function.BiFunction;

public class BankCardFactory {

   public static BankCard createBankCard(String bankPrefix, User user, BankCardType bankCardType) {
      String cardNumber = CardNumberGenerator.generateCardNumber();

      BiFunction<String, User, BankCard> bankCardConstructor = switch (bankCardType) {
         case CREDIT -> CreditBankCard::new;
         case DEBIT -> DebitBankCard::new;
      };

      return bankCardConstructor.apply(String.format("%s - %s - %s", bankPrefix, bankCardType, cardNumber), user);
   }
}
