package Miroslav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
  //  private static final String JDBC = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://itsovy.sk:3306/world_x";
    private static Connection connection;


    public static Connection getConnection() throws Exception {
        Class.forName(JDBC);
        connection = DriverManager.getConnection(URL, "student", "kosice2019");
        return connection;
    }
}/* mysql connetctor java .jar*/