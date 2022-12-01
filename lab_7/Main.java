import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Введите количество строк матрицы А: ");
        int n=sc.nextInt(); // Количество строк первой матрицы
        System.out.println();
        System.out.print("Введите количество столбцов и матрицы А: ");
        int m=sc.nextInt();
        System.out.println();
        System.out.print("Введите количество столбцов матрицы В: ");
        int k=sc.nextInt(); // Количество столбцов во второй матрице

        LinkedList<LinkedList<Integer>> highList = new LinkedList<>();
        LinkedList<LinkedList<Integer>> highList2 = new LinkedList<>();
        LinkedList<LinkedList<Integer>> matrix = new LinkedList<>();

        for (int i = 0; i < n; i++){
            LinkedList<Integer> list = new LinkedList<>();
            for(int j = 0; j < m; j++){
                System.out.print("Матрица A, " + i + " строка: ");
                list.insert(sc.nextInt());
                System.out.println();
            }
            highList.insert(list);
        }

        for (int i = 0; i < m; i++){
            LinkedList<Integer> list = new LinkedList<>();
            for(int j = 0; j < k; j++){
                System.out.print("Матрица В, " + i + " строка: ");
                list.insert(sc.nextInt());
                System.out.println();
            }
            highList2.insert(list);
        }
        System.out.println("Матрица А");
        highList.printList();
        System.out.println("Матрица В");
        highList2.printList();


        System.out.println("Матрица А * В");
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> matrix1 = new LinkedList<>();
            for (int j = 0; j < k; j++) {
                int res = 0;
                for ( int q = 0; q < m; q++) {
                    res += highList.get(i,q) * highList2.get(q,j);
                }

                matrix1.insert(res);
            }
            matrix.insert(matrix1);
             System.out.println();
        }
        matrix.printList();


    }
}
