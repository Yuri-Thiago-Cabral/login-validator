package br.com.login.validator.dao;

import br.com.login.validator.core.DatabaseConnection;
import br.com.login.validator.entity.LoginData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class LoginDataManagerDAO {

    public Long registerNewLoginData(LoginData loginData) {
        PreparedStatement preparedStatement;
        try (Connection connection = new DatabaseConnection().getConnection()) {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO login_data(login_mail, login_password, password_encrypted)"
                            + "VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, loginData.getMail());
            preparedStatement.setString(2, loginData.getPassword());
            preparedStatement.setString(3, loginData.getEncryptedPassword());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            Long id = null;
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LoginData getLoginData(Long id) {
        PreparedStatement preparedStatement;
        LoginData obj = new LoginData();
        try (Connection connection = new DatabaseConnection().getConnection()) {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM login_data where id_register=?", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                obj.setId(result.getLong("id_register"));
                obj.setMail(result.getString(2));
                obj.setPassword(result.getString(3));
                obj.setEncryptedPassword(result.getString(4));
            }

            return obj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
