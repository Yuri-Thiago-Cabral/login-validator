package br.com.login.validator.service.vo.v1;

import br.com.login.validator.entity.LoginData;

import java.util.ArrayList;

public class LoginRegisterVO {

    private Long id;
    private String mail;
    private String password;
    private String encryptedPassword;
    private ArrayList<String> acceptedConditions;
    private ArrayList<String> conditionsNotAccepted;

    public LoginRegisterVO(LoginData loginRegisterInfo) {
        this.id = loginRegisterInfo.getId();
        this.mail = loginRegisterInfo.getMail();
        this.password = loginRegisterInfo.getPassword();
        this.encryptedPassword = loginRegisterInfo.getEncryptedPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public ArrayList<String> getAcceptedConditions() {
        return acceptedConditions;
    }

    public void setAcceptedConditions(ArrayList<String> condicoesAtendidas) {
        this.acceptedConditions = condicoesAtendidas;
    }

    public ArrayList<String> getConditionsNotAccepted() {
        return conditionsNotAccepted;
    }

    public void setConditionsNotAccepted(ArrayList<String> condicoesNaoAtendidas) {
        this.conditionsNotAccepted = condicoesNaoAtendidas;
    }
}
