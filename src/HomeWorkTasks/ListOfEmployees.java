//Пусть дан список сотрудников...
//Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
package HomeWorkTasks;

import java.util.*;

public class ListOfEmployees {
    private static HashMap<String, Integer> names = new HashMap<>();
    public static void getNames(){
        System.out.println("*****Задача 1*****");
        fillNames(createArrOfEmployees());
        System.out.println(names);
    }
    private static String [] createArrOfEmployees() {
        String stringWithEmployees = "Иван Иванов,Светлана Петрова,Кристина Белова,Анна Мусина," +
                "Анна Крутова,Иван Юрин,Петр Лыков,Павел Чернов,Иван Иванов,Петр Чернышов," +
                "Мария Федорова,Марина Светлова,Мария Савина,Иван Иванов,Мария Рыкова," +
                "Анна Крутова,Марина Лугова,Анна Владимирова,Петр Лыков,Иван Мечников," +
                "Петр Петин,Петр Лыков,Иван Ежов";
        String [] arr = stringWithEmployees.split(",");
        return arr;
    }

    private static void fillNames(String [] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            String temp = inputArr[i].trim().split(" ")[0];
            if (names.containsKey(temp)){
                int tempValue = names.get(temp);
                names.put(temp, ++tempValue);
            }
            else{
                names.put(temp, 1);
            }
        }

    }
}
