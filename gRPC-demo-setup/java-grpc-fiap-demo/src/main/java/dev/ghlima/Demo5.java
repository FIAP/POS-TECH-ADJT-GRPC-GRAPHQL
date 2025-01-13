package dev.ghlima;


import dev.ghlima.demos.map.Veiculo;
import dev.ghlima.demos.map.FrotaComMap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Demo5 {
    private static final Logger log = LoggerFactory.getLogger(Demo5.class);

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


        var frota = FrotaComMap.newBuilder()
                .setNome("Frota São Paulo")
                .putVeiculos(veiculo1.getPlaca(), veiculo1)
                .putVeiculos(veiculo2.getPlaca(), veiculo2)
                .putVeiculos(veiculo3.getPlaca(), veiculo3)
                .putVeiculos(veiculo4.getPlaca(), veiculo4)
                .build();

        var frota2 = FrotaComMap.newBuilder()
                .setNome("Frota São Paulo")
                .putAllVeiculos(Map.of(
                        veiculo1.getPlaca(), veiculo1,
                        veiculo2.getPlaca(), veiculo2,
                        veiculo3.getPlaca(), veiculo3,
                        veiculo4.getPlaca(), veiculo4
                ))
                .build();


        log.info("Frota: {}", frota.getNome());
        frota.getVeiculosMap().forEach((placa, veiculo) ->
                log.info("Veículo Placa: {}, Modelo: {}, Marca: {}, Ano: {}",
                        placa,
                        veiculo.getModelo(),
                        veiculo.getMarca(),
                        veiculo.getAno())
        );
    }


}
