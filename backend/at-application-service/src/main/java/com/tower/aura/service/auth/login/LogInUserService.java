package com.tower.aura.service.auth.login;

import com.tower.aura.api.auth.LogInUserReply;
import com.tower.aura.api.auth.LogInUserRequest;
import com.tower.aura.api.auth.LogInUserUseCase;
import org.springframework.stereotype.Service;

@Service
public class LogInUserService implements LogInUserUseCase {
    @Override
    public LogInUserReply logIn(LogInUserRequest logInUserRequest) {
        return null;
    }
}
