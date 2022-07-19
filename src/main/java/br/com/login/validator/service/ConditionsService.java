package br.com.login.validator.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ConditionsService {

    List<String> findAllLoginConditions(String type);

}
