package com.example.foodonline.android.presentation.navigation

sealed class Screen(val route:String) {

    object RecipeList: Screen("recipeList")

    object RecipeDetails : Screen("recipeDetails")
}