package br.com.estudos.repository

import br.com.estudos.repository.entity.DadosTransferenciaEntity
import java.math.BigDecimal

interface TransferenciaRepository {

    fun transferir(origem: DadosTransferenciaEntity, destino: DadosTransferenciaEntity, valor: BigDecimal)

    fun transferirViaPix(origem: DadosTransferenciaEntity, codigoPix: String, valor: BigDecimal)
}
