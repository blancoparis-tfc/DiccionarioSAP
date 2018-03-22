package org.dbp.diccionarioSap.controller

import org.dbp.diccionarioSap.bom.dto.UsuarioDto
import org.dbp.diccionarioSap.bom.entity.Usuario
import org.dbp.diccionarioSap.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.dbp.diccionarioSap.core.GenericFromEntity
import org.dbp.diccionarioSap.core.GenericRest
import org.springframework.web.bind.annotation.*

@RequestMapping("/usuario")
@RestController
internal class UsuarioController(
        @Autowired val usuarioService:UsuarioService
        ,fromOfDto:GenericFromEntity<UsuarioDto, Usuario> = object: GenericFromEntity<UsuarioDto, Usuario>  {
            override fun fromDto(dto: UsuarioDto)= Usuario.fromDto(dto)
        }
    ): GenericRest<Usuario, String, UsuarioDto>(usuarioService,fromOfDto){

}

