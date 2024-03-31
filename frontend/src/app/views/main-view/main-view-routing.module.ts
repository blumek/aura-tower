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
                component: DashboardComponent,
                data: { title: 'Dashboard', icon: 'dashboard' }
            },
            { 
                path: 'settings',
                component: SettingsComponent,
                data: { title: 'Ustawienia', icon: 'settings' }
            }
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(operatorRoutes)],
    exports: [RouterModule],
})
export class MainViewRoutingModule {}