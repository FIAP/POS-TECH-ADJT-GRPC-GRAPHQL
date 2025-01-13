package dev.ghlima;

import dev.ghlima.demos.oneof.Veiculo;
import dev.ghlima.demos.oneof.DetalhesVeiculo;
import dev.ghlima.demos.oneof.TipoCombustivel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo7 {
    private static final Logger log = LoggerFactory.getLogger(Demo7.class);

    public static void main(String[] args) {
        // Criando um veículo com detalhes de carga máxima (Caminhão)
        var veiculo1 = Veiculo.newBuilder()
                .setPlaca("CAM-1234")
                .setModelo("Actros")
                .setMarca("Mercedes-Benz")
                .setAno(2019)
                .setCombustivel(TipoCombustivel.DIESEL)
                .setDetalhes(DetalhesVeiculo.newBuilder()
                        .setCargaMaxima("20 toneladas")
                        .build())
                .build();

        // Criando um veículo com detalhes de autonomia da bateria (Elétrico)
        var veiculo2 = Veiculo.newBuilder()
                .setPlaca("ELE-5678")
                .setModelo("Model S")
                .setMarca("Tesla")
                .setAno(2023)
                .setCombustivel(TipoCombustivel.ELETRICO)
                .setDetalhes(DetalhesVeiculo.newBuilder()
                        .setAutonomiaBateria("500 km")
                        .build())
                .build();

        // Criando um veículo com detalhes de capacidade de passageiros (Ônibus)
        var veiculo3 = Veiculo.newBuilder()
                .setPlaca("ONB-9012")
                .setModelo("Marcopolo G8")
                .setMarca("Marcopolo")
                .setAno(2020)
                .setCombustivel(TipoCombustivel.DIESEL)
                .setDetalhes(DetalhesVeiculo.newBuilder()
                        .setCapacidadePassageiros("50 passageiros")
                        .build())
                .build();

        // Logando as informações
        log.info("Veículo 1: Placa: {}, Modelo: {}, Marca: {}, Ano: {}, Combustível: {}, Detalhes: {}",
                veiculo1.getPlaca(),
                veiculo1.getModelo(),
                veiculo1.getMarca(),
                veiculo1.getAno(),
                veiculo1.getCombustivel(),
                veiculo1.getDetalhes().getCargaMaxima());

        log.info("Veículo 2: Placa: {}, Modelo: {}, Marca: {}, Ano: {}, Combustível: {}, Detalhes: {}",
                veiculo2.getPlaca(),
                veiculo2.getModelo(),
                veiculo2.getMarca(),
                veiculo2.getAno(),
                veiculo2.getCombustivel(),
                veiculo2.getDetalhes().getAutonomiaBateria());

        log.info("Veículo 3: Placa: {}, Modelo: {}, Marca: {}, Ano: {}, Combustível: {}, Detalhes: {}",
                veiculo3.getPlaca(),
                veiculo3.getModelo(),
                veiculo3.getMarca(),
                veiculo3.getAno(),
                veiculo3.getCombustivel(),
                veiculo3.getDetalhes().getCapacidadePassageiros());
    }
}

