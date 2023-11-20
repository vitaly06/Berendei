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




    public void book(Book book){
        connect();
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO BOOKS VALUES('" + book.getDateStart() + "', '" + book.getDateEnd() +
                    "', '" + book.getPeopleCount() + "', '" + book.getKidsCount() + "', '" + book.getPlace() +
                    "', '" + book.getName() + "', '" + book.getSurname() + "', '" + book.getEmail() + "', '" + book.getNumber() + "')";
            statement.executeUpdate(SQL);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
