package org.example.dao;

import org.example.jdbc.ConnectionFactory;
import org.example.shared.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    Connection connection;

    public UserDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addUser(User user) throws SQLException {
        String sql = "insert into user (name, password) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("User saved");
        else
            System.out.println("Oops! something went wrong");
    }

//    @Override
//    public void updateUser(User user) throws SQLException {
//
//        String sql = "update user set name = ?, password = ? where id = ?";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, user.getName());
//        preparedStatement.setString(2, user.getEmail());
//        preparedStatement.setInt(3, user.getId());
//
//        int count = preparedStatement.executeUpdate();
//        if(count > 0)
//            System.out.println("User updated");
//        else
//            System.out.println("Oops! something went wrong");
//    }
//
//    @Override
//    public void deleteUser(int id) throws SQLException {
//
//        String query = "delete from user where id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setInt(1,id);
//        int count = preparedStatement.executeUpdate();
//        if(count > 0)
//            System.out.println("User deleted");
//        else
//            System.out.println("Oops! something went wrong");
//
//    }
//
//    @Override
//    public List<User> getUsers() throws SQLException {
//        List<User> users = new ArrayList<>();
//        String sql = "select * from user";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        while (resultSet.next()){
//            int id = resultSet.getInt(1);
//            String name  = resultSet.getString(2);
//            String password = resultSet.getString(3);
//            User user = new User(id, name, password);
//            users.add(user);
//        }
//        return users;
//
//    }
//
//    @Override
//    public User getUserById(int empId) throws SQLException {
//        User user = new User(-1);
//        String sql = "select * from user where id = " + empId;
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        if (resultSet.next()) {
//            int id = resultSet.getInt(1);
//            String name = resultSet.getString(2);
//            String password = resultSet.getString(3);
//            user.setName(name);
//            user.setEmail(email);
//            user.setId(id);
//        }
//        return user;
//    }
}
