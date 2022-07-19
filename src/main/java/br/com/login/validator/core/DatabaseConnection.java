package br.com.login.validator.core;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection getConnection() {
        try {
            Class.forName(MysqlConstants.DRIVER_NAME);
            return DriverManager.getConnection(
                    MysqlConstants.DATABASE_URL,
                    MysqlConstants.DATABASE_ID,
                    MysqlConstants.DATABASE_PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
