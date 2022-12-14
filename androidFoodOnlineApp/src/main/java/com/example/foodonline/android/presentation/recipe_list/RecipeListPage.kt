package com.example.foodonline.android.presentation.recipe_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable

fun RecipeListPage(navController: NavController ,onSelectedRecipe: (Int)-> Unit){

    LazyColumn {
        items(count = 100) { recipeId ->
            Row( modifier = Modifier.fillMaxWidth()
                .clickable {
                    onSelectedRecipe(recipeId)
                }
            ) {
                 Text("$recipeId")
            }
        }
    }
}