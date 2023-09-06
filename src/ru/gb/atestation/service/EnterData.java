package ru.gb.atestation.service;

import java.util.Scanner;

public class EnterData {
    public String[] GetData(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите данные через пробел(в формате Фамилия Имя Отчество дата_рождения(" +
                    "в формате дд.мм.гггг) пол(f- жен. m- муж)) номер_телефона(10 цифр):");
            String data = scanner.nextLine();
            String[] dataArr = data.split(" ");
            if(dataArr.length == 6){
                return dataArr;
            }
            else {
                System.err.println("You entered information in wrong format! Please restart.");
            }
        }
    }
}
