package secondproject;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {


    public static  final String USERS = ("");
    public  static int option;

    public static int count = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver"); // adding JDBC driver to Java
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://itsovy.sk:3306/chat1n?autoReconnect=true&useSSL=false", "student", "kosice2019");




            while (option != 5) {

                System.out.println("I --------------------------------------------I");
                System.out.println("I    Select action to do with the table city  I");
                System.out.println("I    1.Show all message                       I");
                System.out.println("I    2.Write message                          I");
                System.out.println("I    3.delete message                         I");
                System.out.println("I    5. End application                       I");
                System.out.println("I --------------------------------------------I");

                System.out.println("Select your action ");
                // System.out.println("Select your action ");
                option = sc.nextInt();




                switch (option) {
                    case 1:
                        PreparedStatement stmt = connection.prepareStatement("Select * from message order by id desc limit 10");
                        ResultSet resultSet = stmt.executeQuery();


                        while (resultSet.next()) {
                            String name = resultSet.getString(1);
                            String a = resultSet.getString(2);
                            String b = resultSet.getString(3);
                            String c = resultSet.getString(4);
                            String d = resultSet.getString(5);
                            System.out.println(name  + "  " + a  + "  "+ b + " " + "  " +  c +"  " + d);

                        }
                        break;
                    case 2:
                        System.out.println(" From user ");
                        String fromUser = sc.nextLine();
                        fromUser = sc.nextLine();


                        System.out.println(" To user ");
                        String toUser = sc.nextLine();


                        System.out.println(" write message ");
                        String message = sc.nextLine();

                         stmt = connection.prepareStatement("INSERT  INTO message (fromUser, toUser,message) "
                                + " VALUES (?, ? ,? ) ");

                        stmt.setString(1,fromUser);
                        stmt.setString(2,toUser);
                        stmt.setString(3, message);
                        stmt.execute();



                        break;
                    case 3:
                        System.out.println("delete message active ");
                        stmt = connection.prepareStatement("DELETE  FROM message  WHERE fromUser LIKE ?");
                        stmt.setString(1,"tomasj");
                        stmt.execute();


                        break;
                    case 4 :
                        System.out.println("select insert and delete ");

                        break;
                    case 5:
                        System.out.println("Exit application");
                        break;

                    default:
                        System.out.println("this value dosnt exist");
                }


            }


            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}


// 3 uloha

