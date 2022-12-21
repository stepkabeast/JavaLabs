package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BinTree tree = new BinTree();
        Scanner keyboard = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Scanner numb = new Scanner(System.in);


        System.out.println("Введите элементы дерева: ");
        String line = in.nextLine();
        char[] current = line.toCharArray();
        String string = "";
        for (int i = 0; i < current.length; i++) {
            if (current[i] != ' ') {
                string = string + current[i];

            } else {
                int number = Integer.valueOf(string);
                tree.add(number);
                string = "";
                tree.createAVLTree(number);
            }
        }
        BinTree.action();

        String input = keyboard.next();
        while (!input.equals("Exit")) {
            if (input.equals("1")) {
                System.out.print("Введите новый элемент: ");
                int newEl = in.nextInt();
                tree.add(newEl);
            }
            if (input.equals("2")) {
                System.out.print("Введите элемент: ");
                int El = in.nextInt();
                tree.delete(El);
            }
            if (input.equals("3")) {
                System.out.print("Введите элемент: ");
                int El = in.nextInt();
                System.out.println(tree.containsNode(El));
            }
            if (input.equals("4")) {
                System.out.print(" ");
                tree.traverseInOrder(tree.root);
                System.out.println();
            }
            if (input.equals("5")) {
                tree.traversePreOrder(tree.root);
                System.out.println();
            }
            if (input.equals("6")) {
                tree.traversePostOrder(tree.root);
                System.out.println();
            }

            if (input.equals("7")) {

                System.out.println("AVL - дерево:");
                System.out.print("Обход в нисходящем порядке :");
                tree.idealTree.traversePreOrder(tree.idealTree.root);
                System.out.println();
                System.out.print("Обход дерева в последовательном порядке :");
                tree.idealTree.traverseInOrder(tree.idealTree.root);
                System.out.println();

                boolean flag = true;
                while (flag) {
                    System.out.println("Добавить элемент в AVL - дерево? : Y/N");
                    String chance = numb.nextLine();
                    if (chance.equals("Y")) {
                        System.out.print("Введите элемент: ");
                        int num = in.nextInt();
                        tree.idealTree.insert(num);
                        tree.idealTree.traversePreOrder(tree.idealTree.root);
                        System.out.println();
                        continue;

                    } else if (chance.equals("N")) {
                        flag = false;
                    } else {
                        System.out.println("Неверный ввод: ");}

                }

            }

            System.out.println("Следующее действие: ");
            input = keyboard.next();
        }

    }
}





