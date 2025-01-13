import dev.ghlima.veiculo.VeiculoRequest;
import dev.ghlima.veiculo.VeiculoResponse;
import dev.ghlima.veiculo.VeiculoServiceGrpc;
import io.grpc.stub.StreamObserver;

public class VeiculoService extends VeiculoServiceGrpc.VeiculoServiceImplBase {

    @Override
    public void consultarVeiculo(VeiculoRequest request, StreamObserver<VeiculoResponse> responseObserver) {
        VeiculoResponse response = VeiculoResponse.newBuilder()
                .setPlaca(request.getPlaca())
                .setModelo("Gol")
                .setMarca("Volkswagen")
                .setAno(2020)
                .setDisponivel(true) // Exemplo: veículo está disponível
                .build();

        responseObserver.onNext(response); // Retorna a resposta
        responseObserver.onCompleted(); // Finaliza a chamada
    }
}
