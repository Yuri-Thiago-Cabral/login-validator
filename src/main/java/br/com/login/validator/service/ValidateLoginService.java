package br.com.login.validator.service;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.HashMap;

@Local
public interface ValidateLoginService {

    Boolean validateConditionsLogin(String mail, String password) throws Exception;

    HashMap<String, ArrayList<String>> validateConditionsLogin_v1(String mail, String password);

    Boolean compareConditions(ArrayList<String> conditions);

}
