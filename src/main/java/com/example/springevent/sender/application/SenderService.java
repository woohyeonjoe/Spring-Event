package com.example.springevent.sender.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SenderService {

    public void sendEmail(String email) {
        log.info("환영 이메일 발송 성공 : {}", email);
    }

    public void sendSMS(String phoneNumber) {
        log.info("환영 SMS 발송 성공 : {}", phoneNumber);
    }

}
