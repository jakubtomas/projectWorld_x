package project2.project;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* hru v jave , serveri , logiku , alg, ,, sudoku  */

public class Database implements DatabaseMethods {
    private final String JDBC = "com.mysql.jdbc.Driver";
    //private final String URL = "jdbc:mysql://localhost:3306/world_x?autoReconnect=true&useSSL=false";
    private final String URL = "jdbc:mysql://itsovy.sk:3306/chat1n?autoReconnect=true&useSSL=false";
    private final String URL2 = "jdbc:mysql://itsovy.sk:3306/chat1n?autoReconnect=true&useSSL=false";
  //  private final String QUERY = "SELECT * FROM users Where email like \"%gmail%\" ";
    //private  final  String WORD = "SELECT * FROM users  Where  name like \"%lev%\"  or  second_name  like \"%lev%\"";
    private  final  String WORD = "Select * from message order by id desc limit 10";
    private Connection connection;



    @Override
    public Connection getConnection() throws Exception {

        Class.forName(JDBC);
        connection = DriverManager.getConnection(URL2, "student", "kosice2019");
        return connection;


    }

    @Override
    public void updateSlovakCity() throws Exception {
/*
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you name of city ");
*/

        PreparedStatement statement = getConnection().prepareStatement("UPDATE city set Name = ? where Name like  \"Poprad\"");
        statement.setString(1, "Lipany");
        statement.execute();
        connection.close();


    }

    @Override
    public void deleteSlovakCity() throws Exception {
     //   PreparedStatement statement = connection.prepareStatement("UPDATE city set Name = ? where Name like  \"Poprad\"");
        PreparedStatement statement = getConnection().prepareStatement("Delete  from city where Name like ? ");
        statement.setString(1, "Lipany");
        statement.execute();
        connection.close();
    }



    @Override
    public void insertUsers(String name, String second_name, String email, Date date) throws Exception {
        PreparedStatement statement = getConnection().prepareStatement("INSERT  INTO users (name, second_name,email, date) "
                + " VALUES (?, ? ,? ,?) ");


        SimpleDateFormat ft =
                new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss ");
        System.out.println("Current Date: " + ft.format(date));



        statement.setString(1, name);
        statement.setString(2, second_name);
        statement.setString(3, email);
        statement.setString(4, ft.format(date)); // "2020-01-22 00:00:00"

        statement.execute();
    }

    @Override
    public void selectSlovakCity() throws Exception {
/*
        Date dates = new Date();
        System.out.println(new Timestamp(dates.getTime()));

*/

        //PreparedStatement statement = getConnection().prepareStatement("Select Name as City ,json_extract(info,'$.Population')as Population from city WHERE countryCode like SVK ");


        PreparedStatement statement = getConnection().prepareStatement(WORD);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("List of  people in database");
        System.out.println("  ");
        System.out.println("------------------------------------  ");

        /*while (rs.next()) {

            String name = rs.getString("name");

            String second_name = rs.getString("second_name");
            String email = rs.getString("email");
            String date = rs.getString("date");

            System.out.println(name + "  " + second_name + "  " + email+ "  " + date);

        }
        */

        while (resultSet.next()) {
            String name = resultSet.getString(1);
            String a = resultSet.getString(2);
            String b = resultSet.getString(3);
            String c = resultSet.getString(4);
            String d = resultSet.getString(5);
            System.out.println(name  + "  " + a  + "  "+ b + " " + "  " +  c +"  " + d);

        }


        System.out.println("------------------------------------  ");
        System.out.println("  ");

        connection.close();
    }


    public void selectPopulation() throws Exception {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you country ");
        String option = sc.nextLine();

        PreparedStatement statement  = getConnection().prepareStatement("SELECT json_extract(doc, '$.Name'),json_extract(doc, '$.demographics.Population') FROM countryinfo WHERE json_extract(doc, '$.Name') like ?");
       // PreparedStatement statement  = getConnection().prepareStatement("select * from input limit 1");
        statement.setString(1, option);

        //statement.execute();
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            String data = rs.getString("name");
            System.out.println(data + " ");

            System.out.println("----------------------------");
            System.out.println(rs.getString(1) + "  " + rs.getString(2));
        }


        connection.close();

    }

    public void makeCalculation() throws  Exception {

       /* Scanner sc = new Scanner(System.in);
        System.out.println("Enter you country ");
        String option = sc.nextLine();
*/
        //PreparedStatement statement  = getConnection().prepareStatement("SELECT json_extract(doc, '$.Name'),json_extract(doc, '$.demographics.Population') FROM countryinfo WHERE json_extract(doc, '$.Name') like ?");
        PreparedStatement statement  = getConnection().prepareStatement("select * from input limit 1");
        //statement.setString(1, option);

        //statement.execute();
        ResultSet rs = statement.executeQuery();


        System.out.println(rs);

        while (rs.next()) {
            String name = rs.getString("name");
            int a = rs.getInt("a");
            int b = rs.getInt("b");
            int c = rs.getInt("c");
            System.out.println(name  + "  " + a  + "  "+ b + " " + "  " +  c);

            int calculateArea=  (a*b*2) +(a*c*2)+(c*b*2);
            int calculateVolume = a * b * c;

            statement = getConnection().prepareStatement("INSERT INTO output(name,p,o) VALUES (?, ?, ?)");
            statement.setString(1,name);
            statement.setInt(2,calculateArea);
            statement.setInt(3, calculateVolume);
            statement.execute();

            statement = getConnection().prepareStatement("DELETE FROM input WHERE name LIKE ?");
            statement.setString(1,name);
            statement.execute();



        }
        System.out.println("you dont have more records in input table");

        //statement.getConnection().prepareStatement("")

        connection.close();

    }



}
