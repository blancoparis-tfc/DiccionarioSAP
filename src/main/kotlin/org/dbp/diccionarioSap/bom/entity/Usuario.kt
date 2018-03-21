package org.dbp.diccionarioSap.bom.entity

import org.dbp.diccionarioSap.bom.dto.UsuarioDto
import org.dbp.diccionarioSap.core.GenenricEntity
import org.dbp.diccionarioSap.core.GenericFromEntity
import javax.persistence.Entity
import javax.persistence.Id



@Entity
internal data class Usuario(
        @Id val id:String
        ,val nombre:String) : GenenricEntity<UsuarioDto> {
    override fun toDto(): UsuarioDto = UsuarioDto(id,nombre)
    companion object : GenericFromEntity<UsuarioDto, Usuario> {
        override fun fromDto(dto: UsuarioDto) = Usuario(dto.id,dto.nombre)
    }
}