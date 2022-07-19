package br.com.login.validator.service.vo.v2;

import br.com.login.validator.entity.LoginData;

public class LoginRegisterVO_v2 {

    private Long id;
    private String mail;
    private String password;
    private String encryptedPassword;
    private Boolean acceptedConditions;

    public LoginRegisterVO_v2(LoginData loginRegisterInfo, Boolean acceptedConditions) {
        this.id = loginRegisterInfo.getId();
        this.mail = loginRegisterInfo.getMail();
        this.password = loginRegisterInfo.getPassword();
        this.encryptedPassword = loginRegisterInfo.getEncryptedPassword();
        this.acceptedConditions = acceptedConditions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getAcceptedConditions() {
        return acceptedConditions;
    }

    public void setAcceptedConditions(Boolean acceptedConditions) {
        this.acceptedConditions = acceptedConditions;
    }
}
