package model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CheckEmail implements Validator {
    private String email;

    public CheckEmail(String email) {
        this.email = email;
    }

    public CheckEmail() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserFile.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CheckEmail checkEmail = (CheckEmail) target;
        String mail = checkEmail.getEmail();
        ValidationUtils.rejectIfEmpty(errors,"mail","mail.empty");



    }
}
