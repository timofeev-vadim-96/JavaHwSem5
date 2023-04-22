//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь
// несколько телефонов.
package HomeWorkTasks;

import java.util.*;

public class PhoneBook {
    static HashMap<String, List<String>> phoneBook = new HashMap<>();
    public static void createPhoneBook() {
        System.out.println("\n*****Задача 2*****");
        phoneBook.put("Иванов", createNumbList());
        phoneBook.put("Петров", createNumbList());
        phoneBook.put("Сидоров", createNumbList());
        printPhoneBook();
    }
    private static List<String> createNumbList(){
        List<String> newList = new LinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(1,6); i++) {
            newList.add("+7 (" + rand.nextInt(100,1000) + ") " +
                    rand.nextInt(100,1000) + " " + rand.nextInt(10, 100) +
                    " " + rand.nextInt(10, 100));
        }
        return newList;
    }
    private static void printPhoneBook(){
        for (var item : phoneBook.entrySet()) {
            System.out.println(item);
        }
    }
}
