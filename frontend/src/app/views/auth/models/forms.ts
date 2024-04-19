import { FormControl } from "@angular/forms";

export interface SignInForm {
    userName: FormControl<string>;
    password: FormControl<string>;
}

export interface SignUpForm {
    userName: FormControl<string | null>;
    password: FormControl<string | null>;
    confirmPassword: FormControl<string | null>;
    auxiliaryQuestion: FormControl<string | null>;
    auxiliaryAnswer: FormControl<string | null>;
}

export interface ForgotPassForm {
    userName: FormControl<string | null>;
    auxiliaryQuestion: FormControl<string | null>;
    auxiliaryAnswer: FormControl<string | null>;
}

export interface ResetPassForm {
    password: FormControl<string | null>;
    confirmPassword: FormControl<string | null>;
}