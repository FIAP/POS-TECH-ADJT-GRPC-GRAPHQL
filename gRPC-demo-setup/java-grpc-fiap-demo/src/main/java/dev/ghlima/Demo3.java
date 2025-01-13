package dev.ghlima;

import dev.ghlima.demos.composition.Endereco;
import dev.ghlima.demos.composition.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo3 {
    private static final Logger log = LoggerFactory.getLogger(Demo3.class);

    public static void main(String[] args) {

        var endereco = Endereco.newBuilder()
                .setRua("Rua das Flores")
                .setBairro("Centro")
                .setCidade("São Paulo")
                .setEstado("SP")
                .setCep("12345-678")
                .build();

        var pessoa = Pessoa.newBuilder()
                .setNome("João")
                .setCpf("99999999999")
                .setRg("99999999999")
                .setEndereco(endereco)
                .build();

        var pessoa2 = Pessoa.newBuilder()
                .setNome("Maria")
                .setCpf("88888888888")
                .setRg("888888888888")
                .setEndereco(endereco.toBuilder().setRua("Rua das Rosas").setCep("12313-1231").build())
                .build();


        log.info("Pessoa: {}", pessoa);
        log.info("Pessoa 2: {}", pessoa2);
        log.info("Endereco: {}", pessoa.getEndereco());
        log.info("Endereco 2: {}", pessoa2.getEndereco());

    }
}
