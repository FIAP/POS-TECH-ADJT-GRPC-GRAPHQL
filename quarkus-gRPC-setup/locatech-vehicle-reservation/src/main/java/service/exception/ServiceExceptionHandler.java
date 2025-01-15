package service.exception;

import exception.ReservationNotFoundException;
import io.grpc.*;
import io.quarkus.grpc.GlobalInterceptor;
import jakarta.inject.Singleton;

@Singleton
@GlobalInterceptor
public class ServiceExceptionHandler implements ServerInterceptor {

  @Override
  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
    ServerCall<ReqT, RespT> serverCall,
    Metadata metadata,
    ServerCallHandler<ReqT, RespT> serverCallHandler) {

    ServerCall.Listener<ReqT> listener = serverCallHandler.startCall(serverCall, metadata);

    return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(listener) {
      @Override
      public void onHalfClose() {
        try {
          super.onHalfClose();
        } catch (ReservationNotFoundException e) {
          serverCall.close(
            Status.NOT_FOUND.withDescription(e.getMessage()),
            new Metadata()
          );
        } catch (RuntimeException e) {
          serverCall.close(
            Status.UNKNOWN.withDescription(e.getMessage()),
            new Metadata()
          );
        }
      }        };
  }
}
