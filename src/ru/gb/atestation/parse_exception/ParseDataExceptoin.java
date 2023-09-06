package ru.gb.atestation.parse_exception;

public class ParseDataExceptoin extends Exception{
    public void Exception(String exception){
        System.err.println("Exception: DataNotCorrectFormat");
        System.err.printf("It`s not correct format: %s\n", exception);
    }
}
