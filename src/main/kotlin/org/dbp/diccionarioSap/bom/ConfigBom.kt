package org.dbp.diccionarioSap.bom

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration

@Configuration
@EntityScan(basePackages = ["org.dbp.diccionarioSap.bom.entity"])
internal class ConfigBom{

}