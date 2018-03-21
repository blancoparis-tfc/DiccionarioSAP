package org.dbp.diccionarioSap.service

import org.dbp.diccionarioSap.bom.dto.UsuarioDto
import org.dbp.diccionarioSap.bom.entity.GenenricEntity
import org.dbp.diccionarioSap.bom.entity.GenericFromEntity
import org.dbp.diccionarioSap.bom.entity.Usuario
import org.dbp.diccionarioSap.repository.UsuarioRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional
interface GenericService<T: GenenricEntity<DTO>,ID,DTO>{
    fun getOne(id: ID): DTO
    fun findById(id: ID): Optional<DTO>
    fun save(entity: DTO): T
    fun findAll(): Iterable<DTO>
    fun deleteById(id: ID)
    fun delete(entity: T)


}

internal open class GenericServiceImpl<T: GenenricEntity<DTO>,ID,DTO>(val repository:JpaRepository<T,ID>, val fromDto: GenericFromEntity<DTO, T>):GenericService<T,ID,DTO>{
    override fun findAll(): Iterable<DTO> =  repository.findAll().map { it.toDto() }
    override fun findById(id: ID): Optional<DTO> = repository.findById(id).map { it.toDto() }
    override fun save(entity: DTO): T = repository.save(fromDto.fromDto(entity))
    override fun getOne(id: ID): DTO = repository.getOne(id).toDto()
    override fun deleteById(id: ID)=repository.deleteById(id);
    override fun delete(entity: T)= repository.delete(entity)
}

internal interface UsuarioService:GenericService<Usuario,String, UsuarioDto> {

}
@Service
@Transactional
internal class UsuarioServiceJpaImpl (
        @Autowired val usuarioRepository:UsuarioRepository
        , fromOfDto:GenericFromEntity<UsuarioDto,Usuario> = object: GenericFromEntity<UsuarioDto,Usuario>  {
            override fun fromDto(dto: UsuarioDto)= Usuario.fromDto(dto)
        }   )
    :UsuarioService,
        GenericServiceImpl<Usuario, String, UsuarioDto>(
                usuarioRepository
                ,fromOfDto) {
    val fromOfDto = fromOfDto
    val logger = LoggerFactory.getLogger(UsuarioServiceJpaImpl::class.java)

}