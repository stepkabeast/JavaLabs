public class Table {
    private Cell[] table; // создаем массив объектов Cell
    public Table(){
        table = new Cell[25];
        for (int i = 0; i < table.length; i++){
            table[i] = new Cell();
        }
    }
    public void delete(String data){
        int hash = hash(data) % 25;
        table[hash].data.remove(data);
    }
    public void put(String data){
        int hash = hash(data) % 25;
        if(!table[hash].data.contains(data))
            table[hash].data.add(data);
    }
    public boolean contains(String data){
        int hash = hash(data) % 25;
        return table[hash].data.contains(data);
    }
    private int hash(String data){
        char[] str = data.toCharArray();
        int len = str.length-1;
        int sum = 0;
        for(char ch : str){
            sum += h(ch)*Math.pow(27,len);
            len--;
        }
        return sum;
    }
    private int h(char ch){
        if(ch >= 97 && ch <= 122)
            return  ch-96;
        if(ch == ' ')
            return 27;
        return 0;
    }
}
