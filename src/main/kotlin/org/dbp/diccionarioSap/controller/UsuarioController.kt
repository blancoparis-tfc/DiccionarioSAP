package org.dbp.diccionarioSap.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
internal class UsuarioController() {

    @GetMapping("/")
    fun comic(principal: Principal): String {
        return "Usuario ${principal.name} ";
    }

}