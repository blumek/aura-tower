package com.tower.aura.service.auth.register;

import com.tower.aura.api.auth.RegisterUserReply;
import com.tower.aura.api.auth.RegisterUserRequest;
import com.tower.aura.api.auth.RegisterUserUseCase;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterUserUseCase {
    @Override
    public RegisterUserReply register(RegisterUserRequest registerUserRequest) {
        return null;
    }
}
