import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AuthComponent } from "./auth.component";
import { SignInComponent } from "./sign-in/sign-in.component";
import { SignUpComponent } from "./sign-up/sign-up.component";
import { ForgotPassComponent } from "./forgot-pass/forgot-pass.component";
import { ResetPassComponent } from "./reset-pass/reset-pass.component";


const operatorRoutes: Routes = [
    {
        path: '',
        component: AuthComponent,
        children: [
            { path: "", redirectTo: "sign-in", pathMatch: 'full'},
            { 
                path: 'sign-in',
                component: SignInComponent
            },
            { 
                path: 'sign-up',
                component: SignUpComponent
            },
            { 
                path: 'sign-up',
                component: SignUpComponent
            },
            { 
                path: 'forgot-pass',
                component: ForgotPassComponent
            },
            {
                path: 'reset-pass',
                component: ResetPassComponent
            }
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(operatorRoutes)],
    exports: [RouterModule],
})
export class AuthRoutingModule {}