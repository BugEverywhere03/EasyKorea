package com.learnkorealanguage.app.viewmodel;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {
    public final StringProperty userName = new SimpleStringProperty("");
    public final StringProperty password = new SimpleStringProperty("");

    public  LoginViewModel(){   

    }
}
