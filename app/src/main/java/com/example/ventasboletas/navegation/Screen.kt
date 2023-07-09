package com.example.ventasboletas.navegation

sealed class Screen(val route: String) {
    object ListScreen : Screen(" ListScreen")
    object ListViewModel : Screen("ListViewModel")
}