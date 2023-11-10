package lk.ijse.todo.model;

import lk.ijse.todo.db.DbConnection;
import lk.ijse.todo.dto.TaskDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task {

    public boolean add(TaskDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO task(task_id,description,due_date) VALUES (?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,dto.getTask_id());
        pstm.setString(2,dto.getDescription());
        pstm.setString(3,dto.getDue_date());

        int affectedRows = pstm.executeUpdate();

        return affectedRows>0;
    }

    public boolean update(TaskDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE task SET description=?,due_date=? WHERE task_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,dto.getDescription());
        pstm.setString(2,dto.getDue_date());
        pstm.setString(3,dto.getTask_id());

        int affectedRows = pstm.executeUpdate();

        return affectedRows>0;
    }

    public boolean delete(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE FROM task WHERE task_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,id);

        int affectedRows = pstm.executeUpdate();

        return affectedRows>0;
    }

    public boolean search(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM task WHERE task_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,id);

        return pstm.executeQuery().next();
    }

    public boolean loadAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM task";
        PreparedStatement pstm = connection.prepareStatement(sql);

        return pstm.executeQuery().next();
    }
}
