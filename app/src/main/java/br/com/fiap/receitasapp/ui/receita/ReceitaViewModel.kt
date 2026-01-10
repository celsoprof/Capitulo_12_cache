package br.com.fiap.receitasapp.ui.receita

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.receitasapp.data.repository.ReceitaRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ReceitaViewModel(
    private val repository: ReceitaRepository
): ViewModel() {

    val receitas = repository.receitas.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(
            stopTimeoutMillis = 5_000
        ),
        initialValue = emptyList()
    )

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            repository.atualizarReceitas()
        }
    }

}