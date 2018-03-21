package org.dbp.diccionarioSap.core

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GenericService<T: GenenricEntity<DTO>,ID,DTO>{
    fun getOne(id: ID): DTO
    fun findById(id: ID): Optional<DTO>
    fun save(entity: DTO): T
    fun findAll(): Iterable<DTO>
    fun deleteById(id: ID)
    fun delete(entity: T)


}

internal open class GenericServiceImpl<T: GenenricEntity<DTO>,ID,DTO>(val repository: JpaRepository<T, ID>, val fromDto: GenericFromEntity<DTO, T>):GenericService<T,ID,DTO>{
    override fun findAll(): Iterable<DTO> =  repository.findAll().map { it.toDto() }
    override fun findById(id: ID): Optional<DTO> = repository.findById(id).map { it.toDto() }
    override fun save(entity: DTO): T = repository.save(fromDto.fromDto(entity))
    override fun getOne(id: ID): DTO = repository.getOne(id).toDto()
    override fun deleteById(id: ID)=repository.deleteById(id);
    override fun delete(entity: T)= repository.delete(entity)
}