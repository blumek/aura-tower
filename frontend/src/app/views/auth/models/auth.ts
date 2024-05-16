export interface SignUpData {
    username: string;
    password: string;
    reminderQuestionId: string;
    reminderQuestionAnswer: string;
}

export interface SignUpResponse {
    userId: string
}

export interface SignInData {
    username: string;
    password: string
}

export interface TokenResponse {
    accessToken: string,
    refreshToken: string
}

export interface ReminderQuestions {
    id: string,
    question: string
}

