package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Database implements DatabaseMethods {
    private final String JDBC = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/parking?autoReconnect=true&useSSL=false";
    private Connection connection;



    @Override
    public Connection getConnection() throws Exception {

        Class.forName(JDBC);
        connection = DriverManager.getConnection(URL, "root", "");
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
    public void insertSlovakCity() throws Exception {
        /*PreparedStatement statement = getConnection().prepareStatement("INSERT  INTO city (Name, CountryCode,District, Info) "
                + " VALUES (?, ? ,? ,?) ");
*/

        PreparedStatement statement = getConnection().prepareStatement(
                "START TRANSACTION" +
                "INSERT INTO employee ( name, second_name)" +
                "VALUES" +
                "(\"Peter\",\"Vselijaky\");" +

                "INSERT INTO car ( id_employee, spz) VALUES" +
                "(12 ,1234567)," +
                "(12, 1231237);" +
                "COMMIT;");


        statement.execute();
        connection.setAutoCommit(true);
    }

    @Override
    public void selectSlovakCity() throws Exception {
        //PreparedStatement statement = getConnection().prepareStatement("Select Name as City ,json_extract(info,'$.Population')as Population from city WHERE countryCode like SVK ");
        //PreparedStatement statement = getConnection().prepareStatement("select Name as City,json_extract(info,'$.Population')as Population from city Where countryCode like \"SVK\"  ");
        PreparedStatement statement = getConnection().prepareStatement("select * from employee  ");
        ResultSet rs = statement.executeQuery();

        System.out.println("List of SVK countrie");
        while (rs.next()) {

            String city = rs.getString("name");
            String population = rs.getString("second_name");
            System.out.println(city + "  " + population );
        }

        connection.close();
    }


    public void selectPopulation() throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you country ");
        String option = sc.nextLine();

        PreparedStatement statement  = getConnection().prepareStatement("SELECT json_extract(doc, '$.Name'),json_extract(doc, '$.demographics.Population') FROM countryinfo WHERE json_extract(doc, '$.Name') like ?");
        statement.setString(1, option);

        //statement.execute();
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            String data = rs.getString("Name");
            System.out.println(data + " ");

            System.out.println("----------------------------");
            System.out.println(rs.getString(1) + "  " + rs.getString(2));
        }

        connection.close();

    }
}
