package org.dbp.diccionarioSap.controller

import org.dbp.diccionarioSap.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
internal class UsuarioController(
) {

    @GetMapping("/")
    fun principal(principal: Principal): String {
        return "Usuario ${principal.name} ";
    }

    data class DetalleUsuario(val usuario:String)

    @GetMapping("/detalle")
    fun detalle(principal: Principal):DetalleUsuario{
        return DetalleUsuario(principal.name)
    }
}