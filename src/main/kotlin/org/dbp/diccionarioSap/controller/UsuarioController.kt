package org.dbp.diccionarioSap.controller

import org.dbp.diccionarioSap.bom.dto.UsuarioDto
import org.dbp.diccionarioSap.repository.UsuarioRepository
import org.dbp.diccionarioSap.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
internal class UsuarioController(@Autowired val usuarioService:UsuarioService){

    @GetMapping("/")
    fun principal(principal: Principal): String {
        usuarioService.save(UsuarioDto(principal.name,"David Blanco"))
        return "Usuario ${principal.name} ";
    }

    data class DetalleUsuario(val usuario:String)

    @GetMapping("/detalle")
    fun detalle(principal: Principal):DetalleUsuario{
        return DetalleUsuario(principal.name)
    }
}