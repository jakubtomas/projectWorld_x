package Martin;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static final String JDBC = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://itsovy.sk:3306/world_x?autoReconnect=true&useSSL=false";
  //  private static final String URL = "jdbc:mysql://itsovy.sk:3306/chat1n?autoReconnect=true&useSSL=false";
    // jdbc:mysql://localhost:3306/world_x?autoReconnect=true&useSSL=false
    private static Connection connection;


    public static Connection getConnection() throws Exception {
        Class.forName(JDBC);
        connection = DriverManager.getConnection(URL, "student", "kosice2019");
        return connection;
    }
}