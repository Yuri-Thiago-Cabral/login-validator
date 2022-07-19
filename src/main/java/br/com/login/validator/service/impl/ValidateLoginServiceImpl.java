package br.com.login.validator.service.impl;

import br.com.login.validator.exception.InvalidDataException;
import br.com.login.validator.service.LoginConditions;
import br.com.login.validator.service.ValidateLoginService;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Stateless
public class ValidateLoginServiceImpl implements ValidateLoginService {

    private final String[] CHARACTERS_LOWER_CASE = new String[]{"abcdefghijklmnopqrstuvwxyz"};
    private final String[] CHARACTERS_UPPER_CASE = new String[]{"ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
    private final String[] NUMBERS_CHARACTERS = new String[]{"0123456789"};
    private final String[] SPECIAL_CHARACTERS = new String[]{"@#$%^&-+=()"};

    @Override
    public Boolean validateConditionsLogin(String mail, String password) throws Exception {
        if (!checkValidEmail(mail)) {
            throw new InvalidDataException("O email deve seguir o padrão mail@mail.com");
        }

        if (Objects.isNull(password) || password.isEmpty()) {
            throw new InvalidDataException("Ops! A senha precisa ser informada");
        }

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+-=])(?=\\S+$).{8,16}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    @Override
    public HashMap<String, ArrayList<String>> validateConditionsLogin_v1(String mail, String password) {
        ArrayList<String> conditionsNotAccepted = new ArrayList<>();
        ArrayList<String> acceptedConditions = new ArrayList<>();

        if (checkValidEmail(mail)) {
            acceptedConditions.add(LoginConditions.MAIL_SYNTAX);
        } else {
            conditionsNotAccepted.add(LoginConditions.MAIL_SYNTAX);
        }

        if (password.length() >= 8 && password.length() <= 20) {
            acceptedConditions.add(LoginConditions.SIZE_PASSWORD);
        } else {
            conditionsNotAccepted.add(LoginConditions.SIZE_PASSWORD);
        }

        checkConditionWasAcceptedAndAddToArray(
                CHARACTERS_LOWER_CASE,
                password,
                acceptedConditions,
                conditionsNotAccepted,
                LoginConditions.ONE_CHARACTER_LOWER_CASE
        );

        checkConditionWasAcceptedAndAddToArray(
                CHARACTERS_UPPER_CASE,
                password,
                acceptedConditions,
                conditionsNotAccepted,
                LoginConditions.ONE_CHARACTER_UPPER_CASE
        );

        checkConditionWasAcceptedAndAddToArray(
                NUMBERS_CHARACTERS,
                password,
                acceptedConditions,
                conditionsNotAccepted,
                LoginConditions.ONE_CHARACTER_NUMBER
        );

        checkConditionWasAcceptedAndAddToArray(
                SPECIAL_CHARACTERS,
                password,
                acceptedConditions,
                conditionsNotAccepted,
                LoginConditions.ONE_SPECIAL_CHARACTER
        );

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        hashMap.put("acceptedConditions", acceptedConditions);
        hashMap.put("conditionsNotAccepted", conditionsNotAccepted);

        return hashMap;
    }

    @Override
    public Boolean compareConditions(ArrayList<String> conditions) {
        return LoginConditions.SIZE_CONDITIONS.equals(conditions.size());
    }

    /*Metódo criado para verificar se a senha possui um caracter minúsculo,
    um caracter maiúsculo, um caracter do tipo número...
    Após verificar, adiciona em um array*/
    private void checkConditionWasAcceptedAndAddToArray(String[] caracteres, String text,
                                                        ArrayList<String> arrAccepted, ArrayList<String> arrNotAccepted, String condition) {
        boolean conditionWasAccepted = false;
        for (Character character : caracteres[0].toCharArray()) {
            if (text.contains(character.toString())) {
                arrAccepted.add(condition);
                conditionWasAccepted = true;
                break;
            }
        }

        if (!conditionWasAccepted) {
            arrNotAccepted.add(condition);
        }
    }

    private Boolean checkValidEmail(String mail) {
        return (Objects.nonNull(mail) && !mail.isEmpty()) && ((mail.contains("@")
                && (mail.endsWith(".com"))) || (mail.endsWith(".br")));
    }
}
