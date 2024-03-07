import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { MainViewComponent } from "./main-view.component";
import { DashboardComponent } from "./dashboard/dashboard.component";


const operatorRoutes: Routes = [
    {
        path: '',
        component: MainViewComponent,
        children: [
            { path: "", redirectTo: "dashboard", pathMatch: 'full'},
            { 
                path: 'dashboard',
                component: DashboardComponent
            }
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(operatorRoutes)],
    exports: [RouterModule],
})
export class MainViewRoutingModule {}