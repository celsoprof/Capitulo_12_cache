package br.com.fiap.receitasapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.fiap.receitasapp.data.local.entity.ReceitaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReceitaDao {

    // Listar todas as receitas do banco de dados local
    @Query("SELECT * FROM receitas")
    fun getReceitas(): Flow<List<ReceitaEntity>>

    // Cadastrar todas as receitas obtidas na API
    // no banco de dados local
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(receitas: List<ReceitaEntity>)

    // Apagar todas as receitas do banco de dados local
    @Query("DELETE FROM receitas")
    suspend fun clear()

}