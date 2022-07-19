package br.com.login.validator.handler;

import br.com.login.validator.exception.ConditionsNotAcceptedException;
import br.com.login.validator.exception.GenericErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConditionsNotAcceptedExceptionHandler implements ExceptionMapper<ConditionsNotAcceptedException> {

    @Override
    public Response toResponse(ConditionsNotAcceptedException e) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
        genericErrorResponse.setMessage(e.getMessage());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(genericErrorResponse).build();
    }

}
