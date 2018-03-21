package org.dbp.diccionarioSap.core


interface GenenricEntity<T>{
    fun toDto(): T
}

interface GenericFromEntity<D,E>{
    fun fromDto(dto: D):E
}