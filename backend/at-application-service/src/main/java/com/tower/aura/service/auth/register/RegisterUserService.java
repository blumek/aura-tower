package com.tower.aura.service.auth.register;

import com.tower.aura.api.auth.register.RegisterUserReply;
import com.tower.aura.api.auth.register.RegisterUserRequest;
import com.tower.aura.api.auth.register.RegisterUserUseCase;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterUserUseCase {
    @Override
    public RegisterUserReply register(RegisterUserRequest registerUserRequest) {
        return null;
    }
}
