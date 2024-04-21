import { RouterModule, Routes } from "@angular/router";
import { BaseComponent } from "./base.component";
import { NgModule } from "@angular/core";

const operatorRoutes: Routes = [
    {
        path: '',
        component: BaseComponent,
        children: [
            { path: "", redirectTo: "center", pathMatch: 'full'},
            // { 
            //     path: 'center',
            //     component: CenterComponent
            // },

        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(operatorRoutes)],
    exports: [RouterModule],
})
export class BaseRoutingModule {}