package com.example.springevent.admin.application;

import com.example.springevent.user.event.UserCouponEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class UserCouponEventListener {

    /**
     * AFTER_COMMIT (기본값) - 트랜잭션이 성공적으로 마무리(commit)됐을 때 이벤트 실행
     * AFTER_ROLLBACK – 트랜잭션이 rollback 됐을 때 이벤트 실행
     * AFTER_COMPLETION – 트랜잭션이 마무리 됐을 때(commit or rollback) 이벤트 실행
     * BEFORE_COMMIT - 트랜잭션의 커밋 전에 이벤트 실행
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onApplicationEvent(UserCouponEvent event) {
        log.info("쿠폰 등록 완료 : {}", event.getEmail());
    }
}
