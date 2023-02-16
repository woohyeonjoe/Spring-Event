package com.example.springevent.admin.application;

import com.example.springevent.user.event.UserAdminEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AdminServiceEventListener {

    /**
     * @EventListener: 이벤트 리스너 등록
     * 매개변수에 이벤트 클래스를 정의하면 해당 이벤트가 발생했을때 수신해서 처리
     */
    @EventListener
    public void onApplicationEvent(UserAdminEvent event) {
        log.info("어드민 서비스 : {}님이 가입했습니다", event.getUsername());
    }

}
