import { FormControl } from "@angular/forms";

export interface signInForm {
    userName: FormControl<string>;
    password: FormControl<string>;
}

export interface signUpForm {
    userName: FormControl<string | null>;
    password: FormControl<string | null>;
    confirmPassword: FormControl<string | null>;
    auxiliaryQuestion: FormControl<string | null>;
    auxiliaryAnswer: FormControl<string | null>;
}