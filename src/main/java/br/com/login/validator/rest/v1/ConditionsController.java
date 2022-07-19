package br.com.login.validator.rest.v1;

import br.com.login.validator.rest.BaseRest;
import br.com.login.validator.service.ConditionsService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(BaseRest.BASE_REST_V1 + "/conditions")
public class ConditionsController {

    @EJB
    private ConditionsService conditionsService;

    @GET
    @Path("/findAllConditions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllConditions(@QueryParam("type") String type) {
        List<String> conditionsList = conditionsService.findAllLoginConditions(type);
        return Response.ok(conditionsList).build();
    }
}
