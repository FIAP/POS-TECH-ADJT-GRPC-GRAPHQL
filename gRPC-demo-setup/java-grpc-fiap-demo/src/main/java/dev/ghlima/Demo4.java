package dev.ghlima;

import  dev.ghlima.demos.collection.Veiculo;
import  dev.ghlima.demos.collection.Frota;
import  dev.ghlima.demos.collection.ListaDeFrotas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Demo4 {
    private static final Logger log = LoggerFactory.getLogger(Demo4.class);

    public static void main(String[] args) {


        var veiculo1 = Veiculo.newBuilder()
                .setPlaca("ABC-1234")
                .setModelo("Gol")
                .setMarca("Volkswagen")
                .setAno(2020)
                .build();

        var veiculo2 = Veiculo.newBuilder()
                .setPlaca("XYZ-5678")
                .setModelo("Corolla")
                .setMarca("Toyota")
                .setAno(2018)
                .build();

        var veiculo3 = Veiculo.newBuilder()
                .setPlaca("DEF-9012")
                .setModelo("Civic")
                .setMarca("Honda")
                .setAno(2022)
                .build();

        var veiculo4 = Veiculo.newBuilder()
                .setPlaca("GHI-3456")
                .setModelo("Onix")
                .setMarca("Chevrolet")
                .setAno(2021)
                .build();


        var frota1 = Frota.newBuilder()
                .setNome("Frota São Paulo")
                .addVeiculos(veiculo1)
                .addVeiculos(veiculo2)
                .build();

        var frota2 = Frota.newBuilder()
                .setNome("Frota Rio de Janeiro")
                .addAllVeiculos(List.of(veiculo3, veiculo4))
                .build();


        var listaDeFrotas = ListaDeFrotas.newBuilder()
                .addFrotas(frota1)
                .addFrotas(frota2)
                .build();


        log.info("Lista de Frotas: {}", listaDeFrotas);
        listaDeFrotas.getFrotasList().forEach(frota -> {
            log.info("Frota: {}", frota.getNome());
            frota.getVeiculosList().forEach(veiculo ->
                    log.info("  Veículo: Placa: {}, Modelo: {}, Marca: {}, Ano: {}",
                            veiculo.getPlaca(),
                            veiculo.getModelo(),
                            veiculo.getMarca(),
                            veiculo.getAno())
            );
        });
    }
}
