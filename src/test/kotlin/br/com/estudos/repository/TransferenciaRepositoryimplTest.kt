package br.com.estudos.repository

import br.com.estudos.enums.BancoEnum
import br.com.estudos.repository.entity.DadosTransferenciaEntity
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class TransferenciaRepositoryimplTest {

    private val transferenciaRepositoryimpl = TransferenciaRepositoryimpl()

    @Test
    fun transferir_sucesso() {

        val origem = this.buildDadosTransferenciaEntity()
        val destino = this.buildDadosTransferenciaEntity()

        transferenciaRepositoryimpl.transferir(origem, destino, BigDecimal.ONE)
    }

    private fun buildDadosTransferenciaEntity() = DadosTransferenciaEntity(
        "",
        BancoEnum.BANCO_DO_BRASIL,
        "",
        ""
    )

    @Test
    fun transferirViaPix_sucesso() {
        val origem = this.buildDadosTransferenciaEntity()

        transferenciaRepositoryimpl.transferirViaPix(origem, "", BigDecimal.ONE)
    }

}