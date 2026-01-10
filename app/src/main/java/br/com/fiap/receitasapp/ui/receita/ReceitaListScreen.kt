package br.com.fiap.receitasapp.ui.receita

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.receitasapp.data.local.entity.ReceitaEntity
import br.com.fiap.receitasapp.ui.theme.ReceitasAppTheme
import coil3.compose.AsyncImage

//import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceitaListScreen(viewModel: ReceitaViewModel) {

    val receitas by viewModel.receitas.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Receitas") },
                actions = {
                    TextButton(onClick = viewModel::refresh) {
                        Text("Atualizar")
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(receitas) { receita ->
                ReceitaItem(receita)
            }
        }
    }
}

@Composable
fun ReceitaItem(receita: ReceitaEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            //.height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = receita.url,
                contentDescription = receita.title,
                modifier = Modifier
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(3f)
            ) {
                Text(
                    text = receita.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = receita.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Preview
@Composable
private fun ReceitaItemPreview() {
    ReceitasAppTheme() {
        ReceitaItem(
            ReceitaEntity(
                id = 1,
                title = "Receita 1",
                description = "Descrição da receita",
                url = "http://10.0.2.2:8080/api/recipes/images/torta_de_frango.jpg")
        )
    }
}