public class Main2 {

    public static void main(String[] args) {
        LinkedList<LinkedList<Integer>> highList = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        LinkedList<LinkedList<Integer>> highList2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();
        LinkedList<Integer> list4 = new LinkedList<>();

        list1.insert(1);
        list1.insert(2);

        list2.insert(5);
        list2.insert(6);

        list3.insert(3);
        list3.insert(4);

        list4.insert(7);
        list4.insert(8);

        highList.insert(list1);
        highList.insert(list2);

        highList2.insert(list3);
        highList2.insert(list4);

        System.out.println("Матрица А");
        highList.printList();
        System.out.println("Матрица В");
        highList2.printList();


        System.out.println("Матрица А * В");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int res = 0;
                for (int k = 0; k < 2; k++) {
                    res += highList.get(i,k) * highList2.get(k,j);
                }
                System.out.print(res + " ");
            }
            System.out.println();
        }


    }
}


