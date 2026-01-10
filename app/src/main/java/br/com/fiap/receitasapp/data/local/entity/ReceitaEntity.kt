package br.com.fiap.receitasapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "receitas")
data class ReceitaEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val url: String
)