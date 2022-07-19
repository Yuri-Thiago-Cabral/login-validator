package br.com.login.validator.service;

public class LoginConditions {
    public static final String MAIL_SYNTAX = "O e-mail deve seguir o padrão mail@mail.com";
    public static final String SIZE_PASSWORD = "A senha deve conter entre 8 a 16 digitos";
    public static final String ONE_CHARACTER_LOWER_CASE = "A senha deve possuir ao menos uma letra minúscula";
    public static final String ONE_CHARACTER_UPPER_CASE = "Deve possuir ao menos uma letra maiúscula";
    public static final String ONE_CHARACTER_NUMBER = "Deve possuir ao menos um caractere numérico";
    public static final String ONE_SPECIAL_CHARACTER = "Deve possuir ao menos um caractere especial";

    /*A cada condição inserida nessa classe, deve ser alterado o valor dessa constante.
    Ela é responsavel por determinar a quantidade de condições existentes e é usada no validatorLoginService*/
    public static final Integer SIZE_CONDITIONS = 6;
}
