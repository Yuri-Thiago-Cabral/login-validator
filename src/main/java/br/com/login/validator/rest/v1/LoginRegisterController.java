package br.com.login.validator.rest.v1;

import br.com.login.validator.rest.BaseRest;
import br.com.login.validator.rest.dto.LoginDataDTO;
import br.com.login.validator.service.RegisterLoginService;
import br.com.login.validator.service.ValidateLoginService;
import br.com.login.validator.service.vo.v1.InvalidLoginRegisterVO;
import br.com.login.validator.service.vo.v1.LoginRegisterVO;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

@Path(BaseRest.BASE_REST_V1 + "/loginmanager")
public class LoginRegisterController {

    @EJB
    private RegisterLoginService registerLoginService;

    @EJB
    private ValidateLoginService validateLoginService;

    @POST
    @Path("/register-login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerLogin(LoginDataDTO requestDTO) throws NoSuchAlgorithmException {
        HashMap<String, ArrayList<String>> hashMap =
                validateLoginService.validateConditionsLogin_v1(requestDTO.getMail(), requestDTO.getPassword());

        if (validateLoginService.compareConditions(hashMap.get("acceptedConditions"))) {
            LoginRegisterVO vo = registerLoginService.registerLogin(requestDTO.getMail(),
                    requestDTO.getPassword(), hashMap.get("acceptedConditions"), hashMap.get("conditionsNotAccepted"));

            return Response.ok(vo).build();
        }

        InvalidLoginRegisterVO vo = new InvalidLoginRegisterVO();
        vo.setMessage("Ops! Os dados informados não atendenderam as condições necessárias. Revise as informações, e tente novamente");
        vo.setAcceptedConditions(hashMap.get("acceptedConditions"));
        vo.setConditionsNotAccepted(hashMap.get("conditionsNotAccepted"));

        return Response.status(Response.Status.BAD_REQUEST).entity(vo).build();
    }
}
