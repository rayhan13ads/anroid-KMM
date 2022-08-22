package com.example.foodonline.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodonline.android.presentation.recipe_detail.RecipeDetailPage
import com.example.foodonline.android.presentation.recipe_list.RecipeListPage

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.RecipeList.route){
      // list page
        composable(route= Screen.RecipeList.route){ navBackStackEntry ->
            RecipeListPage { recipeId ->
                navController.navigate(Screen.RecipeDetails.route + "/$recipeId")
            }
        }
        // list page
        composable(route= Screen.RecipeDetails.route + "/{recipeId}", arguments = listOf(navArgument("recipeId"){
            type = NavType.IntType
        })){ navBackStackEntry ->
            navBackStackEntry.arguments?.getInt("recipeId")?.let { RecipeDetailPage(recipeId = it) }
        }
    }
}
