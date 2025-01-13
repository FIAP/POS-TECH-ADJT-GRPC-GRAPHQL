import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import dev.ghlima.veiculo.VeiculoServiceGrpc;
import dev.ghlima.veiculo.VeiculoRequest;
import dev.ghlima.veiculo.VeiculoResponse;

public class DemoClient {

    public static void main(String[] args) {
        // Configurando o canal
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        // Criando o stub
        VeiculoServiceGrpc.VeiculoServiceBlockingStub stub = VeiculoServiceGrpc.newBlockingStub(channel);

        // Fazendo a requisição
        VeiculoRequest request = VeiculoRequest.newBuilder()
                .setPlaca("ABC-1234")
                .build();

        // Recebendo a resposta
        VeiculoResponse response = stub.consultarVeiculo(request);

        // Imprimindo os detalhes do veículo
        System.out.println("Informações do veículo:");
        System.out.println("Placa: " + response.getPlaca());
        System.out.println("Modelo: " + response.getModelo());
        System.out.println("Marca: " + response.getMarca());
        System.out.println("Ano: " + response.getAno());
        System.out.println("Disponível: " + response.getDisponivel());

        // Encerrando o canal
        channel.shutdown();
    }
}
