package br.com.estudos.repository

import br.com.estudos.repository.entity.DadosTransferenciaEntity
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class TransferenciaRepositoryimpl: TransferenciaRepository {

    override fun transferir(origem: DadosTransferenciaEntity, destino: DadosTransferenciaEntity, valor: BigDecimal) {
        print("transferencia realizada!!!!!!!")
    }

    override fun transferirViaPix(origem: DadosTransferenciaEntity, codigoPix: String, valor: BigDecimal) {
        print("transferencia pix realizada!!!!!!!")
    }
}