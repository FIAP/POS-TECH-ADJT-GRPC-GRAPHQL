package service;


import dev.ghlima.locatech.reservation.CreateReservationRequest;
import dev.ghlima.locatech.reservation.CreateReservationResponse;
import dev.ghlima.locatech.reservation.GetReservationRequest;
import dev.ghlima.locatech.reservation.GetReservationResponse;
import dev.ghlima.locatech.reservation.CompleteReservationRequest;
import dev.ghlima.locatech.reservation.CompleteReservationResponse;
import dev.ghlima.locatech.reservation.GetReservationByVehicleIdRequest;
import dev.ghlima.locatech.reservation.GetReservationByVehicleIdResponse;


import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import dev.ghlima.locatech.reservation.ReservationServiceGrpc.ReservationServiceImplBase;
import service.handler.ReservationRequestHandler;

@GrpcService
@Blocking
public class ReservationService extends ReservationServiceImplBase {
  
  private final ReservationRequestHandler reservationRequestHandler;

  public ReservationService(ReservationRequestHandler reservationRequestHandler) {
    this.reservationRequestHandler = reservationRequestHandler;
  }

  @Override
  public void createReservation(CreateReservationRequest request, StreamObserver<CreateReservationResponse> responseObserver) {
    var response = reservationRequestHandler.createReservation(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void getReservation(GetReservationRequest request, StreamObserver<GetReservationResponse> responseObserver) {
    var response = reservationRequestHandler.getReservation(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void completeReservation(CompleteReservationRequest request, StreamObserver<CompleteReservationResponse> responseObserver) {
    var response = reservationRequestHandler.completeReservation(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void getReservationByVehicleId(GetReservationByVehicleIdRequest request, StreamObserver<GetReservationByVehicleIdResponse> responseObserver) {
    var response = reservationRequestHandler.getReservationByVehicleId(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
