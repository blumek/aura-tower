import { FormControl } from "@angular/forms";

export interface SignInForm {
    userName: FormControl<string | null>;
    password: FormControl<string | null>;
}

export interface signInFormRaw {
    userName: string | null;
    password: string | null;
}

export interface SignUpForm {
    userName: FormControl<string | null>;
    password: FormControl<string | null>;
    confirmPassword: FormControl<string | null>;
    auxiliaryQuestion: FormControl<string | null>;
    auxiliaryAnswer: FormControl<string | null>;
}

export interface SignUpFormRaw {
    userName: string | null;
    password: string | null;
    confirmPassword: string | null;
    auxiliaryQuestion: string | null;
    auxiliaryAnswer: string | null;
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