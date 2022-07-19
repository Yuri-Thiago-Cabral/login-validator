package br.com.login.validator.service;

import br.com.login.validator.service.vo.v1.LoginRegisterVO;
import br.com.login.validator.service.vo.v2.LoginRegisterVO_v2;

import javax.ejb.Local;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@Local
public interface RegisterLoginService {

    LoginRegisterVO_v2 registerLogin(String mail, String password) throws Exception;

    LoginRegisterVO registerLogin(String mail, String password, ArrayList<String> acceptedConditions, ArrayList<String> acceptedNotConditions) throws NoSuchAlgorithmException;

}
