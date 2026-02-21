package com.learnkorealanguage.app.viewmodel;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LoginViewModel {

    private final StringProperty userName = new SimpleStringProperty("");
    private final StringProperty password = new SimpleStringProperty("");

    public LoginViewModel(){
    }

    public boolean loginHandler(){
        String userName = this.userName.getValue();
        String password = this.password.getValue();

        return false;
    }

}
