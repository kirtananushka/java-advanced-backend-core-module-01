package com.tananushka.javabackendcore.dto;

import com.tananushka.javabackendcore.entity.SubscriptionEntity;

import java.time.LocalDate;

public record Subscription(String bankcardNumber, LocalDate startDate) {

   public static Subscription toDto(SubscriptionEntity entity) {
      return new Subscription(entity.getBankcardNumber(), entity.getStartDate());
   }
}
