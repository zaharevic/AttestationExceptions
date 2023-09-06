package ru.gb.atestation.parse_exception;

public class ParsePhoneNumberException extends Exception{
    public void Exception(String exception){
        System.err.println("Exception: PhoneNumberNotCorrectFormat");
        System.err.printf("It`s not correct format: %s\n", exception);
    }
}
