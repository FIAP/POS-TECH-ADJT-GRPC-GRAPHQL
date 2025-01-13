package dev.ghlima.client;


import io.grpc.*;
import dev.ghlima.rastreamento.RastreamentoServiceGrpc;
import dev.ghlima.rastreamento.RastreamentoRequest;
import dev.ghlima.rastreamento.LocalizacaoResponse;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RastreamentoClient {
    private  static final Logger log = LoggerFactory.getLogger(RastreamentoClient.class);
    public static void main(String[] args) {
        // Configurando o canal
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6566)
                .usePlaintext()
                .build();

        // Criando o stub assíncrono
        RastreamentoServiceGrpc.RastreamentoServiceStub stub = RastreamentoServiceGrpc.newStub(channel);

        // Fazendo a requisição
        RastreamentoRequest request = RastreamentoRequest.newBuilder()
                .setPlaca("ABC-1234")
                .build();

        // Consumindo o fluxo de localizações
        stub.iniciarRastreamento(request, new StreamObserver<LocalizacaoResponse>() {
            @Override
            public void onNext(LocalizacaoResponse response) {
                // Exibindo as atualizações de localização
                log.info("Atualização de localização recebida:");
                log.info("Placa: {}", response.getPlaca());
                log.info("Latitude: {}", response.getLatitude());
                log.info("Longitude: {}", response.getLongitude());
                log.info("Velocidade: {} km/h", response.getVelocidade());
                log.info("Entregue: {}", response.getEntregue());
                log.info("--------------------");

                // Verifica se o veículo foi entregue
                if (response.getEntregue()) {
                    log.info("Veículo entregue. Encerrando rastreamento.");
                }
            }

            @Override
            public void onError(Throwable t) {
                log.error("Erro durante o rastreamento: {}", t.getMessage(), t);
            }

            @Override
            public void onCompleted() {
                log.info("Rastreamento concluído.");
            }
        });

        // Manter o cliente ativo enquanto o fluxo está sendo processado
        try {
            Thread.sleep(15000); // Aguarda o término do rastreamento
        } catch (InterruptedException e) {
            log.error("Erro ao aguardar término do rastreamento", e);
        }

        channel.shutdown();
    }
}
