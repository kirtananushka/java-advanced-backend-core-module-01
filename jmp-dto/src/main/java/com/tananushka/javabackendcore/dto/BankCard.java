package com.tananushka.javabackendcore.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@RequiredArgsConstructor
@SuperBuilder
public sealed class BankCard permits CreditBankCard, DebitBankCard {
   private final String number;
   private final User user;
}
