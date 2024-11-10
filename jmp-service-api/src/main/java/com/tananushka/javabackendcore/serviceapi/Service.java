package com.tananushka.javabackendcore.serviceapi;

import com.tananushka.javabackendcore.dto.BankCard;
import com.tananushka.javabackendcore.dto.Subscription;
import com.tananushka.javabackendcore.dto.User;

import java.util.List;
import java.util.Optional;

public interface Service {
   void subscribe(BankCard bankCard);

   Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);

   List<User> getAllUsers();
}
