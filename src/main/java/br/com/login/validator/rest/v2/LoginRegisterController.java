package br.com.login.validator.rest.v2;

import br.com.login.validator.rest.BaseRest;
import br.com.login.validator.rest.dto.LoginDataDTO;
import br.com.login.validator.service.RegisterLoginService;
import br.com.login.validator.service.vo.v2.LoginRegisterVO_v2;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(BaseRest.BASE_REST_V2 + "loginmanager")
public class LoginRegisterController {

    @EJB
    private RegisterLoginService registerLoginService;

    @Path("/register-login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerLoginData(LoginDataDTO loginDataDTO) throws Exception {
        LoginRegisterVO_v2 vo = registerLoginService
                .registerLogin(loginDataDTO.getMail(), loginDataDTO.getPassword());

        return Response.ok(vo).build();
    }
}
