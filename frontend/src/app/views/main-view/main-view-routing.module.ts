import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { MainViewComponent } from "./main-view.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { authGuard } from "../../shared/guards/auth.guard";


const operatorRoutes: Routes = [
    {
        path: '',
        component: MainViewComponent,
        children: [
            { path: "", redirectTo: "dashboard", pathMatch: 'full'},
            { 
                path: 'dashboard/:id',
                component: DashboardComponent,
                canActivate: [authGuard]
            },
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(operatorRoutes)],
    exports: [RouterModule],
})
export class MainViewRoutingModule {}