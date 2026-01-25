package com.learnkorealanguage.app.constant;

public enum ViewPath {
    LOGIN("/com/learnkorealanguage/app/views/layout/auth/Login.fxml"),
    HOME("/com/learnkorealanguage/app/views/layout/home/home.fxml"),
    VOCABULARY("/com/learnkorealanguage/app/views/layout/vocabulary/vocabulary.fxml");
    private final String path;
    ViewPath(String path) {
        this.path = path;
    }
    public String getPath(){
        return this.path;
    }
}
