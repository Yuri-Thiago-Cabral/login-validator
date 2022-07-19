package br.com.login.validator.service.vo.v1;

import java.util.ArrayList;

public class InvalidLoginRegisterVO {

    private String message;
    private ArrayList<String> acceptedConditions;
    private ArrayList<String> conditionsNotAccepted;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<String> getAcceptedConditions() {
        return acceptedConditions;
    }

    public void setAcceptedConditions(ArrayList<String> acceptedConditions) {
        this.acceptedConditions = acceptedConditions;
    }

    public ArrayList<String> getConditionsNotAccepted() {
        return conditionsNotAccepted;
    }

    public void setConditionsNotAccepted(ArrayList<String> condicoesNaoAtendidas) {
        this.conditionsNotAccepted = condicoesNaoAtendidas;
    }
}
