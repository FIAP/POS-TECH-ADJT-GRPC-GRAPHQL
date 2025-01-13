package dev.ghlima;

import dev.ghlima.veiculo.Veiculo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo2 {
    private static final Logger log = LoggerFactory.getLogger(Demo2.class);

    public static void main(String[] args) {



        //criar um veiculo
        var veiculo1 = criaVeiculo();

        //criar outro veiculo com uma nova instancia porem mesmos valores
        var veivulo2 = criaVeiculo();

        //comparar os veiculos
        log.info("equals {}", veiculo1.equals(veivulo2));
        log.info("== {}", (veiculo1 == veivulo2));


        var veiculo3 = veiculo1.toBuilder().setModelo("Gol").build();
        log.info("Veiculo 3: {}", veiculo3);


        //comparar os veiculos
        log.info("equals {}", veiculo1.equals(veiculo3));
        log.info("== {}", (veiculo1 == veiculo3));

        //null?
        var veiculo4 = veiculo3.toBuilder().clearAno().build();
        log.info("Veiculo 4: {}", veiculo4);

    }

    public static Veiculo criaVeiculo() {
        return Veiculo.newBuilder()
                .setId(1)
                .setAno(2021)
                .setModelo("Fusca")
                .setMarca("Volkswagen")
                .build();
    }
}
