module jmp.cloud.bank.impl {
   requires transitive jmp.bank.api;
   requires jmp.dto;
   exports com.tananushka.javabackendcore.bankimpl;

   provides com.tananushka.javabackendcore.bankapi.Bank with com.tananushka.javabackendcore.bankimpl.BankImpl;
}
