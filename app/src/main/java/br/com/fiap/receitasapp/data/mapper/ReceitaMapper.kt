package br.com.fiap.receitasapp.data.mapper

import br.com.fiap.receitasapp.data.local.entity.ReceitaEntity
import br.com.fiap.receitasapp.data.remote.dto.ReceitaDto

fun ReceitaDto.toEntity() = ReceitaEntity(
    id = id,
    title = title,
    description = description,
    url = url
)