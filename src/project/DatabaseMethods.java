package project;

import java.sql.Connection;

public interface DatabaseMethods {
    Connection getConnection() throws Exception;

    void updateSlovakCity() throws Exception;
    void deleteSlovakCity() throws Exception;
    void insertSlovakCity() throws Exception;
    void selectSlovakCity() throws Exception;
}
