import { RouterModule, Routes } from "@angular/router";
import { BaseComponent } from "./base.component";
import { NgModule } from "@angular/core";
import { IntroComponent } from "./intro/intro.component";
import { authGuard } from "../../shared/guards/auth.guard";
import { HeadquartersComponent } from "./headquarters/headquarters.component";
import { SettingsComponent } from "./settings/settings.component";

const operatorRoutes: Routes = [
    {
        path: '',
        component: BaseComponent,
        children: [
            { path: "", redirectTo: "headquarters", pathMatch: 'full'},
            {
                path: 'headquarters',
                component: HeadquartersComponent,
                canActivate: [authGuard]
            },
            { 
                path: 'intro',
                component: IntroComponent,
                canActivate: [authGuard]    
            },
            { 
                path: 'settings',
                component: SettingsComponent,
                canActivate: [authGuard]
            }
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(operatorRoutes)],
    exports: [RouterModule],
})
export class BaseRoutingModule {}