package com.example.androidmidterm1.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.androidmidterm1.R

val horrorGames = listOf(
    HorrorGame(
        "Resident Evil",
        R.drawable.re,
        "Легендарный хоррор-экшен от Capcom, где игрокам предстоит выживать в условиях зомби-апокалипсиса, разгадывать тайны корпорации Umbrella и бороться с ужасающими биологическими созданиями. Тактический геймплей, ограниченные ресурсы и напряженная атмосфера делают игру культовой в жанре survival horror."
    ),
    HorrorGame(
        "Silent Hill",
        R.drawable.silent_hill,
        "Мистический психологический хоррор от Konami, в котором игрок попадает в жуткий туманный город, наполненный кошмарами, монстрами и личными страхами. Сюжетные повороты, символизм и мрачная атмосфера делают игру одной из самых запоминающихся в жанре."
    ),
    HorrorGame(
        "Outlast",
        R.drawable.outlast,
        "Выживание в психиатрической больнице, полной ужасающих пациентов и смертельно опасных тайн. Главный герой — журналист, вооруженный лишь камерой с ночным видением, вынужден скрываться от маньяков и раскрывать зловещие эксперименты, проводимые в учреждении."
    ),
    HorrorGame(
        "Dead Space",
        R.drawable.dead_space,
        "Космический хоррор, в котором игроки оказываются на заброшенном космическом корабле, зараженном жуткими некроморфами. Игроку предстоит использовать инженерные инструменты для выживания, разгадывать страшные тайны экипажа и сражаться с кошмарными мутантами."
    )
)

data class HorrorGame(val title: String, val image: Int, val description: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameListScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF121212), Color(0xFF000000))))
    ) {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text("Лучшие хоррор-игры", color = Color.White, fontSize = 22.sp)
                }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF1C1C1C)))
            },
            containerColor = Color.Transparent
        ) { padding ->
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 160.dp),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.padding(padding)
            ) {
                items(horrorGames) { game ->
                    GameCard(game, navController)
                }
            }
        }
    }
}

@Composable
fun GameCard(game: HorrorGame, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { navController.navigate("gameDetail/${game.title}") },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF222222)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = game.image),
                contentDescription = game.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
            )
            Text(
                text = game.title,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
