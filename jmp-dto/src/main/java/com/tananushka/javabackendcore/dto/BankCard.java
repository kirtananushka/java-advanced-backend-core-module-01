package com.tananushka.javabackendcore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public sealed class BankCard permits CreditBankCard, DebitBankCard {
   private String number;
   private User user;
}
