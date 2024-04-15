package com.tower.aura.rest.web.adapter.controller.authentication;

import com.tower.aura.api.authentication.*;
import com.tower.aura.rest.web.adapter.controller.authentication.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/authentications")
public class AuthenticationController {
    private final RegisterUserUseCase registerUserUseCase;
    private final LogInUserUseCase logInUserUseCase;
    private final RefreshTokenUseCase refreshTokenUseCase;
    private final ChangePasswordUseCase changePasswordUseCase;
    private final ChangeReminderQuestionUseCase changeReminderQuestionUseCase;

    public AuthenticationController(RegisterUserUseCase registerUserUseCase,
                                    LogInUserUseCase logInUserUseCase,
                                    RefreshTokenUseCase refreshTokenUseCase,
                                    ChangePasswordUseCase changePasswordUseCase,
                                    ChangeReminderQuestionUseCase changeReminderQuestionUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.logInUserUseCase = logInUserUseCase;
        this.refreshTokenUseCase = refreshTokenUseCase;
        this.changePasswordUseCase = changePasswordUseCase;
        this.changeReminderQuestionUseCase = changeReminderQuestionUseCase;
    }

    @PostMapping("/credentials")
    public ResponseEntity<RestWebRegisterResponse> register(@RequestBody RestWebRegisterRequest registerRequest) {
        final var registerUserReply = registerUserUseCase.register(registerRequest.toRegisterUserRequest());
        return ok().body(RestWebRegisterResponse.fromApiUserIdentifier(registerUserReply.userIdentifier()));
    }

    @PostMapping("/tokens")
    public ResponseEntity<RestWebJsonWebTokenPairResponse> logIn(@RequestBody RestWebLogInRequest logInRequest) {
        final var jsonWebTokenPair = logInUserUseCase.logIn(logInRequest.toLogInUserRequest());
        return ok().body(RestWebJsonWebTokenPairResponse.fromApiJsonWebTokenPair(jsonWebTokenPair.tokenPair()));
    }

    @PostMapping("/refreshed-tokens")
    public ResponseEntity<RestWebJsonWebTokenPairResponse> refreshToken(@RequestBody RestWebRefreshTokenRequest refreshTokenRequest) {
        final var jsonWebTokenPair = refreshTokenUseCase.refresh(refreshTokenRequest.toRefreshTokenRequest());
        return ok().body(RestWebJsonWebTokenPairResponse.fromApiJsonWebTokenPair(jsonWebTokenPair.tokenPair()));
    }

    @PutMapping("/credentials/{userIdentifier}/passwords")
    public ResponseEntity<?> changePassword(@PathVariable String userIdentifier,
                                            @RequestBody RestWebChangePasswordRequest changePasswordRequest) {
        changePasswordUseCase.change(changePasswordRequest.toChangePasswordRequestWithUserIdentifier(userIdentifier));
        return ok().build();
    }

    @PutMapping("/credentials/{userIdentifier}/reminder-questions")
    public ResponseEntity<?> changeReminderQuestion(@PathVariable String userIdentifier,
                                                    @RequestBody RestWebChangeReminderQuestionRequest changeReminderQuestionRequest) {
        changeReminderQuestionUseCase.change(changeReminderQuestionRequest.toChangeReminderQuestionRequestWithUserIdentifier(userIdentifier));
        return ok().build();
    }
}
