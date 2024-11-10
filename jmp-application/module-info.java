module jmp.application {
   requires jmp.dto;
   requires jmp.bank.api;
   requires jmp.service.api;
   requires jmp.cloud.bank.impl;
   requires jmp.cloud.service.impl;

   uses com.tananushka.javabackendcore.bankapi.Bank;
   uses com.tananushka.javabackendcore.serviceapi.BankService;
}
