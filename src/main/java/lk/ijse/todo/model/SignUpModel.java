package lk.ijse.todo.model;

import lk.ijse.todo.db.DbConnection;
import lk.ijse.todo.dto.SignUpDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpModel {

    public boolean registerUser(SignUpDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO user VALUES(?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getUsername());
        pstm.setString(2, dto.getEmail());
        pstm.setString(3, dto.getPassword());

        return pstm.executeUpdate() > 0;
    }
}
