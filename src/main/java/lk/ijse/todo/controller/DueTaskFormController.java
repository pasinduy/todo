package lk.ijse.todo.controller;

/*
    @author DanujaV
    @created 11/7/23 - 3:46 AM   
*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.todo.dto.TaskDto;
import lk.ijse.todo.dto.tm.DueTm;
import lk.ijse.todo.model.Task;

import java.sql.SQLException;

public class DueTaskFormController {

    @FXML
    private TableColumn<?, ?> colComplete;

    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<DueTm> tblDue;
    private ObservableList<DueTm> obList;
    private Task model = new Task();

    public void initialize() throws SQLException {
        setCellValueFactory();
        loadDueTasks();
    }

    private void setCellValueFactory() {
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colComplete.setCellValueFactory(new PropertyValueFactory<>("btnComplete"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
    }

    private void loadDueTasks() throws SQLException {
        ObservableList<DueTm> obList = FXCollections.observableArrayList();


        for (int i = 0; i < obList.size(); i++) {
            int finalI1 = i;
            obList.get(i).getBtnComplete().setOnAction(event -> {
                TaskDto.class.cast(obList.get(finalI1)).getBtnComplete().setOnAction(event1 -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?");
                });
            });

            int finalI = i;
            obList.get(i).getBtnDelete().setOnAction(event -> {
                TaskDto.class.cast(obList.get(finalI)).getBtnDelete().setOnAction(event1 -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?");
                });
            });
        }
        tblDue.setItems(obList);
    }

}
