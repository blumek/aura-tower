import { FormControl } from "@angular/forms";
import { ResetPassForm } from "../../auth/models/forms";

export interface CommandCenterForm {
    centerIcon: FormControl<string | null>;
    centerName: FormControl<string | null>;
}

export interface RemindQuestionForm {
    auxiliaryQuestion: FormControl<string | null>,
    auxiliaryAnswer: FormControl<string | null>,
}

export interface ChangePassForm extends ResetPassForm {
    oldPassword: FormControl<string | null>;
}