import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command;
        Table table = new Table();
        help();
        do{
            System.out.print("Введите команду: ");
                command = scan.nextLine();
            switch (command){
                case("put"): {
                    System.out.println("Введите строку, которую хотите добавить\n" +
                            "(только латиница нижнего регистра) или -1 для отмены");
                    String string = scan.nextLine();
                    if (string.equals("-1")) break;
                    table.put(string);
                    break;
                }
                case ("remove"): {
                    System.out.println("Введите строку, которую хотите удалить\n" +
                            "(только латиница нижнего регистра) или -1 для отмены");
                    String string = scan.nextLine();
                    if (string.equals("-1")) break;
                    table.delete(string);
                    break;
                }
                case ("contains"): {
                    System.out.println("Введите строку, которую хотите проверить\n" +
                            "(только латиница нижнего регистра) или -1 для отмены");
                    String string = scan.nextLine();
                    if (string.equals("-1")) break;
                    if(table.contains(string))
                        System.out.println("Есть");
                    else System.out.println("Нет");
                    break;
                }
                case ("exit"):
                    break;
                default:
                    System.out.println("Неверная команда! Попробуйте ещё раз");
            }
        }while(!command.equals("exit"));
    }
    public static void help(){
        System.out.println(
                "put - добавить строку в таблицу\n" +
                        "remove - убрать строку из таблицы\n" +
                        "contains - проверить наличие строки в таблице\n" +
                        "exit - выход");
    }
}
