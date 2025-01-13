package dev.ghlima.server;

import dev.ghlima.service.RastreamentoService;

public class RastreamentoServer {
    public static void main(String[] args) {

        GrpcServer.create(6566, builder -> {
                    builder.addService(new RastreamentoService());
                })
                .start()
                .await();

    }
}
