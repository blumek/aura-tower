import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./views/home/home.component";
import { AccesDeniedComponent } from "./views/utility/acces-denied/acces-denied.component";
import { NotFoundComponent } from "./views/utility/not-found/not-found.component";

const routes: Routes = [
    // {
    //     path: '',
    //     component: HomeComponent
    // },
    { path: "", redirectTo: "base", pathMatch: 'full'},
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
    {
        path: 'access-denied',
        component: AccesDeniedComponent
    },
    {
        path: '**',
        component: NotFoundComponent
    },
    
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }