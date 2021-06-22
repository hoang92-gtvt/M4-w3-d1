package model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CheckEmail implements Validator {
    private UserFile userFile;

    public CheckEmail() {
    }

    public CheckEmail(UserFile userFile) {
        this.userFile = userFile;
    }

    public UserFile getUserFile() {
        return userFile;
    }

    public void setUserFile(UserFile userFile) {
        this.userFile = userFile;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserFile.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserFile userFile = (UserFile) target;
        String mail = userFile.getEmail();
        ValidationUtils.rejectIfEmpty(errors,"mail","mail.empty");
        if (!mail.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$\n")){
            errors.rejectValue("mail","fales");
        }


    }
}
