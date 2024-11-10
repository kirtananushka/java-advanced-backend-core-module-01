package com.tananushka.javabackendcore.serviceapi;

import com.tananushka.javabackendcore.dto.BankCard;
import com.tananushka.javabackendcore.dto.Subscription;
import com.tananushka.javabackendcore.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;

public interface BankService {
   static boolean isPayableUser(User user) {
      return calculateAge(user) >= 18;
   }

   private static long calculateAge(User user) {
      return ChronoUnit.YEARS.between(user.birthday(), LocalDate.now());
   }

   void subscribe(BankCard bankCard);

   Subscription getSubscriptionByBankCardNumber(String bankCardNumber);

   List<User> getAllUsers();

   List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> subscriptionPredicate);

   default double getAverageUsersAge() {
      return getAllUsers().stream()
            .mapToLong(BankService::calculateAge)
            .average()
            .orElse(0.0);
   }
}
