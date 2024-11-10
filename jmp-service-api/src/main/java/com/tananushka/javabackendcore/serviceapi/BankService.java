package com.tananushka.javabackendcore.serviceapi;

import com.tananushka.javabackendcore.dto.BankCard;
import com.tananushka.javabackendcore.dto.Subscription;
import com.tananushka.javabackendcore.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public interface BankService {
   void subscribe(BankCard bankCard);

   Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);

   List<User> getAllUsers();

   static boolean isPayableUser(User user) {
      return calculateAge(user) >= 18;
   }

   private static long calculateAge(User user) {
      return ChronoUnit.YEARS.between(user.birthday(), LocalDate.now());
   }

   default double getAverageUsersAge() {
      return getAllUsers().stream()
            .mapToLong(BankService::calculateAge)
            .average()
            .orElse(0.0);
   }
}
