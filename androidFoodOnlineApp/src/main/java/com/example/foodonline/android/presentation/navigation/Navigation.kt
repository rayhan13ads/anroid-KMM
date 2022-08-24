package com.example.foodonline.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodonline.android.presentation.recipe_detail.RecipeDetailPage
import com.example.foodonline.android.presentation.recipe_detail.RecipeDetailViewModel
import com.example.foodonline.android.presentation.recipe_list.RecipeListPage
import com.example.foodonline.android.presentation.recipe_list.RecipeListViewModel

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.RecipeList.route){
      // list page
        composable(route= Screen.RecipeList.route){ navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current,navBackStackEntry)
            val viewModel:RecipeListViewModel? = LocalViewModelStoreOwner.current?.let {
                viewModel(
                    it,"RecipeDetailViewModel", factory = factory)
            }

            RecipeListPage(navController) { recipeId ->
                navController.navigate(Screen.RecipeDetails.route + "/$recipeId")
            }
        }
        // list page
        composable(route= Screen.RecipeDetails.route + "/{recipeId}", arguments = listOf(navArgument("recipeId"){
            type = NavType.IntType
        })){ navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current,navBackStackEntry)
            val viewModel:RecipeDetailViewModel? = LocalViewModelStoreOwner.current?.let {
                viewModel(
                    it,"RecipeDetailViewModel", factory = factory)
            }
            viewModel?.let { it.recipeId.value?.let { it1 -> RecipeDetailPage(recipeId = it1) } }
        }
    }
}
