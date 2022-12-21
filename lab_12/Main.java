package com.company;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        String test = "Иркутск основан как Острог в 1661 году на правом берегу Ангары. В 1686 году ему присвоен статус города. С 1764 года – центр Иркутской губернии.";
        String[] sentences = test.split("\\."); //экранируем точку для деления предложений
        ArrayList<String>[] words = new ArrayList[sentences.length];
        String[][] matrix = new String[sentences.length][];
        for (int i = 0; i < matrix.length; i++){
            //вызываю стрим и записываю все слова в текущей строке в массив
            matrix[i] = Arrays.stream(sentences[i].split(" ")).filter(s -> !s.equals("")).toArray(String[]::new);
        }
        for (int i = 0; i < matrix.length; i++){
            words[i] = new ArrayList<>();
            for (String word : matrix[i]){ //пробегаюсь по строке
                for(int j = 0; j < word.length(); j++){
                    if(word.toLowerCase().charAt(j) == 'о'){
                        words[i].add(word);
                        break;
                    }
                }
            }
        }
        for (ArrayList<String> word : words) {
            String[] row = word.toArray(String[]::new); // передаю строку из списка в массив
            for (String s : row) {
                System.out.printf("%-12s", s);
            }
            System.out.println();
        }
    }
}