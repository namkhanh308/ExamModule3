package dao.Student;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudent{
    private static final String FIND_ALL_STUDENT = "select * from student";

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

    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_STUDENT)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String className = rs.getString("className");
                studentList.add(new Student(id, name, className));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void add(Student student) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Student student) {

    }

    @Override
    public void remove(int id) {

    }
}
