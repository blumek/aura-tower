import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { MainViewComponent } from "./main-view.component";


const operatorRoutes: Routes = [
    {
        path: '',
        component: MainViewComponent,
        children: []
    },
];

@NgModule({
    imports: [RouterModule.forChild(operatorRoutes)],
    exports: [RouterModule],
})
export class MainViewRoutingModule {}