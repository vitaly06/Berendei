package ru.talisman.hackaton.dao;


import org.springframework.stereotype.Component;
import ru.talisman.hackaton.models.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@Component
public class BookDAO {
    public BookDAO() {
    }
    private String name, phoneNumber, typePlace;

    /*private static final String URL = "jdbc:postgresql://localhost:5432/hackaton_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "15213190";
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/




    public void save(Book book){
        this.name = book.getName();
        this.phoneNumber = book.getPhoneNumber();
        this.typePlace = book.getTypePlace();
        System.out.println(name + " " + phoneNumber + " " +typePlace);
    }
        /*try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Book VALUES(" + "'" + book.getName() +
                    "'," + book.getPhoneNumber() + ",'" + book.getTypePlace() + "')";
            statement.executeUpdate(SQL);
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(1);
    }*/



}
