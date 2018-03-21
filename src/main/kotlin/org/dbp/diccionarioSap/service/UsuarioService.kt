package org.dbp.diccionarioSap.service

import org.dbp.diccionarioSap.bom.dto.UsuarioDto
import org.dbp.diccionarioSap.bom.entity.Usuario
import org.dbp.diccionarioSap.core.GenericFromEntity
import org.dbp.diccionarioSap.core.GenericService
import org.dbp.diccionarioSap.core.GenericServiceImpl
import org.dbp.diccionarioSap.repository.UsuarioRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional


internal interface UsuarioService: GenericService<Usuario, String, UsuarioDto> {

}
@Service
@Transactional
internal class UsuarioServiceJpaImpl (
        @Autowired val usuarioRepository:UsuarioRepository
        , fromOfDto:GenericFromEntity<UsuarioDto,Usuario> = object: GenericFromEntity<UsuarioDto,Usuario>  {
            override fun fromDto(dto: UsuarioDto)= Usuario.fromDto(dto)
        }   )
    :UsuarioService,
        GenericServiceImpl<Usuario, String, UsuarioDto>(
                usuarioRepository
                ,fromOfDto) {
    val fromOfDto = fromOfDto
    val logger = LoggerFactory.getLogger(UsuarioServiceJpaImpl::class.java)

}