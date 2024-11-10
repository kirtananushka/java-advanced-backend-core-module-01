package com.tananushka.javabackendcore.dto;

import java.time.LocalDate;

public record Subscription(String bankcardNumber, LocalDate startDate) {
}
