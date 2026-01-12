package br.com.fiap.receitasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.receitasapp.data.local.dao.ReceitaDao
import br.com.fiap.receitasapp.data.local.database.AppDatabase
import br.com.fiap.receitasapp.data.remote.api.ReceitaApi
import br.com.fiap.receitasapp.data.remote.api.RetrofitClient
import br.com.fiap.receitasapp.data.remote.dto.ReceitaDto
import br.com.fiap.receitasapp.data.repository.ReceitaRepository
import br.com.fiap.receitasapp.ui.receita.ReceitaListScreen
import br.com.fiap.receitasapp.ui.receita.ReceitaViewModel
import br.com.fiap.receitasapp.ui.receita.ReceitaViewModelFactory
import br.com.fiap.receitasapp.ui.theme.ReceitasAppTheme

class MainActivity : ComponentActivity() {

//    val api = RetrofitClient().getReceitaApi()
//    val dao = AppDatabase.getDatabase(this).receitaDao()
//    val repository = ReceitaRepository(api, dao)

    private val api by lazy {
        RetrofitClient().getReceitaApi()
    }

    private val dao by lazy {
        AppDatabase.getDatabase(applicationContext).receitaDao()
    }

    private val repository by lazy {
        ReceitaRepository(api, dao)
    }

    private val viewModel: ReceitaViewModel by viewModels {
        ReceitaViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReceitasAppTheme {
                ReceitaListScreen(viewModel)
            }
        }
    }
}