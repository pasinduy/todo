package lk.ijse.todo.model;

import lk.ijse.todo.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public static boolean check(String userName, String pw) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql ="SELECT * FROM email WHERE name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,userName);
        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()){
            if(resultSet.getString(2).equals(pw)){
                return true;
            }
        }
        return false;
    }

    public static boolean add(String email, String username, String password) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO email(email,name,password) VALUES (?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,email);
        pstm.setString(2,username);
        pstm.setString(3,password);

        int affectedRows = pstm.executeUpdate();

        return affectedRows>0;
    }

}
