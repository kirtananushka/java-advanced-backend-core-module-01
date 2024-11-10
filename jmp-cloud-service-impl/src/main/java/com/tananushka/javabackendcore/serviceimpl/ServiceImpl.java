package com.tananushka.javabackendcore.serviceimpl;

import com.tananushka.javabackendcore.dto.BankCard;
import com.tananushka.javabackendcore.dto.Subscription;
import com.tananushka.javabackendcore.dto.User;
import com.tananushka.javabackendcore.entity.SubscriptionEntity;
import com.tananushka.javabackendcore.serviceapi.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
      var userEntity = user.toEntity();
      userRepository.save(userEntity);
   }

   @Override
   public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
      return subscriptionRepository.findById(bankCardNumber)
            .map(Subscription::toDto);
   }

   @Override
   public List<User> getAllUsers() {
      return userRepository.findAll().stream()
            .map(User::toDto)
            .collect(Collectors.toUnmodifiableList());
   }
}
