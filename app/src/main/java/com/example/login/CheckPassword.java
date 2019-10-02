package com.example.login;

import java.util.regex.Pattern;

public class CheckPassword {
    private Pattern pattern;
    private static final String PASSWORD_PATTERN =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!.*#$@_+,?-])(?!.*\\s).{6,}";


    public CheckPassword() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validate(final String password) {
        return pattern.matcher(password).matches();
    }
}