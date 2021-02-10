package br.com.estudos.controller.documentacao

import br.com.estudos.request.DadosDestinoRequest
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import java.math.BigDecimal

interface TransferenciaContasControllerSwagger {

    @ApiOperation(
            "transferir valor",
            notes = "transferir valor",
            response = String::class
    )
    @ApiImplicitParams(
            value = [
                ApiImplicitParam(name = "cpf", required = true, paramType = "header"),
                ApiImplicitParam(name = "banco", required = true, paramType = "header"),
                ApiImplicitParam(name = "agencia", required = true, paramType = "header"),
                ApiImplicitParam(name = "conta", required = true, paramType = "header"),
            ]
    )
    fun transferir(destinoRequest: DadosDestinoRequest): ResponseEntity<String>
}