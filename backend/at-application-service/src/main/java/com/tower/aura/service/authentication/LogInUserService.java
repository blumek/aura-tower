package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.LogInUserReply;
import com.tower.aura.api.authentication.LogInUserRequest;
import com.tower.aura.api.authentication.LogInUserUseCase;
import org.springframework.stereotype.Service;

@Service
class LogInUserService implements LogInUserUseCase {
    @Override
    public LogInUserReply logIn(LogInUserRequest logInUserRequest) {
        return null;
    }
}
