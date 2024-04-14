import { FormControl } from "@angular/forms";

export interface signInForm {
    userName: FormControl<string>;
    password: FormControl<string>;
}