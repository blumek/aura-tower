import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { MainViewComponent } from "./main-view.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { SettingsComponent } from "./settings/settings.component";


const operatorRoutes: Routes = [
    {
        path: '',
        component: MainViewComponent,
        children: [
            { path: "", redirectTo: "dashboard", pathMatch: 'full'},
            { 
                path: 'dashboard',
                component: DashboardComponent
            },
            { 
                path: 'settings',
                component: SettingsComponent
            }
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(operatorRoutes)],
    exports: [RouterModule],
})
export class MainViewRoutingModule {}