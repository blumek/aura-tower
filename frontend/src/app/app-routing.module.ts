import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./views/home/home.component";

const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'main',
        loadChildren: () => import('./views/main-view/main-view.module').then(m => m.MainViewModule),
    },
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }