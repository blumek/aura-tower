import { RouterModule, Routes } from "@angular/router";
import { BaseComponent } from "./base.component";
import { NgModule } from "@angular/core";
import { IntroComponent } from "./intro/intro.component";

const operatorRoutes: Routes = [
    {
        path: '',
        component: BaseComponent,
        children: [
            { path: "", redirectTo: "intro", pathMatch: 'full'},
            { 
                path: 'intro',
                component: IntroComponent
            },
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(operatorRoutes)],
    exports: [RouterModule],
})
export class BaseRoutingModule {}