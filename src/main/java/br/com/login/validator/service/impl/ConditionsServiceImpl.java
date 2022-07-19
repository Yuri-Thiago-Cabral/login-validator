package br.com.login.validator.service.impl;

import br.com.login.validator.service.ConditionsService;
import br.com.login.validator.service.LoginConditions;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Stateless
public class ConditionsServiceImpl implements ConditionsService {

    @Override
    public List<String> findAllLoginConditions(String type) {
        List<String> loginConditions = new ArrayList<>();

        switch (type.toLowerCase(Locale.ROOT)) {
            case "mail" -> loginConditions.add(LoginConditions.MAIL_SYNTAX);
            case "password" -> {
                loginConditions.add(LoginConditions.SIZE_PASSWORD);
                loginConditions.add(LoginConditions.ONE_CHARACTER_LOWER_CASE);
                loginConditions.add(LoginConditions.ONE_CHARACTER_UPPER_CASE);
                loginConditions.add(LoginConditions.ONE_CHARACTER_NUMBER);
                loginConditions.add(LoginConditions.ONE_SPECIAL_CHARACTER);
            }
            default -> {
                loginConditions.add(LoginConditions.MAIL_SYNTAX);
                loginConditions.add(LoginConditions.SIZE_PASSWORD);
                loginConditions.add(LoginConditions.ONE_CHARACTER_LOWER_CASE);
                loginConditions.add(LoginConditions.ONE_CHARACTER_UPPER_CASE);
                loginConditions.add(LoginConditions.ONE_CHARACTER_NUMBER);
                loginConditions.add(LoginConditions.ONE_SPECIAL_CHARACTER);
            }
        }

        return loginConditions;
    }
}
