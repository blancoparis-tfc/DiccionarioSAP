package org.dbp.diccionarioSap.bom.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
internal data class Usuario(
        @Id val id:String
        ,val nombre:String)