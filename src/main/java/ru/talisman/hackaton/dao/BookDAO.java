package ru.talisman.hackaton.dao;


import org.springframework.stereotype.Component;
import ru.talisman.hackaton.models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
                    "', '" + book.getPeopleCount() + "', '" + book.getKidsCount() + "', '" + book.getPlace() + " КОТТЕДЖ" +
                    "', '" + book.getName() + "', '" + book.getSurname() + "', '" + book.getEmail() + "', '" + book.getNumber() + "')";
            statement.executeUpdate(SQL);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Book> getData(String email){
        connect();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM BOOKS WHERE email = '" + email + "'";
            List<Book> books = new ArrayList<Book>();
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next())
            {
                books.add(new Book(
                        resultSet.getString("dateStart"),
                        resultSet.getString("dateEnd"),
                        resultSet.getString("peopleCount"),
                        resultSet.getString("kidsCount"),
                        resultSet.getString("place"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("number")));
            }
            //System.out.println(name + " " + email + " " + password + " " + isteacher);
            connection.close();
            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }
}
