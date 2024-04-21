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
    {
        path: 'auth',
        loadChildren: () => import('./views/auth/auth.module').then(m => m.AuthModule),
    },
    {
        path: 'base',
        loadChildren: () => import('./views/base/base.module').then(m => m.BaseModule),
    },
    
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }