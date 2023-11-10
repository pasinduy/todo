package lk.ijse.todo.controller;

/*
    @author DanujaV
    @created 11/7/23 - 3:23 AM   
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lk.ijse.todo.dto.TaskDto;
import lk.ijse.todo.model.TaskModel;

public class AddTaskFormController {
    @FXML
    private DatePicker txtDate;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtId;

    @FXML
    void btnAddTaskOnAction(ActionEvent event) {
        String id = txtId.getText();
        String date = txtDate.getValue().toString();
        String description = txtDescription.getText();

        var dto = new TaskDto(id, description, date);

        try {
            new TaskModel().addTask(dto);
            clearfields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearfields() {
        txtId.clear();
        txtDate.setValue(null);
        txtDescription.clear();
    }
}
