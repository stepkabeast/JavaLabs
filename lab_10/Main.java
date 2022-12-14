package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Отсортированный обход: ");
        tree.inorder();

        System.out.println("\n\nПосле удаления 10");
        tree.deleteKey(10);

        System.out.print("Отсортированный обход: ");
        tree.inorder();
    }
}
