package commands;

import queries.Queries;
import java.util.Scanner;

public class ListTables {

    public void listTables(){
        Queries queries = new Queries();
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check){
            try {
                String string;
                System.out.println("List of tables what you can use:");
                queries.listTables();
                System.out.println("Make your choice or 'q' to exit");
                string = scanner.nextLine();
                if ((string.toLowerCase()).equals("q")){
                    check = false;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
