package dao.Card;

import model.Book;
import model.Card;
import model.Statistical;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardDAO implements ICard {
    public static final String INSERT_CARD = "insert into card(id, idBook, idStudent, status, borrowDate, payDate) VALUE (?,?,?,?,?,?);";
    public static final String FIND_ALL_STATISTICAL = "select c.id,b.name,b.author, s.name,s.className, c.borrowDate,c.payDate from card c join book b on c.idBook = b.id join student s on s.id = c.idStudent where c.status = false;";
    public static final String FIND_BY_ID = "select * from card where card.id like ?;";
    public static final String UPDATE_CARD = "update card set idBook = ?, card.idStudent = ?,card.status = ? , card.borrowDate = ?, card.payDate = ? where id like ?;";
    public static final String FIND_CARD_BY_NAME_BOOK = "select c.id,b.name,b.author, s.name,s.className, c.borrowDate,c.payDate from card c join book b on c.idBook = b.id join student s on s.id = c.idStudent where b.name like ? and c.status = false;";
    public static final String FIND_BY_NAME_STUDENT = "select c.id,b.name,b.author, s.name,s.className, c.borrowDate,c.payDate from card c join book b on c.idBook = b.id join student s on s.id = c.idStudent where  s.name like ? and c.status = false;";
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
    public List<Card> findAll() {
        return null;
    }

    @Override
    public void add(Card card) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CARD)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, card.getId());
            preparedStatement.setInt(2, card.getIdBook());
            preparedStatement.setInt(3, card.getIdStudent());
            preparedStatement.setBoolean(4, card.isStatus());
            preparedStatement.setString(5, card.getBorrowedDate());
            preparedStatement.setString(6, card.getPayDate());
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
    public Card findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Card card) {

    }


    public Card findByIdCard(String id) {
        Card card = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String idCard = rs.getString(1);
                int idBook = rs.getInt(2);
                int idStudent = rs.getInt(3);
                boolean status = rs.getBoolean(4);
                String borrowDate = rs.getString(5);
                String payDate = rs.getString(6);
                card = new Card(idCard,idBook,idStudent,status,borrowDate,payDate);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return card;
    }
    @Override
    public void updateCard(String id, Card card) {
        List<Statistical> list = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CARD)) {
            preparedStatement.setInt(1,card.getIdBook());
            preparedStatement.setInt(2,card.getIdStudent());
            preparedStatement.setBoolean(3,card.isStatus());
            preparedStatement.setString(4,card.getBorrowedDate());
            preparedStatement.setString(5,card.getPayDate());
            preparedStatement.setString(6,id);
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
    public List<Statistical> findByNameBook(String nameBook) {
        List<Statistical> list = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_CARD_BY_NAME_BOOK)) {
            preparedStatement.setString(1, nameBook + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String bookName = rs.getString(2);
                String actor = rs.getString(3);
                String nameStudent = rs.getString(4);
                String nameClass = rs.getString(5);
                String borrowDate = rs.getString(6);
                String payDate = rs.getString(7);
                list.add(new Statistical(id, bookName, actor, nameStudent, nameClass, borrowDate, payDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Statistical> findByNameStudent(String nameStudent) {
        List<Statistical> list = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME_STUDENT)) {
            preparedStatement.setString(1, nameStudent + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String bookName = rs.getString(2);
                String actor = rs.getString(3);
                String nameStudent1 = rs.getString(4);
                String nameClass = rs.getString(5);
                String borrowDate = rs.getString(6);
                String payDate = rs.getString(7);
                list.add(new Statistical(id, bookName, actor, nameStudent1, nameClass, borrowDate, payDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    @Override
    public void remove(int id) {

    }

    public List<Statistical> findAllStatistical() {
        List<Statistical> list = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_STATISTICAL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String bookName = rs.getString(2);
                String actor = rs.getString(3);
                String nameStudent = rs.getString(4);
                String nameClass = rs.getString(5);
                String borrowDate = rs.getString(6);
                String payDate = rs.getString(7);
                list.add(new Statistical(id, bookName, actor, nameStudent, nameClass, borrowDate, payDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
