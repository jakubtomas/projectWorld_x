package project2.project;

import java.sql.Connection;
import java.util.Date;

public interface DatabaseMethods {
    Connection getConnection() throws Exception;

    void updateSlovakCity() throws Exception;
    void deleteSlovakCity() throws Exception;
    //void insertUsers() throws Exception;

    void insertUsers(String name, String second_name, String email, Date date) throws Exception;

    void selectSlovakCity() throws Exception;
}
