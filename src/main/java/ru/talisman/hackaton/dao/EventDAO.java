package ru.talisman.hackaton.dao;

import org.springframework.stereotype.Component;
import ru.talisman.hackaton.models.Event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class EventDAO {
    public EventDAO(){

    }
    private static Connection connection;
    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\123\\Desktop\\java\\Berendei\\src\\main\\webapp\\resources\\berendei_db.s3db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void event(Event event){
        connect();
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO EVENTS VALUES('" + event.getName() + "', '" + event.getNumber() + "')";
            statement.executeUpdate(SQL);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
