package com.example.springevent.user.application;

import com.example.springevent.admin.application.AdminService;
import com.example.springevent.admin.application.CouponService;
import com.example.springevent.sender.application.SenderService;
import com.example.springevent.user.domain.User;
import com.example.springevent.user.repository.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    public UserService(UserRepository userRepository, ApplicationEventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    public void create(UserRequest userRequest) {
        User user = new User(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getPhoneNumber()
        );
        userRepository.save(user);
        user.registerEventPublish(eventPublisher);
    }

    public UserResponse get(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(""));

        return new UserResponse(
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber()
        );
    }
}
