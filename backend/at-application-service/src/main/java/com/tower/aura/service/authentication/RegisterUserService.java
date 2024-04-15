package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.RegisterUserReply;
import com.tower.aura.api.authentication.RegisterUserRequest;
import com.tower.aura.api.authentication.RegisterUserUseCase;
import org.springframework.stereotype.Service;

@Service
class RegisterUserService implements RegisterUserUseCase {
    @Override
    public RegisterUserReply register(RegisterUserRequest registerUserRequest) {
        return null;
    }
}
