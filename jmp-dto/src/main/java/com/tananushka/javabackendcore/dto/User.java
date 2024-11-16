package com.tananushka.javabackendcore.dto;

import com.tananushka.javabackendcore.entity.UserEntity;

import java.time.LocalDate;

public record User(String name, String surname, LocalDate birthday) {

   public static User toDto(UserEntity entity) {
      return new User(entity.getName(), entity.getSurname(), entity.getBirthday());
   }

   public UserEntity toEntity() {
      return new UserEntity(name, surname, birthday);
   }
}
