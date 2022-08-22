package com.example.foodonline.android.presentation.recipe_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RecipeDetailPage(recipeId:Int){
    Column {
        Text("Recipe product Id : $recipeId")
    }
}