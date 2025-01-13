package dev.ghlima;

import dev.ghlima.demos.enums.Veiculo;
import dev.ghlima.demos.enums.TipoVeiculo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo6 {
    private static final Logger log = LoggerFactory.getLogger(Demo6.class);

    public static void main(String[] args) {
        // Criando veículos com tipos diferentes
        var veiculo1 = Veiculo.newBuilder()
                .setPlaca("ABC-1234")
                .setModelo("Gol")
                .setMarca("Volkswagen")
                .setAno(2020)
                .setTipo(TipoVeiculo.CARRO) // Enum definido como "CARRO"
                .build();

        var veiculo2 = Veiculo.newBuilder()
                .setPlaca("XYZ-5678")
                .setModelo("CG 160")
                .setMarca("Honda")
                .setAno(2022)
                .setTipo(TipoVeiculo.MOTO) // Enum definido como "MOTO"
                .build();

        var veiculo3 = Veiculo.newBuilder()
                .setPlaca("DEF-9012")
                .setModelo("Actros")
                .setMarca("Mercedes-Benz")
                .setAno(2018)
                .setTipo(TipoVeiculo.CAMINHAO) // Enum definido como "CAMINHAO"
                .build();

        // Logando as informações
        log.info("Veículo 1: Placa: {}, Modelo: {}, Marca: {}, Ano: {}, Tipo: {}",
                veiculo1.getPlaca(),
                veiculo1.getModelo(),
                veiculo1.getMarca(),
                veiculo1.getAno(),
                veiculo1.getTipo());

        log.info("Veículo 2: Placa: {}, Modelo: {}, Marca: {}, Ano: {}, Tipo: {}",
                veiculo2.getPlaca(),
                veiculo2.getModelo(),
                veiculo2.getMarca(),
                veiculo2.getAno(),
                veiculo2.getTipo());

        log.info("Veículo 3: Placa: {}, Modelo: {}, Marca: {}, Ano: {}, Tipo: {}",
                veiculo3.getPlaca(),
                veiculo3.getModelo(),
                veiculo3.getMarca(),
                veiculo3.getAno(),
                veiculo3.getTipo());
    }
}

