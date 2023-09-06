package ru.gb.atestation.service;

import java.util.HashMap;
import java.util.Objects;

public class ParseToString {
    public String string(HashMap<String, Object> parsedData){
        StringBuilder result = new StringBuilder();

        result.append("<");
        result.append(parsedData.get("lastname"));
        result.append(">");
        result.append("<");
        result.append(parsedData.get("firstname"));
        result.append(">");
        result.append("<");
        result.append(parsedData.get("patronymic"));
        result.append(">");
        result.append("<");
        result.append(parsedData.get("day"));
        result.append(".");
        result.append(parsedData.get("mounth"));
        result.append(".");
        result.append(parsedData.get("year"));
        result.append(">");
        result.append("<");
        result.append(parsedData.get("gender"));
        result.append(">");
        result.append("<");
        result.append(parsedData.get("phonenumber"));
        result.append(">");

        return result.toString();
    }
}
