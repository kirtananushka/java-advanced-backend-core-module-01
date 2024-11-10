package com.tananushka.javabackendcore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
   @Id
   private String name;
   private String surname;
   private LocalDate birthday;

   @Override
   public final boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UserEntity that = (UserEntity) o;
      return getName() != null && Objects.equals(getName(), that.getName());
   }

   @Override
   public final int hashCode() {
      return getClass().hashCode();
   }
}
