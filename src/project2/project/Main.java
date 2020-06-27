package project2.project;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {


    private static int option;

    public static void main(String[] args) throws Exception {
        System.out.println("Hellou");
        Scanner sc = new Scanner(System.in);


        Database database = new Database();

        database.getConnection();

        while (option != 5) {
            System.out.println("I --------------------------------------------I");
            System.out.println("I    Select action to do with the table city  I");
            System.out.println("I    1.Return list of the name        I");
            System.out.println("I    2.Insert city  city data                 I");
            System.out.println("I    3.Update data                            I");
            System.out.println("I    4.Delete data                            I");
            System.out.println("I    5.Exit application                       I");
            System.out.println("I    6. Select data from db                   I");
            System.out.println("I    7. Do calculaction                       I");
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
                    Date dates = new Date();
                    System.out.println(new Timestamp(dates.getTime()));

                    SimpleDateFormat ft =
                            new SimpleDateFormat (" yyyy.MM.dd  hh:mm:ss ");
                    System.out.println("Current Date: " + ft.format(dates));

                   // System.out.println("Current Date: " + ft.format(dNow));

                    database.insertUsers("Donald" , "Trump" , "trump" , dates);

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
                case 7:
                    System.out.println("Create calculation ");
                    database.makeCalculation();
                    break;
                default:
                    System.out.println("this value dosnt exist");
            }

        }


        /// Genericka trieda

        // Box box = new Box<>();


    }
}






