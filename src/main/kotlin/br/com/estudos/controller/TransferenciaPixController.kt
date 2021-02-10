package br.com.estudos.controller

import br.com.estudos.controller.documentacao.TransferenciaPixControllerSwagger
import br.com.estudos.enums.BancoEnum
import br.com.estudos.repository.entity.DadosTransferenciaEntity
import br.com.estudos.repository.TransferenciaRepository
import br.com.estudos.request.DadosPixRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/pix")
class TransferenciaPixController(
    private val request: HttpServletRequest,
    private val transferenciaRepository: TransferenciaRepository
): TransferenciaPixControllerSwagger {

    @PostMapping
    override fun transferir(@RequestBody dadosPixRequest: DadosPixRequest):ResponseEntity<String> {
        val origem = DadosTransferenciaEntity(
            request.getHeader("cpf"),
            BancoEnum.valueOf(request.getHeader("banco")),
            request.getHeader("agencia"),
            request.getHeader("conta")
        )

        transferenciaRepository.transferirViaPix(origem, dadosPixRequest.codigo, dadosPixRequest.valor)

        return ResponseEntity.status(HttpStatus.CREATED).body("pix realizado.")
    }


}