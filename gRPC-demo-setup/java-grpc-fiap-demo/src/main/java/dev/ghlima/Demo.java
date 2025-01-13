package dev.ghlima;

import dev.ghlima.veiculo.Veiculo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {

        var veiculo = Veiculo.newBuilder()
                .setId(1)
                .setAno(2021)
                .setModelo("Fusca")
                .setMarca("Volkswagen")
                .build();


        log.info("Veiculo: {}", veiculo);

    }
}
