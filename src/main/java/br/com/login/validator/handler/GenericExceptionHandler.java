package br.com.login.validator.handler;

import br.com.login.validator.exception.GenericErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
        genericErrorResponse.setMessage(e.getMessage());

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(genericErrorResponse).build();
    }

}
