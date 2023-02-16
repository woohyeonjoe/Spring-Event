package com.example.springevent.sender.application;

import com.example.springevent.user.event.UserSenderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SenderEventListener {

    @EventListener
    @Async
    public void handleEmail(UserSenderEvent event) {
        log.info("환영 이메일 발송 성공 : {}", event.getEmail());
    }

    @EventListener
    @Async
    public void handleSMS(UserSenderEvent event) {
        log.info("환영 SMS 발송 성공 : {}", event.getPhoneNumber());
    }
}
