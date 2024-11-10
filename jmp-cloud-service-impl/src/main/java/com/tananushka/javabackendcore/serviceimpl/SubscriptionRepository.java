package com.tananushka.javabackendcore.serviceimpl;

import com.tananushka.javabackendcore.entity.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, String> {
}
