package org.dbp.diccionarioSap.core

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GenericService<T: GenenricEntity<DTO>,ID,DTO>{
    fun getOne(id: ID): T
    fun findById(id: ID): Optional<T>
    fun save(entity: T): T
    fun findAll(): Iterable<T>
    fun deleteById(id: ID)
    fun delete(entity: T)
    fun update( id:ID,entity: T):T
}

internal open class GenericServiceImpl<T: GenenricEntity<DTO>,ID,DTO>(val repository: JpaRepository<T, ID>, val fromDto: GenericFromEntity<DTO, T>):GenericService<T,ID,DTO>{
    override fun findAll() =  repository.findAll()
    override fun findById(id: ID) = repository.findById(id)
    override fun save(entity: T) = repository.save(entity)
    override fun getOne(id: ID) = repository.getOne(id)
    override fun deleteById(id: ID)=repository.deleteById(id)
    override fun delete(entity: T)= repository.delete(entity)
    override fun update( id:ID,entity: T)=repository.save(repository.findById(id).orElseThrow{ Exception("ID ${id} not found") }.apply{entity})
}