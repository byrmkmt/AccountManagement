package com.banking.accountmanagement.event.listener;

import com.banking.accountmanagement.event.model.AccountCreatedEvent;
import com.banking.accountmanagement.service.AccountManagementService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CreatedAccountListener {

    private final AccountManagementService userService;

    public CreatedAccountListener(AccountManagementService userService) {
        this.userService = userService;
    }

    @KafkaListener(topics = "registration-topic", groupId = "groupId", containerFactory = "kafkaListenerContainerFactory")
    public void handleUserCreated(AccountCreatedEvent message) {
        System.out.println("Received event for user: " + message.getUserId());
        userService.saveAccount(message);
    }

}
