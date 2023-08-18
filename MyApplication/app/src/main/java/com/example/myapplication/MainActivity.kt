package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                App()
            }
        }
    }
}

data class Recipe(val name: String, val url: String)

@Composable
fun App() {
    val itemList = remember { mutableStateListOf<Recipe>() }
    var inputText by remember { mutableStateOf("") }
    var inputUrl by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Nombre de la receta") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = inputUrl,
            onValueChange = { inputUrl = it },
            label = { Text("URL de la receta") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (inputText.isNotBlank() && inputUrl.isNotBlank()) {
                    itemList.add(Recipe(inputText, inputUrl))
                    inputText = "" // Reiniciar el campo de entrada de nombre
                    inputUrl = "" // Reiniciar el campo de entrada de URL
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Agregar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(itemList) { recipe ->
                RecipeItem(recipe)
            }
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            CoilImage(
                url = recipe.url,
                contentDescription = "Imagen de receta",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 4.dp)
            )

            Text(text = recipe.name, fontSize = 18.sp)
        }
    }
}

@Composable
fun CoilImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    Image(
        painter =
        rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = url).apply(block = fun ImageRequest.Builder.() {
                crossfade(true)
            }).build()
        ),
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MaterialTheme {
        App()
    }
}