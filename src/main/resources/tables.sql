CREATE TABLE login_data(
    id_register INT AUTO_INCREMENT PRIMARY KEY ,
    login_mail VARCHAR(80) NOT NULL,
    login_password VARCHAR(16) NOT NULL,
    password_encrypted VARCHAR(255) NOT NULL
);
