package sk.itsovy.tomasj.project;
import java.sql.*;

public class Main {

    public static final String QUERYCOUNTRIES = "Select Name from country";
    public static final String Cities = "Select Name from city Where name like  ? order  by name";
    public static final String INSERTCITY = "INSERT  INTO city (Name, CountryCode,District, Info) "
            + " VALUES (?, ? ,? ,?) ";

    public static final String CITIESWITHCOUNTRY= "select city.name as City,country.Name as Country,json_extract(city.Info,'$.Population') " +
            "as Population from city join country on city.countrycode = country.code where city.Name like ?;";
    public static final String CITYTOP20 = "SELECT city.Name , country.Name as Country, json_extract(info,'$.Population')as Population FROM country " +
            "INNER JOIN city ON country.code= city.countryCode Order BY Population DESC LIMIT 20 ";

    public static final String COUNTRY = "select * from country limit 10 ";

    public static int count = 0;
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.jdbc.Driver"); // adding JDBC driver to Java
            Connection connection =
                   // DriverManager.getConnection("jdbc:mysql://localhost:3306/world_x?autoReconnect=true&useSSL=false", "root", "");
                    DriverManager.getConnection("jdbc:mysql://itsovy.sk:3306/world_x?autoReconnect=true&useSSL=false", "student", "kosice2019");

            PreparedStatement stmt = connection.prepareStatement(Cities);

            String city = "Berlin";
            stmt.setString(1,city);
            ResultSet rs = stmt.executeQuery();
            System.out.println("List of countries " + rs.getFetchSize()  );


/*

            while (rs.next()) {
                count++;
                String data = rs.getString("Name");
                System.out.println(data + " ");
            }
            stmt.execute();


            System.out.println(count);

            if (count == 0) {

                PreparedStatement stmt2 = connection.prepareStatement(INSERTCITY);

                stmt2.setString(1, "Poprad");
                stmt2.setString(2, "SVK");
                stmt2.setString(3, "Tatry");
                stmt2.setString(4, "{\"Population\" : 51992}");

                stmt2.execute();
            } else {
                System.out.println("Nasledujúce mesto už existuje ");
            }
*/





            stmt = connection.prepareStatement(CITIESWITHCOUNTRY);
           stmt.setString(1,"Berlin");
            rs =stmt.executeQuery();


            System.out.println("List of cities with their countries and population :");
            while (rs.next()) {
                System.out.println(rs.getString("City") + "     " + rs.getString("Country")
                        + "        " + rs.getString("Population"));
            }

            /*int count = 1;

            System.out.println("vypis ");
            while (resultSet.next()) {
                System.out.print(count + ".  " + resultSet.getString(1) + "  " + resultSet.getString(2) + "  " + resultSet.getInt(3) + "\n");
                count++;
            }*/

            PreparedStatement stmt3 = connection.prepareStatement(COUNTRY);
            ResultSet resultSet = stmt3.executeQuery();


            System.out.println(" to this okey ");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String a = resultSet.getString(2);
                String b = resultSet.getString(3);
                String c = resultSet.getString(4);
               // String d = resultSet.getString(5);
                System.out.println(name  + "  " + a  + "  "+ b + " " + "  " +  c +"  " );

            }




            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }












    }

}


// 3 uloha

