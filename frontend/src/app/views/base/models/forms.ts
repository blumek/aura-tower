import { FormControl } from "@angular/forms";
import { ResetPassForm } from "../../auth/models/forms";

export interface CommandCenterForm {
    centerIcon: FormControl<string | null>;
    centerName: FormControl<string | null>;
}

export interface AccountDetailsForm {
    userName: FormControl<string | null>
    auxiliaryQuestion: FormControl<string | null>,
    auxiliaryAnswer: FormControl<string | null>,
}

export interface ChangePassForm extends ResetPassForm {
    oldPassword: FormControl<string | null>;
}