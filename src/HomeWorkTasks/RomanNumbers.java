//Написать метод, который переводит число из римского формата записи в арабский.
//Например, MMXXII = 2022
package HomeWorkTasks;

import java.util.*;

public class RomanNumbers {
    static Map<String, Integer> romanArabian = new HashMap<>();
    public static void mainLogic(){
        System.out.println("\n*****Задача 3*****");
        fillRomanArabian();
        String romanNumb = scanner();
        if (isCorrectRomanNumb(romanNumb)){
            System.out.println(convertArabianToRoman(romanNumb));
        }
    }
    private static void fillRomanArabian() {
        romanArabian.put("M", 1000);
        romanArabian.put("CM", 900);
        romanArabian.put("D", 500);
        romanArabian.put("CD", 400);
        romanArabian.put("C", 100);
        romanArabian.put("XC", 90);
        romanArabian.put("L", 50);
        romanArabian.put("XL", 40);
        romanArabian.put("X", 10);
        romanArabian.put("IX", 9);
        romanArabian.put("V", 5);
        romanArabian.put("IV", 4);
        romanArabian.put("I", 1);
    }
    private static Integer convertArabianToRoman(String inputRomanNumb){
        Integer resNumb = 0;
        String [] stringArray = inputRomanNumb.split("");
        int i = 0;
        while (i < stringArray.length) {
            if (i == stringArray.length-1){
                resNumb += romanArabian.get(stringArray[i]);
                i++;
            }
            else{
                if (romanArabian.get(stringArray[i]) < romanArabian.get(stringArray[i+1])){
                    resNumb += romanArabian.get(stringArray[i] + stringArray[i+1]);
                    i+=2;
                }
                else{
                    resNumb += romanArabian.get(stringArray[i]);
                    i++;
                }
            }
        }
        return resNumb;
    }
    private static String scanner (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите римское число (англ. раскладка): ");
        String newString = scanner.next();
        return newString.toUpperCase();
    }
    private static boolean isCorrectRomanNumb(String inputRomanNumb){
        String [] stringArr = inputRomanNumb.split("");
        for (int i = 0; i < inputRomanNumb.length(); i++) {
            if(!romanArabian.containsKey(stringArr[i])){
                System.out.println("Вы ввели не верный формат римского числа");
                return false;
            }
        }
        return true;
    }

}
