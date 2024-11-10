package com.tananushka.javabackendcore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscriptions")
public class SubscriptionEntity {
   @Id
   private String bankcardNumber;
   private LocalDate startDate;

   @Override
   public final boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SubscriptionEntity that = (SubscriptionEntity) o;
      return getBankcardNumber() != null && Objects.equals(getBankcardNumber(), that.getBankcardNumber());
   }

   @Override
   public final int hashCode() {
      return getClass().hashCode();
   }
}
