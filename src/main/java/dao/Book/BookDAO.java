package dao.Book;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBook {

    public static final String FIND_ALL_BOOK = "select * from book;";
    public static final String UPDATE_BOOK = "update book set name = ?, author = ?, description = ?, quantity = ? where book.id = ?;";
    private static final String SELECT_BOOK_BY_ID = "select * from book where id =?";
    private String jdbcURL = "jdbc:mysql://localhost:3306/kiemtram3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "3008";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Ket noi khong thanh cong");
        }
        return connection;
    }

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BOOK)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String author = rs.getString(3);
                String description = rs.getString(4);
                int quantity = rs.getInt(5);
                list.add(new Book(id, name, author, description, quantity));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Book book) {

    }

    @Override
    public Book findById(int id) {
        Book book = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                book = new Book(id, name, author, description, quantity);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

    @Override
    public void update(int id, Book book) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setString(2,book.getActor());
            preparedStatement.setString(3,book.getDescription());
            preparedStatement.setInt(4,book.getQuantity());
            preparedStatement.setInt(5,id);
            int check = preparedStatement.executeUpdate();
            if (check == 0) {
                connection.rollback();
            } else {
                connection.commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {

    }
}
