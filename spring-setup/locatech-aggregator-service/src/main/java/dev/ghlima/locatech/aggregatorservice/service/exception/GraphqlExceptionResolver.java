package dev.ghlima.locatech.aggregatorservice.service.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import io.grpc.StatusRuntimeException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class GraphqlExceptionResolver extends DataFetcherExceptionResolverAdapter {
  
  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
    
    if(!(ex instanceof StatusRuntimeException)) {
      return GraphqlErrorBuilder.newError()
        .errorType(ErrorType.INTERNAL_ERROR)
        .message(ex.getMessage())
        .path(env.getExecutionStepInfo().getPath())
        .location(env.getField().getSourceLocation())
        .build();
    }

    return GraphqlErrorBuilder.newError()
      .errorType(ErrorType.NOT_FOUND)
      .message(((StatusRuntimeException) ex).getStatus().getDescription())
      .path(env.getExecutionStepInfo().getPath())
      .location(env.getField().getSourceLocation())
      .build();
    
  }
}
