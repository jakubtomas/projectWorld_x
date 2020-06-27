package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {


    private static int option;

    public static void main(String[] args) throws Exception {
        System.out.println("Hellou");
        Scanner sc = new Scanner(System.in);

        Database database = new Database();

        database.getConnection();
        Box<String>  box = new Box<>();
        box.add(" Auto");

        System.out.println(box.getValue());

        while (option != 5) {
            System.out.println("I --------------------------------------------I");
            System.out.println("I    Select action to do with the table city  I");
            System.out.println("I    1.Return list of the slovak city         I");
            System.out.println("I    2.Insert city  city data                 I");
            System.out.println("I    3.Update data                            I");
            System.out.println("I    4.Delete data                            I");
            System.out.println("I    5.Exit application                       I");
            System.out.println("I    6. Select population                      I");
            System.out.println("I --------------------------------------------I");

            System.out.println("Select your action ");
            // System.out.println("Select your action ");
            option = sc.nextInt();


            switch (option) {
                case 1:
                    System.out.println("Function return list");
                    database.selectSlovakCity();
                    break;
                case 2:
                    System.out.println("Function Insert");
                    database.insertSlovakCity();

                    break;
                case 3:
                    System.out.println("Update data");
                    database.updateSlovakCity();
                    break;
                case 4:
                    System.out.println("delete data");
                    database.deleteSlovakCity();
                    break;
                case 5:
                    System.out.println("Exit application");
                    break;

                case 6:
                    System.out.println("Select population");
                    database.selectPopulation();
                    break;

                default:
                    System.out.println("this value dosnt exist");
            }

        }


        /// Genericka trieda

        // Box box = new Box<>();


    }
}






