package com.tananushka.javabackendcore.utils;

import java.util.Random;

public class CardNumberGenerator {

   public static String generateCardNumber() {
      Random random = new Random();

      int group1 = 1000 + random.nextInt(9000);
      int group2 = 1000 + random.nextInt(9000);
      int group3 = 1000 + random.nextInt(9000);
      int group4 = 1000 + random.nextInt(9000);

      return String.format("%04d %04d %04d %04d", group1, group2, group3, group4);
   }
}
