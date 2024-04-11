package com.tower.aura.service.auth.login;

import com.tower.aura.api.auth.login.LogInUserReply;
import com.tower.aura.api.auth.login.LogInUserRequest;
import com.tower.aura.api.auth.login.LogInUserUseCase;
import org.springframework.stereotype.Service;

@Service
public class LogInUserService implements LogInUserUseCase {
    @Override
    public LogInUserReply logIn(LogInUserRequest logInUserRequest) {
        return null;
    }
}
