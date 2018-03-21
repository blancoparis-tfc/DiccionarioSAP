package org.dbp.diccionarioSap.bom.entity

import org.dbp.diccionarioSap.bom.dto.UsuarioDto
import javax.persistence.Entity
import javax.persistence.Id

interface GenenricEntity<T>{
    fun toDto(): T
}

interface GenericFromEntity<D,E>{
    fun fromDto(dto: D):E
}

@Entity
internal data class Usuario(
        @Id val id:String
        ,val nombre:String) : GenenricEntity<UsuarioDto> {
    override fun toDto(): UsuarioDto = UsuarioDto(id,nombre)
    companion object : GenericFromEntity<UsuarioDto,Usuario> {
        override fun fromDto(dto: UsuarioDto) = Usuario(dto.id,dto.nombre)
    }
}