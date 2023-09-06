package ru.gb.atestation.service;

import ru.gb.atestation.parse_exception.ParseDataExceptoin;
import ru.gb.atestation.parse_exception.ParseDateException;
import ru.gb.atestation.parse_exception.ParseGenderException;
import ru.gb.atestation.parse_exception.ParsePhoneNumberException;

import java.time.LocalDate;
import java.util.HashMap;


public class ParsingData {
    public HashMap<String, Object> Parse(String[] data) throws ParseDataExceptoin {
        HashMap<String, Object> parsedData= new HashMap<>();
        String regex = "[0-9]+";

        for(int i = 0; i<data.length; i++){
            if(i < 3){
                String tempString = data[i];
                boolean alphabetCheck = tempString.matches(".*\\p{InCyrillic}.*");
                if (alphabetCheck == false) throwParseDataException(data[i]);
                switch (i){
                    case(1):
                        parsedData.put("firstname", tempString);
                        break;
                    case(0):
                        parsedData.put("lastname", tempString);
                        break;
                    case(2):
                        parsedData.put("patronymic", tempString);
                        break;
                    default:
                        throwParseDataException(data[i]);
                        break;
                }
            } else if (i == 3) {
                String tempDataString = data[3];
                String[] date = tempDataString.split("\\.");
                if(date.length != 3) {
                    throwParseDateException(data[i]);
                }
                else{
                    if(date[0].matches(regex) && date[1].matches(regex) && date[2].matches(regex)){
                        if(Integer.parseInt(date[0]) > 0 && Integer.parseInt(date[0]) < 32 &&
                        Integer.parseInt(date[1]) > 0 && Integer.parseInt(date[1]) < 13 &&
                        Integer.parseInt(date[2]) < LocalDate.now().getYear()){
                            parsedData.put("day", date[0]);
                            parsedData.put("mounth", date[1]);
                            parsedData.put("year", date[2]);
                        }
                        else{
                            throwParseDateException(data[i]);
                        }
                    }
                    else {
                        throwParseDateException(data[i]);
                    }
                }
            } else if (i == 4) {
                if (data[4].length() == 1){
                    if(data[4].equals("f")){
                        parsedData.put("gender", "female");
                    } else if (data[4].equals("m")) {
                        parsedData.put("gender", "male");
                    } else {
                        throwGenderException(data[i]);
                    }
                } else {
                    throwGenderException(data[i]);
                }
            } else if (i == 5) {
                if(data[5].matches(regex)){
                    if(data[5].length() == 11){
                        parsedData.put("phonenumber", data[5]);
                    }else {
                        throwPhoneNumberException(data[5]);
                    }
                }else {
                    throwPhoneNumberException(data[5]);
                }
            }
        }
        return parsedData;
    }

    public void throwParseDataException(String data){
        try{
            throw new ParseDataExceptoin();
        }catch (ParseDataExceptoin e){
            e.Exception(data);
        }
    }

    public void throwParseDateException(String data){
        try {
            throw new ParseDateException();
        }catch (ParseDateException e){
            e.Exception(data);
        }
    }

    public void throwGenderException(String data){
        try {
            throw new ParseGenderException();
        }catch (ParseGenderException e){
            e.Exception(data);
        }
    }

    public void throwPhoneNumberException(String data){
        try{
            throw new ParsePhoneNumberException();
        }catch (ParsePhoneNumberException e){
            e.Exception(data);
        }
    }
}
