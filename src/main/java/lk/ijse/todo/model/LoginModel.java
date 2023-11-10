package lk.ijse.todo.model;

import lk.ijse.todo.db.DbConnection;
import lk.ijse.todo.dto.LoginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    public LoginDto login(LoginDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getUsername());
        pstm.setString(2, dto.getPassword());

        ResultSet resultSet = pstm.executeQuery();

        dto = null;

        if (resultSet.next()) {
            String passengerId = resultSet.getString(1);
            String name = resultSet.getString(2);

            dto = new LoginDto(passengerId, name);
        }

        return dto;
    }
}
