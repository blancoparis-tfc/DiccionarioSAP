package org.dbp.diccionarioSap.repository

import org.dbp.diccionarioSap.bom.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
internal interface UsuarioRepository : JpaRepository<Usuario, String>