import { FormControl } from "@angular/forms";

export interface CommandCenterForm {
    centerIcon: FormControl<string | null>;
    centerName: FormControl<string | null>;
}