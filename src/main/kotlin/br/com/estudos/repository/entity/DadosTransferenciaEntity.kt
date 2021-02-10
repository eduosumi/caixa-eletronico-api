package br.com.estudos.repository.entity

import br.com.estudos.enums.BancoEnum

data class DadosTransferenciaEntity (
        val cpf: String,
        val banco: BancoEnum,
        val agencia: String,
        val conta: String
        )
