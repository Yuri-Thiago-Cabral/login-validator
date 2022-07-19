package br.com.login.validator.service.impl;

import br.com.login.validator.service.vo.v1.LoginRegisterVO;
import br.com.login.validator.dao.LoginDataManagerDAO;
import br.com.login.validator.entity.LoginData;
import br.com.login.validator.exception.InvalidDataException;
import br.com.login.validator.service.RegisterLoginService;
import br.com.login.validator.service.ValidateLoginService;
import br.com.login.validator.service.vo.v2.LoginRegisterVO_v2;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;

@Stateless
public class RegisterLoginServiceImpl implements RegisterLoginService {

    @EJB
    private ValidateLoginService validateLoginService;

    @Override
    public LoginRegisterVO_v2 registerLogin(String mail, String password) throws Exception {
        Boolean isDataValid = validateLoginService.validateConditionsLogin(mail, password);

        if (!isDataValid) {
            throw new InvalidDataException("Os dados de login não atenderam os critérios necessários");
        }

        LoginData loginData = null;
        try {
            String encryptedPassword = encryptionPassword(password);
            LoginDataManagerDAO dao = new LoginDataManagerDAO();
            Long id = dao.registerNewLoginData(new LoginData(mail, password, encryptedPassword));
            loginData = dao.getLoginData(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new LoginRegisterVO_v2(Objects.requireNonNull(loginData), true);
    }

    @Override
    @Transactional
    public LoginRegisterVO registerLogin(String mail, String password,
                                         ArrayList<String> acceptedConditions,
                                         ArrayList<String> acceptedNotConditions) {
        LoginData loginData = null;

        try {
            String encryptedPassword = encryptionPassword(password);
            LoginDataManagerDAO dao = new LoginDataManagerDAO();
            Long id = dao.registerNewLoginData(new LoginData(mail, password, encryptedPassword));
            loginData = dao.getLoginData(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        LoginRegisterVO vo = new LoginRegisterVO(Objects.requireNonNull(loginData));
        vo.setAcceptedConditions(acceptedConditions);
        vo.setConditionsNotAccepted(acceptedNotConditions);

        return vo;
    }

    private String encryptionPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte[] messageDigest = algorithm.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        return hexString.toString();
    }
}
