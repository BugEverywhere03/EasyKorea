package com.learnkorealanguage.app.ultil;

public class GlobalException extends Exception{
    public GlobalException(){
        super();
    }
    public GlobalException(String errorMessage){
        super(errorMessage);
    }
}
