package br.com.estudos.controller

import br.com.estudos.controller.documentacao.TransferenciaContasControllerSwagger
import br.com.estudos.enums.BancoEnum
import br.com.estudos.repository.entity.DadosTransferenciaEntity
import br.com.estudos.repository.TransferenciaRepository
import br.com.estudos.request.DadosDestinoRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/transferencia")
class TransferenciaContasController(
        private val request: HttpServletRequest,
        private val transferenciaReository: TransferenciaRepository
): TransferenciaContasControllerSwagger {

    @PostMapping
    override fun transferir(@RequestBody destinoRequest: DadosDestinoRequest): ResponseEntity<String> {
        request.getHeaders("")

        val origem = DadosTransferenciaEntity(
                request.getHeader("cpf"),
                BancoEnum.valueOf(request.getHeader("banco")),
                request.getHeader("agencia"),
                request.getHeader("conta")
        )

        val destino = DadosTransferenciaEntity(
            destinoRequest.cpf,
            destinoRequest.banco,
            destinoRequest.agencia,
            destinoRequest.conta
        )

        transferenciaReository.transferir(origem, destino, destinoRequest.valor)

        return ResponseEntity.status(HttpStatus.CREATED).body("efetuado com sucesso")
    }

}