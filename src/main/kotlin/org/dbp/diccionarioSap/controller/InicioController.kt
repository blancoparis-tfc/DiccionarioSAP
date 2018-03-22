package org.dbp.diccionarioSap.controller

import org.dbp.diccionarioSap.bom.entity.Usuario
import org.dbp.diccionarioSap.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
internal class InicioController(        @Autowired val usuarioService: UsuarioService
){
    @GetMapping("/")
    fun principal(principal: Principal): String {
        usuarioService.save(Usuario(principal.name,"David Blanco"))
        return "Usuario ${principal.name} ";
    }

    data class DetalleUsuario(val usuario:String)

    @GetMapping("/detalle")
    fun detalle(principal: Principal):DetalleUsuario{
        return DetalleUsuario(principal.name)
    }
}