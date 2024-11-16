module jmp.cloud.service.impl {
   requires transitive jmp.service.api;
   requires jmp.dto;
   requires spring.context;
   requires spring.data.jpa;
   requires spring.boot.autoconfigure;
   requires java.sql;

   exports com.tananushka.javabackendcore.serviceimpl;

   provides com.tananushka.javabackendcore.serviceapi.Service with com.tananushka.javabackendcore.serviceimpl.ServiceImpl;
}
