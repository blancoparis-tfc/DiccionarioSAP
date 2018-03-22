package org.dbp.diccionarioSap.core

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

internal open class GenericRest<T: GenenricEntity<DTO>,ID,DTO> (val service:GenericService<T,ID,DTO>, val fromDto: GenericFromEntity<DTO, T>) {
    @PostMapping
    fun save(entity: DTO) = ResponseEntity.ok().body(service.save(fromDto.fromDto(entity)).toDto())

    @GetMapping("/{id}")
    fun get(@PathVariable id: ID) = ResponseEntity.ok().body(service.getOne(id).toDto());

    @GetMapping
    fun list() = ResponseEntity.ok().body(service.findAll().map { it.toDto() });

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: ID): ResponseEntity<String> {
        service.deleteById(id)
        return ResponseEntity.ok().body("Registro eliminado correctamente");
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: ID,entity: DTO): ResponseEntity<String> {
        service.update(id, fromDto.fromDto(entity));
        return ResponseEntity.ok().body("Actualizado correctamente")
    }

}