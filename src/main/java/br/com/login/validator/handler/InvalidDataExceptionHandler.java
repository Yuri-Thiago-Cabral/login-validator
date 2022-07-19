package br.com.login.validator.handler;

import br.com.login.validator.exception.GenericErrorResponse;
import br.com.login.validator.exception.InvalidDataException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidDataExceptionHandler implements ExceptionMapper<InvalidDataException> {

    @Override
    public Response toResponse(InvalidDataException e) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
        genericErrorResponse.setMessage(e.getMessage());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(genericErrorResponse).build();
    }

}
