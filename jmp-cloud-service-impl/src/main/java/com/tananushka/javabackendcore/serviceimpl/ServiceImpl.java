package com.tananushka.javabackendcore.serviceimpl;

import com.tananushka.javabackendcore.dto.BankCard;
import com.tananushka.javabackendcore.dto.Subscription;
import com.tananushka.javabackendcore.dto.User;
import com.tananushka.javabackendcore.entity.SubscriptionEntity;
import com.tananushka.javabackendcore.entity.UserEntity;
import com.tananushka.javabackendcore.serviceapi.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements BankService {
   private final SubscriptionRepository subscriptionRepository;
   private final UserRepository userRepository;

   @Override
   public void subscribe(BankCard bankCard) {
      var subscriptionEntity = new SubscriptionEntity(
            bankCard.getNumber(),
            LocalDate.now()
      );
      subscriptionRepository.save(subscriptionEntity);

      var user = bankCard.getUser();
      var userEntity = new UserEntity(user.name(), user.surname(), user.birthday());
      userRepository.save(userEntity);
   }

   @Override
   public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
      return subscriptionRepository.findById(bankCardNumber)
            .map(entity -> new Subscription(entity.getBankcardNumber(), entity.getStartDate()));
   }

   @Override
   public List<User> getAllUsers() {
      return userRepository.findAll().stream()
            .map(entity -> new User(entity.getName(), entity.getSurname(), entity.getBirthday()))
            .toList();
   }
}
