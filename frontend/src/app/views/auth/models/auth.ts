export interface SignUp {
    username: string;
    password: string;
    reminderQuestionId: string;
    reminderQuestionAnswer: string;
}

export interface SignUpResponse {
    userIdentifier: string
}

export interface SignIn {
    username: string;
    password: string
}

export interface Token {
    accessToken: string,
    refreshToken: string
}

