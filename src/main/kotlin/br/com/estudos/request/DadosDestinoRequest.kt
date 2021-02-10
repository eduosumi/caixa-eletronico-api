package br.com.estudos.request

import br.com.estudos.enums.BancoEnum
import java.math.BigDecimal

data class DadosDestinoRequest (
        val cpf: String,
        val banco: BancoEnum,
        val agencia: String,
        val conta: String,
        val valor: BigDecimal
        )
