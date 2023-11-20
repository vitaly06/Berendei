package ru.talisman.hackaton.dao;

import org.springframework.stereotype.Component;
import ru.talisman.hackaton.models.Person;

import java.sql.*;
import java.util.Objects;

@Component
public class PersonDAO {
    public PersonDAO(){}
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
    public void save(Person person){
        connect();
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO USERS VALUES('" + person.getName() + "', '" + person.getEmail() +
                    "', '" + person.getPassword() + "')";
            statement.executeUpdate(SQL);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String login(Person person){
        connect();
        try{
            Statement statement = connection.createStatement();
            String SQL = "SELECT password FROM USERS WHERE email = '" + person.getEmail() + "'";
            ResultSet resultSet = statement.executeQuery(SQL);
            String password = resultSet.getString("password");
            if (Objects.equals(person.getPassword(), password)) {
                return "1";
            }
            return "0";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
