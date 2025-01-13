package dev.ghlima.service;

import dev.ghlima.rastreamento.RastreamentoServiceGrpc;
import dev.ghlima.rastreamento.RastreamentoRequest;
import dev.ghlima.rastreamento.LocalizacaoResponse;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RastreamentoService extends RastreamentoServiceGrpc.RastreamentoServiceImplBase {
    private  final Logger log = LoggerFactory.getLogger(RastreamentoService.class);

    @Override
    public void iniciarRastreamento(RastreamentoRequest request, StreamObserver<LocalizacaoResponse> responseObserver) {
        String placa = request.getPlaca();

        log.info("Iniciando rastreamento para o veículo com placa: {}", placa);

        // Simulando envio contínuo de localizações
        for (int i = 0; i < 10; i++) { // Envia 10 atualizações como exemplo
            LocalizacaoResponse response = LocalizacaoResponse.newBuilder()
                    .setPlaca(placa)
                    .setLatitude(-23.56 + i * 0.001) // Simulação de mudança de latitude
                    .setLongitude(-46.63 + i * 0.001) // Simulação de mudança de longitude
                    .setVelocidade(60 + i) // Simulação de velocidade variando
                    .setEntregue(i == 9) // Marca como entregue na última atualização
                    .build();

            responseObserver.onNext(response); // Envia a localização ao cliente

            try {
                Thread.sleep(1000); // Simula intervalo de 1 segundo entre atualizações
            } catch (InterruptedException e) {
                log.error("error: {}", e);
            }

            // Finaliza o streaming quando o veículo é entregue
            if (response.getEntregue()) {
                log.info("Rastreamento finalizado para o veículo com placa: {}", placa);
                break;
            }
        }

        responseObserver.onCompleted(); // Finaliza o fluxo
    }
}