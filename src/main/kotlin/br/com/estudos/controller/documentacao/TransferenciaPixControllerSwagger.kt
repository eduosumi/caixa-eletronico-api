package br.com.estudos.controller.documentacao

import br.com.estudos.request.DadosPixRequest
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity

interface TransferenciaPixControllerSwagger {

    @ApiOperation(
        "Transferencia Pix",
        notes = "Transferencia Pix",
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
    fun transferir(dadosPixRequest: DadosPixRequest):ResponseEntity<String>
}