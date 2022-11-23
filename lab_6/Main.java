package com.company;

import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = sc.nextLine();
//       Calculation1("9 3 1 - 3 * + 10 2 / +");
        System.out.println(Calculation2(expression));
    }

    /**
     * Вычислить постфиксное выражение
     *
     * @param inputString 9 3 1-3 * + 10 2 / + через пробел
     */
    public static int Calculation1(String inputString) {
        String[] input = inputString.split(" ");

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            if (isNumber(s))  // Если это число, оно помещается в стек
                stack.push(Integer.valueOf(s));
            else {
                // Когда встречается оператор, из стека извлекаются два числа для выполнения операций
                int n1 = stack.pop();
                int n2 = stack.pop();
                int res = 0;
                switch (s) {
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n2 - n1;
                        break;
                    case "*":
                        res = n1 * n2;
                        break;
                    case "/":
                        res = n2 / n1;
                        break;
                }
                stack.push(res);
            }
        }

        return stack.pop();
    }

    /**
     * Преобразование инфиксного выражения в постфиксное выражение через пробел
     *
     * @param string - 9 + ( 3 - 1 ) * 3 + 10 / 2
     * @return
     */
    public static String Calculation2(String string) {
        Stack<String> stack = new Stack(); //реализуем стек на основе коллекции
        String[] chars = string.split(" "); //делим строку на слова
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars[i]); //возвращем объект как строку и присваиваем s
            if (isNumber(s)) {       // если встречается цифра
                if (res.length() == 0)
                    res += s;
                else
                    res += " " + s;
            } else {
                if (s.equals("(")) {     //когда открывающая начальная скобка
                    stack.push(s);
                } else {
                    if (s.equals(")")) { //когда встречается закрывающая скобка
                        String t = "";
                        String s1 = "";
                        while (!(t = stack.pop()).equals("(")) {
                            s1 += " " + t;
                        }
                        res += s1;
                    } else {
                        int priority = getPriority(s);    //определяем приоритет оператора
                        String s1 = "";
                        boolean flag = false;
                        while (!stack.empty()) {
                            flag = false;
                            s1 = stack.pop();
                            if (s1.equals("(")) {
//                                stack.push("(");
                                break;
                            }

                            if (getPriority(s1) >= priority) {
                                res += " " + s1;
                                flag = true;
                            }
                        }
                        if (!s1.equals("") && !flag)
                            stack.push(s1);
                        stack.push(s);
                    }
                }
            }
        }

        while (!stack.empty()) {
            res += " " + stack.pop();
        }

        return res;
    }


    // Получаем приоритет оператора
    public static int getPriority(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("+", 0);
        map.put("-", 0);
        map.put("*", 1);
        map.put("/", 1);
        map.put("(", 2);
        map.put(")", 2);

        return map.get(s);
    }

    public static boolean isNumber(String c) {

        Pattern pattern = Pattern.compile("^(0|[1-9][0-9]*)$");// скомпилировали регулярное выражение в представление
        Matcher matcher = pattern.matcher(c);//создали поисковик в тексте c по шаблону "^(0|[1-9][0-9]*)$"
        boolean res = matcher.find();
        return res;
    }
}