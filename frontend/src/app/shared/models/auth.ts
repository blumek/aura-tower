import { FormControl } from "@angular/forms";

export interface signInForm {
    userName: FormControl<string>;
    password: FormControl<string>;
}

export interface signUpForm {
    userName: FormControl<string>;
    password: FormControl<string>;
    confirmPassword: FormControl<string>;
    auxiliaryQuestion: FormControl<string>;
    auxiliaryAnswer: FormControl<string>;
}