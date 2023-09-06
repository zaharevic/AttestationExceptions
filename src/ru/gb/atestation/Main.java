package ru.gb.atestation;

import ru.gb.atestation.parse_exception.ParseDataExceptoin;
import ru.gb.atestation.service.EnterData;
import ru.gb.atestation.service.ParseToString;
import ru.gb.atestation.service.ParsingData;
import ru.gb.atestation.service.WriteToFile;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws ParseDataExceptoin {
        EnterData enterData = new EnterData();
        ParsingData parsingData = new ParsingData();
        ParseToString parseToString = new ParseToString();
        String newFileName = null;
        StringBuilder sb = new StringBuilder();
        WriteToFile writeToFile = new WriteToFile();

        String[] data = enterData.GetData();
        HashMap<String, Object> parsedData = parsingData.Parse(data);
        String writeData = parseToString.string(parsedData);

        sb.append(parsedData.get("lastname"));
        sb.append(".txt");
        newFileName = sb.toString();

        writeToFile.writeData(writeData, newFileName);
    }
}
