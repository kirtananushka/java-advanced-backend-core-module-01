package com.tananushka.javabackendcore.application;

import com.tananushka.javabackendcore.bankimpl.CentralBank;
import com.tananushka.javabackendcore.bankimpl.InvestmentBank;
import com.tananushka.javabackendcore.bankimpl.RetailBank;
import com.tananushka.javabackendcore.dto.BankCard;
import com.tananushka.javabackendcore.dto.BankCardType;
import com.tananushka.javabackendcore.dto.User;
import com.tananushka.javabackendcore.serviceapi.BankService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.tananushka.javabackendcore.serviceimpl")
@EntityScan(basePackages = "com.tananushka.javabackendcore.entity")
@ComponentScan(basePackages = "com.tananushka.javabackendcore")
public class Application {
   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);

      try (var context = new AnnotationConfigApplicationContext("com.tananushka.javabackendcore")) {
         System.out.println("Creating CentralBank user...");
         var centralBank = context.getBean(CentralBank.class);
         var bankService = context.getBean(BankService.class);

         var user1 = new User("Giorgi", "Kikalishvili", LocalDate.of(1985, 2, 14));
         System.out.println("Created User: " + user1);
         BankCard bankCard1 = null;
         if (BankService.isPayableUser(user1)) {
            System.out.println("User is payable.");
            bankCard1 = centralBank.createBankCard(user1, BankCardType.CREDIT);
            System.out.println("Created Bank Card for CentralBank user: " + bankCard1);
            bankService.subscribe(bankCard1);
            System.out.println("User subscribed successfully with CentralBank card: " + bankCard1.getNumber());
         } else {
            System.out.println("User is not payable and cannot receive a bank card.");
         }

         System.out.println("----------------------------------------");
         System.out.println("Creating RetailBank user...");

         var retailBank = context.getBean(RetailBank.class);
         var user2 = new User("Nino", "Tskhadadze", LocalDate.of(1992, 5, 30));
         System.out.println("Created User: " + user2);
         BankCard bankCard2 = null;
         if (BankService.isPayableUser(user2)) {
            System.out.println("User is payable.");
            bankCard2 = retailBank.createBankCard(user2, BankCardType.DEBIT);
            System.out.println("Created Bank Card for RetailBank user: " + bankCard2);
            bankService.subscribe(bankCard2);
            System.out.println("User subscribed successfully with RetailBank card: " + bankCard2.getNumber());
         } else {
            System.out.println("User is not payable and cannot receive a bank card.");
         }

         System.out.println("----------------------------------------");
         System.out.println("Creating InvestmentBank user...");

         var investmentBank = context.getBean(InvestmentBank.class);
         var user3 = new User("Levan", "Chkhaidze", LocalDate.of(2020, 9, 10));
         System.out.println("Created User: " + user3);
         BankCard bankCard3 = null;
         if (BankService.isPayableUser(user3)) {
            System.out.println("User is payable.");
            bankCard3 = investmentBank.createBankCard(user3, BankCardType.CREDIT);
            System.out.println("Created Bank Card for InvestmentBank user: " + bankCard3);
            bankService.subscribe(bankCard3);
            System.out.println("User subscribed successfully with InvestmentBank card: " + bankCard3.getNumber());
         } else {
            System.out.println("User is not payable and cannot receive a bank card.");
         }

         System.out.println("----------------------------------------");
         System.out.println("Displaying all subscriptions and users...");

         if (bankCard1 != null) {
            var subscription1 = bankService.getSubscriptionByBankCardNumber(bankCard1.getNumber());
            subscription1.ifPresentOrElse(
                  sub -> System.out.println("Retrieved Subscription for user1: " + sub),
                  () -> System.out.println("Subscription for user1 not found.")
            );
         }

         if (bankCard2 != null) {
            var subscription2 = bankService.getSubscriptionByBankCardNumber(bankCard2.getNumber());
            subscription2.ifPresentOrElse(
                  sub -> System.out.println("Retrieved Subscription for user2: " + sub),
                  () -> System.out.println("Subscription for user2 not found.")
            );
         }

         if (bankCard3 != null) {
            var subscription3 = bankService.getSubscriptionByBankCardNumber(bankCard3.getNumber());
            subscription3.ifPresentOrElse(
                  sub -> System.out.println("Retrieved Subscription for user3: " + sub),
                  () -> System.out.println("Subscription for user3 not found.")
            );
         }

         System.out.println("----------------------------------------");
         var users = bankService.getAllUsers();
         System.out.println("All users in the system:");
         users.forEach(System.out::println);

         System.out.println("----------------------------------------");
         System.out.println("Calculating average age of all users...");
         double averageAge = bankService.getAverageUsersAge();
         System.out.println("The average age of all users is: " + averageAge);
      }
   }
}
