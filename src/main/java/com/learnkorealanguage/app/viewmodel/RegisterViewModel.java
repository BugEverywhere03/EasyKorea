package com.learnkorealanguage.app.viewmodel;


import com.learnkorealanguage.app.constant.AuthResult;
import com.learnkorealanguage.app.model.Account;
import com.learnkorealanguage.app.service.AuthService;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;

@Getter
public class RegisterViewModel {
    private final StringProperty userName = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty confirmPassword = new SimpleStringProperty();
    private final ObjectProperty<AuthResult> responseStatus = new SimpleObjectProperty<>();

    public void registerHandler(){
        String userName = this.userName.getValue();
        String password = this.password.getValue();
        String confirmPassword = this.confirmPassword.getValue();

        // TODO validate input
        // Handler Register
        Account isExistsAccount = AuthService.getAccountByUserName(userName).orElse(null);
        if (isExistsAccount == null){
            Account newAccount = new Account();
            newAccount.setUserName(userName);
            newAccount.setPassword(password);
            AuthService.createAccount(newAccount);
            this.responseStatus.setValue(AuthResult.REGISTER_SUCCESS);
            clearFields();
            return;
        }
        this.responseStatus.setValue(AuthResult.USERNAME_EXISTS);
    }
    private void clearFields(){
        this.userName.setValue("");
        this.password.setValue("");
        this.confirmPassword.setValue("");
    }
}