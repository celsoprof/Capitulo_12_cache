package br.com.fiap.receitasapp.ui.receita

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.receitasapp.data.repository.ReceitaRepository

class ReceitaViewModelFactory(
    private val repository: ReceitaRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReceitaViewModel::class.java)) {
            return ReceitaViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido")
    }
}