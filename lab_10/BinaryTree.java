package com.company;
class BinaryTree {
    class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinaryTree() {
        root = null;
    }


    void insert(int key) {
        root = insertKey(root, key);
    }

    // Вставляем в дерево элемент
    Node insertKey(Node root, int key) {
        // Возвращаем новый узел, если дерево пустое
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Идем в нужное место и вставляем узел
        if (key < root.key)
            root.left = insertKey(root.left, key);
        else if (key > root.key)
            root.right = insertKey(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    // Отсортированный (inorder) обход
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " -> ");
            inorderRec(root.right);
        }
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        // Возвращаем, если дерево пустое
        if (root == null)
            return root;

        // Ищем узел, который нужно удалить
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Если у узла только один дочерний элемент или их вообще нет
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Если у узла два дочерних элемента
            // Помещаем inorder-преемника на место узла, который хотим удалить
            root.key = minValue(root.right);
            // Удаляем inorder-преемника
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    // Ищем inorder-преемника
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Тестим функции

}